package com.example.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestClientMain {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String url = "http://localhost:8080/station-project/api/prices/StationNord/2026-11-16";

        Response response = client.target(url).request(MediaType.APPLICATION_JSON).get();
        System.out.println("REST Response: " + response.readEntity(String.class));
        client.close();
    }
}