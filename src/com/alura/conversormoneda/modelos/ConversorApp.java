package com.alura.conversormoneda.modelos;

import java.util.Scanner;

public class ConversorApp {
    private final String monedaOrigen;
    private final String monedaDestino;
    private double monto;
    private final double tasa;

    public ConversorApp(APIMonedas misMonedas) {
        this.monedaOrigen = misMonedas.base_code();
        this.monedaDestino = misMonedas.target_code();
        this.tasa = misMonedas.conversion_rate();
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double calcularConversion(){
        return Math.round(monto * tasa * 100.0)/100.0;
    }

    public static int mostrarMenu(Scanner lectura){
        System.out.println("""
                ###########################
                1. Dólar  => Sol peruano
                2. Sol peruano  => Dólar
                3. Dólar  => Euro
                4. Euro  => Dólar
                5. Sol peruano  => Euro
                6. Euro  => Sol peruano
                7. Salir
                ###########################
                """);
        System.out.println("Elija una opción:");
        try {
            return Integer.parseInt(lectura.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Error: Ingrese un número del 1 al 7");
            return -1;
        }
    }

    public static APIMonedas getMoneda(int opcion, ConsultaAPI consulta)
    {
        return switch (opcion)
        {
            case 1 -> consulta.buscaMoneda("usd", "pen");
            case 2 -> consulta.buscaMoneda("pen", "usd");
            case 3 -> consulta.buscaMoneda("usd", "eur");
            case 4 -> consulta.buscaMoneda("eur", "usd");
            case 5 -> consulta.buscaMoneda("pen", "eur");
            case 6 -> consulta.buscaMoneda("eur", "pen");
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "Resultado de conversión: " +
                monto +
                " (" + monedaOrigen + ") => " +
                calcularConversion() +
                " (" + monedaDestino + ")";
    }
}
