package by.pvt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDto {

    private Long sensorId;
    private String sensorDate;
    private Long imei;
    private String ipAddress;
    private String location;
    private String sensorName;
    private Long value;
}
