/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: VehiculoTest.java,v 1.7 2007/04/10 23:02:19 carl-veg Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2006
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos
 * Autor: Mario S�nchez - 07/02/2006 
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
     * Es el primer veh�culo usado para las pruebas
     */
    private Vehiculo vehiculo1;

    /**
     * Es el segundo veh�culo usado para las pruebas
     */
    private Vehiculo vehiculo2;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Crea un par de veh�culos
     */
    private void setupEscenario1( )
    {
        vehiculo1 = new Vehiculo( "modelo1", "marca1", "imagen1", Vehiculo.AUTOMOVIL, 1, 1, 2, 8000000 );
        vehiculo2 = new Vehiculo( "modelo2", "marca2", "imagen2", Vehiculo.AUTOMOVIL, 2, 2, 2, 4500000 );
    }

    /**
     * Verifica el constructor con par�metros de la clase Vehiculo. <br>
     * <b> M�todos a probar: </b> <br>
     * Vehiculo. <br>
     * <b> Objetivo: </b> Probar que el m�todo constructor cree correctamente un veh�culo. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un veh�culo, toda su informaci�n debe ser inicializada correctamente.
     * 
     */
    public void testVehiculo1( )
    {
        setupEscenario1( );

        assertEquals( "El modelo del veh�culo est� mal", "modelo1", vehiculo1.darModelo( ) );
        assertEquals( "La marca del veh�culo est� mal", "marca1", vehiculo1.darMarca( ) );
        assertEquals( "La imagen del veh�culo est� mal", "imagen1", vehiculo1.darImagen( ) );
        assertEquals( "El tipo del veh�culo est� mal", Vehiculo.AUTOMOVIL, vehiculo1.darTipo( ) );
        assertEquals( "La cilindrada del veh�culo est� mal", 1, vehiculo1.darCilindrada( ) );
        assertEquals( "El n�mero de ejes del veh�culo est� mal", 2, vehiculo1.darEjes( ) );
        assertEquals( "El a�o del veh�culo est� mal", 1, vehiculo1.darAnio( ) );
        assertEquals( "El veh�culo del veh�culo est� mal", 8000000, vehiculo1.darValor( ) );
    }

    /**
     * Verifica el m�todo compararPorAnio. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorAnio. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorAnio() realice correctamente la comparaci�n por a�o entre los veh�culos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos veh�culos cuyo a�o es igual se debe obtener 0. <br>
     * 2. Al comprar un veh�culo A con B, sabiendo que el a�o de B es posterior, se debe obtener -1. <br>
     * 3. Al comprar un veh�culo A con B, sabiendo que el a�o de B es anterior, se debe obtener 1.
     */
    public void testCompararPorAnio( )
    {
        setupEscenario1( );

        assertEquals( "Compar� mal el a�o: deb�a ser menor", -1, vehiculo1.compararPorAnio( vehiculo2 ) );
        assertEquals( "Compar� mal el a�o: deb�a ser igual", 0, vehiculo1.compararPorAnio( vehiculo1 ) );
        assertEquals( "Compar� mal el a�o: deb�a ser mayor", 1, vehiculo2.compararPorAnio( vehiculo1 ) );

    }

    /**
     * Verifica el m�todo compararPorCilindrada. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorCilindrada. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorCilindrada() realice correctamente la comparaci�n por cilindrada entre los veh�culos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos veh�culos cuyo cilindrada es igual se debe obtener 0. <br>
     * 2. Al comprar un veh�culo A con B, sabiendo que el cilindrada de B es mayor, se debe obtener -1. <br>
     * 3. Al comprar un veh�culo A con B, sabiendo que el cilindrada de B es menor, se debe obtener 1.
     * 
     */
    public void testCompararPorCilindrada( )
    {
        setupEscenario1( );

        assertEquals( "Compar� mal la Cilindrada: deb�a ser menor", -1, vehiculo1.compararPorCilindrada( vehiculo2 ) );
        assertEquals( "Compar� mal la Cilindrada: deb�a ser igual", 0, vehiculo1.compararPorCilindrada( vehiculo1 ) );
        assertEquals( "Compar� mal la Cilindrada: deb�a ser mayor", 1, vehiculo2.compararPorCilindrada( vehiculo1 ) );
    }

    /**
     * Verifica el m�todo compararPorMarca. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorMarca. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorMarca() realice correctamente la comparaci�n por marca entre los veh�culos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos veh�culos cuyas marcas son iguales se debe obtener 0. <br>
     * 2. Al comprar un veh�culo A con B, sabiendo que la marca de B es mayor lexicogr�ficamente, se debe obtener -1. <br>
     * 3. Al comprar un veh�culo A con B, sabiendo que la marca de B es menor lexicogr�ficamente, se debe obtener 1.
     * 
     */
    public void testCompararPorMarca( )
    {
        setupEscenario1( );

        assertEquals( "Compar� mal la marca: deb�a ser menor", -1, vehiculo1.compararPorMarca( vehiculo2 ) );
        assertEquals( "Compar� mal la marca: deb�a ser igual", 0, vehiculo1.compararPorMarca( vehiculo1 ) );
        assertEquals( "Compar� mal la marca: deb�a ser mayor", 1, vehiculo2.compararPorMarca( vehiculo1 ) );

    }

    /**
     * Verifica el m�todo compararPorValor. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorValor. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorValor() realice correctamente la comparaci�n por valor entre los veh�culos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos veh�culos cuyo valor es igual se debe obtener 0. <br>
     * 2. Al comprar un veh�culo A con B, sabiendo que el valor de B es mayor, se debe obtener -1. <br>
     * 3. Al comprar un veh�culo A con B, sabiendo que el valor de B es menor, se debe obtener 1.
     * 
     */
    public void testCompararPorValor( )
    {
        setupEscenario1( );

        assertEquals( "Compar� mal el Valor: deb�a ser menor", 1, vehiculo1.compararPorValor( vehiculo2 ) );
        assertEquals( "Compar� mal el Valor: deb�a ser igual", 0, vehiculo1.compararPorValor( vehiculo1 ) );
        assertEquals( "Compar� mal el Valor: deb�a ser mayor", -1, vehiculo2.compararPorValor( vehiculo1 ) );
    }
}
