package com.mao.rocket.config;

import com.mao.rocket.filter.RequestResponseLoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qqy
 * @date 2020-05-13 22:07
 */
@Configuration
public class RocketConfiguration {
  @Bean
  public FilterRegistrationBean maskedRequestResponseFilterBean() {
    FilterRegistrationBean bean = new FilterRegistrationBean();
    RequestResponseLoggingFilter filter = new RequestResponseLoggingFilter();
    filter.setMaxRequestLoggingLength(1000);
    filter.setMaxResponseLoggingLength(1000);
    bean.setFilter(filter);
    return bean;
  }
}
