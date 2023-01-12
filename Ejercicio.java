package bootcamp.ejercicios;

public class Ejercicio {

    public static void main(String[] args) {

        reverse("Abel Osbeli Alvarez del aguila");
    }
    public static String reverse(String texto) {

        int txt = texto.length();
        int i;
        //recorro el texto normal
        for (int l = 0; l < txt ; l++){
            System.out.print(texto.charAt(l));
        }
        System.out.println("");
        //recorro el texto en reverse;
        for (i = txt-1; i >= 0; i--){
            System.out.print(texto.charAt(i));
        }
        return texto;
    }
}
