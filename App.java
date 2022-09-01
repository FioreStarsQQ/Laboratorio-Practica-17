
/*
    - Laboratorio Nro 17 - Ejercicio 1: Bisection Method (NUS / MIT)
    - Autor: Fiorela Clariza Quispe Quispe
    - Colaboró: 
    - Tiempo: 5 min
*/
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String coeficientes, nuevaCadena1, nuevaCadena2;
        int coeficiente3, coeficiente2, coeficiente1, coeficiente0, validador = 1;
        double  valorPrueba, x3 = 1, posibleCero = 0;
        System.out.print("Ingrese el valor los coeficientes de la función cúbica(c3,c2,c1,c0):\t");
        coeficientes = scan.nextLine();

        coeficiente3 = Integer.parseInt(coeficientes.substring(0, coeficientes.indexOf(" ")));
        nuevaCadena1 = coeficientes.substring(coeficientes.indexOf(" ") + 1, coeficientes.length());
        coeficiente2 = Integer.parseInt(nuevaCadena1.substring(0, nuevaCadena1.indexOf(" ")));
        nuevaCadena2 = nuevaCadena1.substring(nuevaCadena1.indexOf(" ") + 1, nuevaCadena1.length());
        coeficiente1 = Integer.parseInt(nuevaCadena2.substring(0, nuevaCadena2.indexOf(" ")));
        coeficiente0 = Integer.parseInt(nuevaCadena2.substring(nuevaCadena2.indexOf(" ") + 1, nuevaCadena2.length()));
        System.out.println(coeficiente0 + "******" + coeficiente1 + "******" + coeficiente2 + "******" + coeficiente3);

        validador = -12 / 2;
        System.out.println(validador);
        validador = -12 % 1;
        System.out.println(validador);


        //puntoMedio = (valorExt1 + valorExt2) / 2;

        if (coeficiente0 >= 0) { // coeficiente0 (termino independiente) positivo
            for (int i = 1; i <= coeficiente0; i++) {
                if (coeficiente0 % i == 0) {

                    valorPrueba = (i * 1.0) / (coeficiente3 * 1.0);
                    posibleCero = valorPrueba;
                    // Valores positivos método Horner
                    x3 = (((((coeficiente3 * posibleCero) + coeficiente2) * posibleCero) + coeficiente1) *
                            posibleCero) + coeficiente0;
                    if (x3 == 0.0) {
                        validador = 2; // ??????
                        break;
                    } else {
                        // valores negativos método Horner
                        posibleCero = valorPrueba * (-1.0);
                        x3 = (((((coeficiente3 * posibleCero) + coeficiente2) * posibleCero) +
                                coeficiente1) * posibleCero) + coeficiente0;
                        if (x3 == 0) {

                            validador = 2; // ??????
                            break;
                        }
                    }

                }

            }
        } else { // coeficiente0 (termino independiente) negativo
            for (int i = 1; i >= coeficiente0; i++) {
                if (coeficiente0 % i == 0) {

                    valorPrueba = (i * 1.0) / (coeficiente3 * 1.0);
                    posibleCero = valorPrueba;
                    // Valores positivos método Horner
                    x3 = (((((coeficiente3 * posibleCero) + coeficiente2) * posibleCero) + coeficiente1) *
                            posibleCero) + coeficiente0;
                    if (x3 == 0.0) {
                        validador = 2; // ??????
                        break;
                    } else {
                        // valores negativos método Horner
                        posibleCero = valorPrueba * (-1.0);
                        x3 = (((((coeficiente3 * posibleCero) + coeficiente2) * posibleCero) +
                                coeficiente1) * posibleCero) + coeficiente0;
                        if (x3 == 0) {

                            validador = 2; // ??????
                            break;
                        }
                    }

                }

            }
        }
        System.out.println(posibleCero + "<<<<<<" + x3);

        // divisoresCoeficiente0
        scan.close();
    }
}