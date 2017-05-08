/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: VentaVehiculos.java,v 1.8 2007/04/05 00:55:53 carl-veg Exp $ 
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

import java.util.ArrayList;

/**
 * Es la clase que se encarga de manejar, organizar, cargar y salvar los vehículos <br>
 * <b>inv </b> <br>
 * vehículos != null y no hay dos vehículos con el mismo nombre
 */
public class VentaVehiculos
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los vehículos
     */
    private ArrayList vehiculos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo manejador de vehículos vacío.
     */
    public VentaVehiculos( )
    {
        vehiculos = new ArrayList( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de vehículos. La lista que se retorna no es la misma que la almacenada en esta clase, <br>
     * pero si tiene el mismo orden.
     * @return lista de vehículos
     */
    public ArrayList darVehiculos( )
    {
        ArrayList copiaLista = new ArrayList( vehiculos );
        return copiaLista;
    }

    /**
     * Organiza la lista de vehículos por marca usando el algoritmo de burbuja <br>
     * <b>post: </b>La lista de vehículos está ordenada por marca
     */
    public void ordenarPorMarca( )
    {
        int inicial;

        for( inicial = 0; inicial < vehiculos.size( ); inicial++ )
        {
            for( int i = vehiculos.size( ) - 1; i > inicial; i-- )
            {
                Vehiculo p2 = ( Vehiculo )vehiculos.get( i );
                Vehiculo p1 = ( Vehiculo )vehiculos.get( i - 1 );

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
     * Organiza la lista de vehículos por cilindrada usando el algoritmo de inserción <br>
     * <b>post: </b>La lista de vehículos está ordenada por cilindrada
     */
    public void ordenarPorCilindrada( )
    {
        int inicial;

        // En cada paso se sabe que:
        // 1. Las posiciones antes de vehículos[inicial] están ordenadas
        // En cada paso lo que se hace es encontrar en qué posición entre vehículos[0] y vehículos[inicial] debería
        // estar el vehículo que en este momento se encuentra en vehículos[inicial]

        for( inicial = 1; inicial < vehiculos.size( ); inicial++ )
        {
            Vehiculo insertado = ( Vehiculo )vehiculos.get( inicial );

            boolean termine = false;
            int i = inicial - 1;

            while( !termine )
            {
                // Si encuentra una cilindrada mayor, entonces hay que intercambiarlos
                Vehiculo vehículoPosicion = ( Vehiculo )vehiculos.get( i );

                if( vehículoPosicion.compararPorCilindrada( insertado ) > 0 )
                {
                    vehiculos.set( i, insertado );
                    vehiculos.set( i + 1, vehículoPosicion );
                    i--;
                }
                // Si se encuentra un cilindrada igual o menor entonces ya se encontró la posición
                else
                {
                    termine = true;
                }

                // Si ya se llegó al principio de la lista no hay nada más que hacer
                if( i < 0 )
                {
                    termine = true;
                }
            }
        }
        verificarInvariante( );
    }

    /**
     * Organiza la lista de vehículos por el año usando el algoritmo de selección <br>
     * <b>post: </b>La lista de vehículos está ordenada por año
     */
    public void ordenarPorAnio( )
    {
        int inicial;

        // En cada paso se sabe que:
        // 1. Todos los valores antes de vehículos[inicial] están ordenados
        // 2. No hay ningún valor después de vehículos[inicial-1] que sea menor que vehículos[inicial-1]
        // En cada paso se busca el menor entre vehículos[inicial] y vehículos[final] y se ubica en vehículos[inicial]

        for( inicial = 0; inicial < vehiculos.size( ); inicial++ )
        {
            int posicionMenor = inicial;
            Vehiculo vehículoMenor = ( Vehiculo )vehiculos.get( inicial );

            for( int i = inicial + 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo vehículoPosicion = ( Vehiculo )vehiculos.get( i );

                // El vehículo de la posición actual es menor que el menor encontrado hasta el momento
                if( vehículoPosicion.compararPorAnio( vehículoMenor ) < 0 )
                {
                    vehículoMenor = vehículoPosicion;
                    posicionMenor = i;
                }
            }

            if( posicionMenor != inicial )
            {
                Vehiculo temp = ( Vehiculo )vehiculos.get( inicial );
                vehiculos.set( inicial, vehículoMenor );
                vehiculos.set( posicionMenor, temp );
            }

        }
        verificarInvariante( );
    }

    /**
     * Busca un vehículo según su modelo y retorna la posición en la que se encuentra. <br>
     * @param modelo El modelo del vehículo buscado - modelo != null
     * @param anio El año del vehículo buscado - anio > 0
     * @return Retorna la posición donde se encuentra un vehículo con el modelo y el año dado. Si no se encuentra ningún vehículo con ese modelo y año retorna -1.
     */
    public int buscarVehiculo( String modelo, int anio )
    {
        int posicion = -1;
        boolean termine = false;

        for( int i = 0; i < vehiculos.size( ) && !termine; i++ )
        {
            Vehiculo vehiculoPosicion = ( Vehiculo )vehiculos.get( i );
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
     * Agrega un nuevo vehículo
     * @param modeloV El modelo del vehículo - modeloV != null
     * @param marcaV La marca del vehículo - marcaV != null
     * @param imagenP La ruta a la imagen del vehículo - imagenP != null
     * @param tipoV El tipo de vehículo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El año del vehículo - anioV > 0
     * @param cilindradaV La cilindrada del vehículo - cilindradaV > 0
     * @param ejesV El número de ejes del vehículo - ejesV > 0
     * @param valor El valor del vehículo - valor > 0
     * @return Se retornó true si el vehículo fue agregado o false en caso de que ya existiera un vehículo con el mismo modelo y año
     */
    public boolean agregarVehiculo( String modeloV, String marcaV, String imagenP, String tipoV, int anioV, int cilindradaV, int ejesV, int valor )
    {
        boolean agregado = false;
        int vehículoBuscado = buscarVehiculo( modeloV, anioV );
        if( vehículoBuscado == -1 )
        {
            Vehiculo nuevovehículo = new Vehiculo( modeloV, marcaV, imagenP, tipoV, anioV, cilindradaV, ejesV, valor );
            vehiculos.add( nuevovehículo );
            agregado = true;
            verificarInvariante( );
        }

        return agregado;

    }

    /**
     * Elimina de la lista el vehículo especificado
     * @param modelo Modelo del vehículo - modelo!=null
     * @param anio Año del vehículo - anio>0
     * @return Se retornó true si el vehículo fue comprado o false en caso contrario
     */
    public boolean comprarVehiculo( String modelo, int anio )
    {
        boolean comprado = false;

        for( int cont = 0; cont < vehiculos.size( ) && !comprado; cont++ )
        {
            Vehiculo v = ( Vehiculo )vehiculos.get( cont );

            if( v.darAnio( ) == anio && v.darModelo( ).equalsIgnoreCase( modelo ) )
            {
                vehiculos.remove( cont );
                comprado = true;
            }
        }

        return comprado;
    }

    /**
     * Busca el vehículo más antiguo de todos
     * @return Se retornó la posición donde se encuentra el vehículo más antiguo. Si no hay vehículos a la venta se retornó -1
     */
    public int buscarVehiculoMasAntiguo( )
    {
        int posicion = -1;

        if( vehiculos.size( ) > 0 )
        {
            Vehiculo vMasAntiguo = ( Vehiculo )vehiculos.get( 0 );
            posicion = 0;
            for( int i = 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo vPosicion = ( Vehiculo )vehiculos.get( i );

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
     * Busca el vehículo más económico de todos
     * @return Se retornó la posición donde se encuentra el vehículo más económico. Si no hay vehículos a la venta se retornó -1
     */
    public int buscarVehiculoMasEconomico( )
    {
        int posicion = -1;

        if( vehiculos.size( ) > 0 )
        {
            Vehiculo vMasEconomico = ( Vehiculo )vehiculos.get( 0 );
            posicion = 0;
            for( int i = 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo vPosicion = ( Vehiculo )vehiculos.get( i );

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
     * Busca el vehículo más potente (con mayor cilindrada) de todos
     * @return Se retornó la posición donde se encuentra el vehículo más nuevo. Si no hay vehículos a la venta se retornó -1
     */
    public int buscarVehiculoMasPotente( )
    {
        int posicion = -1;

        if( vehiculos.size( ) > 0 )
        {
            Vehiculo vMasPotente = ( Vehiculo )vehiculos.get( 0 );
            posicion = 0;
            for( int i = 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo vPosicion = ( Vehiculo )vehiculos.get( i );

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
     * Disminuye en un 10% el precio de todos los vehículos cuyo precio es mayor al valor especificado. <br>
     * El precio de un vehículo sólo se disminuye si su valor no queda en cero.
     * @param valor El valor para realizar la disminución de precios. valor>0
     * @return La cantidad de vehículos a los que se les disminuyó el precio
     */
    public int disminuirPrecio( int valor )
    {
        int disminuidos = 0;

        for( int cont = 0; cont < vehiculos.size( ); cont++ )
        {
            Vehiculo v = ( Vehiculo )vehiculos.get( cont );

            if( v.darValor( ) > valor )
            {
                int nValor = ( int ) ( v.darValor( ) * 0.9 );

                if( nValor > 0 )
                {
                    v.cambiarValor( nValor );
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
        assert ( vehiculos != null ) : "La lista de vehículos no debe ser null";
        assert ( !buscarVehiculosModeloYAnioRepetido( ) ) : "Hay dos vehículos del mismo modelo y año";
    }

    /**
     * Verifica si hay dos vehículos con el mismo modelo y el mismo año
     * @return Retorna true si hay dos vehículos con el mismo nombre y año; retorna false en caso contrario.
     */
    private boolean buscarVehiculosModeloYAnioRepetido( )
    {
        for( int i = 0; i < vehiculos.size( ); i++ )
        {
            Vehiculo pi = ( Vehiculo )vehiculos.get( i );
            for( int j = 0; j < vehiculos.size( ); j++ )
            {
                if( i != j )
                {
                    Vehiculo pj = ( Vehiculo )vehiculos.get( j );
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
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensión 1
     * @return respuesta 1
     */
    public String metodo1( )
    {
        return "respuesta1";
    }

    /**
     * Ejecuta el punto de extensión 2
     * @return respuesta 2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }
}