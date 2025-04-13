package co.edu.uniquindio;


public class Soldado {
    private String idSoldado;
    private String nombreCompleto;
    private Rango rango;
    private FuncionSoldado funcion;
    private int edadSoldado;
    private boolean disponible;


    public Soldado(String idSoldado, String nombreCompleto, Rango rango, FuncionSoldado funcion, int edadSoldado, boolean disponible) {
        if (idSoldado != null && !idSoldado.isEmpty()) {
            this.idSoldado = idSoldado;
            this.nombreCompleto = nombreCompleto;
            this.rango = rango;
            this.funcion = funcion;
            this.edadSoldado = edadSoldado;
            this.disponible = disponible;
        } else {
            throw new IllegalArgumentException("El ID del soldado no puede ser null o vacío.");
        }
    }


    public Soldado(String idSoldado, String nombreSoldado, int edadSoldado, FuncionSoldado funcion) {
        if (idSoldado != null && !idSoldado.isEmpty()) {
            this.idSoldado = idSoldado;
            this.nombreCompleto = nombreSoldado;
            this.edadSoldado = edadSoldado;
            this.funcion = funcion;
            this.rango = Rango.SOLDADO;
            this.disponible = true;
        } else {
            throw new IllegalArgumentException("El ID del soldado no puede ser null o vacío.");
        }
    }


    public String toString() {
        String var10000 = this.idSoldado;
        return "Soldado{idSoldado='" + var10000 + "', nombreCompleto='" + this.nombreCompleto + "', rango=" + String.valueOf(this.rango) + ", funcion=" + String.valueOf(this.funcion) + ", edadSoldado=" + this.edadSoldado + ", disponible=" + this.disponible + "}";
    }


    public void getInfo() {
        System.out.println("ID Soldado: " + this.idSoldado);
        System.out.println("Nombre Completo: " + this.nombreCompleto);
        System.out.println("Rango: " + String.valueOf(this.rango));
        System.out.println("Función: " + String.valueOf(this.funcion));
        System.out.println("Edad: " + this.edadSoldado);
        System.out.println("Disponible: " + this.disponible);
    }


    public String getIdSoldado() {
        return this.idSoldado;
    }


    public String getNombreCompleto() {
        return this.nombreCompleto;
    }


    public Rango getRango() {
        return this.rango;
    }


    public FuncionSoldado getFuncion() {
        return this.funcion;
    }


    public int getEdadSoldado() {
        return this.edadSoldado;
    }


    public boolean isDisponible() {
        return this.disponible;
    }


    public void setIdSoldado(String idSoldado) {
        if (idSoldado != null && !idSoldado.isEmpty()) {
            this.idSoldado = idSoldado;
        } else {
            throw new IllegalArgumentException("El ID del soldado no puede ser null o vacío.");
        }
    }


    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    public void setRango(Rango rango) {
        this.rango = rango;
    }


    public void setFuncion(FuncionSoldado funcion) {
        this.funcion = funcion;
    }


    public void setEdadSoldado(int edadSoldado) {
        this.edadSoldado = edadSoldado;
    }


    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    public void asignarMision() {
    }
}
