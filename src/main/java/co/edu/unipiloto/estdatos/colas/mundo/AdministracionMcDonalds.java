package co.edu.unipiloto.estdatos.colas.mundo;

import co.edu.unipiloto.estdatos.colas.estructuras.Cola;
import co.edu.unipiloto.estdatos.colas.interfaz.Pedido;
import co.edu.unipiloto.estdatos.colas.interfaz.Producto;

import java.util.Iterator;

public class AdministracionMcDonalds {

    private Cola<String> colaClientes;
    private Cola<Pedido> colaPedidos;
    private ListaDobleEncadenada<Producto> catalogoProductos;
    private Cola<Pedido> colaDomicilios;
    
    public AdministracionMcDonalds() {
        colaClientes = new Cola<>();
        colaPedidos = new Cola<>();
        catalogoProductos = new ListaDobleEncadenada<>();
        colaDomicilios = new Cola<>();
        
        // Agregar productos al catálogo en el constructor
        catalogoProductos.addLast(new Producto("Combo Nuggets", 200, 5.99));
        catalogoProductos.addLast(new Producto("Combo Big Mac", 300, 6.99));
        catalogoProductos.addLast(new Producto("Combo Cuarto de Libra", 250, 7.99));
        catalogoProductos.addLast(new Producto("Mc Flurry", 100, 3.99));
    }

    public ListaDobleEncadenada<Producto> getCatalogoProductos() {
        return catalogoProductos;
    }

    public void agregarCliente(String nombre) {
        colaClientes.encolar(nombre);
    }
    // Método para agregar un producto al catálogo
    public void agregarProducto(String nombre, long tiempoPreparacion, double costo) {
        Producto nuevoProducto = new Producto(nombre, tiempoPreparacion, costo);
        catalogoProductos.addLast(nuevoProducto);
    }

    // Método para eliminar un producto del catálogo
    public void eliminarProducto(String nombreProducto) {
        Producto productoAEliminar = buscarProducto(nombreProducto);
        if (productoAEliminar != null) {
            catalogoProductos.remove(productoAEliminar);
        }
    }

    // Método para mostrar el catálogo completo
    public void mostrarCatalogo() {
        System.out.println("Catálogo de Productos:");
        System.out.println("----------------------");
        for (Producto producto : catalogoProductos) {
            System.out.println(producto);
        }
    }

    public String atenderCliente(String nombreProducto, String direccion, boolean esDomicilio) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Manejo de excepciones...
        }

        // Buscar el producto en el catálogo
        Producto producto = buscarProducto(nombreProducto);

        // Verificar si se encontró el producto
        if (producto != null) {
            // Crear un objeto Pedido y encolarlo
            Pedido pedido = new Pedido(producto, direccion, esDomicilio);
            colaPedidos.encolar(pedido);
            return colaClientes.desencolar();
        } else {
            // Producto no encontrado
            return null;
        }
    }
    // Método para agregar un cliente a la cola de domicilios
    public void registrarDomicilio(Producto producto, String direccion, boolean esDomicilio) {
        Pedido pedidoDomicilio = new Pedido(producto, direccion, esDomicilio);
        colaDomicilios.encolar(pedidoDomicilio);
    }

    // Método para despachar un domicilio
    public Pedido despacharDomicilio() {
        return colaDomicilios.desencolar();
    }

    // Método para obtener la cantidad de domicilios en espera
    public int domiciliosEnEspera() {
        return colaDomicilios.tamanio();
    }
    private Producto buscarProducto(String nombreProducto) {
        for (Producto producto : catalogoProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                return producto;
            }
        }
        return null; // Producto no encontrado
    }

    public String entregarPedido() {
        Pedido pedido = colaPedidos.desencolar();
        try {
            Thread.sleep(pedido.getProducto().getTiempoPreparacion());
        } catch (InterruptedException e) {
            // Manejo de excepciones...
        }
        return pedido.getProducto().getNombre();
    }

    public int clientesEnFila() {
        return colaClientes.tamanio();
    }

    public int pedidosEnEspera() {
        return colaPedidos.tamanio();
    }

    public Iterator<String> clientes() {
        return colaClientes.iterator();
    }

    public Iterator<Pedido> pedidos() {
        return colaPedidos.iterator();
    }
}
