package com.example.MedicationManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicationManagementApplication.class, args);
    }

	/*
	* 	How to Test

		Open your browser and navigate to http://localhost:8080/h2-console. - This is for the database

		Enter the following details to connect to the H2 database:
		JDBC URL: MedicationManagementApplication
		Username: group1
		Password: (leave blank).

		Click Test and then Connect to access the H2 console.

		Use postman to test the API

		How to test the application:

			1. Run the code
			2. go to http://localhost:8080

        Entity: Represents the data structure.

        Repository: Handles database operations.

        Service: Contains business logic.

        Controller: Manages HTTP requests and serves views.

        Thymeleaf Templates: Dynamic HTML pages for the UI. */

}
