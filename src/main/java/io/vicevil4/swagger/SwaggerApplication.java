package io.vicevil4.swagger;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;

@SpringBootApplication
@ComponentScan(basePackageClasses = { AppBasePackage.class })
public class SwaggerApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(SwaggerApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
