package viktor.dao;

import viktor.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
