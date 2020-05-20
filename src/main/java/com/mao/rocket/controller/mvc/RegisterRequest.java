package com.mao.rocket.controller.mvc;

public class RegisterRequest {
  public String name;
  public String mobile;
  public String password;
  public String confirmPassword;

  @Override
  public String toString() {
    return "RegisterRequest{" +
        "name='" + name + '\'' +
        ", mobile='" + mobile + '\'' +
        ", password='" + password + '\'' +
        ", confirmPassword='" + confirmPassword + '\'' +
        '}';
  }
}
