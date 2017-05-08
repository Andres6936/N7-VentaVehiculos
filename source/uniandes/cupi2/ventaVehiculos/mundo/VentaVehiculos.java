/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: VentaVehiculos.java,v 1.8 2007/04/05 00:55:53 carl-veg Exp $ 
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

import java.util.ArrayList;

/**
 * Es la clase que se encarga de manejar, organizar, cargar y salvar los veh�culos <br>
 * <b>inv </b> <br>
 * veh�culos != null y no hay dos veh�culos con el mismo nombre
 */
public class VentaVehiculos
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los veh�culos
     */
    private ArrayList vehiculos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo manejador de veh�culos vac�o.
     */
    public VentaVehiculos( )
    {
        vehiculos = new ArrayList( );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de veh�culos. La lista que se retorna no es la misma que la almacenada en esta clase, <br>
     * pero si tiene el mismo orden.
     * @return lista de veh�culos
     */
    public ArrayList darVehiculos( )
    {
        ArrayList copiaLista = new ArrayList( vehiculos );
        return copiaLista;
    }

    /**
     * Organiza la lista de veh�culos por marca usando el algoritmo de burbuja <br>
     * <b>post: </b>La lista de veh�culos est� ordenada por marca
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
     * Organiza la lista de veh�culos por cilindrada usando el algoritmo de inserci�n <br>
     * <b>post: </b>La lista de veh�culos est� ordenada por cilindrada
     */
    public void ordenarPorCilindrada( )
    {
        int inicial;

        // En cada paso se sabe que:
        // 1. Las posiciones antes de veh�culos[inicial] est�n ordenadas
        // En cada paso lo que se hace es encontrar en qu� posici�n entre veh�culos[0] y veh�culos[inicial] deber�a
        // estar el veh�culo que en este momento se encuentra en veh�culos[inicial]

        for( inicial = 1; inicial < vehiculos.size( ); inicial++ )
        {
            Vehiculo insertado = ( Vehiculo )vehiculos.get( inicial );

            boolean termine = false;
            int i = inicial - 1;

            while( !termine )
            {
                // Si encuentra una cilindrada mayor, entonces hay que intercambiarlos
                Vehiculo veh�culoPosicion = ( Vehiculo )vehiculos.get( i );

                if( veh�culoPosicion.compararPorCilindrada( insertado ) > 0 )
                {
                    vehiculos.set( i, insertado );
                    vehiculos.set( i + 1, veh�culoPosicion );
                    i--;
                }
                // Si se encuentra un cilindrada igual o menor entonces ya se encontr� la posici�n
                else
                {
                    termine = true;
                }

                // Si ya se lleg� al principio de la lista no hay nada m�s que hacer
                if( i < 0 )
                {
                    termine = true;
                }
            }
        }
        verificarInvariante( );
    }

    /**
     * Organiza la lista de veh�culos por el a�o usando el algoritmo de selecci�n <br>
     * <b>post: </b>La lista de veh�culos est� ordenada por a�o
     */
    public void ordenarPorAnio( )
    {
        int inicial;

        // En cada paso se sabe que:
        // 1. Todos los valores antes de veh�culos[inicial] est�n ordenados
        // 2. No hay ning�n valor despu�s de veh�culos[inicial-1] que sea menor que veh�culos[inicial-1]
        // En cada paso se busca el menor entre veh�culos[inicial] y veh�culos[final] y se ubica en veh�culos[inicial]

        for( inicial = 0; inicial < vehiculos.size( ); inicial++ )
        {
            int posicionMenor = inicial;
            Vehiculo veh�culoMenor = ( Vehiculo )vehiculos.get( inicial );

            for( int i = inicial + 1; i < vehiculos.size( ); i++ )
            {
                Vehiculo veh�culoPosicion = ( Vehiculo )vehiculos.get( i );

                // El veh�culo de la posici�n actual es menor que el menor encontrado hasta el momento
                if( veh�culoPosicion.compararPorAnio( veh�culoMenor ) < 0 )
                {
                    veh�culoMenor = veh�culoPosicion;
                    posicionMenor = i;
                }
            }

            if( posicionMenor != inicial )
            {
                Vehiculo temp = ( Vehiculo )vehiculos.get( inicial );
                vehiculos.set( inicial, veh�culoMenor );
                vehiculos.set( posicionMenor, temp );
            }

        }
        verificarInvariante( );
    }

    /**
     * Busca un veh�culo seg�n su modelo y retorna la posici�n en la que se encuentra. <br>
     * @param modelo El modelo del veh�culo buscado - modelo != null
     * @param anio El a�o del veh�culo buscado - anio > 0
     * @return Retorna la posici�n donde se encuentra un veh�culo con el modelo y el a�o dado. Si no se encuentra ning�n veh�culo con ese modelo y a�o retorna -1.
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
     * Agrega un nuevo veh�culo
     * @param modeloV El modelo del veh�culo - modeloV != null
     * @param marcaV La marca del veh�culo - marcaV != null
     * @param imagenP La ruta a la imagen del veh�culo - imagenP != null
     * @param tipoV El tipo de veh�culo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El a�o del veh�culo - anioV > 0
     * @param cilindradaV La cilindrada del veh�culo - cilindradaV > 0
     * @param ejesV El n�mero de ejes del veh�culo - ejesV > 0
     * @param valor El valor del veh�culo - valor > 0
     * @return Se retorn� true si el veh�culo fue agregado o false en caso de que ya existiera un veh�culo con el mismo modelo y a�o
     */
    public boolean agregarVehiculo( String modeloV, String marcaV, String imagenP, String tipoV, int anioV, int cilindradaV, int ejesV, int valor )
    {
        boolean agregado = false;
        int veh�culoBuscado = buscarVehiculo( modeloV, anioV );
        if( veh�culoBuscado == -1 )
        {
            Vehiculo nuevoveh�culo = new Vehiculo( modeloV, marcaV, imagenP, tipoV, anioV, cilindradaV, ejesV, valor );
            vehiculos.add( nuevoveh�culo );
            agregado = true;
            verificarInvariante( );
        }

        return agregado;

    }

    /**
     * Elimina de la lista el veh�culo especificado
     * @param modelo Modelo del veh�culo - modelo!=null
     * @param anio A�o del veh�culo - anio>0
     * @return Se retorn� true si el veh�culo fue comprado o false en caso contrario
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
     * Busca el veh�culo m�s antiguo de todos
     * @return Se retorn� la posici�n donde se encuentra el veh�culo m�s antiguo. Si no hay veh�culos a la venta se retorn� -1
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
     * Busca el veh�culo m�s econ�mico de todos
     * @return Se retorn� la posici�n donde se encuentra el veh�culo m�s econ�mico. Si no hay veh�culos a la venta se retorn� -1
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
     * Busca el veh�culo m�s potente (con mayor cilindrada) de todos
     * @return Se retorn� la posici�n donde se encuentra el veh�culo m�s nuevo. Si no hay veh�culos a la venta se retorn� -1
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
     * Disminuye en un 10% el precio de todos los veh�culos cuyo precio es mayor al valor especificado. <br>
     * El precio de un veh�culo s�lo se disminuye si su valor no queda en cero.
     * @param valor El valor para realizar la disminuci�n de precios. valor>0
     * @return La cantidad de veh�culos a los que se les disminuy� el precio
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
        assert ( vehiculos != null ) : "La lista de veh�culos no debe ser null";
        assert ( !buscarVehiculosModeloYAnioRepetido( ) ) : "Hay dos veh�culos del mismo modelo y a�o";
    }

    /**
     * Verifica si hay dos veh�culos con el mismo modelo y el mismo a�o
     * @return Retorna true si hay dos veh�culos con el mismo nombre y a�o; retorna false en caso contrario.
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
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensi�n 1
     * @return respuesta 1
     */
    public String metodo1( )
    {
        return "respuesta1";
    }

    /**
     * Ejecuta el punto de extensi�n 2
     * @return respuesta 2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }
}