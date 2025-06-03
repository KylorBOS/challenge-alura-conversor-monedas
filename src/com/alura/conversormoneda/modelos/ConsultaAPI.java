package com.alura.conversormoneda.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public APIMonedas buscaMoneda(String tipo){
        URI URL_BASE = URI.create("https://v6.exchangerate-api.com/v6/e7ac49d4a2ad7f39a33927d7/latest/" + tipo);
        System.out.println(URL_BASE);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URL_BASE)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return new Gson().fromJson(json, APIMonedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda que buscabas");
        }
    }
}
