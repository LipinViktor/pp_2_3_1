package project.dao;

import project.model.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public User findOne(int id);
    public void save(User user);
    public void update(int id, User updatedUser);
    public void delete(int id);
}
