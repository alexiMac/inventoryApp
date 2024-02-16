package codeChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class encontrarPar {

    public static void main(String[] args) {
        int[] arreglo = {2, 7, 4, 5, 1, 3, 8};
        getSum9(arreglo);
        encontrarParSuma9Optimo(arreglo);
        encontrarParSuma9(arreglo);
    }

    public static void getSum9(int[] arreglo) {
        for (int i = 0; i<arreglo.length; i++) {
            for (int j = 1+i; j<arreglo.length; j++) {
                if(arreglo[i]+arreglo[j] == 9) {
                    System.out.println("Suman 9: "+arreglo[i]+"-"+arreglo[j]);
                }
            }
        }
    }

    static void encontrarParSuma9Optimo(int[] arreglo) {
        Set<Integer> numerosVistos = new HashSet<>();

        for (int num : arreglo) {
            int complemento = 9 - num;
            if (numerosVistos.contains(complemento)) {
                System.out.println("Par encontrado: " + num + ", " + complemento);
            }
            
            numerosVistos.add(num);
        }
    }

    static void encontrarParSuma9(int[] arreglo) {
        Map<Integer, Integer> mapa = new HashMap<>();

        for (int i = 0; i < arreglo.length; i++) {
            int complemento = 9 - arreglo[i];
            if (mapa.containsKey(complemento)) {
                System.out.println("Par encontrado con mapa: " + arreglo[i] + ", " + complemento);
            }

            mapa.put(arreglo[i], i);
        }
    }

}