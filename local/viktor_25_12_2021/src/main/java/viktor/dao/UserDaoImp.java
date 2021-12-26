package viktor.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import viktor.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Repository
@Transactional
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT us FROM User us", User.class).getResultList();
    }

    @Transactional
    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {
        em.merge(user);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        user.setId(id);
        em.merge(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        em.createQuery("DELETE FROM User WHERE id=:id").setParameter("id", id).executeUpdate();
    }
}
