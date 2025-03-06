public class Empleado {
    private String nombre;
    private String cedula;
    private String cargo;
    private int tiempoEmpresa;
    private double salario;

    public Empleado(String nombre, String cedula, String cargo, int tiempoEmpresa) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cargo = cargo;
        this.tiempoEmpresa = tiempoEmpresa;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", cargo='" + cargo + '\'' +
                ", tiempoEmpresa=" + tiempoEmpresa +
                ", salario=" + salario +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getTiempoEmpresa() {
        return tiempoEmpresa;
    }

    public void setTiempoEmpresa(int tiempoEmpresa) {
        this.tiempoEmpresa = tiempoEmpresa;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}