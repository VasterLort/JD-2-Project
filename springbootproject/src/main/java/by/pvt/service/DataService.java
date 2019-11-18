package by.pvt.service;

import by.pvt.controller.DataCmd;
import by.pvt.pojo.AppData;
import by.pvt.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataService {

    @Autowired
    private DataRepository sensorRepository;

    public void createNewSensor(DataCmd newDataCmd) {
        if(newDataCmd != null && (newDataCmd.getSensorsName().equals("Accelerometer") && newDataCmd.getValue() >= 0 || newDataCmd.getSensorsName().equals("Temperature")))
        {
            AppData data = new AppData();
            data.setImei(newDataCmd.getImei());
            data.setSensorName(newDataCmd.getSensorsName());
            data.setValue(newDataCmd.getValue());
            data.setLocation(newDataCmd.getLocation());
            data.setIpAddress(newDataCmd.getIpAddress());
            data.setDateNow(new Date().toString());

            sensorRepository.save(data);
        }
    }
}
