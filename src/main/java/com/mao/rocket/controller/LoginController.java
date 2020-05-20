package com.mao.rocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String index() {
    return "login_index";
  }

  @GetMapping("/admin_login")
  public String admin_index() {
    return "admin_login_index";
  }

  @GetMapping("/register")
  public String registerIndex() {
    return "register_index";
  }

  @GetMapping("/business/info")
  public String info() {
    return "info";
  }

}
