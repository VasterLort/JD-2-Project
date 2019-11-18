package by.pvt.controller;


import by.pvt.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class DataController {

    Logger log = Logger.getLogger("DataController");

    @Autowired
    DataService service;

    @PostMapping("/data")
    public void createNewSensor(@RequestBody DataCmd newDataCmd) {
        service.createNewSensor(newDataCmd);
        log.info("New sensor: " + newDataCmd);
    }
}
