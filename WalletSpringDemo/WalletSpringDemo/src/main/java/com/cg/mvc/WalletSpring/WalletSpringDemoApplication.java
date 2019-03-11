package com.cg.mvc.WalletSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
@EntityScan("com.cg.mvc.beans")
public class WalletSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletSpringDemoApplication.class, args);
	}

}
