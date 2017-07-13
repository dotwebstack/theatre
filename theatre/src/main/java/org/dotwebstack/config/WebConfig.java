package org.dotwebstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

/**
 * Created by Rick Fleuren on 7/12/2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.dotwebstack.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public SpringTemplateEngine templateEngine(ITemplateResolver resolver) {
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.addTemplateResolver(new UrlTemplateResolver());
    engine.setEnableSpringELCompiler(true);
    engine.setTemplateResolver(resolver);
    return engine;
  }

  @Bean
  public SpringResourceTemplateResolver templateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setPrefix("/WEB-INF/templates/");
    resolver.setSuffix(".html");
    resolver.setTemplateMode(TemplateMode.HTML);
    resolver.setCharacterEncoding("UTF-8");
    resolver.setCacheable(false);
    return resolver;
  }

  @Bean
  public ThymeleafViewResolver viewResolver(ITemplateEngine engine) {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(engine);
    viewResolver.setOrder(1);

    return viewResolver;
  }

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    super.addResourceHandlers(registry);
    registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
    registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
    registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
//    registry.addResourceHandler("/webjars/**")
//        .addResourceLocations("/META-INF/resources/webjars/");
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
}
