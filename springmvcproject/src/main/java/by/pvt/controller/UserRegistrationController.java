package by.pvt.controller;

import by.pvt.component.UserValidator;
import by.pvt.pojo.AppUser;
import by.pvt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private static Logger log = Logger.getLogger("UserRegistrationController");

    @Autowired
    UserService userService;

    @Autowired
    UserValidator validator;

    @GetMapping
    public ModelAndView showRegistrationForm(Model model) {
        ModelAndView view = new ModelAndView();
        view.setViewName("registration");

        return view;
    }

    @PostMapping
    public String registerForm(
            @ModelAttribute AppUser appUser,
            BindingResult result, Model model
    ) {
        validator.validate(appUser, result);
        if (result.hasErrors()) {
            model.addAttribute("errorsOfUser", result.getAllErrors());
            result.getAllErrors().forEach(objectError -> log.info(objectError.getDefaultMessage()));
            return "registration";
        }

        if (userService.saveUser(appUser)) {
            return "redirect:/login";
        } else {
            return "registrationError";
        }
    }
}
