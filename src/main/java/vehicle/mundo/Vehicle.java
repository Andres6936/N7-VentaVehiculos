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
public final class Vehicle
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
    private final String modelo;

    /**
     * La marca del vehiculo
     */
    private final String trademark;

    /**
     * La ruta hasta la imagen del vehiculo
     */
    private final String imagen;

    /**
     * El tipo de vehiculo
     */
    private final TypeVehicle tipo;

    /**
     * El ao de puesta en venta del modelo
     */
    private final int year;

    /**
     * El cilindrada del vehiculo
     */
    private final int displacement;

    /**
     * El nmero de Ejes
     */
    private final int ejes;

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
    public Vehicle(String modeloV, String marcaV, String imagenV, TypeVehicle tipoV, int anioV, int cilindradaV, int ejesV, int valorV)
    {
        modelo = modeloV;
        trademark = marcaV;
        imagen = imagenV;
        tipo = tipoV;
        year = anioV;
        displacement = cilindradaV;
        ejes = ejesV;
        valor = valorV;

        verifyInvariant();
    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Retorna el modelo del vehiculo
     *
     * @return modelo
     */
    public String getModelo()
    {
        return modelo;
    }

    /**
     * Retorna la marca del vehiculo
     * @return marca
     */
    public String getTrademark( )
    {
        return trademark;
    }

    /**
     * Retorna la ruta a la imagen del vehiculo
     *
     * @return imagen
     */
    public String getImagen()
    {
        return imagen;
    }

    /**
     * Retorna el tipo del vehiculo
     *
     * @return tipo
     */
    public TypeVehicle getTipo()
    {
        return tipo;
    }

    /**
     * Retorna el ao del vehiculo
     * @return anio
     */
    public int getYear( )
    {
        return year;
    }

    /**
     * Retorna la cilindrada del vehiculo
     * @return cilindrada
     */
    public int getDisplacement( )
    {
        return displacement;
    }

    /**
     * Retorna el nmero de ejes del vehiculo
     *
     * @return ejes
     */
    public int getEjes()
    {
        return ejes;
    }

    /**
     * Retorna el valor del vehiculo
     * @return valor
     */
    public int getValue( )
    {
        return valor;
    }

    /**
     * Cambia el valor del vehiculo.
     * Precondition: The new value must be greater to 0.
     *
     * @param nValor Nuevo valor del vehiculo.
     */
    void setValue( final int nValor )
    {
        valor = nValor;
    }

    /**
     * Compara dos vehiculos segn su cilindrada
     *
     * @param v El vehiculo contra el que se est comparando - e!=null
     * @return Retorna 0 si los vehiculos tienen la misma cilindrada. <br>
     * Retorna -1 si el vehiculo v tiene una valor "MAYOR" para la cilindrada. <br>
     * Retorna 1 si el vehiculo v tiene una valor "MENOR" para la cilindrada. <br>
     */
    public int compareDisplacement(final Vehicle v)
    {
        return Integer.compare(displacement, v.getDisplacement());
    }

    /**
     * Compara dos vehiculos segn su marca
     *
     * @param v El vehiculo contra el que se est comparando - e!=null
     * @return Retorna 0 si los vehiculos tienen la misma marca. <br>
     * Retorna -1 si el vehiculo v tiene una valor "MAYOR" para la marca. <br>
     * Retorna 1 si el vehiculo v tiene una valor "MENOR" para la marca. <br>
     */
    public int compareTrademark(final Vehicle v)
    {
        return trademark.toLowerCase().compareTo(v.getTrademark().toLowerCase( ) );
    }

    /**
     * Compara dos vehiculos segn su ao
     *
     * @param v El vehiculo contra el que se est comparando - e!=null
     * @return Retorna 0 si los vehiculos son del mismo ao. <br>
     * Retorna -1 si el vehiculo v es de un ao posterior. <br>
     * Retorna 1 si el vehiculo v es de un ao anterior. <br>
     */
    public int compareYear(final Vehicle v)
    {
        return Integer.compare(year, v.getYear() );
    }

    /**
     * Compara dos vehiculos segn su valor
     *
     * @param v El vehiculo contra el que se est comparando - v!=null
     * @return Retorna 0 si los vehiculos tienen el mismo valor. <br>
     * Retorna -1 si el vehiculo v tiene una valor "MAYOR" para el valor. <br>
     * Retorna 1 si el vehiculo v tiene una valor "MENOR" para el valor. <br>
     */
    public int compareValue(final Vehicle v)
    {
        return Integer.compare(valor, v.getValue());
    }

    /**
     * Retorna una cadena con el nombre y la marca del vehiculo
     * @return <marca> <modelo> (<anio>);
     */
    public String toString( )
    {
        return trademark + " " + modelo + " (" + year + ")";
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
    private void verifyInvariant()
    {
        assert (tipo.equals(BUS) || tipo.equals(AUTOMOVIL) || tipo.equals(MOTOCICLETA) || tipo.equals(CAMION)) : "El tipo debe ser uno de los valores vlidos";
        assert (year > 0) : "El ao no puede ser 0";
        assert (imagen != null) : "La imagen no puede ser null";
        assert (modelo != null) : "El modelo no puede ser null";
        assert (trademark != null) : "La marca no puede ser null";
        assert (displacement > 0) : "La cilindrada no puede ser 0";
        assert (ejes > 1) : "El nmero de ejes debe ser mayor a 1";
        assert (valor > 0) : "El vehiculo debe tener un valor mayor a 0";
    }
}