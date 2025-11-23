# language: es
Característica: Login en OrangeHRM
  Para poder gestionar el sistema
  Como usuario válido
  Quiero iniciar sesión en la aplicación

  Escenario: Login correcto
    Dado que el usuario está en la página de login de OrangeHRM
    Cuando ingresa usuario "Admin" y contraseña "admin123"
    Y hace clic en el botón Login
    Entonces debería ver el dashboard

  Escenario: Login inválido
    Dado que el usuario está en la página de login de OrangeHRM
    Cuando ingresa usuario "Admin" y contraseña "clave_invalida"
    Y hace clic en el botón Login
    Entonces debería ver el mensaje de error "Invalid credentials"
