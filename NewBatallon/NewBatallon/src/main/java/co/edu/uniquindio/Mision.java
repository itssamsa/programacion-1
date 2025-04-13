package co.edu.uniquindio;


import java.io.PrintStream;
import java.time.LocalDate;
import java.util.LinkedList;


public class Mision {
    private String id;
    private LocalDate fecha;
    private String ubicacion;
    private LinkedList<Soldado> personal;
    private Vehiculo theVehiculo;


    public Mision(String id, LocalDate fecha, String ubicacion) {
        this.id = id;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.personal = new LinkedList();
    }


    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public LocalDate getFecha() {
        return this.fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public String getUbicacion() {
        return this.ubicacion;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public LinkedList<Soldado> getPersonal() {
        return this.personal;
    }


    public void setPersonal(LinkedList<Soldado> personal) {
        this.personal = personal;
    }


    public Vehiculo getTheVehiculo() {
        return this.theVehiculo;
    }


    public void setTheVehiculo(Vehiculo theVehiculo) {
        this.theVehiculo = theVehiculo;
    }


    public void agregarSoldadoAMision(Soldado s) {
        if (!this.personal.contains(s)) {
            this.personal.add(s);
            PrintStream var10000 = System.out;
            String var10001 = s.getIdSoldado();
            var10000.println("Soldado " + var10001 + " asignado a la misión " + this.id);
        } else {
            System.out.println("Soldado " + s.getIdSoldado() + " ya está asignado a la misión.");
        }


    }


    public int getCantidadPersonal() {
        return this.personal.size();
    }


    public String getVehiculoId() {
        return this.theVehiculo != null ? this.theVehiculo.getId() : "No asignado";
    }
}
