public class ArbolInventario {

    private Producto raiz;

    public ArbolInventario() {
        raiz = null;
    }

    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {

        if (actual == null) {
            return new Producto(id, nombre);
        }

        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }

        return actual;
    }

    public void mostrarInventario() {

        if (raiz == null) {
            System.out.println("Inventario vacío.");
            return;
        }

        recorridoInorden(raiz);
    }

    private void recorridoInorden(Producto actual) {

        if (actual != null) {

            recorridoInorden(actual.izquierdo);

            System.out.println(
                    "ID: " + actual.id +
                    " | Nombre: " + actual.nombre);

            recorridoInorden(actual.derecho);
        }
    }

    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Producto buscarRecursivo(Producto actual, int id) {

        if (actual == null || actual.id == id) {
            return actual;
        }

        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        }

        return buscarRecursivo(actual.derecho, id);
    }
}
