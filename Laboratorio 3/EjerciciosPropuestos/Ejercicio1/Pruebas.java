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
        System.out.println(nums);
    }
}
