# ACTUALIZACION - Se agrega nuevo commit para evaluacion 4 del ramo TIDC04

Los cambios contemplan: 

- Se agrega seguridad con Spring security, se describen distintos roles de acceso, configurados por tipo de usuario lo cual da acceso a distintas vistas.
- Se agregan los controladores, servicios y vistas asociadas al cliente, con los servicios, ver saldo y depositar. 
- Se agrega una custom Query. 
- Se modifica el modelo relacional para que contemple al usuario y authorities requeridos por spring security

# TIDC04_EV3
Evaluacion 3 del ramo Programacion de componentes WEB, con profesor Cesar Ivan Gutierrez Hernandez, docente Inacap Santiago Sur. 


# Pre requisitos
Para inicializar el proyecto, es requerido tener el motor de base de datos postgreSQL, se recomienda la version 12. 
Crear una base de datos vacia llamada prueba3, esto con el fin de que el proveedor de persistencia cree las entidades y relaciones requeridas. 

Proyecto monolitico de Java en Spring Framework MVC con Spring Boot y Thymeleaf como gestor de templates.

Se precargaron los siguientes datos de usuario en un script data.sql para la interaccion con el sistema

- Ejecutivo 

rut: 170411927
clave: 123
nombre: Ivan Villarroel

- Clientes

1) 
rut: 190000001
nombre: Fernanda Rivera

2)
rut: 161111112
nombre: Catalina Villarroel

3)
rut: 181111113
nombre: Camila Valdivia

# Nuevas vistas para ev4

1) Cliente 

![IMAGEN-CLIENTE](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/cliente.jpg)

2) Ver saldo

![IMAGEN-VERSALDOCLIENTE](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/consultarsaldo.jpg)

3) Depositar

![IMAGEN-DEPOSITAR](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/depositarcliente.jpg)

4) Modelo relacional actualizado


![IMAGEN-NUEVOMODELO](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/nuevomodelo.jpg)

# Vistas

1) Login 

Si las credenciales no son validas, se mostraran dos tipos de errores 

![IMAGEN-LOGIN2](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/login2.jpg)

![IMAGEN-LOGIN3](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/login3.jpg)

2) Ejecutivo 

La vista general del ejecutivo 

![IMAGEN-EJECUTIVO](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/ejecutivo.jpg)

3) Crear cuenta

Funcionalidad crear cuenta, mostrando detalle de la cuenta creada

![IMAGEN-CREARCUENTA](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/crearcuenta.jpg)

4) Depositar dinero

Funcionalidad depositar, mostrando detalle del deposito realizado

![IMAGEN-DEPOSITAR](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/depositar.jpg)

5) Visualizar detalle de cliente, con movimientos de deposito

![IMAGEN-DETALLECLIENTE](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/buscar2.jpg)


6) Modelo relacional del proyecto

![IMAGEN-MODELORELACIONAL](https://github.com/ivillarroelr/TIDC04_EV3/blob/master/readmefiles/modelorelacional.jpg)

