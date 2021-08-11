package com.cxf.demo.restws;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.jaxrs.JsonMappingExceptionMapper;
import org.codehaus.jackson.jaxrs.JsonParseExceptionMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author olysenko
 */
@Configuration
public class AppConfiguration {

   @Bean
   public JacksonJaxbJsonProvider jacksonJaxbJsonProvider() {
      return new JacksonJaxbJsonProvider();
   }

   @Bean
   public JacksonJsonProvider jacksonJsonProvider() {
      return new JacksonJsonProvider();
   }

   @Bean
   public JsonMappingExceptionMapper jsonMappingExceptionMapper() {
      return new JsonMappingExceptionMapper();
   }

   @Bean
   public JsonParseExceptionMapper jsonParseExceptionMapper() {
      return new JsonParseExceptionMapper();
   }
}
