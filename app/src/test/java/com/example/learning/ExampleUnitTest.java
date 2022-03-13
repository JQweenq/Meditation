package com.example.learning;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.learning.cummon.EmailValidator;

public class ExampleUnitTest {
    public EmailValidator validator = new EmailValidator();

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void emailValidationIsCorrect(){
        boolean value = validator.isValidEmail("qwe@exemple.com")

        assertTrue(value);
    }
}