package definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import pageobjects.dashboardPage;
import pageobjects.loginPage;

import java.sql.SQLException;


public class RetoDefinition {
    loginPage login;
    dashboardPage db;



    public RetoDefinition() {
        login = new loginPage();
        db = new dashboardPage();

    }

    @Dado("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        hooks.driver.get("https://bancaporinternetuat.interbank.pe/login");
    }

    @Cuando("se ingrese a la plantalla de login tarjeta {string} y dni {string} y clave {string}")
    public void seIngreseALaPlantallaDeLoginTarjetaYDniYClave(String tarjeta, String dni, String clave) {
        login.clickNroTarjeta();
        login.escribirNroTarjeta(tarjeta);
        login.clickDocumento();
        login.escribirNroDocumento(dni);
        login.clickPassword();
        login.escribirPassword(clave);
    }

    @Y("se da click en checkbox Recordar datos")
    public void seDaClickEnCheckboxRecordarDatos() {
        login.clickRecordarDatos();
    }

    @Y("se da click en el boton Ingresar")
    public void seDaClickEnElBotonIngresar() {
        login.clickIngresar();
    }

    @Y("en la pantalla principal guardo el trackingID")
    public void enLaPantallaPrincipalGuardoElTrackingID() throws SQLException {

    }

    @Y("luego click en boton donde se encuentra el nombre de usuario")
    public void luegoClickEnBotonDondeSeEncuentraElNombreDeUsuario() {
        db.clickUser();
    }

    @Y("click en Cerrar Sesion")
    public void clickEnCerrarSesion() {
       db.cerrarSesion();

    }

    @Entonces("se muestra los datos del cliente grabados")
    public void seMuestraLosDatosDelClienteGrabados() {

    }



}
