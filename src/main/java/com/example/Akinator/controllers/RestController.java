package com.example.Akinator.controllers;


import com.example.Akinator.entity.Dish;
import com.example.Akinator.entity.Question;
import com.example.Akinator.repositories.DishRepository;
import com.example.Akinator.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private DishRepository dishRepository;

    @Transactional
    @GetMapping("/question")
    public List<Question> showAll() {
        return questionRepository.findAll();
    }

    @PostMapping("/question")
    public String getNext(@RequestBody String number) {
        StringBuilder questionOnString = new StringBuilder();
        List<Question> questions = questionRepository.findAll();
        Question question = null;
        for (Question x : questions) {
            if (x.getNumber().equals(number)) {
                question = x;
                questionOnString = new StringBuilder(x.getQuestion());
            }
        }
        if (question == null) {
            List<Dish> dishes = dishRepository.findAll();
            Dish dish = null;
            for (Dish x : dishes) {
                if (x.getNumber().equals(number)) {
                    dish = x;
                    questionOnString.append(" ");
                    questionOnString.append(x.getName());
                }
            }
        }
        return questionOnString.toString();
    }

    @PostMapping("/list")
    public String getList(@RequestBody String way) {
        List<Dish> allDish = dishRepository.findAll();
        List<Dish> filteredDish = new ArrayList<>();
        String wholeWay = "";
        for (Dish x : allDish) {
            wholeWay = x.getNumber();
            if (isPrefix(wholeWay, way)) {
                filteredDish.add(x);
            }
        }
        return getNames(filteredDish);
    }


    private static String getNames(List<Dish> listOfFilteredDishes) {
        StringBuilder sentense = new StringBuilder();
        for (Dish x : listOfFilteredDishes) {
            sentense.append(x.getName());
            sentense.append("/");
        }
        return sentense.toString();
    }

    private static boolean isPrefix(String word, String way) {
        boolean condition;
        if (way.length() > word.length()) {
            condition = false;
        } else {
            if (word.length() == way.length()) {
                condition = word.equals(way);
            } else {
                int length = way.length();
                String partOfWord = word.substring(0, length);
                condition = partOfWord.equals(way);
            }
        }
        return condition;
    }


}
