/*
 * CentralPacienteCLI.java
 * This file is part of ISIS1206
 *
 * Copyright (C) 2015 - ISIS1206 Team
 */
package co.edu.unipiloto.estdatos.colas.interfaz;

import co.edu.unipiloto.estdatos.colas.mundo.AdministracionMcDonalds;
import co.edu.unipiloto.estdatos.colas.mundo.AdministracionMcDonalds.Pedido;
import java.util.Iterator;
import java.util.Scanner;

//import taller.mundo.*;
//import taller.mundo.AdministracionMcDonalds.Pedido;
public class McDonaldsCLI {

    private AdministracionMcDonalds admin;

    private Scanner in;

    public McDonaldsCLI() {
        admin = new AdministracionMcDonalds();
        in = new Scanner(System.in);
    }

    public void mainMenu() throws InterruptedException {
        boolean finish = false;
        while (!finish) {
            System.out.println("------------------------------------------");
            System.out.println("-                                        -");
            System.out.println("-        McDonalds - Candelaria          -");
            System.out.println("                                                        \n"
                    + "                  ╥╣▒▒▒▒@,        ╥╢▒▒▒▒@╖                            \n"
                    + "                ╥▒▒▒▒▄▒▒▒▒▀█▄   ╓╣▒▒▒▄▒▒▒▒▒█▄                         \n"
                    + "               ╣▒▒▒▒███╢▒▒▒▒██ ╓▒▒╣▒███╚▒▒╢▒██                        \n"
                    + "              ╣▒▒▒▒███  ▒▒▒▒▒█▌▒▒╣▒▓██  ║▒▒▒▒██▄                      \n"
                    + "             ╣▒▒▒▒███   ]▒▒╢▒▒╣░║▒▒██U   ╢▒▒▒▒██µ                     \n"
                    + "            ║▒▒╣▒▐██     ▒▒▒▒▒░░▒▒▐██     ▒▒▒▒▒██                     \n"
                    + "            ╣▒▒▒▒███     ╢▒▒╢╣░║▒▒██▌     ╢▒▒▒▒▀██                    \n"
                    + "           ╢▒▒╢▒▒██      ]▒▒▒╣░▒▒▒██      ]▒▒▒▒▒██µ                   \n"
                    + "           ╣▒▒▒▒███       ▒▒▒╣░▒▒▐██       ▒▒▒▒▒▀██                   \n"
                    + "          ║░░╢▒▒██▌       ▒▒░╢║▒▒██▌       ║▒▒╢▒▒██                   \n"
                    + "          ▒░▒▒▒▒██        ╢▒░▒╢▒▒██▌       ]▒▒▒▒▒██▌                  \n"
                    + "          ╣░▒▒▒▐██        ║▒░▒▒▒▒██U        ▒▒▒▒▒▐██                  \n"
                    + "         ]▒░▒▒▒▐██        ║▒░▒▒▒▒██         ▒▒░▒▒▒██                  \n"
                    + "         ║▒░║▒▒██▌        ]▒▒╣▒▒▒██         ▒▒░▒▒▒██                  \n"
                    + "         ║▒╢▒▒▒██▌         ╙▓██████         ▒▒╢▒▒▒██                \n"
                    + "         ``██████▌          ╙▀▀▀▀▀▀         ``██████                ");
            System.out.println("-                                        -");
            System.out.println("------------------------------------------");
            System.out.println("Bienvenido McDonalds\n");

            System.out.println("Menú principal:");
            System.out.println("-----------------");
            System.out.println("1. Agregar cliente a la cola");
            System.out.println("2. Atender cliente");
            System.out.println("3. Entregar pedido");
            System.out.println("4. Cantidad de clientes en cola");
            System.out.println("5. Cola de pedidos en cocina");
            System.out.println("6. Salir");
            System.out.print("\nSeleccione una opción: ");
            int opt1 = in.nextInt();
            in.nextLine();
            switch (opt1) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    atenderCliente();
                    break;
                case 3:
                    entregarPedido();
                    break;
                case 4:
                    numeroClientes();
                    break;
                case 5:
                    pedidos();
                    break;
                case 6:
                    finish = true;
                    break;
                default:
                    break;
            }
        }
    }

    private void agregarCliente() throws InterruptedException {
        boolean finish = false;
        String nombre = "";
        while (!finish) {
            System.out.println("Agregar un cliente nuevo a la cola del restaurante");
            System.out.println("----------------------------------");
            System.out.println("Ingrese el nombre del cliente:");
            nombre = in.nextLine();
            admin.agregarCliente(nombre);
            System.out.println("Se agregó el cliente llamando " + nombre + " a la cola del restaurante");
            System.out.println("Presione enter para volver al menú principal");
            in.nextLine();
            finish = true;
        }

    }

    private void atenderCliente() throws InterruptedException {
    boolean finish = false;
    if (admin.clientesEnFila() == 0) {
        System.out.println("No hay clientes en la fila");
        return;
    }
    while (!finish) {
        System.out.println("Atender al primer cliente de la cola");
        System.out.println("----------------------------------");
        System.out.println("Escoja la orden del cliente:");

        // Mostrar el catálogo de productos dinámico
        int i = 1;
        for (Producto producto : admin.getCatalogoProductos()) {
            System.out.println(i + ". " + producto.getNombre());
            i++;
        }

        int orden = in.nextInt();
        in.nextLine();

        // Obtener el producto seleccionado
        Producto productoSeleccionado = null;
        if (orden >= 1 && orden <= admin.getCatalogoProductos().size()) {
            productoSeleccionado = admin.getCatalogoProductos().get(orden - 1);
        } else {
            System.out.println("Opción no válida");
            continue;
        }

        // Atender al cliente y agregar el pedido a la cola de cocina
        System.out.println("Atendiendo cliente, por favor espere...");
        String nombre = admin.atenderCliente(productoSeleccionado.getNombre());
        System.out.println("Se agregó la orden " + productoSeleccionado.getNombre() +
                " a la cola de pedidos de la cocina, a nombre del cliente " + nombre);
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        finish = true;
    }
}

    private void entregarPedido() throws InterruptedException {
        if (admin.pedidosEnEspera() == 0) {
            System.out.println("No hay pedidos en la cocina");
            return;
        }
        System.out.println("Entregar el primer pedido en lista de la cocina");
        System.out.println("----------------------------------");
        System.out.println("Prepadando pedido porfavor espere .......");
        String pedido = admin.entregarPedido();
        System.out.println("Se entregó el pedido: " + pedido);
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void numeroClientes() throws InterruptedException {
        System.out.println("Número de clientes esperando en fila");
        System.out.println("----------------------------------");
        int num = admin.clientesEnFila();
        System.out.println("Hay " + num + " clientes esperando en la fila.");
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

    private void pedidos() throws InterruptedException {
        System.out.println("Listar pedidos en cocina");
        System.out.println("----------------------------------");
        Iterator<Pedido> it = admin.pedidos();
        while (it.hasNext()) {
            System.out.println("Pedido: " + it.next().getProducto().getNombre());
        }
        System.out.println("Presione enter para volver al menú principal");
        in.nextLine();
        Thread.sleep(3000);
    }

}
