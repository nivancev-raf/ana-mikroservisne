package anamikroservisi.korisnicki_servis.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(title = "API", version = "1.0.0", description = "API swagger definition",
        contact = @Contact(name = "Ana Ivancev", email = "email@example.com"),
        termsOfService = "Terms of service", license = @License(name = "", url = "")))
public class OpenApiConfiguration {

}
