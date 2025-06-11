package com.alura.conversormoneda.principal;

import com.alura.conversormoneda.modelos.APIMonedas;
import com.alura.conversormoneda.modelos.ConsultaAPI;
import com.alura.conversormoneda.modelos.ConversorApp;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        var eleccion = 0;
        double cantidad;
        ConsultaAPI consulta = new ConsultaAPI();
        Scanner escritura = new Scanner(System.in);

        System.out.println("Bienvenido al conversor de monedas: 'MiKambio', estos son los tipos de cambio que tenemos disponibles:");
        while (eleccion != 7) {
            eleccion = ConversorApp.mostrarMenu(escritura);

            if (eleccion >= 1 && eleccion <= 6) {
                System.out.println("Ingrese la cantidad que desea convertir:");
                try {
                    cantidad = Double.parseDouble(escritura.nextLine());

                    APIMonedas monedas = ConversorApp.getMoneda(eleccion, consulta);

                    if (monedas != null) {
                        ConversorApp conversor = new ConversorApp(monedas);
                        conversor.setMonto(cantidad);
                        System.out.println(conversor);

                    } else System.out.println("No se pudo realizar la conversión");

                }catch(NumberFormatException e){
                    System.out.println("Error: la cantidad ingresada debe ser un número");
                }
            }
            else if (eleccion == 7) {
                System.out.println("Saliendo del programa, hasta luego :)");
            }
            else if (eleccion != -1) {
                System.out.println("Opción inválida, vuelva a intentarlo");
            }
        }
    }
}
