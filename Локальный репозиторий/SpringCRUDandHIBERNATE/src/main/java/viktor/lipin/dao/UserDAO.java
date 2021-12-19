package viktor.lipin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import viktor.lipin.model.User;
import viktor.lipin.repositories.UserRepositories;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserDAO {

    private final UserRepositories ur;

    @Autowired
    public UserDAO(UserRepositories ur) {
        this.ur = ur;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        return ur.findAll();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        Optional<User> foundUser = ur.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        ur.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        ur.save(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        ur.deleteById(id);
    }

}
