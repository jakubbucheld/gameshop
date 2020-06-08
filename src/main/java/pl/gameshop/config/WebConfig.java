package pl.gameshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.gameshop.converters.ArticleConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    @Override
    public void addFormatters(FormatterRegistry registry)
    {
        registry.addConverter(new ArticleConverter());
    }

    @Bean
    public ArticleConverter articleConverter() { return new ArticleConverter(); }
}
