package br.com.baron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BaronApplication{

	public static void main(String[] args) {
		SpringApplication.run(BaronApplication.class, args);
	}

}
