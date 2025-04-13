package co.edu.uniquindio;


public class VehiculoApoyo extends Vehiculo {
    private TipoFuncion tipoFuncion;


    public VehiculoApoyo(String id, String modelo, int anioFabricacion, double kilometraje, EstadoOperativo estadoOperativo, TipoFuncion tipoFuncion) {
        super(id, modelo, anioFabricacion, kilometraje, estadoOperativo);
        this.tipoFuncion = tipoFuncion;
    }


    public void desplazar() {
    }


    public TipoFuncion getTipoFuncion() {
        return this.tipoFuncion;
    }


    public void setTipoFuncion(TipoFuncion tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }
}
