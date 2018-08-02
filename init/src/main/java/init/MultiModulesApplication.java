package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"download"})
@PropertySource(value = {"application.properties", "application-dependency.properties"})
public class MultiModulesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiModulesApplication.class, args);
	}
}
