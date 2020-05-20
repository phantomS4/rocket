package com.mao.rocket.utils.exception;

public enum NotifExceptionType {

  COMMON_SERVER_ERROR(10001, NotifExceptionLevel.ERROR),
  COMMON_ILLEGAL_STATE(10002, NotifExceptionLevel.ERROR),
  COMMON_NULL_POINT(10003, NotifExceptionLevel.ERROR),
  PROVIDER_NOT_FOUND(10004, NotifExceptionLevel.ERROR),
  COMMON_ILLEGAL_PARAM(10005, NotifExceptionLevel.ERROR),

  // sms
  SMS_COMMON_ERROR(11001, NotifExceptionLevel.ERROR),
  MOBILE_SEND_SMS_COMMON_ERROR(11002, NotifExceptionLevel.ERROR),
  MOBILE_SEND_SMS_HTTP_ERROR(11003, NotifExceptionLevel.ERROR),
  VERIFY_CODE_EXPIRED(11004, NotifExceptionLevel.WARNING),
  VERIFY_CODE_ERROR(11005, NotifExceptionLevel.WARNING),
  SMS_PROVIDER_NOT_EXISTS(11006, NotifExceptionLevel.ERROR),
  NO_SMS_PROVIDER_AVAILABLE(11007, NotifExceptionLevel.ERROR),
  VERIFY_CODE_TOO_FAST(11008, NotifExceptionLevel.WARNING),
  VERIFY_COUNT_EXCEED_LIMIT(11009, NotifExceptionLevel.WARNING),
  EMPTY_MOBILE_NUMBER(11010, NotifExceptionLevel.ERROR),
  EMPTY_CONTENT(11011, NotifExceptionLevel.ERROR),
  SMS_STATUS_QUERY_COMMON_ERROR(11012, NotifExceptionLevel.ERROR),
  NO_SMS_TEMPLATE_EXISTS(11013, NotifExceptionLevel.ERROR),
  SMS_UNSUBSCRIBED(11014, NotifExceptionLevel.WARNING),
  SMS_REPLY_QUERY_COMMON_ERROR(11015, NotifExceptionLevel.ERROR),
  SEND_SMS_PROVIDER_ERROR(11016, NotifExceptionLevel.ERROR),

  // push
  PUSH_COMMON_ERROR(12000, NotifExceptionLevel.ERROR),
  PUSH_CONNECTION_ERROR(12001, NotifExceptionLevel.ERROR),
  PUSH_CLIENT_ID_NOT_FOUND(12002, NotifExceptionLevel.ERROR),
  PUSH_CREATE_GETUI_MESSAGE_FAIL(12003, NotifExceptionLevel.ERROR),
  PUSH_RESULT_COMMON_ERROR(12004, NotifExceptionLevel.ERROR),
  PUSH_EXECUTION_ERROR(12005, NotifExceptionLevel.ERROR),
  PUSH_STATUS_QUERY_ERROR(12006, NotifExceptionLevel.ERROR),

  // strategy
  ILLEGAL_INTERVAL_ERROR(13001, NotifExceptionLevel.WARNING),
  NOT_ENOUGH_INTERVAL_ERROR(13002, NotifExceptionLevel.WARNING),

  // http
  COMMON_HTTP_ERROR(14001, NotifExceptionLevel.ERROR),

  // app
  DUPLICATE_APP_ERROR(15001, NotifExceptionLevel.WARNING),
  DUPLICATE_SMS_PROVIDER_ERROR(15002, NotifExceptionLevel.WARNING),
  SMS_PROVIDER_MARKETING_NOT_SUPPORTED(15003, NotifExceptionLevel.ERROR),
  UPDATE_SMS_PROVIDER_ERROR(15004, NotifExceptionLevel.ERROR),

  // notification
  UNKNOWN_NOTIFICATION_DETAIL_TYPE(16001, NotifExceptionLevel.ERROR),

  // notification status
  UNKNOWN_NOTIFICATION_SUBMISSION_STATUS(17001, NotifExceptionLevel.ERROR),
  UNKNOWN_NOTIFICATION_QUERY_STATUS(17002, NotifExceptionLevel.ERROR),
  EMPTY_MSGID(17003, NotifExceptionLevel.WARNING),
  UNKNOWN_NOTIFICATION_STATUS(17004, NotifExceptionLevel.ERROR),

  // ivr notification
  IVR_COMMON_ERROR(18001, NotifExceptionLevel.ERROR),
  IVR_NOT_EXCEPT_RESULT_ERROR(18002, NotifExceptionLevel.ERROR),
  IVR_PROVIDER_NOT_EXISTS(18003, NotifExceptionLevel.ERROR),
  IVR_PROVIDER_NOT_IMPLEMENT_METHOD(18004, NotifExceptionLevel.ERROR),

  // wechat notification
  OPENID_NOT_FOUND(19001, NotifExceptionLevel.ERROR),

  //telCheck notification
  TEL_CHECK_SEND_ERROR(20001, NotifExceptionLevel.ERROR),
  TEL_CHECK_QUERY_ERROR(20002, NotifExceptionLevel.ERROR),

  // MYSQL
  DUPLICATE_PARTITION_NAME(21001, NotifExceptionLevel.ERROR),
  PARTITION_NOT_EXIST(21002, NotifExceptionLevel.ERROR),

  ;

  public int code;
  public NotifExceptionLevel level;

  NotifExceptionType(int code, NotifExceptionLevel level) {
    this.code = code;
    this.level = level;
  }

  public static NotifExceptionType findByValue(int value) {
    for (NotifExceptionType type : NotifExceptionType.values()) {
      if (type.code == value) {
        return type;
      }
    }
    return null;
  }
}
