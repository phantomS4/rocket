package com.mao.rocket.utils.exception;

public enum NotifExceptionLevel {
  WARNING(0, "warn"),
  ERROR(1, "error");

  public int code;
  public String text;

  NotifExceptionLevel(int code, String text) {
    this.code = code;
    this.text = text;
  }
}
