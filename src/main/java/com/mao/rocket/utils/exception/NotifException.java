package com.mao.rocket.utils.exception;

public class NotifException extends RuntimeException {

  public NotifExceptionType exceptionType;
  public String detail;

  public NotifException(NotifExceptionType exceptionType, String detail) {
    super(detail);
    initException(exceptionType, detail);
  }

  public NotifException(NotifExceptionType exceptionType) {
    super("");
    initException(exceptionType);
  }

  public NotifException(NotifExceptionType exceptionType, Throwable t) {
    super("", t);
    initException(exceptionType);
  }

  public NotifException(NotifExceptionType exceptionType, String detail, Throwable t) {
    super(detail, t);
    initException(exceptionType, detail);
  }

  private void initException(NotifExceptionType exceptionType) {
    initException(exceptionType, "");
  }

  private void initException(NotifExceptionType exceptionType, String detail) {
    this.exceptionType = exceptionType;
    this.detail = detail;
  }

  public static NotifException wrap(Throwable e) {
    return wrap(e, NotifExceptionType.COMMON_SERVER_ERROR);
  }

  public static NotifException wrap(Throwable e, String detail) {
    return wrap(e, NotifExceptionType.COMMON_SERVER_ERROR, detail);
  }

  public static NotifException wrap(Throwable e, NotifExceptionType exceptionType) {
    return wrap(e, exceptionType, "");
  }

  public static NotifException wrap(Throwable e, NotifExceptionType exceptionType, String detail) {
    return new NotifException(exceptionType, detail, e);
  }
}
