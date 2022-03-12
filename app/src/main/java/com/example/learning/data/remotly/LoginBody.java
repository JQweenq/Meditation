package com.example.learning.data.remotly;

public class LoginBody {

    public LoginBody(CharSequence email, CharSequence password) {
        this(email.toString(), password.toString());
    }

    public LoginBody(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;
}
