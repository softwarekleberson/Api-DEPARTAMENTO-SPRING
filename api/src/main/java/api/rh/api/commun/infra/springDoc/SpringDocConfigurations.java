package api.rh.api.commun.infra.springDoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SpringDocConfigurations {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI();
	}
}
