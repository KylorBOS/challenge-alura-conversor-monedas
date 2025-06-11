package com.alura.conversormoneda.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public APIMonedas buscaMoneda(String origen, String destino){
        URI URL_BASE = URI.create("https://v6.exchangerate-api.com/v6/e7ac49d4a2ad7f39a33927d7/pair/" + origen + "/" + destino);
//        System.out.println(URL_BASE);

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URL_BASE)
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                return new Gson().fromJson(json, APIMonedas.class);
            } catch (Exception e) {
                throw new RuntimeException("No se encontró la información que buscabas");
            }
        }
        catch (Exception e){
            throw new RuntimeException("No se pudo conectar con la API");
        }
    }
}
