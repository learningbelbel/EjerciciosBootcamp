package bootcamp.ejercicios;

import java.io.*;
import java.util.*;

public class EjercicioPrograma {

    public static void main(String[] args) {

        // programa, para que puedas ingresar el nombre de tu familia, y crear un archivo con esa informacion
        // luego, leer ese archivo Sorpréndenos creando un programa de tu elección que utilice

//VARIABLES
        Scanner scanner = new Scanner(System.in);
        int confirmation;
        String nombres;

//MENU
        String[] menu = {"Crear Lista de Productos", "Crear Lista de Tareas", "Salir"};
        for (int i = 0; i <menu.length; i++){
            System.out.println(i + "-. " +  menu[i]);
        }
        int menuConf = scanner.nextInt();

//Creo la lista de los productos que voy a guardar

        HashMap<String,Double> nameList = new HashMap<>();
        String nombreDelFile = null;

        try {

        if (menuConf == 0){
            Double price;
            System.out.println("Ingresa un Nombre de Producto");
            do {
                nombres = scanner.next();
                System.out.println("Ingresa el Costo");
                price = scanner.nextDouble();
                nameList.put(nombres,price);

                System.out.println("Desea Agregar otro producto? \n1-. yes 2-. no ");
                scanner.reset();
                confirmation = scanner.nextInt();
                if (confirmation == 1) {
                    System.out.println("Ingresa otro nombre");
                }
            }while(confirmation ==1);

//Escribir archivo con los nombres
            System.out.println("Escriba el nombre del Archivo donde quiere guardar su information");
            nombreDelFile = scanner.next();
            crearArchivo(nameList,nombreDelFile);
        }
        else if (menuConf == 1) {
            System.out.println("Escriba el nombre de la Tarea");
            ArrayList<String> list = new ArrayList<String>();
            do{
                nombres = scanner.next();
                list.add(nombres);
                System.out.println("Desea Agregar otro nombre? \n Ingresa 1-. yes 2-. no ");
                scanner.reset();
                confirmation = scanner.nextInt();
                if (confirmation == 1) {
                    System.out.println("Ingresa otro nombre");
                }
            }while (confirmation == 1);
//Escribir archivo con los nombres
            System.out.println("Escriba el nombre del Archivo donde quiere guardar su information");
            nombreDelFile = scanner.next();
            crearArchivoList (list,nombreDelFile);
        }
//Leer los nombres ingresados
            readFile(nombreDelFile);

        } catch (InputMismatchException e){
            System.out.println("Error: el tipo de dato ingresado no es correcto. Reinicia el Programa");
        }
    }
    public static void readFile(String nombreDelFile) {
        try{
            InputStream fileToRead = new FileInputStream(nombreDelFile);

            byte[] info = fileToRead.readAllBytes();
            for (byte information : info){
                System.out.print((char) information);
            }

        } catch (FileNotFoundException e){
            System.out.println("Error: no se pudo encontrar el archivo");
        } catch (IOException e){
            System.out.println("Error: no pudo leer el archivo");
        }
    }
    public static void crearArchivo(HashMap nameList, String nombreDelFile) {
        try {
            PrintStream fileToCreate = new PrintStream(nombreDelFile);
            System.out.println("El archivo se creo Correctamente!! \nA continuacion la informacion ingresada \n");
            fileToCreate.println(nameList);
        }
        catch (FileNotFoundException e){
            System.out.println("Error: el archivo no se pudo crear");
        }
    }
    public static void crearArchivoList(ArrayList list, String nombreDelFile) {
        try {
            PrintStream fileToCreate = new PrintStream(nombreDelFile);
            System.out.println("El archivo se creo Correctamente!! \nA continuacion la informacion ingresada \n");
            fileToCreate.println(list);
        }
        catch (FileNotFoundException e){
            System.out.println("Error: el archivo no se pudo crear");
        }
    }
}