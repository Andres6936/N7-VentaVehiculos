package vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import vehicle.mundo.Vehicle;
import vehicle.mundo.OutletVehicles;

import junit.framework.TestCase;

/**
 * Es la clase de pruebas para la clase VentaVehiculos
 */
public class OutletVehiclesTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el manejador al que se le agrega un vehiculo
     */
    private OutletVehicles outletVehicles;

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Crea un manejador a partir del archivo vehiculosTest1.properties
     */
    private void setupEscenario1( )
    {

        outletVehicles = new OutletVehicles();
        cargarVehiculos("vehiculosTest1.properties");

    }

    /**
     * Crea un manejador a partir del archivo vehiculosTest2.properties
     */
    private void setupEscenario2( )
    {
        outletVehicles = new OutletVehicles();
        cargarVehiculos("vehiculosTest2.properties");
    }

    /**
     * Verifica el mtodo agregarVehiculo agregando correctamente un vehiculo. <br>
     * <b> Mtodos a probar: </b> <br>
     * buscarVehiculo, agregarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el mtodo agregarVehiculo() agregue correctamente un nuevo vehiculo a la venta de carros. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un vehiculo, su bsqueda debe retornar una posicin diferente de -1.
     */
    public void testAgregarVehiculo1( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        int tamOriginal = outletVehicles.darVehiculos().size();
        int agregados = 10;
        for( int cont = tamOriginal + 1; cont <= tamOriginal + agregados; cont++ )
        {
            String modeloVehiculo = "modelo_" + cont;
            int anioVehiculo = cont;
            boolean agregado = outletVehicles.agregarVehiculo(modeloVehiculo, modeloVehiculo, modeloVehiculo, Vehicle.AUTOMOVIL, anioVehiculo, 1000, 2, 50000000);
            assertTrue( "No se agreg correctamente el vehiculo", agregado );
            int posicion = outletVehicles.buscarVehiculo(modeloVehiculo, anioVehiculo);
            assertTrue( "No se agreg correctamente el vehiculo", posicion != -1 );
        }

        assertEquals("El nmero de vehiculos agregados no es correcto", tamOriginal + agregados, outletVehicles.darVehiculos().size());

        // Prueba con el escenario 2
        setupEscenario2( );

        ArrayList vehiculos = outletVehicles.darVehiculos();
        assertEquals( "El nmero de vehiculos es incorrecto", 8, vehiculos.size( ) );

        String modelo = "SL2";
        int anio = 1996;
        assertTrue("No se encontr el " + modelo + " de " + anio, outletVehicles.buscarVehiculo(modelo, anio) != -1);

        modelo = "Jetta";
        anio = 1998;
        assertTrue("No se encontr el " + modelo + " de " + anio, outletVehicles.buscarVehiculo(modelo, anio) != -1);

        modelo = "Explorer";
        anio = 1999;
        assertTrue("No se encontr el " + modelo + " de " + anio, outletVehicles.buscarVehiculo(modelo, anio) != -1);

        modelo = "New Beetle";
        anio = 2000;
        assertTrue("No se encontr el " + modelo + " de " + anio, outletVehicles.buscarVehiculo(modelo, anio) != -1);

        modelo = "Caravan";
        anio = 2000;
        assertTrue("No se encontr el " + modelo + " de " + anio, outletVehicles.buscarVehiculo(modelo, anio) != -1);

        modelo = "TT";
        anio = 2002;
        assertTrue("No se encontr el " + modelo + " de " + anio, outletVehicles.buscarVehiculo(modelo, anio) != -1);

        modelo = "CLK430";
        anio = 2003;
        assertTrue("No se encontr el " + modelo + " de " + anio, outletVehicles.buscarVehiculo(modelo, anio) != -1);

        modelo = "S10 Pickup";
        anio = 1983;
        assertTrue("No se encontr el " + modelo + " de " + anio, outletVehicles.buscarVehiculo(modelo, anio) != -1);
    }

    /**
     * Verifica el mtodo agregarVehiculo agregando un vehiculo con modelo y ao repetido. <br>
     * <b> Mtodos a probar: </b> <br>
     * agregarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el mtodo agregarVehiculo() no permita la adicin de dos vehiculos iguales. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al tratar de agregar un vehiculo con ao y modelo iguales a los de otro existente en la venta esto no se debe permitir.
     */
    public void testAgregarVehiculo2( )
    {
        setupEscenario1();

        ArrayList vehiculos = outletVehicles.darVehiculos();
        Vehicle v = (Vehicle)vehiculos.get(0);
        String modeloVehiculo = v.getModelo();

        assertFalse("No debera haberse agregado el vehiculo porque el modelo y el ao estn repetidos", outletVehicles.agregarVehiculo(modeloVehiculo, modeloVehiculo, modeloVehiculo, Vehicle.AUTOMOVIL, v.getYear(), 1000, 2, 500000));

        assertEquals("No se debi agregar el vehiculo", 12, vehiculos.size());

        Vehicle v2 = (Vehicle)vehiculos.get(0);

        assertEquals("No se debi modificar la informacin del vehiculo", v.getYear(), v2.getYear());

        assertEquals("No se debi modificar la informacin del vehiculo", v.getDisplacement(), v2.getDisplacement());

        assertEquals("No se debi modificar la informacin del vehiculo", v.getEjes(), v2.getEjes());

        assertEquals("No se debi modificar la informacin del vehiculo", v.getImagen(), v2.getImagen());

        assertEquals( "No se debi modificar la informacin del vehiculo", v.getTrademark( ), v2.getTrademark( ) );

        assertEquals("No se debi modificar la informacin del vehiculo", v.getModelo(), v2.getModelo());

        assertEquals("No se debi modificar la informacin del vehiculo", v.getTipo(), v2.getTipo());

        assertEquals( "No se debi modificar la informacin del vehiculo", v.getValue( ), v2.getValue( ) );

    }

    /**
     * Verifica el mtodo buscarVehiculo. <br>
     * <b> Mtodos a probar: </b> <br>
     * buscarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el mtodo buscarVehiculo() busque correctamente los vehiculos que han sido agregado a la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un vehiculo previamente agregado, ste debe ser encontrado.
     * 
     */
    public void testBuscarVehiculo( )
    {
        setupEscenario2();

        // Ordena los vehiculos segn el ao y saca el mas antiguo
        outletVehicles.sortForYear();
        ArrayList vehiculos = outletVehicles.darVehiculos();
        Vehicle v0 = (Vehicle)vehiculos.get(0);
        String modeloVehiculo = v0.getModelo();
        int anioVehiculo = v0.getYear();

        // Ordena los modelos segn la marca para "desordenar" antes de buscar por el modelo
        outletVehicles.sortByTrademark();

        // Busca el vehiculo segn el modelo
        int posicion = outletVehicles.buscarVehiculo(modeloVehiculo, anioVehiculo);
        assertTrue("No se encontr el vehiculo", posicion != -1);

        vehiculos = outletVehicles.darVehiculos();
        Vehicle vn = (Vehicle)vehiculos.get(posicion);
        assertEquals("No se encontr el vehiculo buscado", vn.getModelo(), modeloVehiculo);
    }

    /**
     * Verifica el mtodo para ordenar por cilindrada. <br>
     * <b> Mtodos a probar: </b> <br>
     * ordenarPorCilindrada. <br>
     * <b> Objetivo: </b> Probar que el mtodo ordenarPorCilindrada() ordena correctamente la lista de vehiculos <br>
     * por el valor de su cilindrada. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por cilindrada los vehiculos, estos deben quedar en orden ascendente de acuerdo a su cantidad de cilindrada.
     */
    public void testOrdenarPorCilindrada( )
    {
        setupEscenario2();

        outletVehicles.sortForDisplacement();
        ArrayList vehiculos = outletVehicles.darVehiculos();
        for (int i = 1; i < vehiculos.size(); i++) {
            Vehicle v0 = (Vehicle)vehiculos.get(i - 1);
            Vehicle v1 = (Vehicle)vehiculos.get(i);

            assertTrue("No se orden bien por Cilindrada", v0.getDisplacement() <= v1.getDisplacement());
        }
    }

    /**
     * Verifica el mtodo para ordenar por ao. <br>
     * <b> Mtodos a probar: </b> <br>
     * ordenarPorAnio. <br>
     * <b> Objetivo: </b> Probar que el mtodo ordenarPorAnio() ordena correctamente la lista de vehiculos <br>
     * por su ao. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por ao los vehiculos, estos deben quedar en orden ascendente de acuerdo a su ao de fabricacin.
     * 
     */
    public void testOrdenarPorAnio( )
    {
        setupEscenario2();

        outletVehicles.sortForYear();
        ArrayList vehiculos = outletVehicles.darVehiculos();
        for (int i = 1; i < vehiculos.size(); i++) {
            Vehicle v0 = (Vehicle)vehiculos.get(i - 1);
            Vehicle v1 = (Vehicle)vehiculos.get(i);

            assertTrue("No se orden bien por anio", v0.getYear() <= v1.getYear());
        }
    }

    /**
     * Verifica el mtodo para ordenar por marca. <br>
     * <b> Mtodos a probar: </b> <br>
     * ordenarPorMarca. <br>
     * <b> Objetivo: </b> Probar que el mtodo ordenarPorMarca() ordena correctamente la lista de vehiculos <br>
     * de acuerdo a su marca. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar por marca los vehiculos, estos deben quedar en orden ascendente de acuerdo al orden lexicogrfica de sus marcas.
     */
    public void testOrdenarPorMarca( )
    {
        setupEscenario2();

        outletVehicles.sortByTrademark();
        ArrayList vehiculos = outletVehicles.darVehiculos();
        for (int i = 1; i < vehiculos.size(); i++) {
            Vehicle v0 = (Vehicle)vehiculos.get(i - 1);
            Vehicle v1 = (Vehicle)vehiculos.get(i);

            assertTrue("No se orden bien por altura", v0.getTrademark().compareTo(v1.getTrademark()) <= 0);
        }
    }

    /**
     * Verifica el mtodo para buscar el vehiculo mas antiguo. <br>
     * <b> Mtodos a probar: </b> <br>
     * buscarVehiculoMasAntiguo. <br>
     * <b> Objetivo: </b> Probar que el mtodo buscarVehiculoMasAntiguo() retorna correctamente la posicin del vehiculo mas viejo de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el vehiculo mas antiguo es X. Al buscar el vehiculo mas antiguo se debe obtener la posicin de X.
     */
    public void testBuscarVehiculoMasAntiguo( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        int pos = outletVehicles.buscarVehiculoMasAntiguo();

        assertTrue( "El vehiculo mas antiguo no se encontr de forma correcta", pos != -1 );

        Vehicle v = (Vehicle)outletVehicles.darVehiculos().get(pos);

        assertEquals("El vehiculo mas antiguo no se encontr de forma correcta", 1, v.getYear());
        assertEquals("El vehiculo mas antiguo no se encontr de forma correcta", "modelo_1", v.getModelo());

        // Prueba con el escenario 2
        setupEscenario2();
        pos = outletVehicles.buscarVehiculoMasAntiguo();

        assertTrue( "El vehiculo mas antiguo no se encontr de forma correcta", pos != -1 );

        v = (Vehicle)outletVehicles.darVehiculos().get(pos);

        assertEquals("El vehiculo mas antiguo no se encontr de forma correcta", 1983, v.getYear());
        assertEquals("El vehiculo mas antiguo no se encontr de forma correcta", "S10 Pickup", v.getModelo());
    }

    /**
     * Verifica el mtodo para buscar el vehiculo mas econmico. <br>
     * <b> Mtodos a probar: </b> <br>
     * buscarVehiculoMasEconomico. <br>
     * <b> Objetivo: </b> Probar que el mtodo buscarVehiculoMasEconomico() retorna correctamente la posicin del vehiculo mas barato de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el vehiculo mas barato es X. Al buscar el vehiculo mas barato se debe obtener la posicin de X.
     */
    public void testBuscarVehiculoMasEconomico( )
    {

        // Prueba con el escenario 1
        setupEscenario1( );

        int pos = outletVehicles.getIndexOfVehicleMoreCheap();

        assertTrue( "El vehiculo mas econmico no se encontr de forma correcta", pos != -1 );

        Vehicle v = (Vehicle)outletVehicles.darVehiculos().get(pos);

        assertEquals("El vehiculo mas econmico no se encontr de forma correcta", 500, v.getValue());
        assertEquals("El vehiculo mas econmico no se encontr de forma correcta", "modelo_12", v.getModelo());
        assertEquals("El vehiculo mas econmico no se encontr de forma correcta", 12, v.getYear());

        // Prueba con el escenario 2
        setupEscenario2();
        pos = outletVehicles.getIndexOfVehicleMoreCheap();

        assertTrue( "El vehiculo mas nuevo no se encontr de forma correcta", pos != -1 );

        v = (Vehicle)outletVehicles.darVehiculos().get(pos);

        assertEquals("El vehiculo mas econmico no se encontr de forma correcta", 40000000, v.getValue());
        assertEquals("El vehiculo mas econmico no se encontr de forma correcta", "New Beetle", v.getModelo());
        assertEquals("El vehiculo mas econmico no se encontr de forma correcta", 2000, v.getYear());
    }

    /**
     * Verifica el mtodo para buscar el vehiculo mas potente. <br>
     * <b> Mtodos a probar: </b> <br>
     * buscarVehiculoMasPotente. <br>
     * <b> Objetivo: </b> Probar que el mtodo buscarVehiculoMasPotente() retorna correctamente la posicin del vehiculo mas viejo de la venta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el vehiculo mas potente es X. Al buscar el vehiculo mas potente se debe obtener la posicin de X.
     */
    public void testBuscarVehiculoMasPotente( )
    {
       // TODO
    }

    /**
     * Verifica el mtodo para comprar un vehiculo<br>
     * <b> Mtodos a probar: </b> <br>
     * comprarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el mtodo comprarVehiculo() elimine un vehiculo existente en la venta <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar un vehiculo existente, ste debe ser eliminado de la lista de vehiculos. <br>
     * 2. Al comprar un vehiculo existente, el nmero de elementos de la lista debe disminuir en uno. <br>
     * 3. Al comprar un vehiculo existente, al buscarlo ste no debe ser encontrado.
     */
    public void testComprarVehiculo1( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        ArrayList vehiculos = outletVehicles.darVehiculos();
        int cantidad = vehiculos.size();

        for( int cont = 0; cont < cantidad; cont++ )
        {
            assertTrue("El vehiculo debera haberse comprado", outletVehicles.comprarVehiculo("modelo_" + (cont + 1), cont + 1));
        }

        vehiculos = outletVehicles.darVehiculos();
        assertEquals("No deberan haber vehiculos", 0, vehiculos.size());

        // Prueba con el escenario 2
        setupEscenario2( );

        vehiculos = outletVehicles.darVehiculos();
        cantidad = vehiculos.size();

        assertTrue("El vehiculo debera haberse comprado", outletVehicles.comprarVehiculo("CLK430", 2003));

        assertTrue("El vehiculo debera haberse comprado", outletVehicles.comprarVehiculo("Explorer", 1999));

        assertTrue("El vehiculo debera haberse comprado", outletVehicles.comprarVehiculo("New Beetle", 2000));

        vehiculos = outletVehicles.darVehiculos();
        assertEquals("Los vehiculos no se compraron de forma correcta", cantidad - 3, vehiculos.size());

        assertTrue("El vehiculo debera haberse comprado", outletVehicles.buscarVehiculo("CLK430", 2003) == -1);

        assertTrue("El vehiculo debera haberse comprado", outletVehicles.buscarVehiculo("Explorer", 1999) == -1);

        assertTrue("El vehiculo debera haberse comprado", outletVehicles.buscarVehiculo("New Beetle", 2000) == -1);
    }

    /**
     * Verifica el mtodo para comprar un vehiculo<br>
     * <b> Mtodos a probar: </b> <br>
     * comprarVehiculo. <br>
     * <b> Objetivo: </b> Probar que el mtodo comprarVehiculo() no elimine un vehiculo que no exista en la venta <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comprar un vehiculo que no existe, la lista de vehiculos no debe cambiar su tamao.
     */
    public void testComprarVehiculo2( )
    {
        // Prueba con el escenario 1
        setupEscenario1( );

        ArrayList vehiculos = outletVehicles.darVehiculos();
        int cantidad = vehiculos.size();

        for( int cont = 0; cont < cantidad; cont++ )
        {
            assertFalse("El vehiculo no debera haberse comprado", outletVehicles.comprarVehiculo("modelo_" + (cont + 1), cont));
        }

        vehiculos = outletVehicles.darVehiculos();
        assertEquals("No deberan haber vehiculos", cantidad, vehiculos.size());

        // Prueba con el escenario 2
        setupEscenario2( );

        vehiculos = outletVehicles.darVehiculos();
        cantidad = vehiculos.size();

        assertTrue("El vehiculo debera haberse comprado", outletVehicles.comprarVehiculo("CLK430", 2003));

        assertFalse("El vehiculo no debera haberse comprado", outletVehicles.comprarVehiculo("CLK430", 2003));

        assertFalse("El vehiculo no debera haberse comprado", outletVehicles.comprarVehiculo("Explorer", 1990));

        assertFalse("El vehiculo debera haberse comprado", outletVehicles.comprarVehiculo("New Beetless", 2000));

        vehiculos = outletVehicles.darVehiculos();

        assertEquals( "Los vehiculos no se compraron de forma correcta", cantidad - 1, vehiculos.size( ) );
    }

    /**
     * Verifica el mtodo para disminuir el precio de los vehiculos<br>
     * <b> Mtodos a probar: </b> <br>
     * disminuirPrecio. <br>
     * <b> Objetivo: </b> Probar que el mtodo disminuirPrecio() disminuya correctamente el precio de los vehiculos <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que hay X vehiculos cuyo valor es mayor a Z. Al disminuir el valor de los vehiculos usando Z, se debe disminuir el valor de X vehiculos. <br>
     * 2. Se sabe que el valor de un vehiculo antes del descuento es Y. Al realizar el descuento el valor del vehiculo, si estuvo implicado en el descuento, debe ser Y*0.9
     */
    public void testDisminuirPrecio( )
    {
        // Prueba con el escenario 1
        setupEscenario1();

        Vehicle vehicle = (Vehicle)outletVehicles.darVehiculos().get(0);
        int valor = vehicle.getValue();
        assertEquals("No se disminuy el precio de forma correcta", 1, outletVehicles.disminuirPrecio(11500));

        vehicle = (Vehicle)outletVehicles.darVehiculos().get(0);
        int valorNuevo = vehicle.getValue();

        assertEquals("No se disminuy el precio de forma correcta", (int)(valor * 0.9), valorNuevo);

        assertEquals("No se disminuy el precio de forma correcta", 0, outletVehicles.disminuirPrecio(12000));

        // Prueba con el escenario 2
        setupEscenario2();

        vehicle = (Vehicle)outletVehicles.darVehiculos().get(0);
        valor = vehicle.getValue();

        vehicle = (Vehicle)outletVehicles.darVehiculos().get(6);
        int valor2 = vehicle.getValue();

        assertEquals("No se disminuy el precio de forma correcta", 2, outletVehicles.disminuirPrecio(89000000));

        vehicle = (Vehicle)outletVehicles.darVehiculos().get(0);
        valorNuevo = vehicle.getValue();

        vehicle = (Vehicle)outletVehicles.darVehiculos().get(6);
        int valorNuevo2 = vehicle.getValue();

        assertEquals("No se disminuy el precio de forma correcta", (int)(valor * 0.9), valorNuevo);

        assertEquals("No se disminuy el precio de forma correcta", (int)(valor2 * 0.9), valorNuevo2);

        assertEquals("No se disminuy el precio de forma correcta", 0, outletVehicles.disminuirPrecio(600000000));
    }

    // -----------------------------------------------------------------
    // Mtodos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Carga los vehiculos a partir de un archivo de propiedades.
     * @param archivo es el nombre del archivo de propiedades que contiene la informacin de los vehiculos
     */
    private void cargarVehiculos( String archivo )
    {
        try
        {
            FileInputStream fis = new FileInputStream( getFileFromResource( archivo ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            // Cargar los vehiculos
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
                // Carga un vehiculo
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

                // Slo se carga el vehiculo si los datos son correctos
                if( modelo != null && marca != null && imagen != null && tipo != null && anio > 0 && cilandraje > 0 && ejes > 0 && valor > 0 )
                    outletVehicles.agregarVehiculo(modelo, marca, imagen, tipo, anio, cilandraje, ejes, valor);
                fis.close( );
            }
        }
        catch( IOException e )
        {
            fail( "No se debio arrojar excepcion" );
        }
    }

    /**
     * Método utilizado para cargar archivos desde el directorio /resource, es decir,
     * la estructura de proyectos basados en Maven y Gradle.
     *
     * @param filename Nombre del archivo.
     * @return Referencia al archivo.
     */
    private File getFileFromResource( final String filename )
    {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource( filename );

        if (resource == null)
        {
            throw new IllegalArgumentException( "File is not found." );
        }
        else
        {
            return new File( resource.getFile() );
        }
    }

}
