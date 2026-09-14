# Sistema Punto de Venta

Sistema web de Punto de Venta (POS) desarrollado como proyecto de Ingeniería en Sistemas Computacionales.

El sistema permite administrar productos, categorías, clientes y proveedores, además de realizar ventas mediante una interfaz tipo punto de venta y controlar el stock disponible.

---

## Vista del proyecto

### Categorías

![Categorías](screenshots/categorias.png)

### Productos

![Productos](screenshots/productos.png)

### Clientes

![Clientes](screenshots/clientes.png)

### Proveedores

![Proveedores](screenshots/proveedores.png)

### Ventas

![Ventas](screenshots/tabla_ventas.png)

### Realizar venta

![Realizar venta](screenshots/realizar_venta.png)

### Agregar categoría

![Agregar categoría](screenshots/agregar_categoria.png)

### Agregar cliente

![Agregar cliente](screenshots/agregar_cliente.png)

### Agregar producto

![Agregar producto](screenshots/agregar_producto.png)

### Agregar proveedor

![Agregar proveedor](screenshots/agregar_proveedor.png)

---

## Funcionalidades

* Gestión de productos
* Gestión de categorías
* Gestión de clientes
* Gestión de proveedores
* Registro de ventas
* Interfaz tipo ticket para realizar ventas
* Control de cantidades de productos
* Control de stock
* Validación para evitar vender más productos de los disponibles
* Cálculo de subtotal, IVA y total
* Interfaz web personalizada con CSS
* Persistencia de información mediante MySQL

---

## Tecnologías utilizadas

| Tecnología      | Uso                             |
| --------------- | ------------------------------- |
| Java            | Lenguaje principal              |
| Spring Boot     | Desarrollo del backend          |
| Spring Data JPA | Persistencia y acceso a datos   |
| MySQL           | Base de datos                   |
| Thymeleaf       | Generación de vistas HTML       |
| HTML5           | Estructura de las vistas        |
| CSS             | Diseño y estilos de la interfaz |
| Lombok          | Reducción de código repetitivo  |
| Git             | Control de versiones            |
| IntelliJ IDEA   | Entorno de desarrollo           |

---

## Arquitectura

El proyecto utiliza una arquitectura basada en capas para separar las responsabilidades de la aplicación.

```text
Controller
    |
    v
Service
    |
    v
Repository
    |
    v
Database
```

### Controller

Se encarga de recibir las peticiones HTTP y conectar las vistas con la lógica de negocio.

### Service

Contiene la lógica de negocio de la aplicación.

### Repository

Utiliza Spring Data JPA para realizar las operaciones con la base de datos.

### Entity

Representa las diferentes entidades utilizadas por el sistema y su relación con la base de datos.

---

## Modelo de datos

El sistema trabaja principalmente con las siguientes entidades:

* Categorías
* Productos
* Proveedores
* Clientes
* Ventas
* Detalle de venta

Los productos están relacionados con categorías y proveedores, mientras que las ventas contienen los productos vendidos y la información correspondiente a cada operación.

---

## Instalación y configuración

### Requisitos

Para ejecutar el proyecto es necesario contar con:

* Java JDK
* MySQL
* Maven
* IntelliJ IDEA o cualquier IDE compatible con Spring Boot

### Base de datos

Crear una base de datos llamada:

```sql
CREATE DATABASE punto_venta;
```

Después, configurar las credenciales de MySQL en:

```text
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.application.name=punto-venta

spring.datasource.url=jdbc:mysql://localhost:3306/punto_venta
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

La contraseña debe cambiarse de acuerdo con la configuración local de MySQL.

---

## Ejecución

Clonar el repositorio:

```bash
git clone https://github.com/Rulo1804/punto-venta.git
```

Entrar al proyecto:

```bash
cd punto-venta
```

Ejecutar la aplicación desde IntelliJ IDEA o mediante Maven.

Una vez iniciada la aplicación, acceder desde el navegador a:

```text
http://localhost:8080
```

---

## Estructura del proyecto

```text
punto-venta/
|
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── roberto/
│       │           └── punto_venta/
│       │               ├── controller/
│       │               ├── entity/
│       │               ├── repository/
│       │               └── service/
│       │
│       └── resources/
│           ├── static/
│           │   └── css/
│           ├── templates/
│           │   ├── categorias/
│           │   ├── clientes/
│           │   ├── productos/
│           │   ├── proveedores/
│           │   └── ventas/
│           └── application.properties
│
├── screenshots/
│   ├── agregar_categoria.png
│   ├── agregar_cliente.png
│   ├── agregar_producto.png
│   ├── agregar_proveedor.png
│   ├── categorias.png
│   ├── clientes.png
│   ├── productos.png
│   ├── proveedores.png
│   ├── realizar_venta.png
│   └── tabla_ventas.png
│
├── pom.xml
└── README.md
```

---

## Objetivo del proyecto

El objetivo principal del proyecto fue desarrollar un sistema web funcional que permitiera aplicar conocimientos de programación en Java, desarrollo backend, bases de datos, arquitectura por capas y desarrollo de interfaces web.

El proyecto integra frontend, backend y base de datos dentro de una misma aplicación, simulando el funcionamiento de un sistema de punto de venta para un negocio.

---

## Autor

**Roberto Zamora**

Ingeniería en Sistemas Computacionales

Proyecto desarrollado como parte de mi formación profesional.
