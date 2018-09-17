package mk.finki.emt.phoneshop;

import mk.finki.emt.phoneshop.config.ThymeleafLayoutInterceptorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class PhoneShopApplication {

	@Configuration
	@Import({ThymeleafLayoutInterceptorConfig.class})
	public static class MainConfiguration extends WebMvcConfigurationSupport {


	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(16);
	}


	public static void main(String[] args) {
		SpringApplication.run(PhoneShopApplication.class, args);
	}
}
