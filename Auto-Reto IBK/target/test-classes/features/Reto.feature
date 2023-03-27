# language: es
  Característica: Crear campos en un formulario

    Escenario: Obtener del API login el trackingId
      Dado que la web esta operativa
      Cuando se ingrese a la plantalla de login tarjeta "tarjeta" y dni "dni" y clave "clave"
      Y se da click en checkbox Recordar datos
      Y se da click en el boton Ingresar
      Y en la pantalla principal guardo el trackingID
      Y luego click en boton donde se encuentra el nombre de usuario
      Y click en Cerrar Sesion
      Entonces se muestra los datos del cliente grabados




