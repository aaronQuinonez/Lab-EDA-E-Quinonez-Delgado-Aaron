package Laboratorio2;
public class EjercicioResuelto2 {
    void imprimir(int x) { 
        System.out.println(x); 
        imprimir(x - 1); 
    } 
    
    public static void main(String[] ar) { 
        EjercicioResuelto2 re = new EjercicioResuelto2(); 
        re.imprimir(5); 
    } 
}
