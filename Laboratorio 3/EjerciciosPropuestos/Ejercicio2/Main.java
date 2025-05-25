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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("CALCULADORA");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            if (opcion == 1) {
                System.out.print("Ingrese valor 1: ");
                double v1 = sc.nextDouble();
                System.out.print("Ingrese valor 2: ");
                double v2 = sc.nextDouble();
                System.out.println("Resultado: " + suma(v1, v2));
            } else if (opcion == 2) {
                System.out.print("Ingrese valor 1: ");
                double v1 = sc.nextDouble();
                System.out.print("Ingrese valor 2: ");
                double v2 = sc.nextDouble();
                System.out.println("Resultado: " + resta(v1, v2));
            } else if (opcion == 3) {
                System.out.print("Ingrese valor 1: ");
                double v1 = sc.nextDouble();
                System.out.print("Ingrese valor 2: ");
                double v2 = sc.nextDouble();
                System.out.println("Resultado: " + producto(v1, v2));
            }else if (opcion == 8) {
                System.out.println("Saliendo...");
                break;
            }else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
