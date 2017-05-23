package com.cms;

import com.cms.util.SimpleCORSFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }


    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error_page/error_page401.html");
            ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/error_page/error_page403.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error_page/error_page404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error_page/error_page500.html");
            container.addErrorPages(error401Page, error403Page, error404Page, error500Page);
        });
    }

    @Bean
    public SimpleCORSFilter simpleCORSFilter() {
        return new SimpleCORSFilter();
    }
}
