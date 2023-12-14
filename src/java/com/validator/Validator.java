package com.validator;

import com.controller.InitServlet;
import com.errors.ValidationError;

public class Validator extends InitServlet {

    public static void validate(String login, String password, ValidationError error) {

        if (login.trim().length() == 0) {
            error.addError("user.login.error");
        }

        if (password.trim().length() == 0) {
            error.addError("user.pass.error");
        }

    }
}
