/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: VentaVehiculosTest.java,v 1.8 2007/04/10 22:56:32 carl-veg Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario Sánchez - 06/12/2005 
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
     * Es el manejador al que se le agrega un vehículo
     */
    private VentaVehiculos ventaVehiculos;

    // -----------------------------------------------------------------
    // Métodos
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
     * Verifica el método agregarVehiculo agregando correctamente un vehículo. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarVehiculo, agregarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el método agregarVehiculo() agregue correctamente un nuevo vehículo a la venta de carros. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un vehículo, su búsqueda debe retornar una posición diferente de -1.
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
            assertTrue( "No se agregó correctamente el vehículo", agregado );
            int posicion = ventaVehiculos.buscarVehiculo( modeloVehiculo, anioVehiculo );
            assertTrue( "No se agregó correctamente el vehículo", posicion != -1 );
        }

        assertEquals( "El número de vehículos agregados no es correcto", tamOriginal + agregados, ventaVehiculos.darVehiculos( ).size( ) );

        // Prueba con el escenario 2
        setupEscenario2( );

        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        assertEquals( "El número de vehículos es incorrecto", 8, vehiculos.size( ) );

        String modelo = "SL2";
        int anio = 1996;
        assertTrue( "No se encontró el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "Jetta";
        anio = 1998;
        assertTrue( "No se encontró el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "Explorer";
        anio = 1999;
        assertTrue( "No se encontró el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "New Beetle";
        anio = 2000;
        assertTrue( "No se encontró el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "Caravan";
        anio = 2000;
        assertTrue( "No se encontró el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "TT";
        anio = 2002;
        assertTrue( "No se encontró el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "CLK430";
        anio = 2003;
        assertTrue( "No se encontró el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );

        modelo = "S10 Pickup";
        anio = 1983;
        assertTrue( "No se encontró el " + modelo + " de " + anio, ventaVehiculos.buscarVehiculo( modelo, anio ) != -1 );
    }

    /**
     * Verifica el método agregarVehiculo agregando un vehículo con modelo y año repetido. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el método agregarVehiculo() no permita la adición de dos vehículos iguales. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al tratar de agregar un vehículo con año y modelo iguales a los de otro existente en la venta esto no se debe permitir.
     */
    public void testAgregarVehiculo2( )
    {
        setupEscenario1( );

        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        Vehiculo v = ( Vehiculo )vehiculos.get( 0 );
        String modeloVehiculo = v.darModelo( );

        assertFalse( "No debería haberse agregado el vehículo porque el modelo y el año están repetidos", ventaVehiculos.agregarVehiculo( modeloVehiculo, modeloVehiculo, modeloVehiculo, Vehiculo.AUTOMOVIL, v.darAnio( ), 1000, 2, 500000 ) );

        assertEquals( "No se debió agregar el vehículo", 12, vehiculos.size( ) );

        Vehiculo v2 = ( Vehiculo )vehiculos.get( 0 );

        assertEquals( "No se debió modificar la información del vehículo", v.darAnio( ), v2.darAnio( ) );

        assertEquals( "No se debió modificar la información del vehículo", v.darCilindrada( ), v2.darCilindrada( ) );

        assertEquals( "No se debió modificar la información del vehículo", v.darEjes( ), v2.darEjes( ) );

        assertEquals( "No se debió modificar la información del vehículo", v.darImagen( ), v2.darImagen( ) );

        assertEquals( "No se debió modificar la información del vehículo", v.darMarca( ), v2.darMarca( ) );

        assertEquals( "No se debió modificar la información del vehículo", v.darModelo( ), v2.darModelo( ) );

        assertEquals( "No se debió modificar la información del vehículo", v.darTipo( ), v2.darTipo( ) );

        assertEquals( "No se debió modificar la información del vehículo", v.darValor( ), v2.darValor( ) );

    }

    /**
     * Verifica el método buscarVehiculo. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el método buscarVehiculo() busque correctamente los vehículos que han sido agregado a la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un vehículo previamente agregado, éste debe ser encontrado.
     * 
     */
    public void testBuscarVehiculo( )
    {
        setupEscenario2( );

        // Ordena los vehículos según el año y saca el más antiguo
        ventaVehiculos.ordenarPorAnio( );
        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        Vehiculo v0 = ( Vehiculo )vehiculos.get( 0 );
        String modeloVehiculo = v0.darModelo( );
        int anioVehiculo = v0.darAnio( );

        // Ordena los modelos según la marca para "desordenar" antes de buscar por el modelo
        ventaVehiculos.ordenarPorMarca( );

        // Busca el vehículo según el modelo
        int posicion = ventaVehiculos.buscarVehiculo( modeloVehiculo, anioVehiculo );
        assertTrue( "No se encontró el vehículo", posicion != -1 );

        vehiculos = ventaVehiculos.darVehiculos( );
        Vehiculo vn = ( Vehiculo )vehiculos.get( posicion );
        assertEquals( "No se encontró el vehículo buscado", vn.darModelo( ), modeloVehiculo );
    }

    /**
     * Verifica el método para ordenar por cilindrada. <br>
     * <b> Métodos a probar: </b> <br>
     * ordenarPorCilindrada. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorCilindrada() ordena correctamente la lista de vehículos <br>
     * por el valor de su cilindrada. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por cilindrada los vehículos, estos deben quedar en orden ascendente de acuerdo a su cantidad de cilindrada.
     */
    public void testOrdenarPorCilindrada( )
    {
        setupEscenario2( );

        ventaVehiculos.ordenarPorCilindrada( );
        ArrayList vehículos = ventaVehiculos.darVehiculos( );
        for( int i = 1; i < vehículos.size( ); i++ )
        {
            Vehiculo v0 = ( Vehiculo )vehículos.get( i - 1 );
            Vehiculo v1 = ( Vehiculo )vehículos.get( i );

            assertTrue( "No se ordenó bien por Cilindrada", v0.darCilindrada( ) <= v1.darCilindrada( ) );
        }
    }

    /**
     * Verifica el método para ordenar por año. <br>
     * <b> Métodos a probar: </b> <br>
     * ordenarPorAnio. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorAnio() ordena correctamente la lista de vehiculos <br>
     * por su año. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por año los vehículos, estos deben quedar en orden ascendente de acuerdo a su año de fabricación.
     * 
     */
    public void testOrdenarPorAnio( )
    {
        setupEscenario2( );

        ventaVehiculos.ordenarPorAnio( );
        ArrayList vehículos = ventaVehiculos.darVehiculos( );
        for( int i = 1; i < vehículos.size( ); i++ )
        {
            Vehiculo v0 = ( Vehiculo )vehículos.get( i - 1 );
            Vehiculo v1 = ( Vehiculo )vehículos.get( i );

            assertTrue( "No se ordenó bien por anio", v0.darAnio( ) <= v1.darAnio( ) );
        }
    }

    /**
     * Verifica el método para ordenar por marca. <br>
     * <b> Métodos a probar: </b> <br>
     * ordenarPorMarca. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorMarca() ordena correctamente la lista de vehiculos <br>
     * de acuerdo a su marca. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por marca los vehículos, estos deben quedar en orden ascendente de acuerdo al orden lexicográfica de sus marcas.
     */
    public void testOrdenarPorMarca( )
    {
        setupEscenario2( );

        ventaVehiculos.ordenarPorMarca( );
        ArrayList vehículos = ventaVehiculos.darVehiculos( );
        for( int i = 1; i < vehículos.size( ); i++ )
        {
            Vehiculo v0 = ( Vehiculo )vehículos.get( i - 1 );
            Vehiculo v1 = ( Vehiculo )vehículos.get( i );

            assertTrue( "No se ordenó bien por altura", v0.darMarca( ).compareTo( v1.darMarca( ) ) <= 0 );
        }
    }

    /**
     * Verifica el método para buscar el vehículo más antiguo. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarVehiculoMasAntiguo. <br>
     * <b> Objetivo: </b> Probar que el método buscarVehiculoMasAntiguo() retorna correctamente la posición del vehículo más viejo de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el vehículo más antiguo es X. Al buscar el vehículo más antiguo se debe obtener la posición de X.
     */
    public void testBuscarVehiculoMasAntiguo( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        int pos = ventaVehiculos.buscarVehiculoMasAntiguo( );

        assertTrue( "El vehículo más antiguo no se encontró de forma correcta", pos != -1 );

        Vehiculo v = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( pos );

        assertEquals( "El vehículo más antiguo no se encontró de forma correcta", 1, v.darAnio( ) );
        assertEquals( "El vehículo más antiguo no se encontró de forma correcta", "modelo_1", v.darModelo( ) );

        // Prueba con el escenario 2
        setupEscenario2( );
        pos = ventaVehiculos.buscarVehiculoMasAntiguo( );

        assertTrue( "El vehículo más antiguo no se encontró de forma correcta", pos != -1 );

        v = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( pos );

        assertEquals( "El vehículo más antiguo no se encontró de forma correcta", 1983, v.darAnio( ) );
        assertEquals( "El vehículo más antiguo no se encontró de forma correcta", "S10 Pickup", v.darModelo( ) );
    }

    /**
     * Verifica el método para buscar el vehículo más económico. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarVehiculoMasEconomico. <br>
     * <b> Objetivo: </b> Probar que el método buscarVehiculoMasEconomico() retorna correctamente la posición del vehículo más barato de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el vehículo más barato es X. Al buscar el vehículo más barato se debe obtener la posición de X.
     */
    public void testBuscarVehiculoMasEconomico( )
    {

        // Prueba con el escenario 1
        setupEscenario1( );

        int pos = ventaVehiculos.buscarVehiculoMasEconomico( );

        assertTrue( "El vehículo más económico no se encontró de forma correcta", pos != -1 );

        Vehiculo v = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( pos );

        assertEquals( "El vehículo más económico no se encontró de forma correcta", 500, v.darValor( ) );
        assertEquals( "El vehículo más económico no se encontró de forma correcta", "modelo_12", v.darModelo( ) );
        assertEquals( "El vehículo más económico no se encontró de forma correcta", 12, v.darAnio( ) );

        // Prueba con el escenario 2
        setupEscenario2( );
        pos = ventaVehiculos.buscarVehiculoMasEconomico( );

        assertTrue( "El vehículo más nuevo no se encontró de forma correcta", pos != -1 );

        v = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( pos );

        assertEquals( "El vehículo más económico no se encontró de forma correcta", 40000000, v.darValor( ) );
        assertEquals( "El vehículo más económico no se encontró de forma correcta", "New Beetle", v.darModelo( ) );
        assertEquals( "El vehículo más económico no se encontró de forma correcta", 2000, v.darAnio( ) );
    }

    /**
     * Verifica el método para buscar el vehículo más potente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarVehiculoMasPotente. <br>
     * <b> Objetivo: </b> Probar que el método buscarVehiculoMasPotente() retorna correctamente la posición del vehículo más viejo de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el vehículo más potente es X. Al buscar el vehículo más potente se debe obtener la posición de X.
     */
    public void testBuscarVehiculoMasPotente( )
    {
       // TODO
    }

    /**
     * Verifica el método para comprar un vehículo<br>
     * <b> Métodos a probar: </b> <br>
     * comprarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el método comprarVehiculo() elimine un vehículo existente en la venta <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar un vehículo existente, éste debe ser eliminado de la lista de vehículos. <br>
     * 2. Al comprar un vehículo existente, el número de elementos de la lista debe disminuir en uno. <br>
     * 3. Al comprar un vehículo existente, al buscarlo éste no debe ser encontrado.
     */
    public void testComprarVehiculo1( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        int cantidad = vehiculos.size( );

        for( int cont = 0; cont < cantidad; cont++ )
        {
            assertTrue( "El vehículo debería haberse comprado", ventaVehiculos.comprarVehiculo( "modelo_" + ( cont + 1 ), cont + 1 ) );
        }

        vehiculos = ventaVehiculos.darVehiculos( );
        assertEquals( "No deberían haber vehículos", 0, vehiculos.size( ) );

        // Prueba con el escenario 2
        setupEscenario2( );

        vehiculos = ventaVehiculos.darVehiculos( );
        cantidad = vehiculos.size( );

        assertTrue( "El vehículo debería haberse comprado", ventaVehiculos.comprarVehiculo( "CLK430", 2003 ) );

        assertTrue( "El vehículo debería haberse comprado", ventaVehiculos.comprarVehiculo( "Explorer", 1999 ) );

        assertTrue( "El vehículo debería haberse comprado", ventaVehiculos.comprarVehiculo( "New Beetle", 2000 ) );

        vehiculos = ventaVehiculos.darVehiculos( );
        assertEquals( "Los vehículos no se compraron de forma correcta", cantidad - 3, vehiculos.size( ) );

        assertTrue( "El vehículo debería haberse comprado", ventaVehiculos.buscarVehiculo( "CLK430", 2003 ) == -1 );

        assertTrue( "El vehículo debería haberse comprado", ventaVehiculos.buscarVehiculo( "Explorer", 1999 ) == -1 );

        assertTrue( "El vehículo debería haberse comprado", ventaVehiculos.buscarVehiculo( "New Beetle", 2000 ) == -1 );
    }

    /**
     * Verifica el método para comprar un vehículo<br>
     * <b> Métodos a probar: </b> <br>
     * comprarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el método comprarVehiculo() no elimine un vehículo que no exista en la venta <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar un vehículo que no existe, la lista de vehículos no debe cambiar su tamaño.
     */
    public void testComprarVehiculo2( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        ArrayList vehiculos = ventaVehiculos.darVehiculos( );
        int cantidad = vehiculos.size( );

        for( int cont = 0; cont < cantidad; cont++ )
        {
            assertFalse( "El vehículo no debería haberse comprado", ventaVehiculos.comprarVehiculo( "modelo_" + ( cont + 1 ), cont ) );
        }

        vehiculos = ventaVehiculos.darVehiculos( );
        assertEquals( "No deberían haber vehículos", cantidad, vehiculos.size( ) );

        // Prueba con el escenario 2
        setupEscenario2( );

        vehiculos = ventaVehiculos.darVehiculos( );
        cantidad = vehiculos.size( );

        assertTrue( "El vehículo debería haberse comprado", ventaVehiculos.comprarVehiculo( "CLK430", 2003 ) );

        assertFalse( "El vehículo no debería haberse comprado", ventaVehiculos.comprarVehiculo( "CLK430", 2003 ) );

        assertFalse( "El vehículo no debería haberse comprado", ventaVehiculos.comprarVehiculo( "Explorer", 1990 ) );

        assertFalse( "El vehículo debería haberse comprado", ventaVehiculos.comprarVehiculo( "New Beetless", 2000 ) );

        vehiculos = ventaVehiculos.darVehiculos( );

        assertEquals( "Los vehículos no se compraron de forma correcta", cantidad - 1, vehiculos.size( ) );
    }

    /**
     * Verifica el método para disminuir el precio de los vehículos<br>
     * <b> Métodos a probar: </b> <br>
     * disminuirPrecio. <br>
     * <b> Objetivo: </b> Probar que el método disminuirPrecio() disminuya correctamente el precio de los vehículos <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que hay X vehículos cuyo valor es mayor a Z. Al disminuir el valor de los vehículos usando Z, se debe disminuir el valor de X vehículos. <br>
     * 2. Se sabe que el valor de un vehículo antes del descuento es Y. Al realizar el descuento el valor del vehículo, si estuvo implicado en el descuento, debe ser Y*0.9
     */
    public void testDisminuirPrecio( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        Vehiculo vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 0 );
        int valor = vehiculo.darValor( );
        assertEquals( "No se disminuyó el precio de forma correcta", 1, ventaVehiculos.disminuirPrecio( 11500 ) );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 0 );
        int valorNuevo = vehiculo.darValor( );

        assertEquals( "No se disminuyó el precio de forma correcta", ( int ) ( valor * 0.9 ), valorNuevo );

        assertEquals( "No se disminuyó el precio de forma correcta", 0, ventaVehiculos.disminuirPrecio( 12000 ) );

        // Prueba con el escenario 2
        setupEscenario2( );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 0 );
        valor = vehiculo.darValor( );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 6 );
        int valor2 = vehiculo.darValor( );

        assertEquals( "No se disminuyó el precio de forma correcta", 2, ventaVehiculos.disminuirPrecio( 89000000 ) );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 0 );
        valorNuevo = vehiculo.darValor( );

        vehiculo = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( 6 );
        int valorNuevo2 = vehiculo.darValor( );

        assertEquals( "No se disminuyó el precio de forma correcta", ( int ) ( valor * 0.9 ), valorNuevo );

        assertEquals( "No se disminuyó el precio de forma correcta", ( int ) ( valor2 * 0.9 ), valorNuevo2 );

        assertEquals( "No se disminuyó el precio de forma correcta", 0, ventaVehiculos.disminuirPrecio( 600000000 ) );
    }

    // -----------------------------------------------------------------
    // Métodos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Carga los vehículos a partir de un archivo de propiedades.
     * @param archivo es el nombre del archivo de propiedades que contiene la información de los vehículos
     */
    private void cargarVehiculos( String archivo )
    {
        try
        {
            FileInputStream fis = new FileInputStream( new File( archivo ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            // Cargar los vehículos
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
                // Carga un vehículo
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

                // Sólo se carga el vehículo si los datos son correctos
                if( modelo != null && marca != null && imagen != null && tipo != null && anio > 0 && cilandraje > 0 && ejes > 0 && valor > 0 )
                    ventaVehiculos.agregarVehiculo( modelo, marca, imagen, tipo, anio, cilandraje, ejes, valor );
                fis.close( );
            }
        }
        catch( FileNotFoundException e )
        {
            fail( "No se debió arrojar excepción" );
        }
        catch( IOException e )
        {
            fail( "No se debió arrojar excepción" );
        }
    }

}
