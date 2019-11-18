package by.pvt.repository;

import by.pvt.pojo.AppDevice;
import by.pvt.pojo.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class DeviceRepository {

    private static Logger log = Logger.getLogger("DeviceRepository");

    @Autowired
    private SessionFactory sessionFactory;

    public boolean add(AppDevice device) {
        sessionFactory.getCurrentSession().persist(device);
        return true;
    }

    public List<AppDevice> findAll(AppUser appUser) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from AppDevice where user like :param1", AppDevice.class)
                    .setParameter("param1", appUser)
                    .list();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }

    public AppDevice findDeviceById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(AppDevice.class, id);
    }
}
