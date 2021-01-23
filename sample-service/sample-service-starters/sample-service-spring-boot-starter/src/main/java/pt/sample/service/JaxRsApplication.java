package pt.sample.service;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Component
@ApplicationPath("/sample-app/")
public class JaxRsApplication extends Application {
}