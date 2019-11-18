package by.pvt.controller;

import by.pvt.pojo.SensorDto;
import by.pvt.service.DeviceService;
import by.pvt.service.SensorService;
import by.pvt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/device-list")
public class DeviceListController {

    private static Logger log = Logger.getLogger(DeviceListController.class.getName());

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private SensorService sensorService;

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showDevices(Model model, @AuthenticationPrincipal User user) {
        log.info("Calling showDevices");
        log.info("Username=" + user.getUsername());

        model.addAttribute("catalog", deviceService.getAllDevices(user.getUsername()));

        return "deviceList";
    }

    @GetMapping("/device/{imei}")
    public String showSensors(@PathVariable Long imei, Model model) {
        log.info("Call showSensors");
        List<SensorDto> sensorList = sensorService.getSingleSensors(imei);
        if (!sensorList.isEmpty()){
            model.addAttribute("deviceImei", imei);
            model.addAttribute("sensorList", sensorList);

            return "sensorList";

        }else return "sensorListError";
    }

    @GetMapping("/deviceImei/{deviceImei}/sensor/{sensorName}")
    public String showSensorsData(@PathVariable Long deviceImei,
                                  @PathVariable String sensorName, Model model,
                                  @AuthenticationPrincipal User user) {
        log.info("Call showSensorsData");
        if (sensorName.equals("Temperature")) {
            List<SensorDto> cieDataList = sensorService.getSensorsTemperature(deviceImei, sensorName);
            model.addAttribute("cieDataList", cieDataList);
            return "sensorDataTemperature";
        } else if (sensorName.equals("Accelerometer")) {
            List<SensorDto> cieDataList = sensorService.getSensorsAccelerometer(deviceImei, sensorName);
            model.addAttribute("cieDataList", cieDataList);
            return "sensorDataAccelerometer";
        } else return "sensorData";
    }
}
