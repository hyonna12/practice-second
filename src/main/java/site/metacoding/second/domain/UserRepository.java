package site.metacoding.second.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UserRepository {

  private final EntityManager em;
  // db에서 들고온 데이터를 자바 오브젝트로 매핑

  public User save(User user) {
    em.persist(user);
    return user;
  }

  public List<User> findAll() {
    List<User> userList = em.createQuery("select u from User u", User.class)
        .getResultList();
    return userList;
  }

  public Optional<User> findById(Integer userId) {
    try {
      Optional<User> userOP = Optional
          .of(em.createQuery("select u from User u where u.userId =:userId", User.class)
              .setParameter("userId", userId)
              .getSingleResult());
      return userOP;
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  public void deleteById(Integer userId) {
    em.createQuery("delete from User u where u.userId = :userId")
        .setParameter("userId", userId)
        .executeUpdate();
  }

  public Optional<User> findByUsername(String username) {
    try {
      Optional<User> userOP = Optional.of(em.createQuery("select u from User u where u.username =:username", User.class)
          .setParameter("username", username)
          .getSingleResult());
      return userOP;
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
