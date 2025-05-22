## Proyecto Sistema de Turnos en Java con el framework Hibernate para la materia Programación Orientada a Objetos 2 de la UNLA
## Tecnologías utilizadas
- **Java 11+**
- **Hibernate 5.4.x**
- **MySQL**
- **JDBC**
- **JUnit (tests simples)**
- IDE recomendado: **Eclipse** o **IntelliJ IDEA**

---
## Estructura del proyecto

- `src/datos/` → Clases de dominio (Cliente, Empleado, Turno, etc.)
- `src/dao/` → Clases DAO con lógica de persistencia
- `src/negocio/` → Clases ABM que encapsulan lógica de negocio
- `src/mapeos/` → Archivos `.hbm.xml` de mapeo de Hibernate
- `src/test/` → Clases con pruebas funcionales (no unitarias)
- `src/hibernate.cfg.xml` → Configuración de conexión de Hibernate

---

## Cómo levantar el proyecto
  1. Clonar el repositorio

```bash
git clone https://github.com/tuusuario/TP-OO2-Grupo-20.git
cd TP-OO2-Grupo-20
