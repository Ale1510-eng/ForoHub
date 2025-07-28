# 🗨️ API REST para un Foro

## 📌 Descripción

Este proyecto consiste en la creación de una **API REST para un foro**, desarrollada con Java y Spring Boot. Permite a los usuarios publicar tópicos relacionados con dudas o sugerencias y gestionar la información de manera segura mediante autenticación con JWT. 

Es una aplicación backend enfocada en prácticas reales de desarrollo con arquitectura RESTful y persistencia con JPA.

## 🛠️ Tecnologías Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL (puede cambiarse por PostgreSQL, H2, etc.)
- JWT (Json Web Token) para autenticación
- Maven
- Postman para pruebas de endpoints

## ✅ Requisitos Previos

- Tener instalado:
  - Java JDK 17+
  - Maven
  - MySQL o alguna base de datos compatible
- Conocimientos básicos de:
  - Java y Spring Boot
  - APIs REST
  - Uso de herramientas como Postman o Insomnia

## 🚀 Instalación y Ejecución

1. Clonar el repositorio:

```bash
git clone git@github.com:Ale1510-eng/ForoHub.git
```

2. Configurar la conexión a la base de datos en `src/main/resources/application.properties` o `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Ejecutar el proyecto:

```bash
./mvnw spring-boot:run
```

## 📬 Endpoints Principales

### Autenticación
- `POST /auth` – Inicia sesión y devuelve un token JWT

```json
{
  "login": "usuario@email.com",
  "contrasena": "password"
}
```

### Tópicos
- `GET /topicos` – Lista todos los tópicos disponibles
- `POST /topicos` – Crea un nuevo tópico *(requiere JWT)*
- `PUT /topicos//{id}` – Actualiza un tópico *(requiere JWT)*
- `DELETE /topicos/{id}` – Elimina un tópico por ID *(requiere JWT)*

Ejemplo de cuerpo para crear un tópico:

```json
{
    "titulo": "Configuración de seguridad en Spring Boot 3 con JWT",
    "mensaje": "¿Cuál es la forma recomendada de integrar Spring Security con JWT para la autenticación y autorización en una REST API con Spring Boot 3?",
    "autor": "Roberto Gómez",
    "curso": "Desarrollo con Spring Boot"
}
```

## 🔐 Autenticación JWT

Los endpoints protegidos requieren que se incluya el token JWT en la cabecera de la petición:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

Para obtener un token, se debe realizar una solicitud `POST` a `/login` con credenciales válidas.

## 🧪 Cómo Probar la API

1. Abre Insomnia o Postman.
2. Realiza una autenticación `POST /login` y copia el token JWT recibido.
3. En las peticiones protegidas (`POST /topicos`, `PUT /topicos//{id}`, `DELETE /topicos/{id}`), añade el header:

```
Authorization: Bearer <tu_token_jwt>
```

## 🎨 Personalización

Este proyecto está abierto a mejoras. Algunas ideas para extenderlo:
- Sistema de respuestas y comentarios a los tópicos
- Sistema de votación o likes
- Roles de usuario (admin, moderador, usuario)
- Paginación y ordenamiento en consultas
- Manejo de excepciones global


Desarrollado con 💻 por [Alejandra Ordaz](https://www.linkedin.com/in/alejandra-ordaz) 👩‍💻
