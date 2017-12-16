import melo.mc.apolo.loto.facil.backend.controller.JogoController;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        this.register(JogoController.class);
    }
}