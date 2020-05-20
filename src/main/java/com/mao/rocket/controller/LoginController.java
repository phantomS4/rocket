package com.mao.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qqy
 * @date 2020-05-13 09:10
 */
@Controller
public class LoginController {

  @GetMapping("/login")
  public String index() {
    return "login_index";
  }

  @GetMapping("/register")
  public String registerIndex() {
    return "register_index";
  }

}
