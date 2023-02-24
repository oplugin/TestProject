package com.example.servletproject.service;

public enum SumService {

    SUM_SERVICE;

    public int number1;
    public int number2;
    public int result;

    public int getResult(Integer number1, Integer number2) {

        result = number1 + number2;
        return result;
    }
}
