/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Vehiculo.java,v 1.5 2007/04/10 22:56:32 carl-veg Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario S�nchez - 06/12/2005 
 * Autor: Daniel Romero - 17-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.ventaVehiculos.mundo;

/**
 * Es la clase que representa a un veh�culo <br>
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
     * Indica que el veh�culo es un bus
     */
    public static final String BUS = "Bus";

    /**
     * Indica que el veh�culo es un autom�vil
     */
    public static final String AUTOMOVIL = "Autom�vil";

    /**
     * Indica que el veh�culo es una motocicleta
     */
    public static final String MOTOCICLETA = "Moto";

    /**
     * Indica que el veh�culo es un cami�n
     */
    public static final String CAMION = "Cami�n";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El modelo del veh�culo
     */
    private String modelo;

    /**
     * La marca del veh�culo
     */
    private String marca;

    /**
     * La ruta hasta la imagen del veh�culo
     */
    private String imagen;

    /**
     * El tipo de veh�culo
     */
    private String tipo;

    /**
     * El a�o de puesta en venta del modelo
     */
    private int anio;

    /**
     * El cilindrada del veh�culo
     */
    private int cilindrada;

    /**
     * El n�mero de Ejes
     */
    private int ejes;

    /**
     * El valor comercial del veh�culo
     */
    private int valor;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo veh�culo con los par�metros indicados
     * @param modeloV El nombre del modelo - modeloV != null
     * @param marcaV La marca del veh�culo - marcaV != null
     * @param imagenV La ruta a la imagen del veh�culo - imagenP != null
     * @param tipoV El tipo del veh�culo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El a�o del veh�culo - anioV > 0
     * @param cilindradaV La cilindrada del veh�culo - cilindradaV > 0
     * @param ejesV El n�mero de ejes del veh�culo - ejesV > 0
     * @param valorV El valor del veh�culo - valor > 0
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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el modelo del veh�culo
     * @return modelo
     */
    public String darModelo( )
    {
        return modelo;
    }

    /**
     * Retorna la marca del veh�culo
     * @return marca
     */
    public String darMarca( )
    {
        return marca;
    }

    /**
     * Retorna la ruta a la imagen del veh�culo
     * @return imagen
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna el tipo del veh�culo
     * @return tipo
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el a�o del veh�culo
     * @return anio
     */
    public int darAnio( )
    {
        return anio;
    }

    /**
     * Retorna la cilindrada del veh�culo
     * @return cilindrada
     */
    public int darCilindrada( )
    {
        return cilindrada;
    }

    /**
     * Retorna el n�mero de ejes del veh�culo
     * @return ejes
     */
    public int darEjes( )
    {
        return ejes;
    }

    /**
     * Retorna el valor del veh�culo
     * @return valor
     */
    public int darValor( )
    {
        return valor;
    }

    /**
     * Compara dos veh�culos seg�n su cilindrada
     * @param v El veh�culo contra el que se est� comparando - e!=null
     * @return Retorna 0 si los veh�culos tienen la misma cilindrada. <br>
     *         Retorna -1 si el veh�culo v tiene una valor "MAYOR" para la cilindrada. <br>
     *         Retorna 1 si el veh�culo v tiene una valor "MENOR" para la cilindrada. <br>
     */
    public int compararPorCilindrada( Vehiculo v )
    {
        int resultado = ( cilindrada == v.darCilindrada( ) ) ? 0 : ( ( cilindrada > v.darCilindrada( ) ) ? 1 : -1 );
        return resultado;
    }

    /**
     * Compara dos veh�culos seg�n su marca
     * @param v El veh�culo contra el que se est� comparando - e!=null
     * @return Retorna 0 si los veh�culos tienen la misma marca. <br>
     *         Retorna -1 si el veh�culo v tiene una valor "MAYOR" para la marca. <br>
     *         Retorna 1 si el veh�culo v tiene una valor "MENOR" para la marca. <br>
     */
    public int compararPorMarca( Vehiculo v )
    {
        return marca.toLowerCase( ).compareTo( v.darMarca( ).toLowerCase( ) );
    }

    /**
     * Compara dos veh�culos seg�n su a�o
     * @param v El veh�culo contra el que se est� comparando - e!=null
     * @return Retorna 0 si los veh�culos son del mismo a�o. <br>
     *         Retorna -1 si el veh�culo v es de un a�o posterior. <br>
     *         Retorna 1 si el veh�culo v es de un a�o anterior. <br>
     */
    public int compararPorAnio( Vehiculo v )
    {
        int resultado = ( anio == v.darAnio( ) ) ? 0 : ( ( anio > v.darAnio( ) ) ? 1 : -1 );
        return resultado;
    }

    /**
     * Compara dos veh�culos seg�n su valor
     * @param v El veh�culo contra el que se est� comparando - v!=null
     * @return Retorna 0 si los veh�culos tienen el mismo valor. <br>
     *         Retorna -1 si el veh�culo v tiene una valor "MAYOR" para el valor. <br>
     *         Retorna 1 si el veh�culo v tiene una valor "MENOR" para el valor. <br>
     */
    public int compararPorValor( Vehiculo v )
    {
        int resultado = ( valor == v.darValor( ) ) ? 0 : ( ( valor > v.darValor( ) ) ? 1 : -1 );
        return resultado;
    }

    /**
     * Cambia el valor del veh�culo
     * @param nValor Nuevo valor del veh�culo
     */
    public void cambiarValor( int nValor )
    {
        valor = nValor;
    }

    /**
     * Retorna una cadena con el nombre y la marca del veh�culo
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
        assert ( tipo.equals( BUS ) || tipo.equals( AUTOMOVIL ) || tipo.equals( MOTOCICLETA ) || tipo.equals( CAMION )  ) : "El tipo debe ser uno de los valores v�lidos";
        assert ( anio > 0 ) : "El a�o no puede ser 0";
        assert ( imagen != null ) : "La imagen no puede ser null";
        assert ( modelo != null ) : "El modelo no puede ser null";
        assert ( marca != null ) : "La marca no puede ser null";
        assert ( cilindrada > 0 ) : "La cilindrada no puede ser 0";
        assert ( ejes > 1 ) : "El n�mero de ejes debe ser mayor a 1";
        assert ( valor > 0 ) : "El veh�culo debe tener un valor mayor a 0";
    }
}