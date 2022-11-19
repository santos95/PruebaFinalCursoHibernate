package com.client.clientSantosApp;

import com.client.clientSantosApp.Client.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientSantosAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientSantosAppApplication.class, args);

		RestClient rest = new RestClient();

		//System.out.println(rest.getAllPersonas());



//		System.out.println(rest.getAllProducts());
		//System.out.println(rest.getAllPersonas());
	}

}
