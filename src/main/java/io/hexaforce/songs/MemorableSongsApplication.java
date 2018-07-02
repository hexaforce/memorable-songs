package io.hexaforce.songs;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
@EnableAutoConfiguration
public class MemorableSongsApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder()		
		.sources(MemorableSongsApplication.class)
		.listeners(new ApplicationPidFileWriter())
		.bannerMode(Banner.Mode.CONSOLE)
		.run(args);
	}
	
}
