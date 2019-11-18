package by.pvt.component;

import by.pvt.pojo.AppDevice;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DeviceValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AppDevice.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppDevice device = (AppDevice) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imei", "field.required",
                "Imei name must not be empty");
        if (device.getImei() == null || device.getImei().toString().length() != 8) {
            errors.rejectValue("imei", "imei.value",
                    "Imei must have eight digits");
        }
        if (device.getCountry().length() == 0) {
            errors.rejectValue("country", "country.length",
                    "Country name is empty");
        }
        if (device.getDeviceName().length() == 0) {
            errors.rejectValue("deviceName", "deviceName.length",
                    "Device name is empty");
        }
    }
}
