package com.client.clientSantosApp.Client;

import com.client.clientSantosApp.dto.Persona;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;


@RestController
@RequestMapping("/servicio")
public class RestClient {

    private String user = "test";
    private String pass = "test";
    private HttpHeaders httpHeaders = new HttpHeaders();
    private HttpEntity httpEntity;

    @GetMapping("/listpersona")
    public List<Persona> listaPersonas(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/santos/persona/todo";
        HttpHeaders headers = new HttpHeaders();
        String strAuth = "test:test";

        String base64Creds = Base64.getEncoder().encodeToString(strAuth.getBytes());

        headers.add("Authorization", "Basic " + base64Creds);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<List<Persona>> response = restTemplate.exchange(url,
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Persona>>() {
                });
        return response.getBody();
    }
    public String getAllPersonas() {
        String url = "http://localhost:8090/santos/persona/todo";
        String strAuth = user + ":" + pass;
        String base64Creds = Base64.getEncoder().encodeToString(strAuth.getBytes());

        httpHeaders.add("Authorization", "Basic " + base64Creds);
        httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, httpEntity, String.class);

        String json = response.getBody();

        return json;
    }

}
