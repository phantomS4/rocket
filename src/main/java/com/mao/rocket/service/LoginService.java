package com.mao.rocket.service;

import com.mao.rocket.model.UserDao;
import com.mao.rocket.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
  @Autowired
  private UserDao userDao;

  public void register(String name, String mobile, String password) {
    User user = new User();
    user.name = name;
    user.mobile = mobile;
    user.password = password;
    userDao.create(user);
  }

  public User login(String mobile, int type) {
    return userDao.getOneByMobile(mobile, type);
  }

  public void update(User user) {
    userDao.update(user);
  }
}
