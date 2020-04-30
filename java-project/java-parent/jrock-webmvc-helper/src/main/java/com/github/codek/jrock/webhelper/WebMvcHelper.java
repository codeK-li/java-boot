package com.github.codek.jrock.webhelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author codeK
 * @since 2019/10/17
 */
public interface WebMvcHelper {
  /** Ajax 请求的头域 */
  String AJAX_HEADER = "X-Requested-With";
  /** Ajax 请求的头域的值 */
  String AJAX_HEADER_VALUE = "XMLHttpRequest";

  /**
   * 返回当前线程绑定的 {@link HttpServletRequest} 对象
   *
   * @return {@link HttpServletRequest} 对象
   */
  HttpServletRequest getRequest();

  /**
   * 获取当前线程中的 {@link HttpServletResponse} 对象
   *
   * @return {@link HttpServletResponse} 对象
   */
  HttpServletResponse getResponse();

  /**
   * 从当前线程的 {@link HttpServletRequest} 对象中获取客户端的IP地址
   *
   * @return {@link HttpServletRequest} 对象中获取客户端的IP地址
   */
  String getClientIp();

  /**
   * 判断当前线程的 {@link HttpServletRequest} 是否是Ajax请求
   *
   * @return {@link HttpServletRequest} 是否是Ajax请求
   */
  boolean isAjaxRequest();

  /**
   * 根据名称，从当前线程的 {@link HttpServletRequest} 对象中获取 {@link Cookie}
   *
   * @param name Cookie的名称
   * @return {@link HttpServletRequest} 对象中获取 {@link Cookie}
   */
  Cookie getCookie(String name);

  /**
   * 根据名称，从当前线程的 {@link HttpServletRequest} 对象中获取Cookie的值
   *
   * @param name Cookie的名称
   * @return {@link HttpServletRequest} 对象中获取Cookie的值
   */
  String getCookieValue(String name);

  /**
   * 设置 {@link HttpServletRequest} 范围的属性值
   *
   * @param name 属性名
   * @param value 属性值
   * @param <T> 属性值的类型
   */
  <T> void setRequestAttribute(String name, T value);

  /**
   * 获取 {@link HttpServletRequest} 范围的属性值
   *
   * @param name 属性名
   * @param <T> 属性值的类型
   * @return 属性值
   */
  <T> T getRequestAttribute(String name);
}
