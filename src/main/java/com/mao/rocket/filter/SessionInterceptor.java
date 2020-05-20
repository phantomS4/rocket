package com.mao.rocket.filter;

import com.mao.rocket.filter.context.UserContext;
import com.mao.rocket.model.vo.User;
import com.mao.rocket.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor extends HandlerInterceptorAdapter {
  private Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String uri = request.getRequestURI();
    logger.info("url:" + uri);
    if (!uri.matches("/business/(.*)")) {
      logger.info("not matheres");
      return super.preHandle(request, response, handler);
    }

    HttpSession session = request.getSession();
    logger.info("uri = " + request.getRequestURI());
    logger.info("sessionId = " + session.getAttribute("userId"));
    if (session.getAttribute("userId") == null) {
      response.sendRedirect("/login");
      return false;
    }
    UserContext.USER.set(JsonUtils.from(session.getAttribute("user").toString(), User.class));
    return super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                         @Nullable ModelAndView modelAndView) throws Exception {
    if (modelAndView != null) {
      modelAndView.getModelMap().put("user", UserContext.USER.get());
    }
    UserContext.USER.remove();
    super.postHandle(request, response, handler, modelAndView);
  }
}
