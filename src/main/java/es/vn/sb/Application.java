package es.vn.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.elastic.apm.attach.ElasticApmAttacher;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(Application.class, args);
	}


}