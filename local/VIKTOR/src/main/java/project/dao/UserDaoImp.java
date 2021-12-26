package project.dao;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Repository
@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT us FROM User us", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User findOne(int id) {
        TypedQuery<User> showUserById = em.createQuery("SELECT us FROM User us WHERE us.id=:id", User.class);
        return showUserById.setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public void save(User user) {
        em.merge(user);
    }

    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        em.merge(updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        em.remove(id);
    }
}
