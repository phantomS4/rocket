package com.mao.rocket.controller;

import com.mao.rocket.controller.mvc.RegisterRequest;
import com.mao.rocket.filter.context.UserContext;
import com.mao.rocket.model.vo.User;
import com.mao.rocket.service.LoginService;
import com.mao.rocket.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class DoLoginController {
  @Autowired
  private LoginService loginService;

  @PostMapping("/do_register")
  public void doRegister(@RequestBody RegisterRequest request) {
    if (!request.password.equals(request.confirmPassword)) {
      throw new RuntimeException("密码不匹配");
    }

    loginService.register(request.name, request.mobile, request.password);
  }

  @PostMapping("/do_login")
  public void doLogin(@RequestBody RegisterRequest request, HttpServletRequest httpServletRequest) {
    login(httpServletRequest, request.mobile, 0);
  }

  @PostMapping("/business/do_update")
  public void doUpdate(@RequestBody RegisterRequest request, HttpServletRequest httpServletRequest) {
    User user = new User();
    user.id = UserContext.USER.get().id;
    user.name = request.name;
    user.mobile = request.mobile;
    user.password = request.password;
    loginService.update(user);
  }

  @PostMapping("/admin_do_login")
  public void adminDoLogin(@RequestBody RegisterRequest request, HttpServletRequest httpServletRequest) {
    login(httpServletRequest, request.mobile, 1);
  }

  public void login(HttpServletRequest httpServletRequest, String mobile, int type) {
    User user = loginService.login(mobile, type);
    if(user == null) {
      throw new RuntimeException("user not exists");
    }
    HttpSession session = httpServletRequest.getSession();
    session.setAttribute("userId", user.id);
    session.setAttribute("user", JsonUtils.toString(user));
  }
}
