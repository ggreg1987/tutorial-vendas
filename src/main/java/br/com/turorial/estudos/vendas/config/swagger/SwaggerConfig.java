package br.com.turorial.estudos.vendas.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("br.com.turorial.estudos.vendas.domain.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }

    private Contact contact() {
        return new Contact("Gabriel Gregorio"
                ,"https://github.com/ggreg1987"
                ,"gr3g1987@gmail.com");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API de Vendas")
                .description("Tutorial de como fazer uma Api de Vendas")
                .version("1.0")
                .contact(contact())
                .build();
    }

    public ApiKey apiKey() {
        return new ApiKey("JWT","Authorization","header");
    }

    private List<SecurityReference> references() {
        
    }
}
