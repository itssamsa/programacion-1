package co.edu.uniquindio;


import java.io.PrintStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


public class Batallon {
    private String nombre;
    private String id;
    private LinkedList<VehiculoApoyo> listVehiculosApoyo;
    private LinkedList<VehiculoBlindado> listVehiculosBlindados;
    private LinkedList<VehiculoTransporteTropa> listVehiculosTransporteTropa;
    private LinkedList<Mision> listMisiones;
    private List<Soldado> soldados;
    private List<Mision> misiones;


    public Batallon(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.listVehiculosApoyo = new LinkedList();
        this.listVehiculosBlindados = new LinkedList();
        this.listVehiculosTransporteTropa = new LinkedList();
        this.listMisiones = new LinkedList();
        this.soldados = new LinkedList();
        this.misiones = new LinkedList();
    }


    private <T extends Vehiculo> void crearVehiculo(LinkedList<T> lista, T vehiculo) {
        lista.add(vehiculo);
    }


    private <T extends Vehiculo> T leerVehiculo(LinkedList<T> lista, String id) {
        for(T v : lista) {
            if (v.getId().equals(id)) {
                return v;
            }
        }


        return null;
    }


    private <T extends Vehiculo> boolean actualizarVehiculo(LinkedList<T> lista, String id, T nuevo) {
        for(int i = 0; i < lista.size(); ++i) {
            if (((Vehiculo)lista.get(i)).getId().equals(id)) {
                lista.set(i, nuevo);
                return true;
            }
        }


        return false;
    }


    private <T extends Vehiculo> boolean eliminarVehiculo(LinkedList<T> lista, String id) {
        return lista.removeIf((v) -> v.getId().equals(id));
    }


    public void crearVehiculoApoyo(VehiculoApoyo vehiculo) {
        this.crearVehiculo(this.listVehiculosApoyo, vehiculo);
    }


    public VehiculoApoyo leerVehiculoApoyo(String id) {
        return (VehiculoApoyo)this.leerVehiculo(this.listVehiculosApoyo, id);
    }


    public boolean actualizarVehiculoApoyo(String id, VehiculoApoyo nuevo) {
        return this.actualizarVehiculo(this.listVehiculosApoyo, id, nuevo);
    }


    public boolean eliminarVehiculoApoyo(String id) {
        return this.eliminarVehiculo(this.listVehiculosApoyo, id);
    }


    public void crearVehiculoBlindado(VehiculoBlindado vehiculo) {
        this.crearVehiculo(this.listVehiculosBlindados, vehiculo);
    }


    public VehiculoBlindado leerVehiculoBlindado(String id) {
        return (VehiculoBlindado)this.leerVehiculo(this.listVehiculosBlindados, id);
    }


    public boolean actualizarVehiculoBlindado(String id, VehiculoBlindado nuevo) {
        return this.actualizarVehiculo(this.listVehiculosBlindados, id, nuevo);
    }


    public boolean eliminarVehiculoBlindado(String id) {
        return this.eliminarVehiculo(this.listVehiculosBlindados, id);
    }


    public void crearVehiculoTransporte(VehiculoTransporteTropa vehiculo) {
        this.crearVehiculo(this.listVehiculosTransporteTropa, vehiculo);
    }


    public VehiculoTransporteTropa leerVehiculoTransporte(String id) {
        return (VehiculoTransporteTropa)this.leerVehiculo(this.listVehiculosTransporteTropa, id);
    }


    public boolean actualizarVehiculoTransporte(String id, VehiculoTransporteTropa nuevo) {
        return this.actualizarVehiculo(this.listVehiculosTransporteTropa, id, nuevo);
    }


    public boolean eliminarVehiculoTransporte(String id) {
        return this.eliminarVehiculo(this.listVehiculosTransporteTropa, id);
    }


    public void editarVehiculoDirecto(String id, String modelo, int anioFabricacion, double kilometraje, EstadoOperativo estadoOperativo) {
        Vehiculo vehiculo = this.getVehiculo(id);
        if (vehiculo != null) {
            vehiculo.setModelo(modelo);
            vehiculo.setAnioFabricacion(anioFabricacion);
            vehiculo.setKilometraje(kilometraje);
            vehiculo.setEstadoOperativo(estadoOperativo);
            if (vehiculo instanceof VehiculoTransporteTropa) {
                ((VehiculoTransporteTropa)vehiculo).setCapacidadSoldados(50);
            } else if (vehiculo instanceof VehiculoBlindado) {
                ((VehiculoBlindado)vehiculo).setNivelBlindaje(5);
            } else if (vehiculo instanceof VehiculoApoyo) {
                ((VehiculoApoyo)vehiculo).setTipoFuncion(TipoFuncion.LOGISTICA);
            }


            System.out.println("Vehículo editado exitosamente.");
        } else {
            System.out.println("Vehículo con ID " + id + " no encontrado.");
        }


    }


    public Vehiculo getVehiculo(String id) {
        Vehiculo vehiculo = this.leerVehiculo(this.listVehiculosApoyo, id);
        if (vehiculo != null) {
            return vehiculo;
        } else {
            vehiculo = this.leerVehiculo(this.listVehiculosBlindados, id);
            return vehiculo != null ? vehiculo : this.leerVehiculo(this.listVehiculosTransporteTropa, id);
        }
    }


    public void eliminarVehiculo(String id) {
        if (!this.eliminarVehiculo(this.listVehiculosApoyo, id) && !this.eliminarVehiculo(this.listVehiculosBlindados, id) && !this.eliminarVehiculo(this.listVehiculosTransporteTropa, id)) {
            System.out.println("No se encontró ningún vehículo con el ID " + id + ".");
        } else {
            System.out.println("Vehículo con ID " + id + " eliminado correctamente.");
        }


    }


    public double calcularKilometrajePromedioTransporteTropa() {
        return this.calcularKilometrajePromedio(this.listVehiculosTransporteTropa);
    }


    public double calcularKilometrajePromedioBlindados() {
        return this.calcularKilometrajePromedio(this.listVehiculosBlindados);
    }


    public double calcularKilometrajePromedioApoyo() {
        return this.calcularKilometrajePromedio(this.listVehiculosApoyo);
    }


    private <T extends Vehiculo> double calcularKilometrajePromedio(LinkedList<T> lista) {
        if (lista.isEmpty()) {
            return (double)0.0F;
        } else {
            double suma = (double)0.0F;


            for(T v : lista) {
                suma += v.getKilometraje();
            }


            return suma / (double)lista.size();
        }
    }


    public void mostrarMisionesRegistradas() {
    }


    public void crearSoldado(Soldado soldado) {
        this.soldados.add(soldado);
    }


    public Soldado leerSoldado(String id) {
        return (Soldado)this.soldados.stream().filter((s) -> s.getIdSoldado().equals(id)).findFirst().orElse((Object)null);
    }


    public boolean actualizarSoldado(String id, Soldado nuevo) {
        for(int i = 0; i < this.soldados.size(); ++i) {
            if (((Soldado)this.soldados.get(i)).getIdSoldado().equals(id)) {
                this.soldados.set(i, nuevo);
                return true;
            }
        }


        return false;
    }


    public boolean eliminarSoldado(String id) {
        return this.soldados.removeIf((s) -> s.getIdSoldado().equals(id));
    }


    public void registrarMision(LocalDate fecha, String ubicacion, int cantidadPersonal, String vehiculoId) {
        Mision mision = new Mision("M" + (this.misiones.size() + 1), fecha, ubicacion);
        this.misiones.add(mision);
        this.soldados.forEach((soldado) -> soldado.asignarMision());
    }


    public void mostrarMisiones() {
        System.out.println("Misiones Registradas:");
        this.misiones.forEach((m) -> {
            PrintStream var10000 = System.out;
            String var10001 = m.getId();
            var10000.println("ID: " + var10001 + ", Fecha: " + String.valueOf(m.getFecha()) + ", Ubicación: " + m.getUbicacion() + ", Personal: " + m.getCantidadPersonal() + ", Vehículo Asignado: " + m.getVehiculoId());
        });
    }


    public void mostrarInformacion() {
        System.out.println("BATALLÓN: " + this.nombre + " ");
        System.out.println("ID: " + this.id);
        System.out.println("\n Soldados ");
        this.soldados.forEach(Soldado::getInfo);
        System.out.println("\n Misiones Registradas");
        this.mostrarMisiones();
        System.out.println("");
    }


    public LinkedList<Mision> buscarMisionesPorUbicacionYFechas(String ubicacion, LocalDate fechaInicio, LocalDate fechaFin) {
        LinkedList<Mision> misionesFiltradas = new LinkedList();
        Stream var10000 = this.misiones.stream().filter((m) -> m.getUbicacion().equalsIgnoreCase(ubicacion) && (m.getFecha().isEqual(fechaInicio) || m.getFecha().isAfter(fechaInicio)) && (m.getFecha().isEqual(fechaFin) || m.getFecha().isBefore(fechaFin)));
        Objects.requireNonNull(misionesFiltradas);
        var10000.forEach(misionesFiltradas::add);
        return misionesFiltradas;
    }


    public String getId() {
        return this.id;
    }


    public String getNombre() {
        return this.nombre;
    }


    public List<Soldado> getSoldados() {
        return this.soldados;
    }


    public List<Mision> getMisiones() {
        return this.misiones;
    }


    public List<Soldado> buscarSoldadosPorFuncion(FuncionSoldado funcion) {
        List<Soldado> resultado = new LinkedList();


        for(Soldado s : this.soldados) {
            if (s.getFuncion().equals(funcion)) {
                resultado.add(s);
            }
        }


        return resultado;
    }


    public double calcularPromedioEdades() {
        if (this.soldados.isEmpty()) {
            System.out.println("No hay soldados en el batallón.");
            return (double)0.0F;
        } else {
            int sumaEdades = 0;


            for(Soldado soldado : this.soldados) {
                sumaEdades += soldado.getEdadSoldado();
            }


            return (double)sumaEdades / (double)this.soldados.size();
        }
    }


    public Soldado obtenerSoldadoPorId(String id) {
        for(Soldado soldado : this.soldados) {
            if (soldado.getIdSoldado().equals(id)) {
                return soldado;
            }
        }


        System.out.println("Soldado con ID " + id + " no encontrado.");
        return null;
    }
}
