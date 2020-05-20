package com.mao.rocket.controller;

import com.mao.rocket.controller.mvc.RegisterRequest;
import com.mao.rocket.service.LoginService;
import com.mao.rocket.utils.exception.NotifException;
import com.mao.rocket.utils.exception.NotifExceptionType;
import com.mao.rocket.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author qqy
 * @date 2020-05-17 21:23
 */
@RestController
public class DoLoginController {
  @Autowired
  private LoginService loginService;

  @PostMapping("/do_register")
  public void doRegister(@RequestBody RegisterRequest request) {
    if (!request.password.equals(request.confirmPassword)) {
      throw new NotifException(NotifExceptionType.COMMON_SERVER_ERROR, "密码不匹配");
    }

    loginService.register(request.name, request.mobile, request.password);
  }

  @PostMapping("/do_login")
  public void doLogin(@RequestBody RegisterRequest request, HttpServletRequest httpServletRequest) {
    User user = loginService.login(request.mobile, 0);
    if(user == null) {
      throw new NotifException(NotifExceptionType.COMMON_SERVER_ERROR, "user not exists");
    }
    HttpSession session = httpServletRequest.getSession();
    session.setAttribute("userId", user.id);
  }
}
