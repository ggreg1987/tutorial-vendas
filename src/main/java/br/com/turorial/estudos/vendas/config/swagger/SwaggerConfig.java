package br.com.turorial.estudos.vendas.config.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contact() {
        return new Contact("Gabriel Gregorio"
                ,"https://github.com/ggreg1987"
                ,"gr3g1987@gmail.com");
    }

    private ApiInfo apiInfo() {
        
    }
}
