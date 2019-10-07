package vehicle;

import junit.framework.TestCase;

import vehicle.mundo.Vehiculo;

/**
 * Es la clase de pruebas para la clase Vehiculo
 */
public class VehiculoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el primer vehiculo usado para las pruebas
     */
    private Vehiculo vehiculo1;

    /**
     * Es el segundo vehiculo usado para las pruebas
     */
    private Vehiculo vehiculo2;

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Crea un par de vehiculos
     */
    private void setupEscenario1( )
    {
        vehiculo1 = new Vehiculo( "modelo1", "marca1", "imagen1", Vehiculo.AUTOMOVIL, 1, 1, 2, 8000000 );
        vehiculo2 = new Vehiculo( "modelo2", "marca2", "imagen2", Vehiculo.AUTOMOVIL, 2, 2, 2, 4500000 );
    }

    /**
     * Verifica el constructor con parmetros de la clase Vehiculo. <br>
     * <b> Mtodos a probar: </b> <br>
     * Vehiculo. <br>
     * <b> Objetivo: </b> Probar que el mtodo constructor cree correctamente un vehiculo. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un vehiculo, toda su informacin debe ser inicializada correctamente.
     * 
     */
    public void testVehiculo1( )
    {
        setupEscenario1( );

        assertEquals( "El modelo del vehiculo est mal", "modelo1", vehiculo1.darModelo( ) );
        assertEquals( "La marca del vehiculo est mal", "marca1", vehiculo1.darMarca( ) );
        assertEquals( "La imagen del vehiculo est mal", "imagen1", vehiculo1.darImagen( ) );
        assertEquals( "El tipo del vehiculo est mal", Vehiculo.AUTOMOVIL, vehiculo1.darTipo( ) );
        assertEquals( "La cilindrada del vehiculo est mal", 1, vehiculo1.darCilindrada( ) );
        assertEquals( "El nmero de ejes del vehiculo est mal", 2, vehiculo1.darEjes( ) );
        assertEquals( "El ao del vehiculo est mal", 1, vehiculo1.darAnio( ) );
        assertEquals( "El vehiculo del vehiculo est mal", 8000000, vehiculo1.getValue( ) );
    }

    /**
     * Verifica el mtodo compararPorAnio. <br>
     * <b> Mtodos a probar: </b> <br>
     * compararPorAnio. <br>
     * <b> Objetivo: </b> Probar que el mtodo compararPorAnio() realice correctamente la comparacin por ao entre los vehiculos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos vehiculos cuyo ao es igual se debe obtener 0. <br>
     * 2. Al comprar un vehiculo A con B, sabiendo que el ao de B es posterior, se debe obtener -1. <br>
     * 3. Al comprar un vehiculo A con B, sabiendo que el ao de B es anterior, se debe obtener 1.
     */
    public void testCompararPorAnio( )
    {
        setupEscenario1( );

        assertEquals( "Compar mal el ao: deba ser menor", -1, vehiculo1.compararPorAnio( vehiculo2 ) );
        assertEquals( "Compar mal el ao: deba ser igual", 0, vehiculo1.compararPorAnio( vehiculo1 ) );
        assertEquals( "Compar mal el ao: deba ser mayor", 1, vehiculo2.compararPorAnio( vehiculo1 ) );

    }

    /**
     * Verifica el mtodo compararPorCilindrada. <br>
     * <b> Mtodos a probar: </b> <br>
     * compararPorCilindrada. <br>
     * <b> Objetivo: </b> Probar que el mtodo compararPorCilindrada() realice correctamente la comparacin por cilindrada entre los vehiculos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos vehiculos cuyo cilindrada es igual se debe obtener 0. <br>
     * 2. Al comprar un vehiculo A con B, sabiendo que el cilindrada de B es mayor, se debe obtener -1. <br>
     * 3. Al comprar un vehiculo A con B, sabiendo que el cilindrada de B es menor, se debe obtener 1.
     * 
     */
    public void testCompararPorCilindrada( )
    {
        setupEscenario1( );

        assertEquals( "Compar mal la Cilindrada: deba ser menor", -1, vehiculo1.compararPorCilindrada( vehiculo2 ) );
        assertEquals( "Compar mal la Cilindrada: deba ser igual", 0, vehiculo1.compararPorCilindrada( vehiculo1 ) );
        assertEquals( "Compar mal la Cilindrada: deba ser mayor", 1, vehiculo2.compararPorCilindrada( vehiculo1 ) );
    }

    /**
     * Verifica el mtodo compararPorMarca. <br>
     * <b> Mtodos a probar: </b> <br>
     * compararPorMarca. <br>
     * <b> Objetivo: </b> Probar que el mtodo compararPorMarca() realice correctamente la comparacin por marca entre los vehiculos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos vehiculos cuyas marcas son iguales se debe obtener 0. <br>
     * 2. Al comprar un vehiculo A con B, sabiendo que la marca de B es mayor lexicogrficamente, se debe obtener -1. <br>
     * 3. Al comprar un vehiculo A con B, sabiendo que la marca de B es menor lexicogrficamente, se debe obtener 1.
     * 
     */
    public void testCompararPorMarca( )
    {
        setupEscenario1( );

        assertEquals( "Compar mal la marca: deba ser menor", -1, vehiculo1.compararPorMarca( vehiculo2 ) );
        assertEquals( "Compar mal la marca: deba ser igual", 0, vehiculo1.compararPorMarca( vehiculo1 ) );
        assertEquals( "Compar mal la marca: deba ser mayor", 1, vehiculo2.compararPorMarca( vehiculo1 ) );

    }

    /**
     * Verifica el mtodo compararPorValor. <br>
     * <b> Mtodos a probar: </b> <br>
     * compararPorValor. <br>
     * <b> Objetivo: </b> Probar que el mtodo compararPorValor() realice correctamente la comparacin por valor entre los vehiculos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar dos vehiculos cuyo valor es igual se debe obtener 0. <br>
     * 2. Al comprar un vehiculo A con B, sabiendo que el valor de B es mayor, se debe obtener -1. <br>
     * 3. Al comprar un vehiculo A con B, sabiendo que el valor de B es menor, se debe obtener 1.
     * 
     */
    public void testCompararPorValor( )
    {
        setupEscenario1( );

        assertEquals( "Compar mal el Valor: deba ser menor", 1, vehiculo1.compararPorValor( vehiculo2 ) );
        assertEquals( "Compar mal el Valor: deba ser igual", 0, vehiculo1.compararPorValor( vehiculo1 ) );
        assertEquals( "Compar mal el Valor: deba ser mayor", -1, vehiculo2.compararPorValor( vehiculo1 ) );
    }
}
