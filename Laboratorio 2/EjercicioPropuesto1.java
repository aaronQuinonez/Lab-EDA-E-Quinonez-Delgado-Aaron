//Invertir vector de enteros, permite ingresar tamaño y captura de valores del arreglo, el método 
//invertirArray calcula y muestra el resultado.
public class EjercicioPropuesto1 {
    public int[] invertirArray(int[] A){
        int[] Asalida = new int[A.length];
        int i = 0;
        //Creamos un loop que recorrerá desde la última posición del array original y será la primera posición del nuevo array "Asalida" 
        for(int j=A.length-1; i<A.length; i++){
            Asalida[i] = A[j];
            i++;
        }
        return Asalida;
    }
    public static void main(String[] args) {
        
    }
}
