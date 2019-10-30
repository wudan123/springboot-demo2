package com.offcn.dao;

import com.offcn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    @Query("select u from User u")
    public List<User> findAll();

    @Query("select u from User u where u.id=:id")
    public User findOne(@Param("id")long id);


    public User findByIdIs(Long id);

    public void deleteById(Long id);
}
