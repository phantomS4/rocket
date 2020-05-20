package com.mao.rocket.controller;

import com.mao.rocket.model.UserDao;
import com.mao.rocket.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

  @Autowired
  private UserDao userDao;

  @GetMapping("/list")
  public List<User> list(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
    System.out.println("offset : " + offset + " limit : " + limit);
    return userDao.list(limit, offset);
  }

  @GetMapping("/{id}")
  public User getById(@PathVariable("id") long id) {
    return userDao.getOne(id);
  }

  @PostMapping("/create")
  public void create(@RequestBody User user) {
    userDao.create(user);
  }

  @PutMapping("/update")
  public void update(@RequestBody User user) {
    userDao.update(user);
  }

}
