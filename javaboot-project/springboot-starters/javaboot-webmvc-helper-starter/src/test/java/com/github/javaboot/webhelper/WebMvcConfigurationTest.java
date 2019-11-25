package com.github.javaboot.webhelper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
    classes = {
      WebMvcConfiguration.class,
      WebMvcConfigurationTest.class,
      WebMvcConfigurationTest.C.class
    })
@ExtendWith(SpringExtension.class)
@ContextConfiguration
@AutoConfigureMockMvc
class WebMvcConfigurationTest {
  @Autowired private MockMvc mvc;

  @Test
  void should_return_ip() throws Exception {
    mvc.perform(get("/abc")).andExpect(status().isOk()).andExpect(content().string("127.0.0.1"));
  }

  @Configuration
  @RestController
  static class C {
    @Autowired private WebMvcHelper webMvcHelper;

    @RequestMapping("/abc")
    String abc() {
      return webMvcHelper.getClientIp();
    }
  }
}
