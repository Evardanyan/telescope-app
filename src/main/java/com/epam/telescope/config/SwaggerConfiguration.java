package com.epam.telescope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.epam.telescope"))     // for now let it be this one until controllers are set up
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("Telescope API")
                        .description("Telescope API documentation")
                        .version("1.0")
                        .termsOfServiceUrl("free to use")
                        .build());
    }
}