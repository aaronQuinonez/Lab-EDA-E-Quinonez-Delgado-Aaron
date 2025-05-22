import java.util.ArrayList;
import java.util.Iterator;
public class EjercicioResuelto2Lab3 {

    public static void main(String[] args) {
        ArrayList<String> alumnos = new ArrayList<String>(); 
        alumnos.add("MARIA"); 
        alumnos.add("DIEGO"); 
        alumnos.add("RENE"); 
        alumnos.add("ALONSO");
        ArrayList<Integer> notas = new ArrayList<Integer>(); 
        notas.add(1); 
        notas.add(5); 
        notas.add(3); 
        notas.add(4); 
        Iterator<String> itA = alumnos.iterator(); 
        while (itA.hasNext()) { 
            System.out.println(itA.next()); 
        }
        Iterator<Integer> itN = notas.iterator();
        while (itN.hasNext()) {
            System.out.println(itN.next());
        }
    }
}