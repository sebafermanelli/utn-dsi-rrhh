# UTN FRRO - Asignatura: Diseño de Sistemas
## RRHH - Ingenieria inversa
Aplicación académica de ejemplo con Spring para agendar entrevistas con candidatos según los conocimientos requeridos.
- Link para ver la aplicación online: [https://link.com/]()

## Software necesario para correr el proyecto
- Descargar e instalar JDK **[Java 20](https://www.oracle.com/java/technologies/downloads/#java20)**.
- Descargar e instalar la última versión de **[IntellIJ IDEA](https://www.jetbrains.com/idea/download/)** u otro IDE para Java.
- Descargar e instalar **[XAMPP 8.2.4](https://www.apachefriends.org/es/download.html)**.

## Descargar dependencias
Antes de ejecutar el proyecto por primera vez se deben descargar las dependencias a través de Maven:
1. Ir a la barra lateral derecha y hacer clic en el icono de **Maven**
2. Hacer doble clic sobre **clean**

## Como conectar la base de datos MySQL
1. Ejecutar XAMPP y hacer clic en **Start** de **Apache** y **MySQL**
2. En el navegador web entrar a [http://localhost/phpmyadmin/](http://localhost/phpmyadmin/)
3. En el menu izquierdo hacer click en **New** y colocar de *Database name*: **rrhh_db**

## Correr la aplicación
Para ejecutar la aplicación:
1. Terminar cualquier aplicación que esté corriendo dentro de IntellIJ.
2. Ir al Paquete **rrhh**
3. Clic derecho en **Application.java** y luego en **Run 'Aplication'**.
4. Finalmente abrir el navegador web en [http://localhost:8080/](http://localhost:8080/)
