/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: VehiculoTest.java,v 1.7 2007/04/10 23:02:19 carl-veg Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2006
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos
 * Autor: Mario Sánchez - 07/02/2006 
 * Autor: Daniel Romero - 17-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.ventaVehiculos.test;

import junit.framework.TestCase;
import uniandes.cupi2.ventaVehiculos.mundo.Vehiculo;

/**
 * Es la clase de pruebas para la clase Vehiculo
 */
public class VehiculoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el primer vehículo usado para las pruebas
     */
    private Vehiculo vehiculo1;

    /**
     * Es el segundo vehículo usado para las pruebas
     */
    private Vehiculo vehiculo2;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Crea un par de vehículos
     */
    private void setupEscenario1( )
    {
        vehiculo1 = new Vehiculo( "modelo1", "marca1", "imagen1", Vehiculo.AUTOMOVIL, 1, 1, 2, 8000000 );
        vehiculo2 = new Vehiculo( "modelo2", "marca2", "imagen2", Vehiculo.AUTOMOVIL, 2, 2, 2, 4500000 );
    }

    /**
     * Verifica el constructor con parámetros de la clase Vehiculo. <br>
     * <b> Métodos a probar: </b> <br>
     * Vehiculo. <br>
     * <b> Objetivo: </b> Probar que el método constructor cree correctamente un vehículo. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un vehículo, toda su información debe ser inicializada correctamente.
     * 
     */
    public void testVehiculo1( )
    {
        setupEscenario1( );

        assertEquals( "El modelo del vehículo está mal", "modelo1", vehiculo1.darModelo( ) );
        assertEquals( "La marca del vehículo está mal", "marca1", vehiculo1.darMarca( ) );
        assertEquals( "La imagen del vehículo está mal", "imagen1", vehiculo1.darImagen( ) );
        assertEquals( "El tipo del vehículo está mal", Vehiculo.AUTOMOVIL, vehiculo1.darTipo( ) );
        assertEquals( "La cilindrada del vehículo está mal", 1, vehiculo1.darCilindrada( ) );
        assertEquals( "El número de ejes del vehículo está mal", 2, vehiculo1.darEjes( ) );
        assertEquals( "El año del vehículo está mal", 1, vehiculo1.darAnio( ) );
        assertEquals( "El vehículo del vehículo está mal", 8000000, vehiculo1.darValor( ) );
    }

    /**
     * Verifica el método compararPorAnio. <br>
     * <b> Métodos a probar: </b> <br>
     * compararPorAnio. <br>
     * <b> Objetivo: </b> Probar que el método compararPorAnio() realice correctamente la comparación por año entre los vehículos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos vehículos cuyo año es igual se debe obtener 0. <br>
     * 2. Al comprar un vehículo A con B, sabiendo que el año de B es posterior, se debe obtener -1. <br>
     * 3. Al comprar un vehículo A con B, sabiendo que el año de B es anterior, se debe obtener 1.
     */
    public void testCompararPorAnio( )
    {
        setupEscenario1( );

        assertEquals( "Comparó mal el año: debía ser menor", -1, vehiculo1.compararPorAnio( vehiculo2 ) );
        assertEquals( "Comparó mal el año: debía ser igual", 0, vehiculo1.compararPorAnio( vehiculo1 ) );
        assertEquals( "Comparó mal el año: debía ser mayor", 1, vehiculo2.compararPorAnio( vehiculo1 ) );

    }

    /**
     * Verifica el método compararPorCilindrada. <br>
     * <b> Métodos a probar: </b> <br>
     * compararPorCilindrada. <br>
     * <b> Objetivo: </b> Probar que el método compararPorCilindrada() realice correctamente la comparación por cilindrada entre los vehículos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos vehículos cuyo cilindrada es igual se debe obtener 0. <br>
     * 2. Al comprar un vehículo A con B, sabiendo que el cilindrada de B es mayor, se debe obtener -1. <br>
     * 3. Al comprar un vehículo A con B, sabiendo que el cilindrada de B es menor, se debe obtener 1.
     * 
     */
    public void testCompararPorCilindrada( )
    {
        setupEscenario1( );

        assertEquals( "Comparó mal la Cilindrada: debía ser menor", -1, vehiculo1.compararPorCilindrada( vehiculo2 ) );
        assertEquals( "Comparó mal la Cilindrada: debía ser igual", 0, vehiculo1.compararPorCilindrada( vehiculo1 ) );
        assertEquals( "Comparó mal la Cilindrada: debía ser mayor", 1, vehiculo2.compararPorCilindrada( vehiculo1 ) );
    }

    /**
     * Verifica el método compararPorMarca. <br>
     * <b> Métodos a probar: </b> <br>
     * compararPorMarca. <br>
     * <b> Objetivo: </b> Probar que el método compararPorMarca() realice correctamente la comparación por marca entre los vehículos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos vehículos cuyas marcas son iguales se debe obtener 0. <br>
     * 2. Al comprar un vehículo A con B, sabiendo que la marca de B es mayor lexicográficamente, se debe obtener -1. <br>
     * 3. Al comprar un vehículo A con B, sabiendo que la marca de B es menor lexicográficamente, se debe obtener 1.
     * 
     */
    public void testCompararPorMarca( )
    {
        setupEscenario1( );

        assertEquals( "Comparó mal la marca: debía ser menor", -1, vehiculo1.compararPorMarca( vehiculo2 ) );
        assertEquals( "Comparó mal la marca: debía ser igual", 0, vehiculo1.compararPorMarca( vehiculo1 ) );
        assertEquals( "Comparó mal la marca: debía ser mayor", 1, vehiculo2.compararPorMarca( vehiculo1 ) );

    }

    /**
     * Verifica el método compararPorValor. <br>
     * <b> Métodos a probar: </b> <br>
     * compararPorValor. <br>
     * <b> Objetivo: </b> Probar que el método compararPorValor() realice correctamente la comparación por valor entre los vehículos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos vehículos cuyo valor es igual se debe obtener 0. <br>
     * 2. Al comprar un vehículo A con B, sabiendo que el valor de B es mayor, se debe obtener -1. <br>
     * 3. Al comprar un vehículo A con B, sabiendo que el valor de B es menor, se debe obtener 1.
     * 
     */
    public void testCompararPorValor( )
    {
        setupEscenario1( );

        assertEquals( "Comparó mal el Valor: debía ser menor", 1, vehiculo1.compararPorValor( vehiculo2 ) );
        assertEquals( "Comparó mal el Valor: debía ser igual", 0, vehiculo1.compararPorValor( vehiculo1 ) );
        assertEquals( "Comparó mal el Valor: debía ser mayor", -1, vehiculo2.compararPorValor( vehiculo1 ) );
    }
}
