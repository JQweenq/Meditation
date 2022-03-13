package com.example.learning.cummon;

public final class EmailValidator {
    public static boolean isValidEmail(String target) {
        return (!target.isEmpty() && target.matches("^[A-Za-z.]+@[A-z]+.?[A-Za-z]{2,3}"));
    }
}
