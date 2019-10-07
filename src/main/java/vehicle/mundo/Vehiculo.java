package vehicle.mundo;

/**
 * Es la clase que representa a un vehiculo <br>
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
     * Indica que el vehiculo es un bus
     */
    public static final String BUS = "Bus";

    /**
     * Indica que el vehiculo es un automvil
     */
    public static final String AUTOMOVIL = "Automovil";

    /**
     * Indica que el vehiculo es una motocicleta
     */
    public static final String MOTOCICLETA = "Moto";

    /**
     * Indica que el vehiculo es un camin
     */
    public static final String CAMION = "Camion";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El modelo del vehiculo
     */
    private String modelo;

    /**
     * La marca del vehiculo
     */
    private String marca;

    /**
     * La ruta hasta la imagen del vehiculo
     */
    private String imagen;

    /**
     * El tipo de vehiculo
     */
    private String tipo;

    /**
     * El ao de puesta en venta del modelo
     */
    private int anio;

    /**
     * El cilindrada del vehiculo
     */
    private int cilindrada;

    /**
     * El nmero de Ejes
     */
    private int ejes;

    /**
     * El valor comercial del vehiculo
     */
    private int valor;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo vehiculo con los parmetros indicados
     * @param modeloV El nombre del modelo - modeloV != null
     * @param marcaV La marca del vehiculo - marcaV != null
     * @param imagenV La ruta a la imagen del vehiculo - imagenP != null
     * @param tipoV El tipo del vehiculo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El ao del vehiculo - anioV > 0
     * @param cilindradaV La cilindrada del vehiculo - cilindradaV > 0
     * @param ejesV El nmero de ejes del vehiculo - ejesV > 0
     * @param valorV El valor del vehiculo - valor > 0
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
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Retorna el modelo del vehiculo
     * @return modelo
     */
    public String darModelo( )
    {
        return modelo;
    }

    /**
     * Retorna la marca del vehiculo
     * @return marca
     */
    public String darMarca( )
    {
        return marca;
    }

    /**
     * Retorna la ruta a la imagen del vehiculo
     * @return imagen
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna el tipo del vehiculo
     * @return tipo
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el ao del vehiculo
     * @return anio
     */
    public int darAnio( )
    {
        return anio;
    }

    /**
     * Retorna la cilindrada del vehiculo
     * @return cilindrada
     */
    public int darCilindrada( )
    {
        return cilindrada;
    }

    /**
     * Retorna el nmero de ejes del vehiculo
     * @return ejes
     */
    public int darEjes( )
    {
        return ejes;
    }

    /**
     * Retorna el valor del vehiculo
     * @return valor
     */
    public int darValor( )
    {
        return valor;
    }

    /**
     * Compara dos vehiculos segn su cilindrada
     * @param v El vehiculo contra el que se est comparando - e!=null
     * @return Retorna 0 si los vehiculos tienen la misma cilindrada. <br>
     *         Retorna -1 si el vehiculo v tiene una valor "MAYOR" para la cilindrada. <br>
     *         Retorna 1 si el vehiculo v tiene una valor "MENOR" para la cilindrada. <br>
     */
    public int compararPorCilindrada( Vehiculo v )
    {
        return Integer.compare( cilindrada, v.darCilindrada( ) );
    }

    /**
     * Compara dos vehiculos segn su marca
     * @param v El vehiculo contra el que se est comparando - e!=null
     * @return Retorna 0 si los vehiculos tienen la misma marca. <br>
     *         Retorna -1 si el vehiculo v tiene una valor "MAYOR" para la marca. <br>
     *         Retorna 1 si el vehiculo v tiene una valor "MENOR" para la marca. <br>
     */
    public int compararPorMarca( Vehiculo v )
    {
        return marca.toLowerCase( ).compareTo( v.darMarca( ).toLowerCase( ) );
    }

    /**
     * Compara dos vehiculos segn su ao
     * @param v El vehiculo contra el que se est comparando - e!=null
     * @return Retorna 0 si los vehiculos son del mismo ao. <br>
     *         Retorna -1 si el vehiculo v es de un ao posterior. <br>
     *         Retorna 1 si el vehiculo v es de un ao anterior. <br>
     */
    public int compararPorAnio( Vehiculo v )
    {
        return Integer.compare( anio, v.darAnio( ) );
    }

    /**
     * Compara dos vehiculos segn su valor
     * @param v El vehiculo contra el que se est comparando - v!=null
     * @return Retorna 0 si los vehiculos tienen el mismo valor. <br>
     *         Retorna -1 si el vehiculo v tiene una valor "MAYOR" para el valor. <br>
     *         Retorna 1 si el vehiculo v tiene una valor "MENOR" para el valor. <br>
     */
    public int compararPorValor( Vehiculo v )
    {
        return Integer.compare( valor, v.darValor( ) );
    }

    /**
     * Cambia el valor del vehiculo
     * @param nValor Nuevo valor del vehiculo
     */
    public void cambiarValor( int nValor )
    {
        valor = nValor;
    }

    /**
     * Retorna una cadena con el nombre y la marca del vehiculo
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
        assert ( tipo.equals( BUS ) || tipo.equals( AUTOMOVIL ) || tipo.equals( MOTOCICLETA ) || tipo.equals( CAMION )  ) : "El tipo debe ser uno de los valores vlidos";
        assert ( anio > 0 ) : "El ao no puede ser 0";
        assert ( imagen != null ) : "La imagen no puede ser null";
        assert ( modelo != null ) : "El modelo no puede ser null";
        assert ( marca != null ) : "La marca no puede ser null";
        assert ( cilindrada > 0 ) : "La cilindrada no puede ser 0";
        assert ( ejes > 1 ) : "El nmero de ejes debe ser mayor a 1";
        assert ( valor > 0 ) : "El vehiculo debe tener un valor mayor a 0";
    }
}