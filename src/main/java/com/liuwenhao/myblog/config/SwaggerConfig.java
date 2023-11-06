package com.liuwenhao.myblog.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 指定扫描的包路径来定义指定要建立API的目录。
     * @return
     */
    @Bean
    public Docket docket(Environment environment){
        boolean flag = flag(environment);
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(flag)
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        // .any()
                        .basePackage("com.liuwenhao.myblog.controller")
                )
                //只显示admin下面的路径
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    public Docket docket1(Environment environment){
        boolean flag = flag(environment);
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(flag)
                .apiInfo(adminApiInfo())
                .groupName("user")
                .select()
                //只显示admin下面的路径
                .paths(PathSelectors.regex("/user/.*"))
                .build();
    }

    @Bean
    public Docket docket2(Environment environment){
        boolean flag = flag(environment);
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(flag)
                .apiInfo(adminApiInfo())
                .groupName("adminApi")
                .select()
                //只显示admin下面的路径
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("个人博客系统--api文档")
                .description("个人博客：从零开始")
                .version("1.0")
                .contact(new Contact("刘文浩","http://baidu.com","980954808@qq.com"))
                .build();
    }

    private boolean flag(Environment environment){
        // 设置环境范围
        Profiles profiles = Profiles.of("dev","test");
        // 如果在该环境返回内则返回：true，反之返回 false
        return environment.acceptsProfiles(profiles);
    }
}
