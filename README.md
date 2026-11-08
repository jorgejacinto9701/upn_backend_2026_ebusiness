# 🛒 UPN Backend 2026 – E-Business

API REST para una plataforma de comercio electrónico, desarrollada como proyecto del curso de **E-Business (UPN 2026)**.

## 📌 Tecnologías

| Tecnología | Uso |
|---|---|
| Java 17+ | Lenguaje |
| Spring Framework / Spring Boot | Framework principal |
| Spring Data JPA (Hibernate) | Persistencia / ORM |
| MySQL 8 | Base de datos relacional |
| Maven | Gestión de dependencias |

## 👥 Integrantes y funcionalidades

| # | Integrante | Funcionalidad asignada |
|---|---|---|
| 1 | Jimenes Inofuente Anhely Maxima | Comentarios por usuarios |
| 2 | Schwarten Flores Hainz | Agregar descripción completa (del producto) |
| 3 | Rojas Espinoza Edwin | Agregar al carrito (solo agregar a una grilla) |
| 4 | Valencia Diaz Gian Piero | Búsqueda por categoría |

## ✨ Detalle de funcionalidades

### 1. Comentarios por usuarios — *Jimenes Inofuente Anhely Maxima*
Permite que un usuario registre comentarios sobre un producto y que estos puedan consultarse.
- Registrar un comentario asociado a un usuario y a un producto.
- Listar los comentarios de un producto.

### 2. Agregar descripción completa — *Schwarten Flores Hainz*
Permite registrar y consultar la descripción detallada de un producto (características, especificaciones, detalles).
- Agregar/actualizar la descripción completa de un producto.
- Obtener el detalle completo de un producto por su id.

### 3. Agregar al carrito — *Rojas Espinoza Edwin*
Permite agregar productos al carrito, mostrándolos en una **grilla** (listado). El alcance se limita a **agregar** y listar.
- Agregar un producto al carrito.
- Listar los productos agregados (grilla).

### 4. Búsqueda por categoría — *Valencia Diaz Gian Piero*
Permite filtrar los productos según su categoría.
- Listar categorías.
- Listar productos filtrados por categoría.

## 🔗 Endpoints (propuesta)

> Ajustar las rutas según lo implementado en cada controlador.

| Método | Endpoint | Descripción | Responsable |
|---|---|---|---|
| POST | `/api/comentarios` | Registrar comentario | Anhely |
| GET | `/api/comentarios/producto/{idProducto}` | Listar comentarios de un producto | Anhely |
| PUT | `/api/productos/{id}/descripcion` | Agregar/actualizar descripción completa | Hainz |
| GET | `/api/productos/{id}` | Obtener producto con descripción completa | Hainz |
| POST | `/api/carrito` | Agregar producto al carrito | Edwin |
| GET | `/api/carrito` | Listar productos del carrito (grilla) | Edwin |
| GET | `/api/categorias` | Listar categorías | Gian Piero |
| GET | `/api/productos/categoria/{idCategoria}` | Buscar productos por categoría | Gian Piero |

### Ejemplo de petición

```http
POST /api/comentarios
Content-Type: application/json

{
  "idUsuario": 1,
  "idProducto": 10,
  "texto": "Excelente producto, llegó en buen estado."
}
```

## 🗂️ Estructura del proyecto

```
src/main/java/.../
├── controller/     # Controladores REST
├── service/        # Lógica de negocio
├── repository/     # Interfaces JPA (JpaRepository)
├── entity/         # Entidades JPA
└── dto/            # Objetos de transferencia (opcional)

src/main/resources/
└── application.properties
```

## ⚙️ Configuración

### Requisitos previos
- JDK 17 o superior
- Maven 3.8+
- MySQL 8+

### 1. Clonar el repositorio

```bash
git clone https://github.com/jorgejacinto9701/upn_backend_2026_ebusiness.git
cd upn_backend_2026_ebusiness
```

### 2. Crear la base de datos

```sql
CREATE DATABASE ebusiness CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configurar `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ebusiness?useSSL=false&serverTimezone=America/Lima
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8090
```

### 4. Ejecutar

```bash
mvn clean install
mvn spring-boot:run
```

La API quedará disponible en `http://localhost:8090`.

## 🌿 Flujo de trabajo con Git

1. Cada integrante trabaja en su propia rama: `feature/comentarios`, `feature/descripcion`, `feature/carrito`, `feature/busqueda-categoria`.
2. Hacer *commit* con mensajes claros.
3. Abrir un *Pull Request* hacia `main` para integrar.

## 📄 Licencia

Proyecto académico – Universidad Privada del Norte (UPN) – 2026.
