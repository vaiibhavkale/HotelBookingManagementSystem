package com.cg;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.cg*")
@EnableSwagger2
public class UserUpdateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserUpdateServiceApplication.class, args);
	}
	
	@Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                   .select()
                   .paths(PathSelectors.any())
                   .apis(RequestHandlerSelectors.basePackage("com.cg.util"))
                   .build()
                   .apiInfo(myApiInfo());
           }
	
	private ApiInfo myApiInfo() {
        ApiInfo apiInfo=new ApiInfo(
                "USER-UPDATE-SERVICE CRUD API's",
                 "API CREATION",
                 "2.0",
                 "Free to Use",
                 new Contact("Vaibhav Kale","www.hbms.com" ,"vaiibhavkale@gmail.com"),
                 "API licence",
                 "API License URL",
                 Collections.emptyList());
        return apiInfo;  }
}
