package Projekt.xt_oc_ti.PEXOCTI.config;

import Projekt.xt_oc_ti.PEXOCTI.interceptor.Authorizationinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    private final Authorizationinterceptor authorizationInterceptor;

    @Autowired
    public WebMvcConfig(Authorizationinterceptor authorizationInterceptor) {
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/api/user");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/user")
                .allowedOrigins("http://localhost:3000/", "http://localhost:3000/login")
                .allowedMethods("*")
                .allowCredentials(true);
        registry.addMapping("/api/login").allowedOrigins("http://localhost:3000/", "http://localhost:3000/login").allowedMethods("*").allowCredentials(true);
        registry.addMapping("/api/refresh").allowedOrigins("http://localhost:3000/", "http://localhost:3000/login").allowedMethods("*").allowCredentials(true);
    }



}
