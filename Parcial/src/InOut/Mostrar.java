package InOut;

import java.util.ArrayList;
import java.util.Scanner;

import Operaciones.Archivos;
import Operaciones.Operar;

        public class Mostrar {
        private static Scanner sc = new Scanner(System.in);
        private static String nombre;
        
        public static void menuPrincipal() throws InterruptedException{
            do {
                System.out.println("Digite su nombre: ");
                nombre = sc.nextLine();
            } while (Operar.comprobarNombre(nombre)==false);
            int opc;
            do{
                System.out.println("******************\n*      Menú     *\n******************\n\n1. Compra\n2. Agregar porductos\n3. Pagar\n4. Salir\nDigite Opcion: ");
                opc = sc.nextInt();
                switch(opc){
                    case 1 ->
                    Pedido.Menu1(nombre);
                    case 2->
                    CargarProductos.clave(nombre);
                    case 3 ->
                    mostrarFactura(nombre);
                }
    
            }while(opc!=4);
        }

        private static void mostrarFactura(String nombre){
            ArrayList <Producto> factura = new ArrayList <Producto>();
            factura = Archivos.leerArchivo(nombre);
            System.out.println("***********\n* Factura "+nombre+"*\n***********\nProducto\t Tipo\t Cantidad\tPrecio");
            double total = 0; // se declara e inicializa un acumulador
            for(int i = 0; i<factura.size();i++){
                System.out.println(factura.get(i).getNombre_Producto()+"\t"+factura.get(i).getTipo()+"\t"+factura.get(i).getCantidad()+"\t"+factura.get(i).getPrecio()*factura.get(i).getCantidad());
                total += factura.get(i).getPrecio()*factura.get(i).getCantidad(); // se suma el precio por cantidad de cada producto al acumulador
            }
            System.out.println("\nValor a pagar: "+total); // se muestra el valor del acumulador como el total a pagar
        }

        public static void mostrarPorTipo(ArrayList<Producto> lista, String tipo){
        int num,cantidad;
        System.out.println("-- \t"+tipo);
        mostrar(lista, tipo);
            do {
                System.out.println("Digite la opcion: ");
                num=sc.nextInt();
            } while (num<0 && num>lista.size());

            do {
                System.out.println("Digite la cantidad: ");
                cantidad=Operar.comprobarNumero(sc.nextInt());
                if(lista.get(num).getCantidad()-cantidad<0){
                    System.out.println("Cantidad no disponible");
                }
            } while (lista.get(num).getCantidad()-cantidad < 0);

            Pedido.cargarPedido(tipo, num, cantidad, lista, nombre,0); 
            lista.get(num).setCantidad(lista.get(num).getCantidad()-cantidad);
            Archivos.crearArchivo(lista, 1, "Productos");
        }
        
        public static void mostrar(ArrayList<Producto> lista, String tipo){
            System.out.println("******\n*"+tipo+"*\n******");
            System.out.println("opcion"+"\t"+"producto"+"\t\t"+"Precio");
            for(int i=0;i<lista.size();i++){
                if(lista.get(i).getTipo().equalsIgnoreCase(tipo))
                    System.out.println(i+"\t\t"+lista.get(i).getNombre_Producto()+"\t\t"+lista.get(i).getPrecio());
            }
        }
}
