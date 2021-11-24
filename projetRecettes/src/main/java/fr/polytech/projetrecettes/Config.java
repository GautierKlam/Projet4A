package fr.polytech.projetrecettes;

import fr.polytech.projetrecettes.web.RecetteControlleur;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class Config {
    @Bean
    public ResourceConfig maconfiguration(){
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(RecetteControlleur.class);
        return resourceConfig;
    }

    @Bean
    SimpleJaxWsServiceExporter simpleJaxWsServiceExporter(){
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://0.0.0.0:8888/");
        return exporter;
    }
}
