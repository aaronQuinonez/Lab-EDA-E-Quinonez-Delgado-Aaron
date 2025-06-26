package Laboratorio3.EjerciciosPropuestos.Ejercicio2;

import java.util.Scanner;

public class Main {
    static <T extends Number> double suma(T valor1, T valor2){
        return (valor1.doubleValue() + valor2.doubleValue());
    }

    static <T extends Number> double resta(T valor1, T valor2){
        return (valor1.doubleValue() - valor2.doubleValue());
    }
    
    static <T extends Number> double producto(T valor1, T valor2){
        return (valor1.doubleValue() * valor2.doubleValue());
    }

    static <T extends Number> double division(T valor1, T valor2){
        //Si se divide entre 0
        if(valor2.doubleValue() == 0)
            throw new ArithmeticException("División por cero");
        return (valor1.doubleValue() / valor2.doubleValue());
    }

    static <T extends Number> double potencia(T valor1, T potencia){
        return (Math.pow(valor1.doubleValue(), potencia.doubleValue()));
    }
    static <T extends Number> double raizCuadrada(T valor1){
        return (Math.sqrt(valor1.doubleValue()));
    }
    static <T extends Number> double raizCubica(T valor1){
        return (Math.cbrt(valor1.doubleValue()));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("CALCULADORA");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            if (opcion == 1) {
                System.out.print("Ingrese valor 1: ");
                double v1 = sc.nextDouble();
                System.out.print("Ingrese valor 2: ");
                double v2 = sc.nextDouble();
                System.out.println("Resultado: " + suma(v1, v2));
            }else if (opcion == 2) {
                System.out.print("Ingrese valor 1: ");
                double v1 = sc.nextDouble();
                System.out.print("Ingrese valor 2: ");
                double v2 = sc.nextDouble();
                System.out.println("Resultado: " + resta(v1, v2));
            }else if (opcion == 3) {
                System.out.print("Ingrese valor 1: ");
                double v1 = sc.nextDouble();
                System.out.print("Ingrese valor 2: ");
                double v2 = sc.nextDouble();
                System.out.println("Resultado: " + producto(v1, v2));
            }else if (opcion == 4) {
                System.out.print("Ingrese valor 1: ");
                double v1 = sc.nextDouble();
                System.out.print("Ingrese valor 2: ");
                double v2 = sc.nextDouble();
                System.out.println("Resultado: " + division(v1, v2));
            }else if (opcion == 5) {
                System.out.print("Ingrese base: ");
                double base = sc.nextDouble();
                System.out.print("Ingrese exponente: ");
                double exp = sc.nextDouble();
                System.out.println("Resultado: " + potencia(base, exp));
            }else if (opcion == 6) {
                System.out.print("Ingrese valor: ");
                double val = sc.nextDouble();
                System.out.println("Resultado: " + raizCuadrada(val));
            }else if (opcion == 7) {
                System.out.print("Ingrese valor: ");
                double val = sc.nextDouble();
                System.out.println("Resultado: " + raizCubica(val));
            }else if (opcion == 8) {
                System.out.println("Saliendo...");
                break;
            }else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
