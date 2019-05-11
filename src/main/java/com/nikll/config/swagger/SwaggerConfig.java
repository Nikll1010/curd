/**
 * @program: demo
 * @description: swaggerconfig
 * @author Nikll
 * @date 2019/5/11 13:57
 */
package com.nikll.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Nikll

 * @date 2019/5/11 13:57

 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfor()).pathMapping("/")
                .select().paths(PathSelectors.regex("/.*")).build();
    }

    private ApiInfo apiInfor() {
        return new ApiInfoBuilder().title("我的接口").contact(new Contact("nikll","","294758896"))
                .description("这是我的swaggerui生成的接口文档").version("1.0.0.1").build();
    }
}