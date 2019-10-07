package vehicle.mundo;

import java.util.ArrayList;

/**
 * Es la clase que se encarga de manejar, organizar, cargar y salvar los vehiculos <br>
 * <b>inv </b> <br>
 * vehiculos != null y no hay dos vehiculos con el mismo nombre
 */
public class VentaVehiculos
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los vehiculos
     */
    private ArrayList< Vehiculo > vehiculos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo manejador de vehiculos vaco.
     */
    public VentaVehiculos( )
    {
        vehiculos = new ArrayList<>( );

    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de vehiculos.
     * La lista que se retorna no es la misma que la almacenada en esta clase,
     * pero si tiene el mismo orden.
     * @return lista de vehiculos
     */
    public ArrayList darVehiculos( )
    {
        return new ArrayList<>( vehiculos );
    }

    /**
     * Organiza la lista de vehiculos por marca usando el algoritmo de burbuja <br>
     * <b>post: </b>La lista de vehiculos est ordenada por marca
     */
    public void ordenarPorMarca( )
    {
        for ( int inicial = 0; inicial < vehiculos.size( ); inicial++ )
        {
            for( int i = vehiculos.size( ) - 1; i > inicial; i-- )
            {
                Vehiculo p2 = vehiculos.get( i );
                Vehiculo p1 = vehiculos.get( i - 1 );

                if( p1.compararPorMarca( p2 ) > 0 )
                {
                    vehiculos.set( i, p1 );
                    vehiculos.set( i - 1, p2 );
                }
            }
        }
        verificarInvariante( );
    }

    /**
     * Organiza la lista de vehiculos por cilindrada usando el algoritmo de insercin <br>
     * <b>post: </b>La lista de vehiculos est ordenada por cilindrada
     */
    public void ordenarPorCilindrada( )
    {
        // En cada paso se sabe que:
        // 1. Las posiciones antes de vehiculos[inicial] estn ordenadas
        // En cada paso lo que se hace es encontrar en qu posicin entre vehiculos[0] y vehiculos[inicial] debera
        // estar el vehiculo que en este momento se encuentra en vehiculos[inicial]

        for ( int inicial = 1; inicial < vehiculos.size( ); inicial++ )
        {
            Vehiculo insertado = vehiculos.get( inicial );

            boolean termine = false;
            int i = inicial - 1;

            while( !termine )
            {
                // Si encuentra una cilindrada mayor, entonces hay que intercambiarlos
                Vehiculo vehiculoPosicion = vehiculos.get( i );

                if( vehiculoPosicion.compararPorCilindrada( insertado ) > 0 )
                {
                    vehiculos.set( i, insertado );
                    vehiculos.set( i + 1, vehiculoPosicion );
                    i--;
                }
                // Si se encuentra un cilindrada igual o menor entonces ya se encontr la posicin
                else
                {
                    termine = true;
                }

                // Si ya se lleg al principio de la lista no hay nada mas que hacer
                if( i < 0 )
                {
                    termine = true;
                }
            }
        }
        verificarInvariante( );
    }

    /**
     * Organiza la lista de vehiculos por el ao usando el algoritmo de seleccin <br>
     * <b>post: </b>La lista de vehiculos est ordenada por ao
     */
    public void ordenarPorAnio( )
    {
        // En cada paso se sabe que:
        // 1. Todos los valores antes de vehiculos[inicial] estn ordenados
        // 2. No hay ningn valor despus de vehiculos[inicial-1] que sea menor que vehiculos[inicial-1]
        // En cada paso se busca el menor entre vehiculos[inicial] y vehiculos[final] y se ubica en vehiculos[inicial]

        for ( int inicial = 0; inicial < vehiculos.size( ); inicial++ )
        {
            int posicionMenor = inicial;
            Vehiculo vehiculoMenor = vehiculos.get( inicial );

            for( int i = inicial + 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo vehiculoPosicion = vehiculos.get( i );

                // El vehiculo de la posicin actual es menor que el menor encontrado hasta el momento
                if( vehiculoPosicion.compararPorAnio( vehiculoMenor ) < 0 )
                {
                    vehiculoMenor = vehiculoPosicion;
                    posicionMenor = i;
                }
            }

            if( posicionMenor != inicial )
            {
                Vehiculo temp = vehiculos.get( inicial );
                vehiculos.set( inicial, vehiculoMenor );
                vehiculos.set( posicionMenor, temp );
            }

        }
        verificarInvariante( );
    }

    /**
     * Busca un vehiculo segn su modelo y retorna la posicin en la que se encuentra. <br>
     * @param modelo El modelo del vehiculo buscado - modelo != null
     * @param anio El ao del vehiculo buscado - anio > 0
     * @return Retorna la posicin donde se encuentra un vehiculo con el modelo y el ao dado. Si no se encuentra ningn vehiculo con ese modelo y ao retorna -1.
     */
    public int buscarVehiculo( String modelo, int anio )
    {
        int posicion = -1;
        boolean termine = false;

        for( int i = 0; i < vehiculos.size( ) && !termine; i++ )
        {
            Vehiculo vehiculoPosicion = vehiculos.get( i );
            String modeloVehiculo = vehiculoPosicion.darModelo( );

            // Los modelos son iguales
            if( modeloVehiculo.equals( modelo ) && vehiculoPosicion.darAnio( ) == anio )
            {
                posicion = i;
                termine = true;
            }
        }

        return posicion;
    }

    /**
     * Agrega un nuevo vehiculo
     * @param modeloV El modelo del vehiculo - modeloV != null
     * @param marcaV La marca del vehiculo - marcaV != null
     * @param imagenP La ruta a la imagen del vehiculo - imagenP != null
     * @param tipoV El tipo de vehiculo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El ao del vehiculo - anioV > 0
     * @param cilindradaV La cilindrada del vehiculo - cilindradaV > 0
     * @param ejesV El nmero de ejes del vehiculo - ejesV > 0
     * @param valor El valor del vehiculo - valor > 0
     * @return Se retorn true si el vehiculo fue agregado o false en caso de que ya existiera un vehiculo con el mismo modelo y ao
     */
    public boolean agregarVehiculo( String modeloV, String marcaV, String imagenP, String tipoV, int anioV, int cilindradaV, int ejesV, int valor )
    {
        boolean agregado = false;
        int vehiculoBuscado = buscarVehiculo( modeloV, anioV );
        if( vehiculoBuscado == -1 )
        {
            Vehiculo nuevovehiculo = new Vehiculo( modeloV, marcaV, imagenP, tipoV, anioV, cilindradaV, ejesV, valor );
            vehiculos.add( nuevovehiculo );
            agregado = true;
            verificarInvariante( );
        }

        return agregado;

    }

    /**
     * Elimina de la lista el vehiculo especificado
     * @param modelo Modelo del vehiculo - modelo!=null
     * @param anio Ao del vehiculo - anio>0
     * @return Se retorn true si el vehiculo fue comprado o false en caso contrario
     */
    public boolean comprarVehiculo( String modelo, int anio )
    {
        boolean comprado = false;

        for( int cont = 0; cont < vehiculos.size( ) && !comprado; cont++ )
        {
            Vehiculo v = vehiculos.get( cont );

            if( v.darAnio( ) == anio && v.darModelo( ).equalsIgnoreCase( modelo ) )
            {
                vehiculos.remove( cont );
                comprado = true;
            }
        }

        return comprado;
    }

    /**
     * Busca el vehiculo mas antiguo de todos
     * @return Se retorn la posicin donde se encuentra el vehiculo mas antiguo. Si no hay vehiculos a la venta se retorn -1
     */
    public int buscarVehiculoMasAntiguo( )
    {
        int posicion = -1;

        if( vehiculos.size( ) > 0 )
        {
            Vehiculo vMasAntiguo = vehiculos.get( 0 );
            posicion = 0;
            for( int i = 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo vPosicion = vehiculos.get( i );

                if( vMasAntiguo.compararPorAnio( vPosicion ) == 1 )
                {
                    posicion = i;
                    vMasAntiguo = vPosicion;
                }
            }
        }
        return posicion;
    }

    /**
     * Busca el vehiculo mas econmico de todos
     * @return Se retorn la posicin donde se encuentra el vehiculo mas econmico. Si no hay vehiculos a la venta se retorn -1
     */
    public int buscarVehiculoMasEconomico( )
    {
        int posicion = -1;

        if( vehiculos.size( ) > 0 )
        {
            Vehiculo vMasEconomico = vehiculos.get( 0 );
            posicion = 0;
            for( int i = 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo vPosicion = vehiculos.get( i );

                if( vMasEconomico.compararPorValor( vPosicion ) == 1 )
                {
                    posicion = i;
                    vMasEconomico = vPosicion;
                }
            }
        }
        return posicion;
    }

    /**
     * Busca el vehiculo mas potente (con mayor cilindrada) de todos
     * @return Se retorn la posicin donde se encuentra el vehiculo mas nuevo. Si no hay vehiculos a la venta se retorn -1
     */
    public int buscarVehiculoMasPotente( )
    {
        int posicion = -1;

        if( vehiculos.size( ) > 0 )
        {
            Vehiculo vMasPotente = vehiculos.get( 0 );
            posicion = 0;
            for( int i = 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo vPosicion = vehiculos.get( i );

                if( vMasPotente.compararPorCilindrada( vPosicion ) == -1 )
                {
                    posicion = i;
                    vMasPotente = vPosicion;
                }
            }
        }
        return posicion;
    }

    /**
     * Disminuye en un 10% el precio de todos los vehiculos cuyo precio es mayor al valor especificado. <br>
     * El precio de un vehiculo slo se disminuye si su valor no queda en cero.
     * @param valor El valor para realizar la disminucin de precios. valor>0
     * @return La cantidad de vehiculos a los que se les disminuy el precio
     */
    public int disminuirPrecio( int valor )
    {
        int disminuidos = 0;

        for ( Vehiculo v : vehiculos )
        {
            if ( v.getValue( ) > valor )
            {
                int nValor = ( int ) ( v.getValue( ) * 0.9 );

                if ( nValor > 0 )
                {
                    v.setValue( nValor );
                    disminuidos++;
                }
            }
        }
        return disminuidos;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica el invariante de la clase
     * 
     */
    private void verificarInvariante( )
    {
        assert ( vehiculos != null ) : "La lista de vehiculos no debe ser null";
        assert ( !buscarVehiculosModeloYAnioRepetido( ) ) : "Hay dos vehiculos del mismo modelo y ao";
    }

    /**
     * Verifica si hay dos vehiculos con el mismo modelo y el mismo ao
     * @return Retorna true si hay dos vehiculos con el mismo nombre y ao; retorna false en caso contrario.
     */
    private boolean buscarVehiculosModeloYAnioRepetido( )
    {
        for( int i = 0; i < vehiculos.size( ); i++ )
        {
            Vehiculo pi = vehiculos.get( i );
            for( int j = 0; j < vehiculos.size( ); j++ )
            {
                if( i != j )
                {
                    Vehiculo pj = vehiculos.get( j );
                    if( pj.darModelo( ).equals( pi.darModelo( ) ) && pj.darAnio( ) == pi.darAnio( ) )
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensin
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensin 1
     * @return respuesta 1
     */
    public String metodo1( )
    {
        return "respuesta1";
    }

    /**
     * Ejecuta el punto de extensin 2
     * @return respuesta 2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }
}