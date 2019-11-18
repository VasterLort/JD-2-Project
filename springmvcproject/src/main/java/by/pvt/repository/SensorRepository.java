package by.pvt.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class SensorRepository {

    private static Logger log = Logger.getLogger("SensorRepository");

    @Autowired
    private SessionFactory sessionFactory;

    public List findAll(Long imei) {
        try {
            return sessionFactory.getCurrentSession()
                    .createSQLQuery("select id, date_now, imei, ip_address, location, sensor_name, value  from appsensor where imei = " + imei)
                    .list();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }

    public List findSingles(Long imei) {
        try {
            return sessionFactory.getCurrentSession()
                    .createSQLQuery("select id, date_now, imei, ip_address, location, sensor_name, value  " +
                            "from appsensor where imei = " + imei + " GROUP BY(sensor_name)")
                    .list();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }

    public List findSensorsResults(Long imei, String sensorName) {
        try {
            return sessionFactory.getCurrentSession()
                    .createSQLQuery("select id, date_now, imei, ip_address, location, sensor_name, value  " +
                            "from appsensor where imei = " + imei)
                    .list();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }
}
