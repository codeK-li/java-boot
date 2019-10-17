package com.github.javaboot.webhelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author liweichao11
 * @date 2019/10/17
 */
public interface WebMvcHelper {
  /** Ajax 请求的头域 */
  String AJAX_HEADER = "X-Requested-With";
  /** Ajax 请求的头域的值 */
  String AJAX_HEADER_VALUE = "XMLHttpRequest";

  /**
   * 返回当前线程绑定的 ServletRequestAttributes 对象
   *
   * @return
   */
  ServletRequestAttributes getServletRequestAttributes();

  /** @return */
  HttpServletRequest getRequest();

  /**
   * 获取当前线程中的 HttpServletResponse 对象
   *
   * @return
   */
  HttpServletResponse getResponse();

  /**
   * 从当前线程的 HttpServletRequest 对象中获取客户端的IP地址
   *
   * @return
   */
  String getClientIp();

  /**
   * 判断当前线程的 HttpServletRequest 是否是Ajax请求
   *
   * @return
   */
  boolean isAjaxRequest();

  /**
   * 根据名称，从当前线程的 HttpServletRequest 对象中获取Cookie
   *
   * @param name Cookie的名称
   * @return
   */
  Cookie getCookie(String name);

  /**
   * 根据名称，从当前线程的 HttpServletRequest 对象中获取Cookie的值
   *
   * @param name
   * @return
   */
  String getCookieValue(String name);

  /**
   * 设置 request 范围的属性值
   *
   * @param name
   * @param value
   * @param <T>
   */
  <T> void setRequestAttribute(String name, T value);

  /**
   * 获取 request 范围的属性值
   *
   * @param name
   * @param <T>
   * @return
   */
  <T> T getRequestAttribute(String name);
}
