package by.pvt.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataCmd implements Serializable {

    private Long imei;
    private String sensorsName;
    private long value;
    private String location;
    private String ipAddress;
}
