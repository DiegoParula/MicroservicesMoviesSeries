package com.dh.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
////////////////////////////////////////////////////////////////////
/////////////////////////  CONFIG SERVER  //////////////////////////
////////////////////////////////////////////////////////////////////
*/

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
