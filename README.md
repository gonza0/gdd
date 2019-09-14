### Compilar y ejecutar el proyecto
Para compilar el proyecto es necesario tener instalado JAVA y MAVEN. Ingresa a spring-boot-gdd-rest y ejecutar el
siguiente comando maven:

* mvn package

ya compilado ingresar a la carpeta target y ejecutar el siguiente comando java
* java -jar .\spring-boot-gdd-rest.jar

* importante: favor ejecutar el servicio "Generador_Datos_Desafio_Uno" para que la aplicación consulte la api.

### Consumir API
se adjunta colección postman y respuesta de ejemplo, es muy importante tener el puerto 8082 disponible, de otra forma favor configurar el archivo application.properties para actualizar el puerto