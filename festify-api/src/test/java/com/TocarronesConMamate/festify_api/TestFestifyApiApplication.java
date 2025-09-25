package com.TocarronesConMamate.festify_api;

import org.springframework.boot.SpringApplication;

public class TestFestifyApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(FestifyApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
