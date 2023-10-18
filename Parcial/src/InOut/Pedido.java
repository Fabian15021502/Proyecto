package InOut;

import java.util.ArrayList;
import java.util.Scanner;

import Operaciones.Archivos;

public class Pedido {
    private static final Scanner sc = new Scanner(System.in);

    public static void Menu1(String nombre) throws InterruptedException{
        if(Archivos.leerArchivo("Productos")==null){
            System.out.println("No hay productos Cargados, regresando al menu principal");
            Mostrar.menuPrincipal();
        }else{
            int resp;
            ArrayList <Producto> ListaProductos = new ArrayList<Producto>();
            
            ListaProductos = Archivos.leerArchivo("Productos");
            do {
                System.out.println(" MENU \n1. Entrantes.\n2. Hamburguesas.\n3. Bebidas.\n4. Combos Hamburgesa \n5. Salir. \nDigite la opción:");

                    resp = sc.nextInt();
                    switch (resp) {
                        case 1 ->
                            Mostrar.mostrarPorTipo(ListaProductos, "Entrantes");
                        case 2 ->
                            Mostrar.mostrarPorTipo(ListaProductos, "Hamburguesa");
                        case 3 ->
                            Mostrar.mostrarPorTipo(ListaProductos, "Bebidas");
                        case 4->
                            Mostrar.mostrarPorTipo(ListaProductos, "Combos Hamburgesa");
                    }
            } while (resp!=5);     
        }
   }

    public static String cargarPedido(String tipo, int num, int cantidad, ArrayList<Producto> lista,String nombre, int opciones){
    ArrayList <Producto> factura = new ArrayList<Producto>();
    Producto pedido = new Producto();
    if(tipo.equalsIgnoreCase("Entrantes")){
        String adicional []= {"Con Salsa de tomate","Con Ají","Con salsa BBQ"};
        System.out.println("¿Qué desea agregar?");
        pedido.setCantidad(cantidad);
        pedido.setNombre_Producto(lista.get(num).getNombre_Producto().concat(" "+CargarProductos.seleccionarTipo(adicional, "adiciones")));
        pedido.setPrecio(lista.get(num).getPrecio());
        pedido.setTipo(lista.get(num).getTipo());

    }else if(tipo.equalsIgnoreCase("Hamburguesa")){
        String adicional []= {"Sin Salsa de tomate","Sin Mayonesa","Sin Cebolla","Con Peinillo","Con Tocino","Con champiñon"};
        System.out.println("¿Qué desea agregar?");
        pedido.setCantidad(cantidad);
        pedido.setNombre_Producto(lista.get(num).getNombre_Producto().concat(" "+CargarProductos.seleccionarTipo(adicional, "adiciones")));
        pedido.setPrecio(lista.get(num).getPrecio());
        pedido.setTipo(lista.get(num).getTipo());
        
    }else if (tipo.equalsIgnoreCase("Bebidas")){
         System.out.println("¿Qué desea agregar?");
          String adicional []= {"Con hielo", "Con tajin","Sin ázucar"};
        pedido.setCantidad(cantidad);
        pedido.setNombre_Producto(lista.get(num).getNombre_Producto().concat(" "+CargarProductos.seleccionarTipo(adicional, "adiciones")));
        pedido.setPrecio(lista.get(num).getPrecio());
        pedido.setTipo(lista.get(num).getTipo());
    }else if(tipo.equalsIgnoreCase("Combos Hamburgesa")){
        System.out.println("¿Qué desea agregar?");
          String adicional []= {"Sin Salsa de tomate","Sin Mayonesa","Sin Cebolla","Con Peinillo","Con Tocino","Con champiñon"};
        pedido.setCantidad(cantidad);
        pedido.setNombre_Producto(lista.get(num).getNombre_Producto().concat(" "+CargarProductos.seleccionarTipo(adicional, "adiciones")));
        pedido.setPrecio(lista.get(num).getPrecio());
        pedido.setTipo(lista.get(num).getTipo());
    }
    if(opciones == 0){
        factura.add(pedido);
        Operaciones.Archivos.crearArchivo(factura,0,nombre);
        factura.clear();
        return null;
    }else{
        return pedido.getNombre_Producto().concat(","+String.valueOf(pedido.getPrecio()));
    }
    

   }

   /*  public static void combos(String nombre){
    ArrayList <Producto> listaProductos = new ArrayList<Producto>();
    ArrayList <Producto> factura = new ArrayList<Producto>();
    Producto pedido = new Producto();
    listaProductos = Archivos.leerArchivo("Productos");
    
    Operar.acumuladorCombo(listaProductos, nombre, "Hamburguesa", pedido);
    Operar.acumuladorCombo(listaProductos, nombre, "Bebida", pedido);
    Operar.acumuladorCombo(listaProductos, nombre, "Postre", pedido);
    factura.add(pedido);
    Operaciones.Archivos.crearArchivo(factura,0,nombre);
    factura.clear();
    }
    */

}
