package by.pvt.service;

import by.pvt.pojo.AppUser;
import by.pvt.pojo.RoleName;
import by.pvt.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {
    private static Logger log = Logger.getLogger("UserService");

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public boolean saveUser(AppUser user) {
        log.info("Saving user =" + user);

        if (user == null || user.getFirstName().isEmpty() || user.getLastName().isEmpty() ||
                user.getEmail().isEmpty() || user.getPassword().isEmpty() ||
                userRepository.findUserByEmail(user.getEmail()) != null) {
            return false;
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setRoles(Collections.singleton(RoleName.USER));
        user.setPassword(encodedPassword);
        log.info("Encoded password: " + encodedPassword);
        userRepository.save(user);

        return true;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public AppUser findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public AppUser findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }
}
