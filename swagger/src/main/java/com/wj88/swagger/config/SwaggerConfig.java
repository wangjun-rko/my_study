package com.wj88.swagger.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 * 
 * @description TODO
 * @author huayu
 * @date 2020/6/23 18:08
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            // 方法需要有ApiOperation注解才能生存接口文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            // 路径使用any风格
            .paths(PathSelectors.any()).build()
            // 如何保护我们的Api，有三种验证（ApiKey, BasicAuth, OAuth）
            //.securitySchemes(security())
            // 接口文档的基本信息
            .apiInfo(apiInfo());
    }

    /**
     * 接口文档详细信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("测试接口") //设置文档的标题
                .description("wj-api文档") // 设置文档的描述
                .termsOfServiceUrl("http://www.baidu.com") // 设置文档的License信息
                .version("1.0.0").build(); // 设置文档的版本信息
    }

    private List<ApiKey> security() {
        ArrayList<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("token", "token", "header"));
        return apiKeys;
    }
}
