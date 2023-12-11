package map.project.demo.config;

import java.util.List;

import map.project.demo.util.mvc.JsonArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        JsonArgumentResolver jsonArgumentResolver = new JsonArgumentResolver();
        argumentResolvers.add(jsonArgumentResolver);
    }
}
