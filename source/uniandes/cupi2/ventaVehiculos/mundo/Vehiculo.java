/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Vehiculo.java,v 1.5 2007/04/10 22:56:32 carl-veg Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario Sánchez - 06/12/2005 
 * Autor: Daniel Romero - 17-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.ventaVehiculos.mundo;

/**
 * Es la clase que representa a un vehículo <br>
 * <b>inv: </b> <br>
 * modelo != null <br>
 * imagen != null <br>
 * marca != null <br>
 * anio > 0 <br>
 * tipo es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION} <br>
 * cilindrada > 0 <br>
 * ejes > 1 <br>
 * valor>0
 */
public class Vehiculo
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indica que el vehículo es un bus
     */
    public static final String BUS = "Bus";

    /**
     * Indica que el vehículo es un automóvil
     */
    public static final String AUTOMOVIL = "Automóvil";

    /**
     * Indica que el vehículo es una motocicleta
     */
    public static final String MOTOCICLETA = "Moto";

    /**
     * Indica que el vehículo es un camión
     */
    public static final String CAMION = "Camión";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El modelo del vehículo
     */
    private String modelo;

    /**
     * La marca del vehículo
     */
    private String marca;

    /**
     * La ruta hasta la imagen del vehículo
     */
    private String imagen;

    /**
     * El tipo de vehículo
     */
    private String tipo;

    /**
     * El año de puesta en venta del modelo
     */
    private int anio;

    /**
     * El cilindrada del vehículo
     */
    private int cilindrada;

    /**
     * El número de Ejes
     */
    private int ejes;

    /**
     * El valor comercial del vehículo
     */
    private int valor;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo vehículo con los parámetros indicados
     * @param modeloV El nombre del modelo - modeloV != null
     * @param marcaV La marca del vehículo - marcaV != null
     * @param imagenV La ruta a la imagen del vehículo - imagenP != null
     * @param tipoV El tipo del vehículo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El año del vehículo - anioV > 0
     * @param cilindradaV La cilindrada del vehículo - cilindradaV > 0
     * @param ejesV El número de ejes del vehículo - ejesV > 0
     * @param valorV El valor del vehículo - valor > 0
     */
    public Vehiculo( String modeloV, String marcaV, String imagenV, String tipoV, int anioV, int cilindradaV, int ejesV, int valorV )
    {
        modelo = modeloV;
        marca = marcaV;
        imagen = imagenV;
        tipo = tipoV;
        anio = anioV;
        cilindrada = cilindradaV;
        ejes = ejesV;
        valor = valorV;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el modelo del vehículo
     * @return modelo
     */
    public String darModelo( )
    {
        return modelo;
    }

    /**
     * Retorna la marca del vehículo
     * @return marca
     */
    public String darMarca( )
    {
        return marca;
    }

    /**
     * Retorna la ruta a la imagen del vehículo
     * @return imagen
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna el tipo del vehículo
     * @return tipo
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el año del vehículo
     * @return anio
     */
    public int darAnio( )
    {
        return anio;
    }

    /**
     * Retorna la cilindrada del vehículo
     * @return cilindrada
     */
    public int darCilindrada( )
    {
        return cilindrada;
    }

    /**
     * Retorna el número de ejes del vehículo
     * @return ejes
     */
    public int darEjes( )
    {
        return ejes;
    }

    /**
     * Retorna el valor del vehículo
     * @return valor
     */
    public int darValor( )
    {
        return valor;
    }

    /**
     * Compara dos vehículos según su cilindrada
     * @param v El vehículo contra el que se está comparando - e!=null
     * @return Retorna 0 si los vehículos tienen la misma cilindrada. <br>
     *         Retorna -1 si el vehículo v tiene una valor "MAYOR" para la cilindrada. <br>
     *         Retorna 1 si el vehículo v tiene una valor "MENOR" para la cilindrada. <br>
     */
    public int compararPorCilindrada( Vehiculo v )
    {
        int resultado = ( cilindrada == v.darCilindrada( ) ) ? 0 : ( ( cilindrada > v.darCilindrada( ) ) ? 1 : -1 );
        return resultado;
    }

    /**
     * Compara dos vehículos según su marca
     * @param v El vehículo contra el que se está comparando - e!=null
     * @return Retorna 0 si los vehículos tienen la misma marca. <br>
     *         Retorna -1 si el vehículo v tiene una valor "MAYOR" para la marca. <br>
     *         Retorna 1 si el vehículo v tiene una valor "MENOR" para la marca. <br>
     */
    public int compararPorMarca( Vehiculo v )
    {
        return marca.toLowerCase( ).compareTo( v.darMarca( ).toLowerCase( ) );
    }

    /**
     * Compara dos vehículos según su año
     * @param v El vehículo contra el que se está comparando - e!=null
     * @return Retorna 0 si los vehículos son del mismo año. <br>
     *         Retorna -1 si el vehículo v es de un año posterior. <br>
     *         Retorna 1 si el vehículo v es de un año anterior. <br>
     */
    public int compararPorAnio( Vehiculo v )
    {
        int resultado = ( anio == v.darAnio( ) ) ? 0 : ( ( anio > v.darAnio( ) ) ? 1 : -1 );
        return resultado;
    }

    /**
     * Compara dos vehículos según su valor
     * @param v El vehículo contra el que se está comparando - v!=null
     * @return Retorna 0 si los vehículos tienen el mismo valor. <br>
     *         Retorna -1 si el vehículo v tiene una valor "MAYOR" para el valor. <br>
     *         Retorna 1 si el vehículo v tiene una valor "MENOR" para el valor. <br>
     */
    public int compararPorValor( Vehiculo v )
    {
        int resultado = ( valor == v.darValor( ) ) ? 0 : ( ( valor > v.darValor( ) ) ? 1 : -1 );
        return resultado;
    }

    /**
     * Cambia el valor del vehículo
     * @param nValor Nuevo valor del vehículo
     */
    public void cambiarValor( int nValor )
    {
        valor = nValor;
    }

    /**
     * Retorna una cadena con el nombre y la marca del vehículo
     * @return <marca> <modelo> (<anio>);
     */
    public String toString( )
    {
        return marca + " " + modelo + " (" + anio + ")";
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica el invariante de la clase <br>
     * <b>inv: </b> <br>
     * modelo != null <br>
     * imagen != null <br>
     * marca != null <br>
     * anio > 0 <br>
     * tipo es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION} <br>
     * cilindrada > 0 <br>
     * ejes > 1 <br>
     * valor > 0
     */
    private void verificarInvariante( )
    {
        assert ( tipo.equals( BUS ) || tipo.equals( AUTOMOVIL ) || tipo.equals( MOTOCICLETA ) || tipo.equals( CAMION )  ) : "El tipo debe ser uno de los valores válidos";
        assert ( anio > 0 ) : "El año no puede ser 0";
        assert ( imagen != null ) : "La imagen no puede ser null";
        assert ( modelo != null ) : "El modelo no puede ser null";
        assert ( marca != null ) : "La marca no puede ser null";
        assert ( cilindrada > 0 ) : "La cilindrada no puede ser 0";
        assert ( ejes > 1 ) : "El número de ejes debe ser mayor a 1";
        assert ( valor > 0 ) : "El vehículo debe tener un valor mayor a 0";
    }
}