package com.etf.nbp;

import com.etf.nbp.database.DatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionApplication.class, args);
//		DatabaseService db = context.getBean(DatabaseService.class);
//		db.startConnection();
	}

}
