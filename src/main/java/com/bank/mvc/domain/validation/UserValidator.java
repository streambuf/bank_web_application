package com.bank.mvc.domain.validation;

import com.bank.mvc.models.User;
import com.bank.mvc.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class UserValidator extends AbstractValidator {

    @Autowired
    UserService userService;

    static String fieldPass = "password";
    static String fieldConfirmPass = "confirmPassword";

    public void validate(User user, Map<String, String> errors) {

        this.checkAllFieldsOnEmpty(user, errors);

        // TODO validate all field

        if (!errors.containsKey(fieldPass) && !errors.containsKey(fieldConfirmPass)) {
            String password = user.getPassword();
            String confirmPassword = user.getConfirmPassword();

            if (password.length() < 6) {
                errors.put(fieldPass, "Минимальная длина 6 символов");
            }
            else if (password.length() > 50) {
                errors.put(fieldPass, "Максимальная длина 50 символов");
            }
            else if (!password.equals(confirmPassword)) {
                errors.put(fieldConfirmPass, "Пароли не совпадают");
            }
        }

        errors.remove("username");

    }
}
