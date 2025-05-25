public class Pruebas {
    public static void main(String[] args) {
        ListLinked<Integer> nums = new ListLinked<>();
        System.out.println(nums.isEmpty());
        //Agregando
        nums.insertarPrimero(12);
        System.out.println(nums.isEmpty());
        System.out.println(nums);
        nums.insertarPrimero(14);
        nums.insertarPrimero(55);
        nums.insertarPrimero(7);
        nums.insertarUltimo(99);
        nums.insertarUltimo(77);
        System.out.println(nums);
        //Buscando
        System.out.println("Buscando 55: "+ nums.buscar(55));
        System.out.println("Buscando 1: " + nums.buscar(1));

        //Usando objeto Alumno
        ListLinked<Alumno> alumnos = new ListLinked<>();
        System.out.println(alumnos.isEmpty());
        //Agregando
        alumnos.insertarPrimero(new Alumno("Aarón", 20, 20230466));
        alumnos.insertarUltimo(new Alumno("Juan", 19, 20230544));
        alumnos.insertarPrimero(new Alumno("José", 20, 20230769));
        alumnos.insertarPrimero(new Alumno("María", 20, 20240512));
        System.out.println(alumnos);
        //Buscando
        System.out.println("Buscando alumno Aarón:" + alumnos.buscar(new Alumno("Aarón", 20, 20230466)));
        System.out.println("Buscando alumno Aarón (diferente cui):" + alumnos.buscar(new Alumno("Aarón", 20, 20230400)));
        System.out.println("Buscando alumno Pedro:" + alumnos.buscar(new Alumno("Pedro", 23, 20241578)));
    }
}
