package vehicle.interfaz;

import vehicle.mundo.Vehiculo;
import vehicle.mundo.VentaVehiculos;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Properties;

import javax.swing.*;


/**
 * Es la clase principal de la java.vehicle.interfaz
 */
public class InterfazVentaVehiculos extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Ruta donde se encuentra ubicado el archivo con los datos de los vehiculos
     */
    public static final String ARCHIVO_VEHICULOS = "data/vehiculos.properties";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la exposicin de vehiculo
     */
    private VentaVehiculos ventaVehiculos;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se muestra la lista de vehiculo
     */
    private PanelListaVehiculos panelLista;

    /**
     * Es el panel donde se muestran los datos de un vehiculo
     */
    private PanelDatosVehiculo panelDatos;

    /**
     * Es el panel donde estn los botones para los puntos de extensin
     */
    private PanelExtension panelExtension;

    /**
     * Es el panel donde estn los botones para realizar bsquedas y ordenamiento sobre <br>
     * la lista de vehiculos
     */
    private PanelBusquedaOrdenamiento panelBusquedaOrdenamiento;

    /**
     * Es el panel donde estn los botones para realizar consultas y operaciones <br>
     * sobre la la lista de vehiculos
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
     * Construye la java.vehicle.interfaz e inicializa todos sus componentes
     */
    private InterfazVentaVehiculos( )
    {
        ventaVehiculos = new VentaVehiculos( );

        cargarVehiculos( );

        setLayout( new BoxLayout( getContentPane( ), BoxLayout.Y_AXIS ) );

        panelImagen = new PanelImagen( );
        add( panelImagen );

        // Layout : List <---> Data
        JPanel panelDataAndList = new JPanel( );
        panelDataAndList.setLayout( new BoxLayout( panelDataAndList, BoxLayout.X_AXIS ) );

        panelLista = new PanelListaVehiculos( this );
        panelDataAndList.add( panelLista );

        panelDatos = new PanelDatosVehiculo( );
        panelDataAndList.add( panelDatos );

        add( panelDataAndList );

        // Layout : Find <---> Consult
        JPanel panelFindAndConsult = new JPanel( );
        panelFindAndConsult.setLayout( new BoxLayout( panelFindAndConsult, BoxLayout.X_AXIS ) );

        panelBusquedaOrdenamiento = new PanelBusquedaOrdenamiento( this );
        panelFindAndConsult.add( panelBusquedaOrdenamiento );

        panelConsultasOperaciones = new PanelConsultasOperaciones( this );
        panelFindAndConsult.add( panelConsultasOperaciones );

        add( panelFindAndConsult );

        panelExtension = new PanelExtension( this );
        add( panelExtension );

        actualizarLista( );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Venta de vehiculos" );

        setSize( new Dimension( 800, 600 ) );
        setMinimumSize( new Dimension( 800, 600 ) );
        setMaximumSize( new Dimension( 800, 600 ) );

        setResizable( false );

        centrar( );
    }

    // -----------------------------------------------------------------
    // Mtodos
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
     * Actualiza la lista de vehiculos mostrada
     */
    private void actualizarLista( )
    {
        panelLista.actualizarLista( ventaVehiculos.darVehiculos( ) );
    }

    /**
     * Ordena los vehiculos por marca y actualiza la lista
     */
    void ordenarPorMarca( )
    {
        ventaVehiculos.sortForTrademark( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Ordena los vehiculos por cilindrada y actualiza la lista
     */
    void ordenarPorCilindrada( )
    {
        ventaVehiculos.sortForDisplacement( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Ordena los vehiculos por ao y actualiza la lista
     */
    void ordenarPorAnio( )
    {
        ventaVehiculos.sortForYear( );
        panelDatos.limpiarDatos( );
        actualizarLista( );
    }

    /**
     * Busca un vehiculo usando el modelo y el ao y cuando lo encuentra lo selecciona en la lista y muestra sus datos
     */
    void buscar( )
    {
        String nombreBuscado = JOptionPane.showInputDialog( this, "Modelo Buscado" );

        if( nombreBuscado != null )
        {
            String anioBuscado = JOptionPane.showInputDialog( this, "Ao Buscado" );
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
                        JOptionPane.showMessageDialog( this, "No se encontr el vehiculo" );
                    }
                }
                catch( NumberFormatException nfe )
                {
                    JOptionPane.showMessageDialog( this, "El ao debe se un nmero entero", "Error", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
    }

    /**
     * Muestra los datos de un vehiculo en el panel correspondiente
     * @param vehiculo El vehiculo del que se quieren ver los datos - vehiculo != null
     */
    void verDatos( Vehiculo vehiculo )
    {
        panelDatos.mostrarDatos( vehiculo );
        pack( );
    }

    /**
     * Muestra el dilogo para agregar un vehiculo
     */
    void mostrarDialogoAgregarVehiculo( )
    {
        DialogoAgregarVehiculo dav = new DialogoAgregarVehiculo( this );
        dav.setVisible( true );
    }

    /**
     * Agrega un nuevo vehiculo
     * @param dialogo Es el dilogo usado para agregar el vehiculo
     * @param modeloV El modelo del vehiculo - modeloV != null
     * @param marcaV La marca del vehiculo - marcaV != null
     * @param imagenV La ruta a la imagen del vehiculo - imagenV != null
     * @param tipoV El tipo de vehiculo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El ao del vehiculo - anioV > 0
     * @param cilindradaV La cilindrada del vehiculo - cilindradaV > 0
     * @param ejesV El nmero de ejes del vehiculo - ejesV > 0
     * @param valor El valor del vehiculo - valor > 0
     */
    void agregarVehiculo( DialogoAgregarVehiculo dialogo, String modeloV, String marcaV, String imagenV, String tipoV, int anioV, int cilindradaV, int ejesV, int valor )
    {

        boolean agregado = ventaVehiculos.agregarVehiculo( modeloV, marcaV, imagenV, tipoV, anioV, cilindradaV, ejesV, valor );

        if( agregado )
        {
            actualizarLista( );
            dialogo.dispose( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "El vehiculo no pudo ser adicionado", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el vehiculo mas antiguo a la venta y muestra sus datos en el panel informacin
     */
    void buscarMasAntiguo( )
    {
        int posicion = ventaVehiculos.buscarVehiculoMasAntiguo( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "An no hay vehiculos a la venta", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el vehiculo mas potente a la venta y muestra sus datos en el panel informacin
     */
    void buscarMasPotente( )
    {
        int posicion = ventaVehiculos.getIndexOfVehicleMorePowerful( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "An no hay vehiculos a la venta", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el vehiculo mas econmico a la venta y muestra sus datos en el panel informacin
     */
    void buscarMasEconomico( )
    {
        int posicion = ventaVehiculos.getIndexOfVehicleMoreCheap( );

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "An no hay vehiculos a la venta", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Compra el vehiculo seleccionado de la lista
     */
    void comprarVehiculo( )
    {
        Vehiculo v = panelLista.darVehiculoSeleccionado( );

        if( v != null )
        {
            ventaVehiculos.comprarVehiculo( v.darModelo( ), v.getYear( ) );
            panelDatos.limpiarDatos( );
            actualizarLista( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un vehiculo", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Disminuye el precio de todos los vehiculos cuyo valor sea mayor al dado por el usuario
     */
    void disminuirPrecio( )
    {
        String precio = JOptionPane.showInputDialog( this, "Precio para realizar el descuento" );

        if( precio != null )
        {
            if( precio.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "El precio debe ser un nmero entero", "Error", JOptionPane.ERROR_MESSAGE );
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
                            JOptionPane.showMessageDialog( this, "Se disminuy el precio de " + disminuidos + " vehiculos", "Venta de vehiculos", JOptionPane.INFORMATION_MESSAGE );
                        }
                        else
                        {
                            JOptionPane.showMessageDialog( this, "No se disminuy el precio de ningn vehiculo", "Venta de vehiculos", JOptionPane.INFORMATION_MESSAGE );
                        }

                        actualizarLista( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El precio debe ser un nmero entero positivo", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                }
                catch( NumberFormatException nfe )
                {
                    JOptionPane.showMessageDialog( this, "El precio debe ser un nmero entero", "Error", JOptionPane.ERROR_MESSAGE );
                }
            }

        }
    }

    /**
     * Carga los carros iniciales de la venta a partir de un archivo de propiedades.
     */
    private void cargarVehiculos( )
    {
        try
        {
            FileInputStream fis = new FileInputStream( getFileFromResource( ) );
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

            for( int i = 1; i <= cantidad; i++ )
            {
                // Carga un vehiculo
                dato = "vehiculo" + i + ".modelo";
                modelo = propiedades.getProperty( dato );

                dato = "vehiculo" + i + ".marca";
                marca = propiedades.getProperty( dato );

                dato = "vehiculo" + i + ".marca";
                marca = propiedades.getProperty( dato );

                dato = "vehiculo" + i + ".imagen";
                imagen = propiedades.getProperty( dato );

                dato = "vehiculo" + i + ".tipo";
                tipo = propiedades.getProperty( dato );

                dato = "vehiculo" + i + ".anio";
                aux = propiedades.getProperty( dato );
                anio = Integer.parseInt( aux );

                dato = "vehiculo" + i + ".cilindrada";
                aux = propiedades.getProperty( dato );
                cilandraje = Integer.parseInt( aux );

                dato = "vehiculo" + i + ".ejes";
                aux = propiedades.getProperty( dato );
                ejes = Integer.parseInt( aux );

                dato = "vehiculo" + i + ".valor";
                aux = propiedades.getProperty( dato );
                valor = Integer.parseInt( aux );

                // Slo se carga el vehiculo si los datos son correctos
                if( modelo != null && marca != null && imagen != null && tipo != null && anio > 0 && cilandraje > 0 && ejes > 0 && valor > 0 )
                    ventaVehiculos.agregarVehiculo( modelo, marca, imagen, tipo, anio, cilandraje, ejes, valor );
                fis.close( );
            }
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Problemas al cargar la informacin de los vehiculos", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Método utilizado para cargar archivos desde el directorio /resource, es decir,
     * la estructura de proyectos basados en Maven y Gradle.
     *
     * @return Referencia al archivo.
     */
    private File getFileFromResource( )
    {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource( ARCHIVO_VEHICULOS );

        if (resource == null)
        {
            throw new IllegalArgumentException( "File is not found." );
        }
        else
        {
            return new File( resource.getFile() );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensin
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensin 1
     */
    void reqFuncOpcion1( )
    {
        String respuesta = ventaVehiculos.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta el punto de extensin 2
     */
    void reqFuncOpcion2( )
    {
        String respuesta = ventaVehiculos.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicacin
     * @param args Son los parmetros de ejecucin de la aplicacin. No deben usarse.
     */
    public static void main( String[] args )
    {
        InterfazVentaVehiculos iec = new InterfazVentaVehiculos( );
        iec.setVisible( true );
    }
}