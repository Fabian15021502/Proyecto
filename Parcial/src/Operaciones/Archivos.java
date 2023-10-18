package Operaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import InOut.Producto;

public class Archivos {

    private final static String archivo = new String ("C:\\Users\\Esteban Beltran\\Desktop\\Parcial\\Parcial\\src\\Archivos"); // especificar la ruta de la carpeta conde se guardan los archivos
	private static File leer_p;
	private static FileWriter escritor;
	
	public static void crearArchivo(ArrayList<Producto> listaProductos, int opciones, String nombre){
		File archivo2 = new File (archivo);
		System.out.println("hola");
		if (archivo2.exists()){
			System.out.println("Ya existe el archivo\n adicionando productos...");
			escribir_archivo(listaProductos, opciones, nombre);
		}else{
			try{
			if(archivo2.createNewFile()){
				System.out.println("Archivo creado...");
			}else{
				 System.out.println("Error al crear archivo");
			}
		}catch(IOException exception){
			exception.printStackTrace(System.out);
		}
		}
	}

	public static void escribir_archivo(ArrayList<Producto> listaProductos, int opciones, String nombre){
		try{
			if(opciones == 0){
				escritor = new FileWriter(archivo+nombre+".txt",true);
			}else{
				escritor = new FileWriter(archivo+nombre+".txt");
			}
			

			for (Producto producto : listaProductos) {
				//escribe los datos en el archivo
				escritor.write(producto.getNombre_Producto() + "," + producto.getTipo() + "," + producto.getCantidad() + "," + producto.getPrecio() + "\n");
			}
			escritor.close();
			System.out.println("Archivo creado satisfactoriamente..");
		}catch(IOException exception){
			exception.printStackTrace(System.out);
		}
	}

	public static ArrayList<Producto> leerArchivo(String nombre) {
		leer_p = new File(archivo+nombre+".txt");
        ArrayList <Producto> temp = new ArrayList<Producto>();
		if(!leer_p.exists()){
			return null;
		}else{
			Scanner lector;
            try(BufferedReader reader=new BufferedReader(new FileReader(leer_p))){
                lector = new Scanner(leer_p);
                while (lector.hasNextLine()){
                    String linea = lector.nextLine();
                    Scanner delimitar = new Scanner(linea);
                    delimitar.useDelimiter("\\s*,\\s*");
                        Producto producto = new Producto();
                        producto.setNombre_Producto(delimitar.next());
                        producto.setTipo(delimitar.next());
                        producto.setCantidad((int) delimitar.nextDouble());
						producto.setPrecio(delimitar.nextInt());
                        temp.add(producto);
                    delimitar.close();
                }
                
                lector.close();
                reader.close();
            }catch (IOException e){
            	 System.out.println("Ocurrio un error al leer el archivo...");
            }
			return temp;
		}
	}
    
}
