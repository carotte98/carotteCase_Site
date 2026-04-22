package fr.afpa.codecasesite;

import fr.afpa.codecasesite.config.CustomProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data
@EnableConfigurationProperties(CustomProperties.class)
@SpringBootApplication
public class CodecasesiteApplication implements CommandLineRunner {

	@Autowired
	private CustomProperties props;

	public static void main(String[] args) {
		SpringApplication.run(CodecasesiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println(props.getApiUrl());
	}
	

}
