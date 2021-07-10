package io.vicevil4.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    /**
     * <pre>
     * Swagger API
     *
     * - http://localhost:8080/swagger-ui/
     * </pre>
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30) // Open API Spec 3.0
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
