import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();

        int opcion;

        do {

            System.out.println("\n===== TREE-STOCK =====");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    inventario.insertar(id, nombre);

                    System.out.println("Producto registrado.");
                    break;

                case 2:

                    inventario.mostrarInventario();
                    break;

                case 3:

                    System.out.print("Ingrese ID a buscar: ");

                    int buscar = sc.nextInt();

                    Producto encontrado = inventario.buscar(buscar);

                    if (encontrado != null) {

                        System.out.println("Producto encontrado:");
                        System.out.println("ID: " + encontrado.id);
                        System.out.println("Nombre: " + encontrado.nombre);

                    } else {

                        System.out.println("Producto no encontrado en el inventario.");
                    }

                    break;

                case 0:

                    System.out.println("Muchas gracias por la consulta, vuelve luego.");
                    break;

                default:

                    System.out.println("Opción inválida, marca una opción correcta.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
