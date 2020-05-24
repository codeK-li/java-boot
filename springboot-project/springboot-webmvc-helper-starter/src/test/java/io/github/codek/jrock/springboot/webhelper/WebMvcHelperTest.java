package io.github.codek.jrock.springboot.webhelper;

import io.github.codek.jrock.webhelper.WebMvcHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author codeK
 * @since 2019/10/17
 */
class WebMvcHelperTest {
  MockHttpServletRequest request;
  MockHttpServletResponse response;

  @BeforeEach
  void init() {
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();

    ServletRequestAttributes servletRequestAttributes =
        new ServletRequestAttributes(request, response);
    RequestContextHolder.setRequestAttributes(servletRequestAttributes);
  }

  @AfterEach
  void cleanup() {
    RequestContextHolder.resetRequestAttributes();
  }

  @Test
  void should_return_ServletRequestAttributes_request_response() {
    WebMvcHelper helper = new WebMvcHelperImpl();
    assertThat(helper.getRequest()).isEqualTo(request);
    assertThat(helper.getResponse()).isEqualTo(response);
  }

  @Test
  void should_return_cookie_named_aaa() {
    Cookie cookie = new Cookie("aaa", "AAA");
    request.setCookies(cookie);

    WebMvcHelper helper = new WebMvcHelperImpl();
    assertThat(helper.getCookie("aaa")).isEqualTo(cookie);
    assertThat(helper.getCookieValue("aaa")).isEqualTo("AAA");
    assertThat(helper.getCookie("NOT_EXIST")).isNull();
    assertThat(helper.getCookieValue("NOT_EXIST")).isNull();
  }

  @Test
  void should_return_ip_from_x_forwarded_for() {
    final String ip = "111.116.133.44";
    request.addHeader("x-forwarded-for", ip);

    WebMvcHelper helper = new WebMvcHelperImpl();
    assertThat(helper.getClientIp()).isEqualTo(ip);
  }

  @Test
  void should_return_ip_from_Proxy_Client_IP() {
    final String ip = "111.116.133.44";
    request.addHeader("Proxy-Client-IP", ip);
    WebMvcHelper helper = new WebMvcHelperImpl();
    assertThat(helper.getClientIp()).isEqualTo(ip);
  }

  @Test
  void should_return_ip_from_WL_Proxy_Client_IP() {
    String ip = "111.116.133.44";
    String ip2 = ip + ",222.116.133.44";
    request.addHeader("WL-Proxy-Client-IP", ip2);
    WebMvcHelper helper = new WebMvcHelperImpl();
    assertThat(helper.getClientIp()).isEqualTo(ip);
  }

  @Test
  void should_return_ip_from_RemoteAddr() {
    final String ip = "111.116.133.44";
    request.setRemoteAddr(ip);
    WebMvcHelper helper = new WebMvcHelperImpl();
    assertThat(helper.getClientIp()).isEqualTo(ip);
  }

  @Test
  void should_return_true_if_request_by_ajax() {
    WebMvcHelper helper = new WebMvcHelperImpl();
    assertThat(helper.isAjaxRequest()).isFalse();
    request.addHeader("X-Requested-With", "XMLHttpRequest");
    assertThat(helper.isAjaxRequest()).isTrue();
  }

  @Test
  void should_return_aaa_from_request_attribute() {
    WebMvcHelper helper = new WebMvcHelperImpl();
    String attributeValue = helper.getRequestAttribute("aaa");
    assertThat(attributeValue).isNull();
    request.setAttribute("aaa", "AAA");
    attributeValue = helper.getRequestAttribute("aaa");
    assertThat(attributeValue).isEqualTo("AAA");
    helper.setRequestAttribute("aaa", "A22");
    attributeValue = helper.getRequestAttribute("aaa");
    assertThat(attributeValue).isEqualTo("A22");
  }
}
