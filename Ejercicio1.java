/*
    - Laboratorio Nro 17 - Ejercicio 1: Bisection Method (NUS / MIT)
    - Autor: Fiorela Clariza Quispe Quispe
    - Colaboró: 
    - Tiempo: 25 min
*/
import java.util.*;
import java.text.DecimalFormat;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String coeficientes, nuevaCadena;
        int coeficiente3, coeficiente2, coeficiente1, coeficiente0;
        double valorX1, valorX2, valorA, valorB, valorFuncionA,
                valorFuncionB, valorFuncionXm = 1, valorXm;

        System.out.print("Ingrese el valor los coeficientes de la función cúbica(c3,c2,c1,c0):\t");
        coeficientes = scan.nextLine();
        // Extracción de los coeficientes
        coeficiente3 = Integer.parseInt(coeficientes.substring(0, coeficientes.indexOf(" ")));
        nuevaCadena = coeficientes.substring(coeficientes.indexOf(" ") + 1, coeficientes.length());
        coeficiente2 = Integer.parseInt(nuevaCadena.substring(0, nuevaCadena.indexOf(" ")));
        nuevaCadena = nuevaCadena.substring(nuevaCadena.indexOf(" ") + 1, nuevaCadena.length());
        coeficiente1 = Integer.parseInt(nuevaCadena.substring(0, nuevaCadena.indexOf(" ")));
        coeficiente0 = Integer.parseInt(nuevaCadena.substring(nuevaCadena.indexOf(" ") + 1, nuevaCadena.length()));
        // Pedir los valores extremos
        System.out.print("Ingrese el valor de los puntos extremos finales: ");
        valorX1 = scan.nextDouble();
        System.out.print("Ingrese el valor de los puntos extremos finales: ");
        valorX2 = scan.nextDouble();
        valorA = Math.min(valorX1, valorX2);
        valorB = Math.max(valorX1, valorX2);
        // Bucle para calcular el valor menor a 0.0001
        for (int i = 1; !(valorFuncionXm > -0.0001 && valorFuncionXm < 0.0001); i++) {
            // Calcula las funciones y el punto medio
            valorFuncionA = coeficiente3 * Math.pow(valorA, 3) + coeficiente2 * Math.pow(valorA, 2)
                    + coeficiente1 * valorA + coeficiente0;
            valorFuncionB = coeficiente3 * Math.pow(valorB, 3) + coeficiente2 * Math.pow(valorB, 2)
                    + coeficiente1 * valorB + coeficiente0;
            valorXm = valorA + ((valorB - valorA) / 2);
            valorFuncionXm = coeficiente3 * Math.pow(valorXm, 3) + coeficiente2 * Math.pow(valorXm, 2)
                    + coeficiente1 * valorXm + coeficiente0;
            // Permite la salida de números con seis decimales
            DecimalFormat df = new DecimalFormat("0.000000");
            System.out.print(i + "\t" + "Valor de A: " + df.format(valorA) + "  Función de A: "
                    + df.format(valorFuncionA) + "\t");
            System.out.print("Valor de B: " + df.format(valorB) + "  Función de B: " + df.format(valorFuncionB) + "\t");
            System.out.print(
                    "Valor de Xm: " + df.format(valorXm) + "  Función de Xm: " + df.format(valorFuncionXm) + "\n");
            // Condición en caso valor menor sea superado por el punto medio
            if (valorFuncionXm > 0) {
                valorB = valorXm;
            } else {
                valorA = valorXm;
            }
        }
        scan.close();
    }
}