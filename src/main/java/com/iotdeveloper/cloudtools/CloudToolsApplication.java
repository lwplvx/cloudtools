package com.iotdeveloper.cloudtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;

@SpringBootApplication
public class CloudToolsApplication {
	private static Logger logger = Logger.getLogger(CloudToolsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CloudToolsApplication.class, args);

		logger.info("=====spring boot start success====");
	}

}
