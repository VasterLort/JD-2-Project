package by.pvt.service;

import by.pvt.pojo.AppDevice;
import by.pvt.pojo.AppUser;
import by.pvt.pojo.SensorDto;
import by.pvt.repository.AppUserRepository;
import by.pvt.repository.DeviceRepository;
import by.pvt.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    SensorRepository sensorRepository;


    @Transactional
    public boolean addDevice(AppDevice device, String userName) {
        if (device.getImei() == null || device.getImei() <= 0 || device.getDeviceName() == null ||
                device.getCountry() == null || device.getCountry().isEmpty()) {
            return false;
        }

        AppUser appUser = appUserRepository.findUserByEmail(userName);

        if (appUser == null) {
            return false;
        }else device.setUser(appUser);

        return deviceRepository.add(device);
    }

    @Transactional
    public List<AppDevice> getAllDevices(String userName) {
        AppUser appUser = appUserRepository.findUserByEmail(userName);

        return deviceRepository.findAll(appUser);
    }

    @Transactional
    public AppDevice findDevice(Long id) {
        return deviceRepository.findDeviceById(id);
    }
}
