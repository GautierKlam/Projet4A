package fr.polytech.projetrecettes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class Config {
    @Bean
    public ResourceConfig maconfiguration(){
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(Controlleur.class);
        return resourceConfig;
    }

    @Bean
    SimpleJaxWsServiceExporter simpleJaxWsServiceExporter(){
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://0.0.0.0:8981/");
        return exporter;
    }
}
