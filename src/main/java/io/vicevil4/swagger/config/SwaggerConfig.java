package io.vicevil4.swagger.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


/**
 * <pre>
 * Swagger Configuration
 *
 * - https://springfox.github.io/springfox/docs/snapshot/#springfox-spring-mvc-and-spring-boot
 * - https://velog.io/@tigger/API-%EB%AC%B8%EC%84%9C-%EC%9E%90%EB%8F%99%ED%99%94-Swagger
 * </pre>
 */
@Configuration
@EnableSwagger2
@Import({
        springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class,
        springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class,
})
public class SwaggerConfig {

    @Autowired
    private TypeResolver typeResolver;

    /**
     * <pre>
     * Swagger Documentation
     *
     * - http://localhost:8080/swagger-ui/
     * </pre>
     * @return
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "제목입니다.",
                "설명을 넣어주세요",
                "v1",
                "http://localhost:8080/terms",
                new Contact("Contact Me", "http://localhost:8080", "abc@mail.com"),
                "MIT",
                "http://localhost:8080/license",
                Collections.emptyList()
        );
    }

    /**
     * Swagger UI
     *
     * @return
     */
    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .showCommonExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }
}
