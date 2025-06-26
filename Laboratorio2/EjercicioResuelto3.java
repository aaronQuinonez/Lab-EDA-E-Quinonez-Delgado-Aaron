package Laboratorio2;
public class EjercicioResuelto3 {
    void imprimir(int x) { 
        if (x > 0) { 
            System.out.println(x); 
            imprimir(x - 1); 
        } 
    } 
    
    public static void main(String[] ar) { 
        EjercicioResuelto3 re = new EjercicioResuelto3(); 
        re.imprimir(5); 
    } 
}
