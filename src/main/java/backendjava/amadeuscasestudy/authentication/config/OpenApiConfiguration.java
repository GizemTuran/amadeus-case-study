package backendjava.amadeuscasestudy.authentication.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customizeApi(){
        final String securityName = "bearerAuth";
        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList(securityName))
                .components(new Components().addSecuritySchemes(securityName,new SecurityScheme().name(securityName)
                        .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}
