package com.alura.conversormoneda.principal;

import com.alura.conversormoneda.modelos.APIMonedas;
import com.alura.conversormoneda.modelos.ConsultaAPI;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner escritura = new Scanner(System.in);
        System.out.println("Ingresa la moneda a buscar");
        var monedaABuscar = escritura.nextLine();

        ConsultaAPI consulta = new ConsultaAPI();
        APIMonedas moneda = consulta.buscaMoneda(monedaABuscar);
        System.out.println(moneda);
    }
}
