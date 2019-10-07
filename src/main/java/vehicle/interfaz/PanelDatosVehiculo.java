/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelDatosVehiculo.java,v 1.4 2007/04/05 00:31:11 carl-veg Exp $ 
 * Universidad de los Andes (Bogot - Colombia)
 * Departamento de Ingeniera de Sistemas y Computacin
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario Snchez - 06/12/2005
 * Autor: Daniel Romero - 17-Nov-2006 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package vehicle.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import vehicle.mundo.Vehiculo;

/**
 * Es el panel donde se muestran los datos de un vehiculo
 */
public class PanelDatosVehiculo extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la etiqueta donde se muestra la imagen del vehiculo
     */
    private JLabel etiquetaImagen;

    /**
     * Es la etiqueta para el modelo del vehiculo
     */
    private JLabel etiquetaModelo;

    /**
     * Es la etiqueta para la marca del vehiculo
     */
    private JLabel etiquetaMarca;

    /**
     * Es la etiqueta donde se muestra el tipo del vehiculo
     */
    private JLabel etiquetaTipo;

    /**
     * Es la etiqueta para el ao del vehiculo
     */
    private JLabel etiquetaAnio;

    /**
     * Es la etiqueta donde se muestra el cilindrada del vehiculo
     */
    private JLabel etiquetaCilindrada;

    /**
     * Es la etiqueta para el nmero de ejes del vehiculo
     */
    private JLabel etiquetaEjes;

    /**
     * Es la etiqueta para el valor del vehiculo
     */
    private JLabel etiquetaValor;

    /**
     * Es el campo para el modelo del vehiculo
     */
    private JTextField txtModelo;

    /**
     * Es el campo para la marca del vehiculo
     */
    private JTextField txtMarca;

    /**
     * Es el campo para el ao del vehiculo
     */
    private JTextField txtAnio;

    /**
     * Es el campo para el cilindrada del vehiculo
     */
    private JTextField txtCilindrada;

    /**
     * Es el campo para el nmero de ejes del vehiculo
     */
    private JTextField txtEjes;

    /**
     * Es el campo para el tipo del vehiculo
     */
    private JTextField txtTipo;

    /**
     * Es el campo para el valor del vehiculo
     */
    private JTextField txtValor;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     */
    public PanelDatosVehiculo( )
    {
        setLayout( new GridBagLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Datos del vehiculo" ) ) );

        GridBagConstraints gbcE = new GridBagConstraints( 0, 0, 1, 1, 0, 1, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        GridBagConstraints gbcC = new GridBagConstraints( 1, 0, 1, 1, 0, 0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets( 5, 5, 5, 5 ), 0, 0 );

        etiquetaModelo = new JLabel( "Modelo: " );
        txtModelo = new JTextField( 10 );
        txtModelo.setEditable( false );
        add( etiquetaModelo, gbcE );
        add( txtModelo, gbcC );

        gbcE.weighty = 0;
        gbcE.gridy = 1;
        gbcC.gridy = 1;
        etiquetaMarca = new JLabel( "Marca: " );
        txtMarca = new JTextField( 10 );
        txtMarca.setEditable( false );
        add( etiquetaMarca, gbcE );
        add( txtMarca, gbcC );

        gbcE.gridy = 2;
        gbcC.gridy = 2;
        etiquetaTipo = new JLabel( "Tipo: " );
        txtTipo = new JTextField( 10 );
        txtTipo.setEditable( false );
        add( etiquetaTipo, gbcE );
        add( txtTipo, gbcC );

        gbcE.gridy = 3;
        gbcC.gridy = 3;
        etiquetaAnio = new JLabel( "Ao: " );
        txtAnio = new JTextField( 10 );
        txtAnio.setEditable( false );
        add( etiquetaAnio, gbcE );
        add( txtAnio, gbcC );

        gbcE.gridy = 4;
        gbcC.gridy = 4;
        etiquetaCilindrada = new JLabel( "Cilindrada: " );
        txtCilindrada = new JTextField( 10 );
        txtCilindrada.setEditable( false );
        add( etiquetaCilindrada, gbcE );
        add( txtCilindrada, gbcC );

        gbcE.gridy = 5;
        gbcC.gridy = 5;
        etiquetaEjes = new JLabel( "Ejes: " );
        txtEjes = new JTextField( 10 );
        txtEjes.setEditable( false );
        add( etiquetaEjes, gbcE );
        add( txtEjes, gbcC );

        gbcE.gridy = 6;
        gbcC.gridy = 6;
        etiquetaValor = new JLabel( "Valor: " );
        txtValor = new JTextField( 10 );
        txtValor.setEditable( false );
        add( etiquetaValor, gbcE );
        add( txtValor, gbcC );

        GridBagConstraints gbcI = new GridBagConstraints( 2, 0, 1, 7, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );

        JPanel panelImagen = new JPanel( new GridBagLayout( ) );
        etiquetaImagen = new JLabel( );
        etiquetaImagen.setBorder( new LineBorder( Color.BLACK, 1 ) );
        etiquetaImagen.setMinimumSize( new Dimension( 200, 200 ) );
        panelImagen.add( etiquetaImagen );
        add( panelImagen, gbcI );

    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Muestra los datos del vehiculo
     * @param vehiculo El vehiculo del que se quieren mostrar los datos - vehiculo != null
     */
    public void mostrarDatos( Vehiculo vehiculo )
    {
        String imagen = vehiculo.darImagen( );
        etiquetaImagen.setIcon( new ImageIcon( getFileFromResource( imagen ) ) );

        txtModelo.setText( vehiculo.darModelo( ) );
        txtMarca.setText( vehiculo.darMarca( ) );
        txtTipo.setText( vehiculo.darTipo( ) );
        txtAnio.setText( "" + vehiculo.darAnio( ) );
        txtCilindrada.setText( "" + vehiculo.darCilindrada( ) );
        txtEjes.setText( "" + vehiculo.darEjes( ) );
        txtValor.setText( "" + vehiculo.darValor( ) );

        validate( );
    }

    /**
     * Limpia todos los campos
     */
    public void limpiarDatos( )
    {
        etiquetaImagen.setIcon( null );
        txtModelo.setText( "" );
        txtMarca.setText( "" );
        txtTipo.setText( "" );
        txtAnio.setText( "" );
        txtCilindrada.setText( "" );
        txtEjes.setText( "" );
        txtValor.setText( "" );
    }

    /**
     * Método utilizado para cargar archivos desde el directorio /resource, es decir,
     * la estructura de proyectos basados en Maven y Gradle.
     *
     * @param filename Nombre del archivo.
     * @return Referencia al archivo.
     */
    private URL getFileFromResource( final String filename )
    {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource( filename );

        if (resource == null)
        {
            throw new IllegalArgumentException( "File is not found." );
        }
        else
        {
            return resource;
        }
    }
}