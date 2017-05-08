/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazVentaVehiculos.java,v 1.11 2007/04/05 00:55:53 carl-veg Exp $ 
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
package uniandes.cupi2.ventaVehiculos.interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.ventaVehiculos.mundo.VentaVehiculos;
import uniandes.cupi2.ventaVehiculos.mundo.Vehiculo;

/**
 * Es la clase principal de la interfaz
 */
public class InterfazVentaVehiculos extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Ruta donde se encuentra ubicado el archivo con los datos de los vehículos
     */
    public static final String ARCHIVO_VEHICULOS = "./data/vehiculos.dat";
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la exposición de vehículo
     */
    private VentaVehiculos ventaVehiculos;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se muestra la lista de vehículo
     */
    private PanelListaVehiculos panelLista;

    /**
     * Es el panel donde se muestran los datos de un vehículo
     */
    private PanelDatosVehiculo panelDatos;

    /**
     * Es el panel donde están los botones para los puntos de extensión
     */
    private PanelExtension panelExtension;

    /**
     * Es el panel donde están los botones para realizar búsquedas y ordenamiento sobre <br>
     * la lista de vehículos
     */
    private PanelBusquedaOrdenamiento panelBusquedaOrdenamiento;

    /**
     * Es el panel donde están los botones para realizar consultas y operaciones <br>
     * sobre la la lista de vehículos
     */
    private PanelConsultasOperaciones panelConsultasOperaciones;

    /**
     * Panel con una imagen decorativa
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz e inicializa todos sus componentes
     */
    public InterfazVentaVehiculos( )
    {
        ventaVehiculos = new VentaVehiculos( );

        cargarVehiculos( ARCHIVO_VEHICULOS );

        setLayout( new GridBagLayout( ) );

        GridBagConstraints gbc = new GridBagConstraints( 1, 1, 1, 1, 1, 0.2, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 3, 5, 3, 5 ), 0, 0 );
        panelDatos = new PanelDatosVehiculo( );
        add( panelDatos, gbc );

        gbc = new GridBagConstraints( 0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 3, 5, 3, 5 ), 0, 0 );
        panelLista = new PanelListaVehiculos( this );
        add( panelLista, gbc );

        gbc = new GridBagConstraints( 0, 3, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 3, 5, 3, 5 ), 0, 0 );
        panelExtension = new PanelExtension( this );
        add( panelExtension, gbc );

        panelBusquedaOrdenamiento = new PanelBusquedaOrdenamiento( this );
        gbc = new GridBagConstraints( 0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 3, 5, 3, 5 ), 0, 0 );
        add( panelBusquedaOrdenamiento, gbc );

        panelConsultasOperaciones = new PanelConsultasOperaciones( this );
        gbc = new GridBagConstraints( 1, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 3, 5, 3, 5 ), 0, 0 );
        add( panelConsultasOperaciones, gbc );

        panelImagen = new PanelImagen( );
        gbc = new GridBagConstraints( 0, 0, 2, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 3, 5, 3, 5 ), 0, 0 );
        add( panelImagen, gbc );

        actualizarLista( );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Venta de Vehículos" );

        setSize( new Dimension( 911, 576 ) );
        setResizable( false );

        centrar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Centra la ventana en la pantalla
     */
    private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }

    /**
     * Actualiza la lista de vehículos mostrada
     */
    private void actualizarLista( )
    {
        panelLista.actualizarLista( ventaVehiculos.darVehiculos( ) );
    }

    /**
     * Ordena los vehículos por marca y actualiza la lista
     */
    public void ordenarPorMarca( )
    {
        ventaVehiculos.ordenarPorMarca( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Ordena los vehículos por cilindrada y actualiza la lista
     */
    public void ordenarPorCilindrada( )
    {
        ventaVehiculos.ordenarPorCilindrada( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Ordena los vehículos por año y actualiza la lista
     */
    public void ordenarPorAnio( )
    {
        ventaVehiculos.ordenarPorAnio( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Busca un vehículo usando el modelo y el año y cuando lo encuentra lo selecciona en la lista y muestra sus datos
     */
    public void buscar( )
    {
        String nombreBuscado = JOptionPane.showInputDialog( this, "Modelo Buscado" );

        if( nombreBuscado != null )
        {
            String anioBuscado = JOptionPane.showInputDialog( this, "Año Buscado" );
            if( anioBuscado != null )
            {
                try
                {
                    int anio = Integer.parseInt( anioBuscado );

                    int posicion = ventaVehiculos.buscarVehiculo( nombreBuscado, anio );

                    actualizarLista( );
                    if( posicion != -1 )
                    {
                        panelLista.seleccionar( posicion );
                        Vehiculo p = ( Vehiculo )ventaVehiculos.darVehiculos( ).get( posicion );
                        verDatos( p );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "No se encontró el vehículo" );
                    }
                }
                catch( NumberFormatException nfe )
                {
                    JOptionPane.showMessageDialog( this, "El año debe se un número entero", "Error", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
    }

    /**
     * Muestra los datos de un vehículo en el panel correspondiente
     * @param vehiculo El vehículo del que se quieren ver los datos - vehiculo != null
     */
    public void verDatos( Vehiculo vehiculo )
    {
        panelDatos.mostrarDatos( vehiculo );
        pack( );
    }

    /**
     * Muestra el diálogo para agregar un vehículo
     */
    public void mostrarDialogoAgregarVehiculo( )
    {
        DialogoAgregarVehiculo dav = new DialogoAgregarVehiculo( this );
        dav.setVisible( true );
    }

    /**
     * Agrega un nuevo vehículo
     * @param dialogo Es el diálogo usado para agregar el vehículo
     * @param modeloV El modelo del vehículo - modeloV != null
     * @param marcaV La marca del vehículo - marcaV != null
     * @param imagenV La ruta a la imagen del vehículo - imagenV != null
     * @param tipoV El tipo de vehículo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El año del vehículo - anioV > 0
     * @param cilindradaV La cilindrada del vehículo - cilindradaV > 0
     * @param ejesV El número de ejes del vehículo - ejesV > 0
     * @param valor El valor del vehículo - valor > 0
     */
    public void agregarVehiculo( DialogoAgregarVehiculo dialogo, String modeloV, String marcaV, String imagenV, String tipoV, int anioV, int cilindradaV, int ejesV, int valor )
    {

        boolean agregado = ventaVehiculos.agregarVehiculo( modeloV, marcaV, imagenV, tipoV, anioV, cilindradaV, ejesV, valor );

        if( agregado )
        {
            actualizarLista( );
            dialogo.dispose( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "El vehículo no pudo ser adicionado", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el vehículo más antiguo a la venta y muestra sus datos en el panel información
     */
    public void buscarMasAntiguo( )
    {
        int posicion = ventaVehiculos.buscarVehiculoMasAntiguo( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Aún no hay vehículos a la venta", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el vehículo más potente a la venta y muestra sus datos en el panel información
     */
    public void buscarMasPotente( )
    {
        int posicion = ventaVehiculos.buscarVehiculoMasPotente( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Aún no hay vehículos a la venta", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el vehículo más económico a la venta y muestra sus datos en el panel información
     */
    public void buscarMasEconomico( )
    {
        int posicion = ventaVehiculos.buscarVehiculoMasEconomico( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Aún no hay vehículos a la venta", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Compra el vehículo seleccionado de la lista
     */
    public void comprarVehiculo( )
    {
        Vehiculo v = panelLista.darVehiculoSeleccionado( );

        if( v != null )
        {
            ventaVehiculos.comprarVehiculo( v.darModelo( ), v.darAnio( ) );
            panelDatos.limpiarDatos( );
            actualizarLista( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un vehículo", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Disminuye el precio de todos los vehículos cuyo valor sea mayor al dado por el usuario
     */
    public void disminuirPrecio( )
    {
        String precio = JOptionPane.showInputDialog( this, "Precio para realizar el descuento" );

        if( precio != null )
        {
            if( precio.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "El precio debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    int valor = Integer.parseInt( precio );

                    if( valor > 0 )
                    {
                        int disminuidos = ventaVehiculos.disminuirPrecio( valor );

                        if( disminuidos > 0 )
                        {
                            JOptionPane.showMessageDialog( this, "Se disminuyó el precio de " + disminuidos + " vehículos", "Venta de Vehículos", JOptionPane.INFORMATION_MESSAGE );
                        }
                        else
                        {
                            JOptionPane.showMessageDialog( this, "No se disminuyó el precio de ningún vehículo", "Venta de Vehículos", JOptionPane.INFORMATION_MESSAGE );
                        }

                        actualizarLista( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El precio debe ser un número entero positivo", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                }
                catch( NumberFormatException nfe )
                {
                    JOptionPane.showMessageDialog( this, "El precio debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE );
                }
            }

        }
    }

    /**
     * Carga los carros iniciales de la venta a partir de un archivo de propiedades.
     * @param archivo nombre del archivo de propiedades que contiene la información de los vehiculos - archivo!=null
     */
    private void cargarVehiculos( String archivo )
    {

        try
        {
            FileInputStream fis = new FileInputStream( new File( archivo ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            // Cargar los vehículos
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
                // Carga un vehículo
                dato = "vehiculo" + cont + ".modelo";
                modelo = propiedades.getProperty( dato );

                dato = "vehiculo" + cont + ".marca";
                marca = propiedades.getProperty( dato );

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

                // Sólo se carga el vehiculo si los datos son correctos
                if( modelo != null && marca != null && imagen != null && tipo != null && anio > 0 && cilandraje > 0 && ejes > 0 && valor > 0 )
                    ventaVehiculos.agregarVehiculo( modelo, marca, imagen, tipo, anio, cilandraje, ejes, valor );
                fis.close( );
            }
        }
        catch( FileNotFoundException e )
        {
            JOptionPane.showMessageDialog( this, "Problemas al cargar la información de los vehículos", "Error", JOptionPane.ERROR_MESSAGE );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Problemas al cargar la información de los vehículos", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = ventaVehiculos.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta el punto de extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = ventaVehiculos.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación
     * @param args Son los parámetros de ejecución de la aplicación. No deben usarse.
     */
    public static void main( String[] args )
    {
        InterfazVentaVehiculos iec = new InterfazVentaVehiculos( );
        iec.setVisible( true );
    }
}