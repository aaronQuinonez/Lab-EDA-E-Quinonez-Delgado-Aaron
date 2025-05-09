import java.util.Scanner;

public class EjercicioPropuesto3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la longitud de su array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            System.out.println("Ingrese el valor para la posición" + (i) + ":");
            arr[i] = sc.nextInt();
        }
        System.out.println("Antes de ordenar:");
        ImpArreglo(arr);
        //Usamos el método de Insercion
        Insercion(arr);
        System.out.println("Después de ordenar:");
        ImpArreglo(arr);
    }
    public static void ImpArreglo(int[] arr){
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void Insercion(int[] arr){
        for(int i=1; i<arr.length; i++){
            int num = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > num) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = num;
        }
    }
}
