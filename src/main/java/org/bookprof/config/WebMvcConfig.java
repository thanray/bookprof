package org.bookprof.config;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableMongoRepositories
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Resource ServletContext servletContext;

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    configurer.enable();
  }
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

  }
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/hello").setViewName("hello");
    registry.addViewController("/hello3").setViewName("hello3");
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/login").setViewName("login");
  }

}

