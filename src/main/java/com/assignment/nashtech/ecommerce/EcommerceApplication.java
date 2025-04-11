package com.assignment.nashtech.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	public void run(String... args) throws Exception {
		String sql = "INSERT INTO employees (username, email, first_name, last_name, birth_date, role, avatar_url, created_at, updated_at) VALUES ("
				+ "'nam123', 'nam@example.com', 'Nam', 'Nguyen', '1995-06-15', 'Engineer', 'avatar.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";

		int rows = jdbcTemplate.update(sql);
		if (rows > 0) {
			System.out.println("A new row has been inserted.");
		}
	}

}
