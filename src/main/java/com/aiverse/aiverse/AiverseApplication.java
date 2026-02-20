package com.aiverse.aiverse;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class AiverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiverseApplication.class, args);
	}

	@PostConstruct
	public void openBrowser() {
		new Thread(() -> {
			try {
				Thread.sleep(1000); // wait for server to start
				Desktop.getDesktop().browse(new URI("http://localhost:8547"));
			} catch (Exception ignored) {}
		}).start();
	}
}
