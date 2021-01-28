package pt.sample.service;

import pt.digglet.integration.NestJsTcpClient;
import pt.digglet.integration.exceptions.NestJsConnectionException;

import javax.enterprise.inject.Produces;

public class SampleServiceContext {

    @Produces
    public NestJsTcpClient nestJsTcpClient() throws NestJsConnectionException {
        return NestJsTcpClient.createClient("localhost", 60260);
    }

}
