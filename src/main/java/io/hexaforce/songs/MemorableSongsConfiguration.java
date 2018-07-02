package io.hexaforce.songs;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableConfigurationProperties(MemorableSongsConfiguration.class)
public class MemorableSongsConfiguration implements WebMvcConfigurer {

}
