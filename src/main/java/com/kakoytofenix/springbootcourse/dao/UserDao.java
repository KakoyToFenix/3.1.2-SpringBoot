package com.kakoytofenix.springbootcourse.dao;


import com.kakoytofenix.springbootcourse.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao  {

    public List<User> getAllUsers();

    public void update(User user);
    public void save(User user);

    public User getUserById(Long id);

    public void deleteUser(Long id);
}
