@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogota - Colombia)
REM Departamento de Ingeniería de Sistemas y Computacion
REM Todos los derechos reservados 2005
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n7_ventaVehiculos
REM Autor: Mario Sánchez 06/12/2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/

REM ---------------------------------------------------------
REM Ejecucion de la prueba
REM Archivo de ejecucion: ventaVehiculosTest.jar
REM ---------------------------------------------------------

cd..

java -ea -classpath ./lib/ventaVehiculos.jar;./test/lib/ventaVehiculosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.ventaVehiculos.test.VentaVehiculosTest
java -ea -classpath ./lib/ventaVehiculos.jar;./test/lib/ventaVehiculosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.ventaVehiculos.test.VehiculoTest

cd bin

