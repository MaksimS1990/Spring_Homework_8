package ru.geekbrains.Homework_8.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.geekbrains.Homework_8.aspects.LoggingAspect;

@ComponentScan(basePackages = "ru.geekbrains")
@Configuration
@EnableAspectJAutoProxy
public class AspectConfiguration {

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }

}
