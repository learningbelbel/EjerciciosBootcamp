package bootcamp.ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Ejercicios {

    public static void main(String[] args) {

        //Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
        System.out.println("#########################################");
        System.out.println("1. Ejercicio 1");

        String [] frutas = {"Manzana", "Peras", "Mango","Sandia","Banano"};

        for (String fruta : frutas){
            System.out.println(fruta);
        }

        //Crea un array bidimensional de enteros y
        // recórrelo, mostrando la posición y el valor de cada elemento en ambas dimensiones.
        System.out.println("");
        System.out.println("#########################################");
        System.out.println("2. Ejercicio 2");


        int [][] numeros = new int[3][4];
        numeros[0][0] = 10;
        numeros[0][1] = 20;
        numeros[0][2] = 30;
        numeros[0][3] = 40;

        numeros[1][0] = 100;
        numeros[1][1] = 200;
        numeros[1][2] = 300;
        numeros[1][3] = 400;

        numeros[2][0] = 1000;
        numeros[2][1] = 2000;
        numeros[2][2] = 3000;
        numeros[2][3] = 4000;


        for (int i = 0; i < numeros.length; i++){
            System.out.println("fila: " + i);

            for (int j = 0; j <= numeros.length; j++){
                System.out.println("columna: " + j + " valor: " + numeros[i][j]);
            }
        }

        //Crea un "Vector" del tipo de dato que prefieras,
        //y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.

        System.out.println("");
        System.out.println("#########################################");
        System.out.println("3. Ejercicio 3");

        Vector<String> nombres = new Vector<String>(2,5);
        nombres.add("Abel");
        nombres.add("Angel");
        nombres.add("Abiel");
        nombres.add("Eman");
        nombres.add("Enjil");
        System.out.println(nombres);

        nombres.remove(2); // elimino elemento en posicion 2
        nombres.remove(3); // elimino elemento en posicion 3
        System.out.println(nombres);

        //Indica cuál es el problema de utilizar un
        //Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser añadidos al mismo.

        //Respuesta// el problema seria que cada vez que llenamos el vector, este se debe de copiar,
        // duplicando el consumo de memoria y podria ser que el programa se relentice


//        Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList.
//        Recorre ambos mostrando únicamente el valor de cada elemento.

        System.out.println("");
        System.out.println("#########################################");
        System.out.println("5. Ejercicio 5");

        ArrayList<String> listaLenguajes = new ArrayList<>();
        listaLenguajes.add("JAVA");
        listaLenguajes.add("JavaScript");
        listaLenguajes.add("C#");
        listaLenguajes.add("Python");

        LinkedList<String> lenguajes = new LinkedList<>(listaLenguajes);

        System.out.println("");
        for(String lenguaje : listaLenguajes){
            System.out.println("El lenguaje es: " + lenguaje);
        }
        System.out.println("");
        for (String lenguaje : lenguajes){
            System.out.println("El lenguaje de programacion es: " + lenguaje);
        }
//        Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
//        A continuación, con otro bucle, recórrelo y elimina los numeros pares.
//        Por último, vuelve a recorrerlo y muestra el ArrayList final.
//        Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

        System.out.println("");
        System.out.println("#########################################");
        System.out.println("6. Ejercicio 6");
        ArrayList<Integer> numerosList = new ArrayList<>();

        System.out.println(" ");
        for (int i = 1; i <= 10; i++){
            numerosList.add(i);

        }
        System.out.println(numerosList);
//        System.out.println(numerosList.size());

        for( int i = 0; i <= numerosList.size(); i++){
            if (i % 2 == 0){
                numerosList.remove(i);
            }
        }
        System.out.println(numerosList);


//        Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante
//        del tipo ArithmeticException que será capturada por su llamante (desde "main", por ejemplo).
//        Si se dispara la excepción, mostraremos el mensaje
//        "Esto no puede hacerse". Finalmente, mostraremos en cualquier caso: "Demo de código".
        System.out.println("");
        System.out.println("#########################################");
        System.out.println("7. Ejercicio 7");

        try{

            dividePorCer(10);
        } catch (ArithmeticException e){
            System.out.println("Error: Esto no puede hacerse");
        }

//        Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros:
//        "fileIn" y "fileOut". La tarea de la función será realizar la copia del fichero dado
//        en el parámetro "fileIn" al fichero dado en "fileOut".
        System.out.println("");
        System.out.println("#########################################");
        System.out.println("8. Ejercicio 8");

        try{
            InputStream fileIn = new FileInputStream("./datos.txt");
            PrintStream fileOut = new PrintStream( "fileOut.txt");
            copiarFiles(fileIn, fileOut);
        }catch (FileNotFoundException e){
            System.out.println("Error: file not found " + e.getMessage());
        }

//     Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.

    }

    public static void copiarFiles(InputStream fileIn, PrintStream fileOut) {

        try{
            byte[] data = fileIn.readAllBytes();
            for(byte b : data){
                System.out.print((char) b);
            }

            fileOut.write(data);


        }catch (FileNotFoundException e){
            System.out.println("Error: File Not found" + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int dividePorCer(int numero) throws ArithmeticException{
        int resultado;
            resultado = numero/0;
            System.out.println(resultado);

        return  resultado;
    }
}
