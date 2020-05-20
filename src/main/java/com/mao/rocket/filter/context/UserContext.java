package com.mao.rocket.filter.context;

import com.mao.rocket.model.vo.User;

public class UserContext {
  public static final ThreadLocal<User> USER = ThreadLocal.withInitial(() -> null);
}
