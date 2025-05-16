public class EjercicioResuelto4 {
    void imprimir(int x) { 
        if (x > 0) { 
            imprimir(x - 1); 
            System.out.println(x); 
        } 
    } 
    
    public static void main(String[] ar) { 
        EjercicioResuelto4 re = new EjercicioResuelto4(); 
        re.imprimir(5); 
    } 
}
