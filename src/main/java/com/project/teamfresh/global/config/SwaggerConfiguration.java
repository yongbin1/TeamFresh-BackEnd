package com.project.teamfresh.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("[팀프레시] 시스템개발3팀 과제 API")
                .version("version 1.0")
                .description("[팀프레시] 시스템개발3팀 과제 API 문서");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}
