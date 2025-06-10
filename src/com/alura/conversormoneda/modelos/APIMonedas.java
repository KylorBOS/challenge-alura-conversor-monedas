package com.alura.conversormoneda.modelos;

public record APIMonedas(String base_code,
                         String target_code,
                         double conversion_rate,
                         double conversion_result) {

}
