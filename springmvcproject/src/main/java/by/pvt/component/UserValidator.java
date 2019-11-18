package by.pvt.component;

import by.pvt.pojo.AppUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AppUser.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppUser user = (AppUser) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required",
                "Email name must not be empty");
        if (user.getFirstName().length() == 0) {
            errors.rejectValue("firstName", "firstName.length",
                    "First name is empty");
        }

        if (user.getLastName().length() == 0) {
            errors.rejectValue("lastName", "lastName.length",
                    "Last name is empty");
        }

        if (user.getPassword().length() == 0) {
            errors.rejectValue("password", "password.length",
                    "Password is empty");
        }
    }
}
