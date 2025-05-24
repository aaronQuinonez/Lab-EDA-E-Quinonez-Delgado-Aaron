import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EjercicioPropuesto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Alumno> alumnos = new ArrayList<>();
        System.out.println("Ingrese la cantidad de alumnos a registrar:");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            System.out.println("Ingrese el nombre del alumno " + (i+1) + ":");
            String nom = sc.next();
            System.out.println("Ingrese la edad del alumno " + (i+1) + ":");
            int edad = sc.nextInt();
            System.out.println("Ingrese el CUI del alumno " + (i+1) + ":");
            int cui = sc.nextInt();
            //Creamos un objeto de tipo alumno
            Alumno tmp = new Alumno();
            tmp.setNombre(nom);
            tmp.setCui(cui);
            tmp.setEdad(edad);
            //Método "add()" para agregarlos al ArrayList
            alumnos.add(tmp);
        }
        
        Node<Integer>nodeInteger = new Node<>();
        Node<Alumno>nodeAlumno = new Node<>();
        Node<String>nodeString = new Node<>();
    }
}
