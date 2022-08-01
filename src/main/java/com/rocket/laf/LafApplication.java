package com.rocket.laf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication(exclude = { MultipartAutoConfiguration.class }) // SpringBoot의 특성 중 하나는 어플리케이션의 스프링 설정이 자동으로
																		// 구성된다는 것이다. 사진 업로드를 위해 multipartResolver를 등록했기
																		// 때문에 첨부파일 관련 자동 구성을
																		// 사용하지 않도록 설정해야한다.
public class LafApplication {
	public static void main(String[] args) {
		SpringApplication.run(LafApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
}
}