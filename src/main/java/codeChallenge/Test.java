package codeChallenge;

public class Test {
    public static void main(String[] args) {
        //System.out.println("Factorial de un numero");
        //int number = 3;
        //long factorial = calculaFactorial(number);
        //System.out.println("El factorial de "+number+" es: "+factorial);
        subcadena();
    }

    public static long calculaFactorial(int numero) {
        if (numero == 0 || numero == 1 ) {
            return 1;
        } else {
            return numero * calculaFactorial(numero -1);
        }
    }

    public static void subcadena() {
        //String palabra = "aeiaaioooaauuaeiu";
        //String palabra = "aeeiiaou";
        String palabra = "aeeiiau";
        String vowels = "aeiou";
        Integer index = 0; // Hasta el indice 4
        Integer contador = 0; // numero de subcadena

        for (char c: palabra.toCharArray()) {
            //System.out.println("Letra actual: "+ c);
            //System.out.println("letra actual: "+vowels.charAt(0));
            if (c == vowels.charAt(index)) {
                contador = contador + 1;
                //System.out.println("Letra coincide: " + vowels.charAt(index));
            } else if (index+1 < vowels.length() && c == vowels.charAt(index+1)) {
                //System.out.println("Letra no coincide pero es la siguiente en las vocales: " + vowels.charAt(index+1));
                contador += 1;
                index += 1;
            }
        }

        if (index != 4) {
            contador = 0;
        }

        System.out.println("Subcadenas: " + contador);
        System.out.println("Index: " + index);

    }

}
