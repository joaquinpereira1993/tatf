package centro_deporte;

import centro_deporte.manager.CentroDeporte;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class CentroDeDeporteTest {

    private CentroDeporte centroDeporte;

    @BeforeAll
    static void iniciarPruebas() {
        System.out.println("Inicio de las pruebas");
    }

    @AfterAll
    static void finalizarPruebas() {
        System.out.println("Fin de las pruebas");
    }

    @BeforeEach
    void prepararPrueba() {
        centroDeporte = new CentroDeporte();
    }

    @AfterEach
    void limpiarPrueba() {
        centroDeporte = null;
    }
    @Test
    void obtenerDeporte() {
        assertThat(centroDeporte.obtenerDeportes()).isNotEmpty();
    }
    @Test
    void obtenerDeportePorLetra() {
        assertThat(centroDeporte.obtenerDeportes("F")).contains("Fútbol");
    }
    @Test
    void crearDeporte() {
        centroDeporte.crearDeporte("Natacion");
        assertThat(centroDeporte.obtenerDeportes()).contains("Natacion");
    }
    @Test
    void modificarDeporte() {
        centroDeporte.crearDeporte("Boxeo");
        centroDeporte.modificarDeporte(
                "Boxeo",
                "BoxeoModificado"
        );
        assertThat(centroDeporte.obtenerDeportes()).contains("BoxeoModificado");
    }
    @Test
    void eliminarDeporte() {
        centroDeporte.eliminarDeporte("TENIS");
        assertThat(centroDeporte.obtenerDeportes()).doesNotContain("TENIS");
    }
}