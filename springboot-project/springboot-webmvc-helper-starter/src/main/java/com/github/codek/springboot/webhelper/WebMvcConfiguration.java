package com.github.codek.springboot.webhelper;

import com.github.codek.javaboot.webhelper.WebMvcHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebMvc 模块的启动项
 *
 * @author liweichao11
 * @since 2018/3/16
 */
@ConditionalOnClass(DispatcherServlet.class)
@ConditionalOnMissingBean(RequestContextListener.class)
@Configuration
@ComponentScan
class WebMvcConfiguration {

  @Order(Ordered.HIGHEST_PRECEDENCE)
  @Bean
  public RequestContextListener requestContextListener() {
    return new RequestContextListener();
  }

  @Bean
  public WebMvcHelper webHelper() {
    return new WebMvcHelperImpl();
  }
}
