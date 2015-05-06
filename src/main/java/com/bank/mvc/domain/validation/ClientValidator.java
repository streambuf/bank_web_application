package com.bank.mvc.domain.validation;

import com.bank.mvc.models.User;
import com.bank.mvc.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ClientValidator {

    @Autowired
    UserService userService;

    public void validate(User user, Errors errors) {
        if (user.getLname() == "test") {
            errors.rejectValue("lname", "validation.negative", "must be real");
        }
    }
}
