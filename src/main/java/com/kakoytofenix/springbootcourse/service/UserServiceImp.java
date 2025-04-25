package com.kakoytofenix.springbootcourse.service;

import com.kakoytofenix.springbootcourse.dao.UserDao;
import com.kakoytofenix.springbootcourse.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        if (getUserById(user.getId()) == null) {
            throw new NoSuchElementException("Пользователь с ID " + user.getId() + " не найден.");
        } else {
            userDao.update(user);
        }
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
