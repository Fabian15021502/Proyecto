package Operaciones;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operar {

    public static boolean comprobarNombre(String nom) {
        boolean com = true;
        for (int i = 0; i < nom.length(); i++) {
            if (nom.charAt(i) != ' ') {
                if (nom.charAt(i) <= 65 || nom.charAt(i) >= 91 && nom.charAt(i) > 122 && nom.charAt(i) != 'ñ') {
                    com = false;
                }
            }
        }

        return com;
    }

    public static int comprobarNumero(int num2){
        int num=0;
            do{
                try {
                    num = num2;
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR: Caracteres no permitidos");
                }
                if (num<=0){
                    System.out.println("Numeros nulos o negativos no validos....");
                }
            }while( num <= 0);
        return num;
    }

    public static int digitosNegativos (Scanner sc,String p) throws InterruptedException{
    boolean a= false;
        int num=0;
            do{
                System.out.println("Digite "+p+": ");
                try {
                    num = sc.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR: Caracteres no permitidos");
                }
                if (num<0){
                    System.out.println("Numeros negativos no validos....");
                    Thread.sleep(500);
                }else {
                    a=true;
                }
            }while(a!=true);
        return num;
    }

    public static int digitosne(Scanner sc, String p)throws InterruptedException{
        boolean a= false;
        int num=0;
        do {
            System.out.println("Digite"+p+": ");
            try{
               num=sc.nextInt(); 
            }catch(InputMismatchException ex){
                System.out.println("ERROR: Caracteres no permitidos");
            }
            if (num<=0){
                    System.out.println("Numeros negativos no validos....");
                    Thread.sleep(1000);
            }else{
                a=true;
            }
            
        } while (a!=true);
        return num;
    }

   /*  public static void acumuladorCombo(ArrayList<Producto> lista, String nombre, String tipo, Producto pedido){
        Scanner sc = new Scanner(System.in);
        int num;
        String nombreCompleto;
        String[] temp ;
        Mostrar.mostrar(lista, tipo);
        do {
            System.out.println("Digite la opcion: ");
            num=sc.nextInt();
        } while (num<0 && num>lista.size());

        if ((lista.get(num).getCantidad()-1) == 0){
            System.out.println(tipo+" no disponible, Escoja otra...");
            Mostrar.mostrar(lista, nombre);
        }else{
            nombreCompleto = Pedido.cargarPedido(tipo, num, 1, lista, nombre, 1);
            temp = nombreCompleto.split(",");
            pedido.setNombre_Producto(temp[0]+pedido.getNombre_Producto());
            pedido.setPrecio((int)(Integer.parseInt(temp[1])/0.1)+pedido.getPrecio());
            pedido.setTipo("Combo");
        }
        sc.close();
    }*/
}
