package codeChallenge;

import java.util.HashMap;

public class CrackingCodeInterview {
    public static void main(String[] args){
        System.out.println("Hello Cracking the code interview");
        // 1.- Is Unique
        System.out.println("The string has unique characters: "+isUniqueChars("aAzZ09aBaDCds"));
        // 1.- Is Unique Lower Alphabetic
        System.out.println("The string a-z has unique characters: "+isUniqueLowerChars("ac"));
        //System.out.println("hi".hashCode());
        //System.out.println("abc".hashCode());
        System.out.println("The string has unique characters MAP: "+isUniqueCharsMap("abc"));
    }

    // Is Unique: Implement an algorithm to determine if a String has all unique characters.
    // What if you cannot use additional data structures
    // Validate ASCII characters (numbers 0-9, upper/lower case A to Z) / Unicode characters ??
    // Time complexity: O(n) n->The length of the string / Could be O(1) -> Cause loop never iterate more than 128 characters
    // Space complexity: O(1)
    // Could be express the Complexity: Space O(c) and Time O(min(c,n)) or O(c) -> c is the size of the character set
    // Could be check with a for (for) -> Time O(n2) - Space O(1)
    // Could be sort the array, and compare the character to the next character to check if its equal (Check the time to sort)
    public static Boolean isUniqueChars(String str) {
        if (str.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];

        for (int i=0; i < str.length(); i++) {
            int val = str.charAt(i);
            //System.out.println("Char: "+str.charAt(i)+" Ascii Val: "+val);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static Boolean isUniqueLowerChars(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            //System.out.println("Char: "+str.charAt(i)+" nuevo valor ASCII para desplazamiento: "+val);
            //System.out.println("Checker: "+checker+" Desplazamiento a Izquierda: "+(1 << val));
            if ((checker & (1 << val)) > 0) { // And es operacion binaria con los decimales
                return false;
            }
            checker |= (1 << val); // Or es operacion binaria con los decimales
            //System.out.println("Checker Iteracion: "+checker);
        }
        return true;
    }

    public static Boolean isUniqueCharsMap(String str) {
        HashMap<Integer,Integer> mapChars = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            int valor = str.charAt(i);
            System.out.println("valor: "+valor);

            mapChars.put(valor, mapChars.getOrDefault(valor, 0) +1);

            if (mapChars.get(valor) > 1) {
                return false;
            }
        }


        return true;
    }

}
