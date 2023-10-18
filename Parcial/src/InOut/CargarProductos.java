package InOut;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Operaciones.Archivos;
import Operaciones.Operar;

public class CargarProductos {
    
        private static Scanner sc = new Scanner(System.in);
        private static String[] opciones = {"Entrantes","Hamburguesa","Combos Hamburgesa","Bebidas"};
        private static String [] opciones0 = {"Alitas", "Patacones","Nachos","Doritos","Maduro"};
        private static String [] opciones1 = {"Mixta", "Doble ","Sencilla","Especial","Pollo"};
        private static String [] opciones2 = {"Mixta + Gaseosa + Papas", "Doble + Gaseosa + Papas ","Sencilla + Gaseosa + Papas","Especial + Gaseosa + Papas","Pollo + Gaseosa + Papas"};
        private static String [] opciones3 = {"Coca cola", "Agua","Pepsi","Colombiana","Heineken","Cuatro"};
       

        public static void clave(String nombre) throws InterruptedException{
            int contra=0;
            do{
                System.out.println(nombre+" Digite la contraseña");
                try {
                    contra = sc.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR: Caracteres no permitidos");
                }
                if (contra!=2458){
                    System.out.println("Contraseña Incorrecta");
                    Thread.sleep(500);
                }
            }while(contra!=2458);
            ingresar_porductos();
        }

        public static void ingresar_porductos() throws InterruptedException{
        ArrayList <Producto> ListaProductos = new ArrayList<Producto>();
        
        int cent=1;
        Producto productotemp = new Producto();
        System.out.println("**************\n* Acceso Concedido *\n**************");
            do {
                productotemp.setTipo(seleccionarTipo(opciones, "producto"));
                if(productotemp.getTipo().equalsIgnoreCase(opciones[0])){
                    productotemp.setNombre_Producto(seleccionarTipo(opciones0,opciones[0]));
                }else if(productotemp.getTipo().equalsIgnoreCase(opciones[1])){
                    productotemp.setNombre_Producto(seleccionarTipo(opciones1,opciones[1]));
                }else if(productotemp.getTipo().equalsIgnoreCase(opciones[2])){
                    productotemp.setNombre_Producto(seleccionarTipo(opciones2,opciones[2]));
                }else if(productotemp.getTipo().equalsIgnoreCase(opciones[3])){
                    productotemp.setNombre_Producto(seleccionarTipo(opciones3,opciones[3]));
                }else {
                    System.out.println("ERROR: Digite una opción válida...");
                    ingresar_porductos();
                }
                productotemp.setCantidad(Operar.digitosne(sc, " cantidad"));
                productotemp.setPrecio(Operar.digitosNegativos(sc," precio"));
                ListaProductos.add(productotemp);
               
                System.out.println("Desea regstrar otro producto? No = 0  Si = otra tecla");
                cent = sc.nextInt();
            } while (cent!=0);
            Archivos.crearArchivo(ListaProductos, 0, "Productos");
            ArrayList <Producto> ListaLeida = new ArrayList<Producto>();
            System.out.println("\t\tDatos Guardados\nNombre\t\tTipo\t\tCantidad\tPrecio");
            Thread.sleep(500);
            ListaLeida = Operaciones.Archivos.leerArchivo("productos");
            
             for( Producto prod : ListaLeida){
                    System.out.println(prod.getNombre_Producto()+"\t\t"+prod.getTipo()+"\t\t"+prod.getCantidad()+"\t\t"+prod.getPrecio());
             }
          
        }

        public static String seleccionarTipo(String[] opciones, String p){
            System.out.println("Seleccione el tipo de "+p+": ");
            for(int i=0;i<opciones.length;i++){
                System.out.println((i)+"\t"+opciones[i]);
            }
            return opciones[sc.nextInt()];
        } 

}
