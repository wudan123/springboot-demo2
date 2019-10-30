package com.offcn.controller;

import com.offcn.dao.UserDao;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;


    @GetMapping("/findAll")
    public String findAll(Model model){

        List<User> list = userDao.findAll();
        model.addAttribute("userList",list);

        return "/user/list";
    }

    @RequestMapping("/add")
    public String add(User user){

        userDao.save(user);

        return "redirect:/findAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        userDao.deleteById(id);

        return "redirect:/findAll";
    }

    @RequestMapping("/update")
    public String update(User user){
        userDao.saveAndFlush(user);

        return "redirect:/findAll";
    }

    @GetMapping("/toUpdate/{id}")
    public String findOne(@PathVariable("id")long id,Model model){

        User user = userDao.findByIdIs(id);
        model.addAttribute("user",user);

        return "user/userEdit";
    }

    @GetMapping("/toAdd")
    public String toAdd(){

        return "user/userAdd";
    }

}
