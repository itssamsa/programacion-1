package co.edu.uniquindio;


import java.io.PrintStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public Main() {
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Batallon batallon = new Batallon("Batallón Alpha", "B001");


        while(true) {
            System.out.println("Menu de Opciones:");
            System.out.println("1. Crear Vehículo Apoyo");
            System.out.println("2. Crear Vehículo Blindado");
            System.out.println("3. Crear Vehículo Transporte");
            System.out.println("4. Crear Soldado");
            System.out.println("5. Registrar Misión");
            System.out.println("6. Mostrar Información del Batallón");
            System.out.println("7. Buscar Misión por Ubicación y Fechas");
            System.out.println("8. Calcular Promedio de Edad de Soldados");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del Vehículo Apoyo: ");
                    String idApoyo = scanner.nextLine();
                    System.out.print("Ingrese Modelo del Vehículo Apoyo: ");
                    String modeloApoyo = scanner.nextLine();
                    System.out.print("Ingrese Año de Fabricación del Vehículo Apoyo: ");
                    int anioApoyo = scanner.nextInt();
                    System.out.print("Ingrese Kilometraje del Vehículo Apoyo: ");
                    double kmApoyo = scanner.nextDouble();
                    scanner.nextLine();
                    VehiculoApoyo vehiculoApoyo = new VehiculoApoyo(idApoyo, modeloApoyo, anioApoyo, kmApoyo, EstadoOperativo.DISPONIBLE, TipoFuncion.LOGISTICA);
                    batallon.crearVehiculoApoyo(vehiculoApoyo);
                    break;
                case 2:
                    System.out.print("Ingrese ID del Vehículo Blindado: ");
                    String idBlindado = scanner.nextLine();
                    System.out.print("Ingrese Modelo del Vehículo Blindado: ");
                    String modeloBlindado = scanner.nextLine();
                    System.out.print("Ingrese Año de Fabricación del Vehículo Blindado: ");
                    int anioBlindado = scanner.nextInt();
                    System.out.print("Ingrese Kilometraje del Vehículo Blindado: ");
                    double kmBlindado = scanner.nextDouble();
                    scanner.nextLine();
                    VehiculoBlindado vehiculoBlindado = new VehiculoBlindado(idBlindado, modeloBlindado, anioBlindado, kmBlindado, EstadoOperativo.DISPONIBLE, 5);
                    batallon.crearVehiculoBlindado(vehiculoBlindado);
                    break;
                case 3:
                    System.out.print("Ingrese ID del Vehículo de Transporte: ");
                    String idTransporte = scanner.nextLine();
                    System.out.print("Ingrese Modelo del Vehículo de Transporte: ");
                    String modeloTransporte = scanner.nextLine();
                    System.out.print("Ingrese Año de Fabricación del Vehículo de Transporte: ");
                    int anioTransporte = scanner.nextInt();
                    System.out.print("Ingrese Kilometraje del Vehículo de Transporte: ");
                    double kmTransporte = scanner.nextDouble();
                    scanner.nextLine();
                    VehiculoTransporteTropa vehiculoTransporte = new VehiculoTransporteTropa(idTransporte, modeloTransporte, anioTransporte, kmTransporte, EstadoOperativo.DISPONIBLE, 50);
                    batallon.crearVehiculoTransporte(vehiculoTransporte);
                    break;
                case 4:
                    System.out.print("Ingrese ID del Soldado: ");
                    String idSoldado = scanner.nextLine();
                    System.out.print("Ingrese Nombre del Soldado: ");
                    String nombreSoldado = scanner.nextLine();
                    System.out.print("Ingrese Edad del Soldado: ");
                    int edadSoldado = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese Función del Soldado (1: COMBATE, 2: LOGISTICA): ");
                    int funcionSoldado = scanner.nextInt();
                    scanner.nextLine();
                    Soldado soldado = new Soldado(idSoldado, nombreSoldado, edadSoldado, funcionSoldado == 1 ? FuncionSoldado.SANIDAD : FuncionSoldado.LOGISTICA);
                    batallon.crearSoldado(soldado);
                    break;
                case 5:
                    System.out.print("Ingrese Fecha de la Misión (YYYY-MM-DD): ");
                    String fechaMisionStr = scanner.nextLine();
                    LocalDate fechaMision = LocalDate.parse(fechaMisionStr);
                    System.out.print("Ingrese Ubicación de la Misión: ");
                    String ubicacionMision = scanner.nextLine();
                    System.out.print("Ingrese Cantidad de Personal: ");
                    int cantidadPersonal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese ID del Vehículo Asignado: ");
                    String vehiculoIdMision = scanner.nextLine();
                    batallon.registrarMision(fechaMision, ubicacionMision, cantidadPersonal, vehiculoIdMision);
                    break;
                case 6:
                    batallon.mostrarInformacion();
                    break;
                case 7:
                    System.out.print("Ingrese Ubicación de la Misión: ");
                    String ubicacionBusqueda = scanner.nextLine();
                    System.out.print("Ingrese Fecha de Inicio (YYYY-MM-DD): ");
                    String fechaInicioStr = scanner.nextLine();
                    LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);
                    System.out.print("Ingrese Fecha de Fin (YYYY-MM-DD): ");
                    String fechaFinStr = scanner.nextLine();
                    LocalDate fechaFin = LocalDate.parse(fechaFinStr);
                    LinkedList<Mision> misionesEncontradas = batallon.buscarMisionesPorUbicacionYFechas(ubicacionBusqueda, fechaInicio, fechaFin);
                    System.out.println("Misiones encontradas:");
                    misionesEncontradas.forEach((m) -> {
                        PrintStream var10000 = System.out;
                        String var10001 = m.getId();
                        var10000.println(var10001 + " - " + String.valueOf(m.getFecha()) + " - " + m.getUbicacion());
                    });
                    break;
                case 8:
                    double promedioEdad = batallon.calcularPromedioEdades();
                    System.out.println("Promedio de Edad de los Soldados: " + promedioEdad);
                    break;
                case 9:
                    System.out.println("¡Hasta pronto!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }
}
