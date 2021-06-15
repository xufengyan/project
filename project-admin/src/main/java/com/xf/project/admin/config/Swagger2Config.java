package com.xf.project.admin.config;

import com.google.common.collect.Lists;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
@ConditionalOnProperty(prefix = "swagger", name = "enabled", havingValue = "true")
public class Swagger2Config {

    /**
     * 基础包路径
     */
    private String basePackage;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目版本
     */
    private String projectVersion;
    /**
     * 项目描述
     */
    private String projectDesc;
    /**
     * 文档组名
     */
    private String groupName;
    /**
     * 项目联系人
     */
    private String contactName;
    /**
     * 联系人网址
     */
    private String contactUrl;
    /**
     * 联系人邮箱
     */
    private String contactEmail;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(projectName)
                .version(projectVersion)
                .description(projectDesc)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .build();
    }

    @Bean
    public Docket buildDocket() {
        ParameterBuilder builder = new ParameterBuilder()
//                .name(SysConstant.TOKEN).description("访问令牌")
                .modelRef(new ModelRef("string")).required(false)
                .parameterType("header");
        List<Parameter> parameters = Lists.newArrayList(builder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters)
//                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

//    private List<ApiKey> securitySchemes() {
//        return newArrayList(
//                new ApiKey("Authorization", SysConstant.TOKEN, "header"));
//    }

    private List<SecurityContext> securityContexts() {
        return newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!login|bestsign|httpStore).*$"))
                        .build()
        );
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
