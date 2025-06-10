package com.alura.conversormoneda.principal;

import com.alura.conversormoneda.modelos.APIMonedas;
import com.alura.conversormoneda.modelos.ConsultaAPI;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        var eleccion = 0;
        double monto = 0;
        Scanner lectura = new Scanner(System.in);
        System.out.println("Bienvenido al conversor de monedas: 'MiKambio', estos son los tipos de cambio que tenemos disponibles:");
        while (eleccion != 7){
            System.out.println("###########################\n" +
                    "1. Dólar  => Sol peruano\n" +
                    "2. Sol peruano  => Dólar\n" +
                    "3. Dólar  => Euro\n" +
                    "4. Euro  => Dólar\n" +
                    "5. Sol peruano  => Euro\n" +
                    "6. Euro  => Sol peruano\n" +
                    "7. Salir\n" +
                    "############################\n");
            try{
                System.out.println("Elija una opción:");
                eleccion = Integer.valueOf(lectura.nextLine());

                ConsultaAPI consulta = new ConsultaAPI();
                APIMonedas moneda = null;

                switch (eleccion){
                    case 1:
                        moneda = consulta.buscaMoneda("usd","pen", monto);
                        break;
                    case 2:
                        moneda = consulta.buscaMoneda("pen","usd", monto);
                        break;
                    case 3:
                        moneda = consulta.buscaMoneda("usd","eur", monto);
                        break;
                    case 4:
                        moneda = consulta.buscaMoneda("eur","usd", monto);
                        break;
                    case 5:
                        moneda = consulta.buscaMoneda("pen","eur", monto);
                        break;
                    case 6:
                        moneda = consulta.buscaMoneda("eur","pen", monto);
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Opción inválida, vuelva a intentarlo\n");
                }
                if(eleccion >=1 && eleccion <=6){
                    System.out.println("Ingrese la cantidad que desea convertir:");
                    monto = Double.parseDouble(lectura.nextLine());

                    double resultado = monto * moneda.conversion_rate();
                    System.out.println("El resultado de convertir " + monto + " " + moneda.base_code() + " es " + resultado + " " + moneda.target_code());
                }

            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("Ocurrió un error:" + e.getMessage());
            }
        }
        System.out.println("Saliendo del programa, hasta luego :)");
    }
}
