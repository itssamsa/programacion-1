import co.edu.uniquindio.Batallon;
import co.edu.uniquindio.FuncionSoldado;
import co.edu.uniquindio.Mision;
import co.edu.uniquindio.Rango;
import co.edu.uniquindio.Soldado;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BatallonTest {
    private Batallon batallon;


    public BatallonTest() {
    }


    @BeforeEach
    public void setUp() {
        this.batallon = new Batallon("Batallón Águila", "B123");
    }


    @Test
    public void testCrearYLeerSoldado() {
        Soldado soldado = new Soldado("S1", "Juan", 25, FuncionSoldado.LOGISTICA);
        this.batallon.crearSoldado(soldado);
        Soldado recuperado = this.batallon.leerSoldado("S1");
        Assertions.assertNotNull(recuperado);
        Assertions.assertEquals("Juan", recuperado.getNombreCompleto());
    }


    @Test
    public void testActualizarSoldado() {
        Soldado s1 = new Soldado("S2", "Carlos", 30, FuncionSoldado.SANIDAD);
        this.batallon.crearSoldado(s1);
        Soldado actualizado = new Soldado("S2", "Carlos Actualizado", 31, FuncionSoldado.INGENIERIA);
        boolean actualizadoOk = this.batallon.actualizarSoldado("S2", actualizado);
        Assertions.assertTrue(actualizadoOk);
        Assertions.assertEquals("Carlos Actualizado", this.batallon.leerSoldado("S2").getNombreCompleto());
    }


    @Test
    public void testRegistrarYBuscarMision() {
        this.batallon.registrarMision(LocalDate.of(2024, 10, 1), "Bogotá", 10, "V1");
        this.batallon.registrarMision(LocalDate.of(2024, 10, 5), "Bogotá", 12, "V2");
        this.batallon.registrarMision(LocalDate.of(2024, 11, 1), "Medellín", 8, "V3");
        List<Mision> misiones = this.batallon.buscarMisionesPorUbicacionYFechas("Bogotá", LocalDate.of(2024, 9, 30), LocalDate.of(2024, 10, 6));
        Assertions.assertEquals(2, misiones.size());
    }


    @Test
    public void testCrearSoldadoConIdValido() {
        Soldado soldado = new Soldado("123", "Juan Perez", Rango.CABO, FuncionSoldado.INFANTERIA, 30, true);
        Assertions.assertNotNull(soldado);
        Assertions.assertEquals("123", soldado.getIdSoldado());
        Assertions.assertEquals("Juan Perez", soldado.getNombreCompleto());
        Assertions.assertEquals(30, soldado.getEdadSoldado());
        Assertions.assertTrue(soldado.isDisponible());
    }


    @Test
    public void testCompararIdsDeSoldados() {
        Soldado soldado1 = new Soldado("163", "Juan Perez", Rango.CABO, FuncionSoldado.COMUNICACIONES, 30, true);
        Soldado soldado2 = new Soldado("123", "Carlos Lopez", Rango.SARGENTO, FuncionSoldado.INGENIERIA, 32, true);
        Assertions.assertEquals(soldado1.getIdSoldado(), soldado2.getIdSoldado(), "Los IDs de los soldados deberían ser iguales");
    }
}
