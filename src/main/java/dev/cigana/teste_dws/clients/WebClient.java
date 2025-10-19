package dev.cigana.teste_dws.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;

public class WebClient {

    private RestClient restClient;

    @Autowired
    public WebClient(RestClient.Builder restClient) {
        this.restClient = restClient.baseUrl("https://bands-api.vercel.app/").build();
    }

}
