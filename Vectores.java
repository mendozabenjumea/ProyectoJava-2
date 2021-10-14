import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vectores {

    static int sumaPares = 0, contadorPares = 0, sumaImpares = 0, contadorImpares = 0, x = 0;
    static int sumaTotal = 0;
    static int numeros[] = new int[10];
    public static void main(String[] args) {
        
        int opcion;
        boolean en = true;
        boolean Sa = false;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        int mayorv = Integer.MIN_VALUE;
        int menorv = Integer.MAX_VALUE;

        Scanner sc = new Scanner(System.in);
        Scanner sm = new Scanner(System.in);

        while (true) {

            System.out.println("=========Elige una Opcion y obten tus Resultados===");
            System.out.println("Opcion 1========Llenar el Vector Aleatoriamente====");
            System.out.println("Opcion 2==========Llenar el Vector Manualmente======");
            System.out.println("Opcion 3==================Salir===================");

            try {
                System.out.println("Introduce una opcion  entre 1 y 3");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Este Vector se Realiza Aleatoriamente entre -10 y 10");
                        // Primero lleno el array con números aleatorios del -10 al 10

                        rellenarArrayAleatorio(numeros);

                        System.out.println();
                        System.out.println();

                        break;

                    case 2:
                    
                        Scanner gt = new Scanner(System.in);
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Elemento [" + i + "]=");
                            x = gt.nextInt();
                            numeros[i] = x;
                            if (x % 2 == 0) {
                                sumaPares += x;
                                contadorPares++;
                            } 
                            else {
                                sumaImpares += x;
                                contadorImpares++;
                            }
                        }

                        // PARES
                        System.out.println("El Cantidad de pares son:" + contadorPares);
                        System.out.println("La suma de pares son:" + sumaPares);
                        System.out.println("El Promedio de pares es:" + promediar(sumaPares, contadorPares));
                        System.out.println("");

                        // IMPARES
                        System.out.println("El Cantidad de impares son:" + contadorImpares);
                        System.out.println("La suma de impares son:" + sumaImpares);
                        System.out.println("El Promedio de impares es:" + promediar(sumaImpares, contadorImpares));
                        sacarPorcentaje(contadorPares, contadorImpares);
                        break;

                    case 3:

                        en = true;

                        break;

                    default:
                        System.out.println("Las Opciones son entre 1 y 3");

                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Debe ser un numero");
                sm.next();
                sm.next();
                sm.next();
            }
            System.out.println("Fin del Menu");
        }
        if (Sa == false) {

            System.out.println("Saliste del menu");

            /// Vector Mayor Y Menor
            for (int i = 0; i < numeros.length; i++) {
                mayorv = Integer.max(mayorv, numeros[i]);
                menorv = Integer.min(menorv, numeros[i]);
            }
            System.out.println("El mayor valor es " + mayorv);

            System.out.println("El menor valor es " + menorv);

            ///////////////////// SUMA VECTORES

            for (int i = 0; i < 10; i++) {

                sumaTotal += numeros[i];

            }
            //////////////////////////////////////

            System.out.println("La suma de los Vectores es: " + sumaTotal);

            System.out.println("El promedio de los Vectores es: " + promediar(sumaTotal, 10));

            for (int i = 0; i < 10; i++) {

                if (numeros[i] % 2 == 0)
                    System.out.println("Dato par en posicion:" + (i + 1));
                else
                    System.out.println("Dato impar en posicion:" + (i + 1));

            }

        }
    }

    public static void rellenarArrayAleatorio(int numeros[]) {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 10 - 10 + i);
            System.out.println("En la Poscision[" + i + "]esta el vector:" + numeros[i]);
            System.out.println();

        }
    }

    public static double promediar(int sumaNumeros, int contadorNumeros) {
        return sumaNumeros/contadorNumeros;
    }

    public static void sacarPorcentaje(int contadorPares, int contadorImpares){
        int cantidadTotal = contadorImpares + contadorPares;
        double porcentajeImpar = (contadorImpares * 100)/cantidadTotal;
        double porcentajePar = (contadorPares*100)/cantidadTotal;

        System.out.println("El porcentaje de los números pares es " + porcentajePar);
        System.out.println("El porcentaje de los números impares es " + porcentajeImpar);
    }

}