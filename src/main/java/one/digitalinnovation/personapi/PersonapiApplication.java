package one.digitalinnovation.personapi;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonapiApplication.class, args);

		System.out.println("Inicial!");



	}

}
