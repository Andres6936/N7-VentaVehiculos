/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: VentaVehiculosTest.java,v 1.8 2007/04/10 22:56:32 carl-veg Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario S�nchez - 06/12/2005 
 * Autor: Daniel Romero - 17-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.ventaVehiculos.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import junit.framework.TestCase;
import uniandes.cupi2.ventaVehiculos.mundo.VentaVehiculos;
import uniandes.cupi2.ventaVehiculos.mundo.Vehiculo;

/**
 * Es la clase de pruebas para la clase VentaVehiculos
 */
public class VentaVehiculosTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el manejador al que se le agrega un veh�culo
     */
    private VentaVehiculos ventaVehiculos;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Crea un manejador a partir del archivo vehiculos1.dat
     */
    private void setupEscenario1( )
    {

        ventaVehiculos = new VentaVehiculos( );
        cargarVehiculos( "./test/data/vehiculos1.dat" );

    }

    /**
     * Crea un manejador a partir del archivo vehiculos2.dat
     */
    private void setupEscenario2( )
    {
        ventaVehiculos = new VentaVehiculos( );
        cargarVehiculos( "./test/data/vehiculos2.dat" );
    }

    /**
     * Verifica el m�todo agregarVehiculo agregando correctamente un veh�culo. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarVehiculo, agregarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el m�todo agregarVehiculo() agregue correctamente un nuevo veh�culo a la venta de carros. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un veh�culo, su b�squeda debe retornar una posici�n diferente de -1.
     */
    public void testAgregarVehiculo1( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        int tamOriginal = ventaVehiculos.darVehiculos( ).size( );
        int agregados = 10;
        for( int cont = tamOriginal + 1; cont <= tamOriginal + agregados; cont++ )
        {
            String modeloVehiculo = "modelo_" + cont;
            int anioVehiculo = cont;
            boolean agregado = ventaVehiculos.agregarVehiculo( modeloVehiculo, modeloVehiculo, modeloVehiculo, Vehiculo.AUTOMOVIL, anioVehiculo, 1000, 2, 50000000 );
            assertTrue( "No se agreg� correctamente el veh�culo", agregado );
            int posicion = ventaVehiculos.buscarVehiculo( modeloVehiculo, anioVehiculo );
            assertTrue( "No se agreg� correctamente el veh�culo", posicion != -1 );
        }

        assertEquals( "El n�mero de veh�culos agregados no es correcto", tamOriginal + agregados, ventaVehiculos.darVehiculos( ).size( ) );

        // Prueba con el escenario 2
        setupEscenario2( );

        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        assertEquals( "El n�mero de veh�culos es incorrecto", 8, vehiculos.size( ) );

        String modelo = "SL2";
        int anio = 1996;
        assertTrue( "No se encontr� el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "Jetta";
        anio = 1998;
        assertTrue( "No se encontr� el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "Explorer";
        anio = 1999;
        assertTrue( "No se encontr� el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "New Beetle";
        anio = 2000;
        assertTrue( "No se encontr� el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "Caravan";
        anio = 2000;
        assertTrue( "No se encontr� el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "TT";
        anio = 2002;
        assertTrue( "No se encontr� el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "CLK430";
        anio = 2003;
        assertTrue( "No se encontr� el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "S10 Pickup";
        anio = 1983;
        assertTrue( "No se encontr� el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );
    }

    /**
     * Verifica el m�todo agregarVehiculo agregando un veh�culo con modelo y a�o repetido. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el m�todo agregarVehiculo() no permita la adici�n de dos veh�culos iguales. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al tratar de agregar un veh�culo con a�o y modelo iguales a los de otro existente en la venta esto no se debe permitir.
     */
    public void testAgregarVehiculo2( )
    {
        setupEscenario1( );

        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        Vehiculo v = ( Vehiculo )vehiculos.get( 0 );
        String modeloVehiculo = v.darModelo( );

        assertFalse( "No deber�a haberse agregado el veh�culo porque el modelo y el a�o est�n repetidos", ventaVehiculos.agregarVehiculo( modeloVehiculo, modeloVehiculo, modeloVehiculo, Vehiculo.AUTOMOVIL, v.darAnio( ), 1000, 2, 500000 ) );

        assertEquals( "No se debi� agregar el veh�culo", 12, vehiculos.size( ) );

        Vehiculo v2 = ( Vehiculo )vehiculos.get( 0 );

        assertEquals( "No se debi� modificar la informaci�n del veh�culo", v.darAnio( ), v2.darAnio( ) );

        assertEquals( "No se debi� modificar la informaci�n del veh�culo", v.darCilindrada( ), v2.darCilindrada( ) );

        assertEquals( "No se debi� modificar la informaci�n del veh�culo", v.darEjes( ), v2.darEjes( ) );

        assertEquals( "No se debi� modificar la informaci�n del veh�culo", v.darImagen( ), v2.darImagen( ) );

        assertEquals( "No se debi� modificar la informaci�n del veh�culo", v.darMarca( ), v2.darMarca( ) );

        assertEquals( "No se debi� modificar la informaci�n del veh�culo", v.darModelo( ), v2.darModelo( ) );

        assertEquals( "No se debi� modificar la informaci�n del veh�culo", v.darTipo( ), v2.darTipo( ) );

        assertEquals( "No se debi� modificar la informaci�n del veh�culo", v.darValor( ), v2.darValor( ) );

    }

    /**
     * Verifica el m�todo buscarVehiculo. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarVehiculo() busque correctamente los veh�culos que han sido agregado a la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un veh�culo previamente agregado, �ste debe ser encontrado.
     * 
     */
    public void testBuscarVehiculo( )
    {
        setupEscenario2( );

        // Ordena los veh�culos seg�n el a�o y saca el m�s antiguo
        ventaVehiculos.ordenarPorAnio( );
        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        Vehiculo v0 = ( Vehiculo )vehiculos.get( 0 );
        String modeloVehiculo = v0.darModelo( );
        int anioVehiculo = v0.darAnio( );

        // Ordena los modelos seg�n la marca para "desordenar" antes de buscar por el modelo
        ventaVehiculos.ordenarPorMarca( );

        // Busca el veh�culo seg�n el modelo
        int posicion = ventaVehiculos.buscarVehiculo( modeloVehiculo, anioVehiculo );
        assertTrue( "No se encontr� el veh�culo", posicion != -1 );

        vehiculos = ventaVehiculos.darVehiculos( );
        Vehiculo vn = ( Vehiculo )vehiculos.get( posicion );
        assertEquals( "No se encontr� el veh�culo buscado", vn.darModelo( ), modeloVehiculo );
    }

    /**
     * Verifica el m�todo para ordenar por cilindrada. <br>
     * <b> M�todos a probar: </b> <br>
     * ordenarPorCilindrada. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorCilindrada() ordena correctamente la lista de veh�culos <br>
     * por el valor de su cilindrada. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por cilindrada los veh�culos, estos deben quedar en orden ascendente de acuerdo a su cantidad de cilindrada.
     */
    public void testOrdenarPorCilindrada( )
    {
        setupEscenario2( );

        ventaVehiculos.ordenarPorCilindrada( );
        ArrayList veh�culos = ventaVehiculos.darVehiculos( );
        for( int i = 1; i < veh�culos.size( ); i++ )
        {
            Vehiculo v0 = ( Vehiculo )veh�culos.get( i - 1 );
            Vehiculo v1 = ( Vehiculo )veh�culos.get( i );

            assertTrue( "No se orden� bien por Cilindrada", v0.darCilindrada( ) <= v1.darCilindrada( ) );
        }
    }

    /**
     * Verifica el m�todo para ordenar por a�o. <br>
     * <b> M�todos a probar: </b> <br>
     * ordenarPorAnio. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorAnio() ordena correctamente la lista de vehiculos <br>
     * por su a�o. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por a�o los veh�culos, estos deben quedar en orden ascendente de acuerdo a su a�o de fabricaci�n.
     * 
     */
    public void testOrdenarPorAnio( )
    {
        setupEscenario2( );

        ventaVehiculos.ordenarPorAnio( );
        ArrayList veh�culos = ventaVehiculos.darVehiculos( );
        for( int i = 1; i < veh�culos.size( ); i++ )
        {
            Vehiculo v0 = ( Vehiculo )veh�culos.get( i - 1 );
            Vehiculo v1 = ( Vehiculo )veh�culos.get( i );

            assertTrue( "No se orden� bien por anio", v0.darAnio( ) <= v1.darAnio( ) );
        }
    }

    /**
     * Verifica el m�todo para ordenar por marca. <br>
     * <b> M�todos a probar: </b> <br>
     * ordenarPorMarca. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarPorMarca() ordena correctamente la lista de vehiculos <br>
     * de acuerdo a su marca. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por marca los veh�culos, estos deben quedar en orden ascendente de acuerdo al orden lexicogr�fica de sus marcas.
     */
    public void testOrdenarPorMarca( )
    {
        setupEscenario2( );

        ventaVehiculos.ordenarPorMarca( );
        ArrayList veh�culos = ventaVehiculos.darVehiculos( );
        for( int i = 1; i < veh�culos.size( ); i++ )
        {
            Vehiculo v0 = ( Vehiculo )veh�culos.get( i - 1 );
            Vehiculo v1 = ( Vehiculo )veh�culos.get( i );

            assertTrue( "No se orden� bien por altura", v0.darMarca( ).compareTo( v1.darMarca( ) ) <= 0 );
        }
    }

    /**
     * Verifica el m�todo para buscar el veh�culo m�s antiguo. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarVehiculoMasAntiguo. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarVehiculoMasAntiguo() retorna correctamente la posici�n del veh�culo m�s viejo de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el veh�culo m�s antiguo es X. Al buscar el veh�culo m�s antiguo se debe obtener la posici�n de X.
     */
    public void testBuscarVehiculoMasAntiguo( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        int pos = ventaVehiculos.buscarVehiculoMasAntiguo( );

        assertTrue( "El veh�culo m�s antiguo no se encontr� de forma correcta", pos != -1 );

        Vehiculo v = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( pos );

        assertEquals( "El veh�culo m�s antiguo no se encontr� de forma correcta", 1, v.darAnio( ) );
        assertEquals( "El veh�culo m�s antiguo no se encontr� de forma correcta", "modelo_1", v.darModelo( ) );

        // Prueba con el escenario 2
        setupEscenario2( );
        pos = ventaVehiculos.buscarVehiculoMasAntiguo( );

        assertTrue( "El veh�culo m�s antiguo no se encontr� de forma correcta", pos != -1 );

        v = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( pos );

        assertEquals( "El veh�culo m�s antiguo no se encontr� de forma correcta", 1983, v.darAnio( ) );
        assertEquals( "El veh�culo m�s antiguo no se encontr� de forma correcta", "S10 Pickup", v.darModelo( ) );
    }

    /**
     * Verifica el m�todo para buscar el veh�culo m�s econ�mico. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarVehiculoMasEconomico. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarVehiculoMasEconomico() retorna correctamente la posici�n del veh�culo m�s barato de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el veh�culo m�s barato es X. Al buscar el veh�culo m�s barato se debe obtener la posici�n de X.
     */
    public void testBuscarVehiculoMasEconomico( )
    {

        // Prueba con el escenario 1
        setupEscenario1( );

        int pos = ventaVehiculos.buscarVehiculoMasEconomico( );

        assertTrue( "El veh�culo m�s econ�mico no se encontr� de forma correcta", pos != -1 );

        Vehiculo v = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( pos );

        assertEquals( "El veh�culo m�s econ�mico no se encontr� de forma correcta", 500, v.darValor( ) );
        assertEquals( "El veh�culo m�s econ�mico no se encontr� de forma correcta", "modelo_12", v.darModelo( ) );
        assertEquals( "El veh�culo m�s econ�mico no se encontr� de forma correcta", 12, v.darAnio( ) );

        // Prueba con el escenario 2
        setupEscenario2( );
        pos = ventaVehiculos.buscarVehiculoMasEconomico( );

        assertTrue( "El veh�culo m�s nuevo no se encontr� de forma correcta", pos != -1 );

        v = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( pos );

        assertEquals( "El veh�culo m�s econ�mico no se encontr� de forma correcta", 40000000, v.darValor( ) );
        assertEquals( "El veh�culo m�s econ�mico no se encontr� de forma correcta", "New Beetle", v.darModelo( ) );
        assertEquals( "El veh�culo m�s econ�mico no se encontr� de forma correcta", 2000, v.darAnio( ) );
    }

    /**
     * Verifica el m�todo para buscar el veh�culo m�s potente. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarVehiculoMasPotente. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarVehiculoMasPotente() retorna correctamente la posici�n del veh�culo m�s viejo de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el veh�culo m�s potente es X. Al buscar el veh�culo m�s potente se debe obtener la posici�n de X.
     */
    public void testBuscarVehiculoMasPotente( )
    {
       // TODO
    }

    /**
     * Verifica el m�todo para comprar un veh�culo<br>
     * <b> M�todos a probar: </b> <br>
     * comprarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el m�todo comprarVehiculo() elimine un veh�culo existente en la venta <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar un veh�culo existente, �ste debe ser eliminado de la lista de veh�culos. <br>
     * 2. Al comprar un veh�culo existente, el n�mero de elementos de la lista debe disminuir en uno. <br>
     * 3. Al comprar un veh�culo existente, al buscarlo �ste no debe ser encontrado.
     */
    public void testComprarVehiculo1( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        int cantidad = vehiculos.size( );

        for( int cont = 0; cont < cantidad; cont++ )
        {
            assertTrue( "El veh�culo deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "modelo_" + ( cont + 1 ), cont + 1 ) );
        }

        vehiculos = ventaVehiculos.darVehiculos( );
        assertEquals( "No deber�an haber veh�culos", 0, vehiculos.size( ) );

        // Prueba con el escenario 2
        setupEscenario2( );

        vehiculos = ventaVehiculos.darVehiculos( );
        cantidad = vehiculos.size( );

        assertTrue( "El veh�culo deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "CLK430", 2003 ) );

        assertTrue( "El veh�culo deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "Explorer", 1999 ) );

        assertTrue( "El veh�culo deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "New Beetle", 2000 ) );

        vehiculos = ventaVehiculos.darVehiculos( );
        assertEquals( "Los veh�culos no se compraron de forma correcta", cantidad - 3, vehiculos.size( ) );

        assertTrue( "El veh�culo deber�a haberse comprado", ventaVehiculos.buscarVehiculo( "CLK430", 2003 ) == -1 );

        assertTrue( "El veh�culo deber�a haberse comprado", ventaVehiculos.buscarVehiculo( "Explorer", 1999 ) == -1 );

        assertTrue( "El veh�culo deber�a haberse comprado", ventaVehiculos.buscarVehiculo( "New Beetle", 2000 ) == -1 );
    }

    /**
     * Verifica el m�todo para comprar un veh�culo<br>
     * <b> M�todos a probar: </b> <br>
     * comprarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el m�todo comprarVehiculo() no elimine un veh�culo que no exista en la venta <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar un veh�culo que no existe, la lista de veh�culos no debe cambiar su tama�o.
     */
    public void testComprarVehiculo2( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        int cantidad = vehiculos.size( );

        for( int cont = 0; cont < cantidad; cont++ )
        {
            assertFalse( "El veh�culo no deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "modelo_" + ( cont + 1 ), cont ) );
        }

        vehiculos = ventaVehiculos.darVehiculos( );
        assertEquals( "No deber�an haber veh�culos", cantidad, vehiculos.size( ) );

        // Prueba con el escenario 2
        setupEscenario2( );

        vehiculos = ventaVehiculos.darVehiculos( );
        cantidad = vehiculos.size( );

        assertTrue( "El veh�culo deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "CLK430", 2003 ) );

        assertFalse( "El veh�culo no deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "CLK430", 2003 ) );

        assertFalse( "El veh�culo no deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "Explorer", 1990 ) );

        assertFalse( "El veh�culo deber�a haberse comprado", ventaVehiculos.comprarVehiculo( "New Beetless", 2000 ) );

        vehiculos = ventaVehiculos.darVehiculos( );

        assertEquals( "Los veh�culos no se compraron de forma correcta", cantidad - 1, vehiculos.size( ) );
    }

    /**
     * Verifica el m�todo para disminuir el precio de los veh�culos<br>
     * <b> M�todos a probar: </b> <br>
     * disminuirPrecio. <br>
     * <b> Objetivo: </b> Probar que el m�todo disminuirPrecio() disminuya correctamente el precio de los veh�culos <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que hay X veh�culos cuyo valor es mayor a Z. Al disminuir el valor de los veh�culos usando Z, se debe disminuir el valor de X veh�culos. <br>
     * 2. Se sabe que el valor de un veh�culo antes del descuento es Y. Al realizar el descuento el valor del veh�culo, si estuvo implicado en el descuento, debe ser Y*0.9
     */
    public void testDisminuirPrecio( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        Vehiculo vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 0 );
        int valor = vehiculo.darValor( );
        assertEquals( "No se disminuy� el precio de forma correcta", 1, ventaVehiculos.disminuirPrecio( 11500 ) );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 0 );
        int valorNuevo = vehiculo.darValor( );

        assertEquals( "No se disminuy� el precio de forma correcta", ( int ) ( valor * 0.9 ), valorNuevo );

        assertEquals( "No se disminuy� el precio de forma correcta", 0, ventaVehiculos.disminuirPrecio( 12000 ) );

        // Prueba con el escenario 2
        setupEscenario2( );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 0 );
        valor = vehiculo.darValor( );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 6 );
        int valor2 = vehiculo.darValor( );

        assertEquals( "No se disminuy� el precio de forma correcta", 2, ventaVehiculos.disminuirPrecio( 89000000 ) );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 0 );
        valorNuevo = vehiculo.darValor( );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 6 );
        int valorNuevo2 = vehiculo.darValor( );

        assertEquals( "No se disminuy� el precio de forma correcta", ( int ) ( valor * 0.9 ), valorNuevo );

        assertEquals( "No se disminuy� el precio de forma correcta", ( int ) ( valor2 * 0.9 ), valorNuevo2 );

        assertEquals( "No se disminuy� el precio de forma correcta", 0, ventaVehiculos.disminuirPrecio( 600000000 ) );
    }

    // -----------------------------------------------------------------
    // M�todos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Carga los veh�culos a partir de un archivo de propiedades.
     * @param archivo es el nombre del archivo de propiedades que contiene la informaci�n de los veh�culos
     */
    private void cargarVehiculos( String archivo )
    {
        try
        {
            FileInputStream fis = new FileInputStream( new File( archivo ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            // Cargar los veh�culos
            String dato;
            String modelo;
            String marca;
            String imagen;
            String tipo;
            int anio;
            int cilandraje;
            int ejes;
            int valor;
            String aux;
            dato = "total.vehiculos";
            aux = propiedades.getProperty( dato );
            int cantidad = Integer.parseInt( aux );

            for( int cont = 1; cont <= cantidad; cont++ )
            {
                // Carga un veh�culo
                dato = "vehiculo" + cont + ".modelo";
                modelo = propiedades.getProperty( dato );

                dato = "vehiculo" + cont + ".marca";
                marca = propiedades.getProperty( dato );

                dato = "vehiculo" + cont + ".imagen";
                imagen = propiedades.getProperty( dato );

                dato = "vehiculo" + cont + ".tipo";
                tipo = propiedades.getProperty( dato );

                dato = "vehiculo" + cont + ".anio";
                aux = propiedades.getProperty( dato );
                anio = Integer.parseInt( aux );

                dato = "vehiculo" + cont + ".cilindrada";
                aux = propiedades.getProperty( dato );
                cilandraje = Integer.parseInt( aux );

                dato = "vehiculo" + cont + ".ejes";
                aux = propiedades.getProperty( dato );
                ejes = Integer.parseInt( aux );

                dato = "vehiculo" + cont + ".valor";
                aux = propiedades.getProperty( dato );
                valor = Integer.parseInt( aux );

                // S�lo se carga el veh�culo si los datos son correctos
                if( modelo != null && marca != null && imagen != null && tipo != null && anio > 0 && cilandraje > 0 && ejes > 0 && valor > 0 )
                    ventaVehiculos.agregarVehiculo( modelo, marca, imagen, tipo, anio, cilandraje, ejes, valor );
                fis.close( );
            }
        }
        catch( FileNotFoundException e )
        {
            fail( "No se debi� arrojar excepci�n" );
        }
        catch( IOException e )
        {
            fail( "No se debi� arrojar excepci�n" );
        }
    }

}
