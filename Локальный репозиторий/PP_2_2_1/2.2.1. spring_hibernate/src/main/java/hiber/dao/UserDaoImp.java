package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String mod, int ser) {
      TypedQuery<User> query = null;
      query = sessionFactory.getCurrentSession().createQuery("FROM User where car.model =:param1 and car.series =:param2");
      query.setParameter("param1", mod);
      query.setParameter("param2", ser);
      return query.getSingleResult();
   }
}
