package com.github.javaboot.webhelper;

import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author liweichao11
 * @date 2019/10/17
 */
public class WebMvcHelperImpl implements WebMvcHelper {

  private static final String UNKNOWN_IP = "unknown";
  private static String[] IP_HEADERS =
      new String[] {"x-forwarded-for", "Proxy-Client-IP", "WL-Proxy-Client-IP"};

  @Override
  public ServletRequestAttributes getServletRequestAttributes() {
    ServletRequestAttributes servletRequestAttributes = null;
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

    if (requestAttributes != null) {
      if (requestAttributes instanceof ServletRequestAttributes) {
        servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
      }
    }

    Objects.requireNonNull(
        servletRequestAttributes, "no ServletRequestAttributes banded in the thread.");
    return servletRequestAttributes;
  }

  @Override
  public HttpServletRequest getRequest() {
    ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
    return servletRequestAttributes.getRequest();
  }

  @Override
  public HttpServletResponse getResponse() {
    ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
    return servletRequestAttributes.getResponse();
  }

  @Override
  public Cookie getCookie(String name) {
    HttpServletRequest servletRequest = getRequest();
    Cookie[] cookies = servletRequest.getCookies();
    if (cookies != null && cookies.length > 0) {
      for (Cookie cookie : cookies) {
        String cookieName = cookie.getName();
        if (cookieName.equals(name)) {
          return cookie;
        }
      }
    }
    return null;
  }

  @Override
  public String getCookieValue(String name) {
    Cookie cookie = getCookie(name);
    if (cookie != null) {
      return cookie.getValue();
    } else {
      return null;
    }
  }

  @Override
  public String getClientIp() {
    HttpServletRequest servletRequest = getRequest();
    String ip = servletRequest.getRemoteAddr();
    for (String header : IP_HEADERS) {
      String ipValue = servletRequest.getHeader(header);
      if (isIpValue(ipValue)) {
        ip = getFirst(ipValue);
        break;
      }
    }

    return ip;
  }

  private boolean isIpValue(String ip) {
    return ip != null && !UNKNOWN_IP.equalsIgnoreCase(ip);
  }

  private String getFirst(String ip) {
    if (ip != null) {
      // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
      int position = ip.indexOf(",");
      if (position > 0) {
        ip = ip.substring(0, position);
      }
    }
    return ip;
  }

  @Override
  public boolean isAjaxRequest() {
    HttpServletRequest request = getRequest();
    return AJAX_HEADER_VALUE.equalsIgnoreCase(request.getHeader(AJAX_HEADER));
  }

  @Override
  public <T> T getRequestAttribute(String name) {
    HttpServletRequest servletRequest = getRequest();
    return (T) servletRequest.getAttribute(name);
  }

  @Override
  public <T> void setRequestAttribute(String name, T value) {
    HttpServletRequest servletRequest = getRequest();
    servletRequest.setAttribute(name, value);
  }
}
