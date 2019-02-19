package hellotest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.filter.OncePerRequestFilter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * 关于Swagger API 的配置
 */
@Configuration
@EnableSwagger2
@ControllerAdvice(basePackages = "hellotest.api.controllers")
@Slf4j
public class SwaggerConfiguration {
  private final static String SWAGGER_UI_HEADER = "Referer";
  private final static String SWAGGER_UI_URL_HOST = "swagger-ui.mingyizhudao.com";

  private ApiInfo initApiInfo() {
    Contact contact = new Contact("seven", "", "");
    return new ApiInfo(
      "11",
      "22",
      "1.0.1",
      "",
      contact,
      "",
      "",
      Collections.emptyList()
    );
  }

  @Bean
  public Docket api() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2);
    return docket
      .apiInfo(initApiInfo()).select()
      .apis(RequestHandlerSelectors.basePackage("hellotest.api.controllers")).paths(PathSelectors.any())
      .build();
  }

  @Bean
  public OncePerRequestFilter swaggerFilter() {
    return new OncePerRequestFilter() {
      @Override
      protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getHeader(SWAGGER_UI_HEADER) != null && request.getHeader(SWAGGER_UI_HEADER).contains(SWAGGER_UI_URL_HOST)) {
          response.addHeader(
            "Access-Control-Allow-Origin",
            "http://swagger-ui.mingyizhudao.com"
          );
          response.addHeader(
            "Access-Control-Allow-Headers",
            "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range,Authorization"
          );
          response.addHeader(
            "Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, PATCH, OPTIONS"
          );
        }
        filterChain.doFilter(request, response);
      }
    };
  }

}
