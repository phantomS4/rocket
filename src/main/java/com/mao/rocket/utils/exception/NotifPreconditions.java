package com.mao.rocket.utils.exception;

public class NotifPreconditions {
  private NotifPreconditions() {
  }

  public static void checkArgument(boolean expression, NotifExceptionType exceptionType) {
    if (!expression) {
      throw new NotifException(exceptionType);
    }
  }

  public static void checkArgument(boolean expression, NotifExceptionType exceptionType, Object errorMessage) {
    if (!expression) {
      throw new NotifException(exceptionType, String.valueOf(errorMessage));
    }
  }

  public static void checkArgument(boolean expression, NotifExceptionType exceptionType,
                                   String errorMessageTemplate, Object... errorMessageArgs) {
    if (!expression) {
      throw new NotifException(exceptionType,
          format(errorMessageTemplate, errorMessageArgs));
    }
  }

  public static void checkState(boolean expression) {
    checkArgument(expression, NotifExceptionType.COMMON_ILLEGAL_STATE);
  }

  public static void checkState(boolean expression, Object errorMessage) {
    checkArgument(expression, NotifExceptionType.COMMON_ILLEGAL_STATE, errorMessage);
  }

  public static void checkState(boolean expression,
                                String errorMessageTemplate, Object... errorMessageArgs) {
    checkArgument(expression, NotifExceptionType.COMMON_ILLEGAL_STATE, errorMessageTemplate, errorMessageArgs);
  }

  public static void checkState(boolean expression, NotifExceptionType exceptionType) {
    if (!expression) {
      throw new NotifException(exceptionType);
    }
  }

  public static void checkState(boolean expression, NotifExceptionType exceptionType, Object errorMessage) {
    if (!expression) {
      throw new NotifException(exceptionType, String.valueOf(errorMessage));
    }
  }

  public static void checkState(boolean expression, NotifExceptionType exceptionType,
                                String errorMessageTemplate, Object... errorMessageArgs) {
    if (!expression) {
      throw new NotifException(exceptionType,
          format(errorMessageTemplate, errorMessageArgs));
    }
  }

  public static <T> T checkNotNull(T reference) {
    if (reference == null) {
      throw new NotifException(NotifExceptionType.COMMON_NULL_POINT);
    }
    return reference;
  }

  public static <T> T checkNotNull(T reference, Object errorMessage) {
    if (reference == null) {
      throw new NotifException(NotifExceptionType.COMMON_NULL_POINT, String.valueOf(errorMessage));
    }
    return reference;
  }

  public static <T> T checkNotNull(T reference, String errorMessageTemplate,
                                   Object... errorMessageArgs) {
    if (reference == null) {
      throw new NotifException(NotifExceptionType.COMMON_NULL_POINT,
          format(errorMessageTemplate, errorMessageArgs));
    }
    return reference;
  }

  public static <T> T checkNotNull(T reference, NotifExceptionType exceptionType) {
    if (reference == null) {
      throw new NotifException(exceptionType);
    }
    return reference;
  }

  public static <T> T checkNotNull(T reference, NotifExceptionType exceptionType, Object errorMessage) {
    if (reference == null) {
      throw new NotifException(exceptionType, String.valueOf(errorMessage));
    }
    return reference;
  }

  public static <T> T checkNotNull(T reference, NotifExceptionType exceptionType, String errorMessageTemplate,
                                   Object... errorMessageArgs) {
    if (reference == null) {
      throw new NotifException(exceptionType,
          format(errorMessageTemplate, errorMessageArgs));
    }
    return reference;
  }

  // copy from guava precondition
  static String format(String template, Object... args) {
    // start substituting the arguments into the '%s' placeholders
    StringBuilder builder = new StringBuilder(
        template.length() + 16 * args.length);
    int templateStart = 0;
    int i = 0;
    while (i < args.length) {
      int placeholderStart = template.indexOf("%s", templateStart);
      if (placeholderStart == -1) {
        break;
      }
      builder.append(template.substring(templateStart, placeholderStart));
      builder.append(args[i++]);
      templateStart = placeholderStart + 2;
    }
    builder.append(template.substring(templateStart));

    // if we run out of placeholders, append the extra args in square braces
    if (i < args.length) {
      builder.append(" [");
      builder.append(args[i++]);
      while (i < args.length) {
        builder.append(", ");
        builder.append(args[i++]);
      }
      builder.append("]");
    }

    return builder.toString();
  }
}
