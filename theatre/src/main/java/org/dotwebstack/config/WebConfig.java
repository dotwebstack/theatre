package org.dotwebstack.config;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rick Fleuren on 7/12/2017.
 */

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "org.dotwebstack.controller")
public class WebConfig extends WebMvcAutoConfiguration {

}
