package com.rocket.laf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class LafApplication {

	public static void main(String[] args) {
		SpringApplication.run(LafApplication.class, args);
	}

	//@DeleteMapping, @PutMapping등 최신 매핑기능을 이용하기 위한 코드 START
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	//END
}
