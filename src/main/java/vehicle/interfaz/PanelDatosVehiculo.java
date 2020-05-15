package vehicle.interfaz;

import java.awt.*;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import vehicle.mundo.Vehicle;

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
    PanelDatosVehiculo( )
    {
        setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );
        setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new TitledBorder( "Datos del vehiculo" ) ) );

        // Label and Text <<< Left

        JPanel panelModel = new JPanel( );
        panelModel.setLayout( new BorderLayout( ) );

        etiquetaModelo = new JLabel( "Modelo: " );
        txtModelo = new JTextField( 10 );
        txtModelo.setEditable( false );

        panelModel.add( etiquetaModelo, BorderLayout.WEST );
        panelModel.add( txtModelo, BorderLayout.EAST );

        JPanel panelTrademark = new JPanel( );
        panelTrademark.setLayout( new BorderLayout( ) );

        etiquetaMarca = new JLabel( "Marca: " );
        txtMarca = new JTextField( 10 );
        txtMarca.setEditable( false );

        panelTrademark.add( etiquetaMarca, BorderLayout.WEST );
        panelTrademark.add( txtMarca, BorderLayout.EAST );

        JPanel panelType = new JPanel( );
        panelType.setLayout( new BorderLayout( ) );

        etiquetaTipo = new JLabel( "Tipo: " );
        txtTipo = new JTextField( 10 );
        txtTipo.setEditable( false );

        panelType.add( etiquetaTipo, BorderLayout.WEST );
        panelType.add( txtTipo, BorderLayout.EAST );

        JPanel panelYear = new JPanel( );
        panelYear.setLayout( new BorderLayout( ) );

        etiquetaAnio = new JLabel( "Ao: " );
        txtAnio = new JTextField( 10 );
        txtAnio.setEditable( false );

        panelYear.add( etiquetaAnio, BorderLayout.WEST );
        panelYear.add( txtAnio, BorderLayout.EAST );

        JPanel panelDisplacement = new JPanel( );
        panelDisplacement.setLayout( new BorderLayout( ) );

        etiquetaCilindrada = new JLabel( "Cilindrada: " );
        txtCilindrada = new JTextField( 10 );
        txtCilindrada.setEditable( false );

        panelDisplacement.add( etiquetaCilindrada, BorderLayout.WEST );
        panelDisplacement.add( txtCilindrada, BorderLayout.EAST );

        JPanel panelEjes = new JPanel( );
        panelEjes.setLayout( new BorderLayout( ) );

        etiquetaEjes = new JLabel( "Ejes: " );
        txtEjes = new JTextField( 10 );
        txtEjes.setEditable( false );

        panelEjes.add( etiquetaEjes, BorderLayout.WEST );
        panelEjes.add( txtEjes, BorderLayout.EAST );

        JPanel panelValue = new JPanel( );
        panelValue.setLayout( new BorderLayout( ) );

        etiquetaValor = new JLabel( "Valor: " );
        txtValor = new JTextField( 10 );
        txtValor.setEditable( false );

        panelValue.add( etiquetaValor, BorderLayout.WEST );
        panelValue.add( txtValor, BorderLayout.EAST );

        JPanel panelLabelAndText = new JPanel( );
        panelLabelAndText.setLayout( new BoxLayout( panelLabelAndText, BoxLayout.Y_AXIS ) );

        panelLabelAndText.add( Box.createRigidArea( new Dimension( 0, 20 ) ) );
        panelLabelAndText.add( panelModel );
        panelLabelAndText.add( panelTrademark );
        panelLabelAndText.add( panelType );
        panelLabelAndText.add( panelYear );
        panelLabelAndText.add( panelDisplacement );
        panelLabelAndText.add( panelEjes );
        panelLabelAndText.add( panelValue );
        panelLabelAndText.add( Box.createRigidArea( new Dimension( 0, 20 ) ) );

        panelLabelAndText.setSize( new Dimension( 300, 200 ) );
        panelLabelAndText.setBorder( BorderFactory.createEmptyBorder( 2, 2, 2, 2 ) );

        add( panelLabelAndText );

        etiquetaImagen = new JLabel( );
        etiquetaImagen.setBorder( new LineBorder( Color.BLACK, 1 ) );
        etiquetaImagen.setSize( new Dimension( 200, 200 ) );
        etiquetaImagen.setMinimumSize( new Dimension( 200, 200 ) );
        etiquetaImagen.setMaximumSize( new Dimension( 200, 200 ) );

        add( etiquetaImagen );

        setSize( new Dimension( 500, 200 ) );
        setMinimumSize( new Dimension( 500, 200 ) );
        setMaximumSize( new Dimension( 500, 200 ) );

    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Muestra los datos del vehiculo
     *
     * @param vehicle El vehiculo del que se quieren mostrar los datos - vehiculo != null
     */
    public void mostrarDatos(Vehicle vehicle)
    {
        String imagen = vehicle.getImagen();
        etiquetaImagen.setIcon(new ImageIcon(getFileFromResource(imagen)));

        txtModelo.setText(vehicle.getModelo());
        txtMarca.setText(vehicle.getTrademark());
        txtTipo.setText(vehicle.getTipo());
        txtAnio.setText("" + vehicle.getYear());
        txtCilindrada.setText("" + vehicle.getDisplacement());
        txtEjes.setText("" + vehicle.getEjes());
        txtValor.setText("" + vehicle.getValue());

        validate();
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