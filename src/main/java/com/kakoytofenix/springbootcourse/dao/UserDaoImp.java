package com.kakoytofenix.springbootcourse.dao;

import com.kakoytofenix.springbootcourse.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void update(User user) {
        if (getUserById(user.getId()) == null) {
            throw new NoSuchElementException("Пользователь с ID " + user.getId() + " не найден.");
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }




    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
