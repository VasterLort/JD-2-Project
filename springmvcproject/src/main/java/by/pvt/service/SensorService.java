package by.pvt.service;

import by.pvt.pojo.SensorDto;
import by.pvt.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class SensorService {

    @Autowired
    SensorRepository sensorRepository;

    @Transactional
    public List<SensorDto> getSingleSensors(Long imei) {
        Long count = 0L;
        List<Object[]> rows = sensorRepository.findSingles(imei);
        List<SensorDto> sensors = new ArrayList<>();
        for (Object[] row : rows) {
            count++;
            sensors.add(new SensorDto(count,
                    row[1].toString(), Long.parseLong(row[2].toString()), row[3].toString(),
                    row[4].toString(), row[5].toString(), Long.parseLong(row[6].toString())));
        }

        return sensors;
    }

    @Transactional
    public List<SensorDto> getSensorsAccelerometer(Long imei, String sensorName) {
        Long count = 0L;
        List<Object[]> rows = sensorRepository.findSensorsResults(imei, sensorName);
        List<SensorDto> sensors = new ArrayList<>();
        for (Object[] row : rows) {
            if (sensorName.equals(row[5].toString())) {
                count++;
                sensors.add(new SensorDto(count,
                        row[1].toString(), Long.parseLong(row[2].toString()), row[3].toString(),
                        row[4].toString(), row[5].toString(), Long.parseLong(row[6].toString())));
            }
        }

        return sensors;
    }

    @Transactional
    public List<SensorDto> getSensorsTemperature(Long imei, String sensorName) {
        Long count = 0L;
        List<Object[]> rows = sensorRepository.findSensorsResults(imei, sensorName);
        List<SensorDto> sensors = new ArrayList<>();
        for (Object[] row : rows) {
            if (sensorName.equals(row[5].toString())) {
                count++;
                sensors.add(new SensorDto(count,
                        row[1].toString(), Long.parseLong(row[2].toString()), row[3].toString(),
                        row[4].toString(), row[5].toString(), Long.parseLong(row[6].toString())));
            }
        }

        return sensors;
    }
}
