package by.pvt.controller;

import by.pvt.component.DeviceValidator;
import by.pvt.pojo.AppDevice;
import by.pvt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/add-device")
public class AddDeviceController {

    private static Logger log = Logger.getLogger("AddDeviceController");

    @Autowired
    DeviceService deviceService;

    @Autowired
    DeviceValidator validator;

    @GetMapping
    public ModelAndView showAddDeviceView() {
        ModelAndView view = new ModelAndView();
        view.setViewName("addDevice");

        return view;
    }

    @PostMapping
    public String submitAddDeviceForm(
            @ModelAttribute AppDevice device,
            BindingResult result, Model model
    ) throws IOException {
        validator.validate(device, result);
        if (result.hasErrors()) {
            model.addAttribute("errorsOfDevice", result.getAllErrors());
            result.getAllErrors().forEach(objectError -> log.info(objectError.getDefaultMessage()));
            return "addDevice";
        }

        log.info("Call submitAddDeviceForm: " + device);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("Username=" + user.getUsername());

        if (!deviceService.addDevice(device, user.getUsername())) {
            return "addDeviceError";
        }

        return "addDeviceOk";
    }
}
