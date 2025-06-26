package Laboratorio2;
public class Recursividad {
    static int[] vec = {52, 78, 10, 654, 278};
    void repetir() {
        repetir(); 
    } 

    void imprimir(int n){
        if(n == 0){
            System.out.println(0);
        }
        else{
            System.out.println(n);
            imprimir(n-1);
        } 
    }

    int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n*factorial(n-1);
    }

    void ordenar(int[] vec, int len){
        if(len > 1){
            for (int f = 0; f < len - 1; f++){
                if (vec[f] > vec[f + 1]) { 
                    int aux = vec[f]; 
                    vec[f] = vec[f + 1]; 
                    vec[f + 1] = aux; 
                }
            } 
            ordenar(vec, len - 1); 
        }
    }

    void imprimirVec(int[] vec){
        for(int num : vec){
            System.out.print(num + " ");
        }
        System.err.println();
    }
    public static void main(String[] ar) { 
        Recursividad re = new Recursividad(); 
        re.imprimir(5);
        System.out.println(re.factorial(6));
        re.imprimirVec(vec);
        re.ordenar(vec, vec.length);
        re.imprimirVec(vec);
    }

}
