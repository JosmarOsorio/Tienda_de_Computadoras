// ejercicio 2 sumativa 3 .cpp : Programa que modela una tienda de computadoras, agrega productos, los busca, los elimina y los muestra. Por: Josmar Osorio. Para: Programación II-UBA.
import java.util.ArrayList;//Importamos la libreria Arraylist para poder trabajar con Arraylist.
import java.util.Scanner;//Importamos la libreria Scanner para poder pedir datos al usuario por teclado.

public class TiendaDeComputadoras {//Creamos la clase tienda de computadoras.
    private final ArrayList<Computador> inventario;//Creamos un Arraylist

    public TiendaDeComputadoras() {
        this.inventario = new ArrayList<>();//Determinamos donde guardaremos los datos del inventario.
    }

    public void agregarComputador() {//Creamos un metodo para agregar un computador.
        Scanner sc = new Scanner(System.in);//Creamos el objeto sc para leer la entrada de datos que ingrese el usuario.
        System.out.print("Ingrese la marca del computador: ");//Le solicitamos al usuario ingresar el nombre de la marca del computador.
        String marca = sc.nextLine();
        System.out.print("Ingrese la cantidad de memoria del computador: ");//Le solicitamos al usuario ingresar la cantidad de memoria del computador.
        String cantidadMemoria = sc.nextLine();
        System.out.print("Ingrese el procesador del computador: ");//Le solicitamos al usuario ingresar el nombre del procesador del computador.
        String caracteristicasProcesador = sc.nextLine();
        System.out.print("Ingrese el sistema operativo del computador: ");//Le solicitamos al usuario ingresar el sistema operativo que posee del computador.
        String sistemaOperativo = sc.nextLine();
        System.out.print("Ingrese el precio del computador: ");//Le solicitamos al usuario ingresar el precio del computador.
        double precio = sc.nextDouble();
        sc.nextLine();
        Computador computador = new Computador(marca, cantidadMemoria, caracteristicasProcesador, sistemaOperativo, precio);//Guardamos los datos ingresados.
        inventario.add(computador);//Añadimos estos datos al inventario.
        System.out.println("El computador ha sido agregado correctamente al inventario.");//Le notificamos al usuario que los datos ingresados han sido agregados al inventario.
    }

    public void eliminarComputador() {//Creamos un metodo para eliminar un computador de la lista por medio de su marca.
        Scanner sc = new Scanner(System.in);//Creamos el objeto sc para leer la entrada de datos que ingrese el usuario.
        System.out.print("Ingrese la marca del computador que desea eliminar: ");//Le solicitamos la usaurio la marca del computador que desea eliminar.
        String marca = sc.nextLine();
        for (Computador computador : inventario) {//Creamos un for para recorrer el array y buscar un computador con esa marca.
            if (computador.getMarca().equals(marca)) {//Creamos un if donde si la condicion se cumple(se encuentra una computadora con esa marca) se elimine un ocmputador de la marca ingresada.
                inventario.remove(computador);
                System.out.println("El computador ha sido eliminado correctamente.");//Si se encuentra un computador con esta marca se elimina y se le notifica al usuario.
                return;
            }
        }
        System.out.println("No se encontró un computador con la marca: " + marca);//Si la condicion no se cumple(no se ecnuentra un computador de la marca ingresada)
                                                                                  // se notofica al usuario y no se elimina ninguna computadora.
    }

    public void buscarComputador() {//Creamos un metodo para buscar una computadora Por medio de su marca.
        Scanner sc = new Scanner(System.in);//Creamos el objeto sc para leer la entrada de datos que ingrese el usuario.
        System.out.print("Ingrese la marca del computador que desea buscar: ");//Solicitamos la marca a buscar al usuario.
        String marca = sc.nextLine();
        for (Computador computador : inventario) {//Creamos un for para recorrer el Array.
            if (computador.getMarca().equals(marca)) {//Creamos un if que muestre la computadora de la marca solicitada si se cumple la condicion de que esté en el inventario
                System.out.println(computador);
                return;
            }
        }
        System.out.println("No se encontró un computador con la marca " + marca);//Si la marca ingresada no coinside con ninguna computadora dle inventario se notofica al usaurio.
    }

    public void listarComputadores() {//Creamos un metodo para mostar toda la lista de los computadores añadidos al inventario.
        for (Computador computador : inventario) {//Creamos un for para ir moestrando cada uno de los computadores y sus caracteristicas.
            System.out.println(computador.toString());
        }
    }

    static class Computador {//Creamos la clase computador
        private final String marca;
        private final String cantidadMemoria;
        private final String caracteristicasProcesador;
        private final String sistemaOperativo;
        private final double precio;

        public Computador(String marca, String cantidadMemoria, String caracteristicasProcesador, String sistemaOperativo, double precio) {
            this.marca = marca; //Creamos el elemento marca para almacenar la marca del computador.
            this.cantidadMemoria = cantidadMemoria;//Creamos el elemento cantidadMemoria para almacenar la cantidad de memoria del computador.
            this.caracteristicasProcesador = caracteristicasProcesador;//Creamos el elemento caracteristicas Procesador para almacenar el procesador que tien el computador.
            this.sistemaOperativo = sistemaOperativo;//Creamos el elemento sistema operativo para almacenar el sistema operativo que tiene el porcesador.
            this.precio = precio;//Creamos el elemento precio para almacenar el precio del computador.
        }

        public String getMarca() {
            return marca;
        }

        public String toString() {//Creamos un metodo que nos ayude a mostar todas las caracteristicas del computador.
            return "Computador {" + "marca='" + marca + '\'' + ", Cantidad de Memoria='" + cantidadMemoria + '\'' +
                    ", Procesador='" + caracteristicasProcesador + '\'' + ", Sistema Operativo='" + sistemaOperativo + '\'' + ", Precio=" + precio + "$" + '}';
        }
    }

    public static void main(String[] args) {

        TiendaDeComputadoras miTienda = new TiendaDeComputadoras();
        System.out.println(" ");
        System.out.println("Tienda: Tu compu barata");//Mostramos el nombre de la tienda.
        System.out.println("Propetario: Josmar Alivava");//Mostramos el nombre del propietario de la tienda.
        System.out.println("Identificador tributario de la tienda: 1234567890");//Mostramos el identificador tributarios de la tienda.


        Scanner sc = new Scanner(System.in);//Creamos el objeto sc para leer la entrada de datos que ingrese el usuario.
        int opcion;//Creamos una variable de tipo int llamada opcion para saber que opcion ingresa el usuario.

        do {//Creamos un ciclo que se repita para mostar el menu al usuario cuantas veces sea necesaria.
            System.out.println("\n---- Menú de opciones ----");//Creamos el menu de opciones que se mostrara al usuario.
            System.out.println("1. Agregar un computador");
            System.out.println("2. Eliminar un computador");
            System.out.println("3. Buscar un computador por marca");
            System.out.println("4. Listar todos los computadores");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) { //Creamos un switch con las opciones y metodos.
                case 1 -> miTienda.agregarComputador();//Creamos un primer caso donde llamamos al metodo de agregar un computador.
                case 2 -> miTienda.eliminarComputador();//Creamos un segundo caso donde llamamos al metodo de eliminar un computador.
                case 3 -> miTienda.buscarComputador();//Creamos un tercer caso donde llamamos al metodo de buscar un computador.
                case 4 -> miTienda.listarComputadores();//Creamos un cuarto caso donde llamamos al metodo de mostar la lista de computadores en inventario.
                case 5 -> System.out.println("¡Hasta luego!");//Creamos un quinto metodo para salir del menu.
                default -> System.out.println("Opción inválida. Por favor seleccione una opción válida.");//Creamos una condicion dodne en caso de que el usaurio ingrese una opcion invalida se le notifique.
            }
        } while (opcion != 5);
    }
}

