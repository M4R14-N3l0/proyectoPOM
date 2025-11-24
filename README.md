# Automatización Login OrangeHRM – proyectoPOM

Este repositorio contiene la automatización del **login de OrangeHRM** utilizando **Selenium WebDriver**, **Cucumber BDD** y **Page Object Model (POM)**.

El objetivo es validar el correcto funcionamiento del login mediante escenarios de prueba automatizados.

## Web bajo prueba

https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Maven**
- **Selenium WebDriver 4**
- **WebDriverManager 6**
- **Cucumber JVM 7**
- **JUnit 4**
- **Page Object Model (POM)**
- **VS Code**

---

## 📁 Estructura del proyecto

```
proyectoPOM/
├─ pom.xml
└─ src
└─ test
├─ java
│ ├─ pages
│ │ └─ LoginPage.java
│ ├─ runners
│ │ └─ TestRunner.java
│ └─ stepdefinitions
│ └─ LoginDemoSteps.java
└─ resources
└─ features
└─ login_demo.feature

```

---

## 🧩 Arquitectura POM + BDD

### Page Object Model (POM)
Centraliza:
- Localizadores
- Interacciones con la UI
- Esperas explícitas (WebDriverWait)

### Cucumber BDD
- `Feature files` con lenguaje Gherkin  
- `Step Definitions` en Java  
- `TestRunner` con JUnit para lanzar pruebas  

---

## 📄 Escenarios implementados

### ✔ Login correcto
Dado que el usuario está en la página de login de OrangeHRM
Cuando ingresa usuario "Admin" y contraseña "admin123"
Y hace clic en el botón Login
Entonces debería ver el dashboard


### ❌ Login inválido
Dado que el usuario está en la página de login de OrangeHRM
Cuando ingresa usuario "Admin" y contraseña "clave_invalida"
Y hace clic en el botón Login
Entonces debería ver el mensaje de error "Invalid credentials"


---

### Clonar el repositorio

```
git clone https://github.com/M4R14-N3l0/proyectoPOM.git
```

### Cómo ejecutar el proyecto

Ejecutar con Maven:
```
mvn clean test
```

📊 Reporte de Cucumber

Después de la ejecución se genera:

target/cucumber-report.html

Ábrelo en el navegador para ver el detalle completo de los escenarios.






