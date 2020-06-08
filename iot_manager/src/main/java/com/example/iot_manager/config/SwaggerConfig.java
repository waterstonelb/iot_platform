package com.example.iot_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .pathMapping("/")
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build().apiInfo(new ApiInfoBuilder()
            .title("IOT平台设备管理模块接口文档")
            .description("关于设备管理模块的所有接口")
            .version("1.0")
            .contact(new Contact("梁斌","101.200.189.184:8080","waterstonel@outlo0k.com"))
            .license("The Apache License")
            .licenseUrl("http://www.baidu.com")
            .build());
  }
}
