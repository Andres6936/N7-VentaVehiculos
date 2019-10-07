/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAgregarVehiculo.java,v 1.3 2007/04/05 00:31:11 carl-veg Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import vehicle.mundo.Vehiculo;

/**
 * Este es el panel donde se agregan vehiculos
 */
public class PanelAgregarVehiculo extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String AGREGAR = "Agregarvehiculo";

    private static final String BUSCAR = "BuscarImagen";

    private static final String[] TIPOS = new String[]{ Vehiculo.BUS, Vehiculo.AUTOMOVIL, Vehiculo.CAMION, Vehiculo.MOTOCICLETA };

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al dilogo que contiene el panel
     */
    private DialogoAgregarVehiculo dialogo;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el campo para la ruta hasta la imagen del vehiculo
     */
    private JTextField txtImagen;

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
     * Es el campo para la cilindrada del vehiculo
     */
    private JTextField txtCilindrada;

    /**
     * Es el campo para el nmero de ejes del vehiculo
     */
    private JTextField txtEjes;

    /**
     * Es el campo para el valor comercial del vehiculo
     */
    private JTextField txtValor;

    /**
     * El combo para seleccionar el tipo del vehiculo
     */
    private JComboBox cbbTipo;

    /**
     * Es la etiqueta para la imagen del vehiculo
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
     * Es la etiqueta para la cilindrada del vehiculo
     */
    private JLabel etiquetaCilindrada;

    /**
     * Es la etiqueta para el nmero de ejes del vehiculo
     */
    private JLabel etiquetaEjes;

    /**
     * Es la etiqueta para el valor comercial del vehiculo
     */
    private JLabel etiquetaValor;

    /**
     * Es el botn que se usa para agregar un vehiculo
     */
    private JButton botonAgregar;

    /**
     * Es el botn que se usa para examinar el disco buscando la imagen del vehiculo
     */
    private JButton botonExaminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param dav Es una referencia al dilogo que contiene el panel- dav!=null
     */
    public PanelAgregarVehiculo( DialogoAgregarVehiculo dav )
    {
        dialogo = dav;

        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Agregar vehiculo" ) ) );

        JPanel panelDatos = new JPanel( new GridLayout( 8, 2 ) );

        // Modelo
        etiquetaModelo = new JLabel( "Modelo: " );
        panelDatos.add( etiquetaModelo );
        txtModelo = new JTextField( "" );
        panelDatos.add( txtModelo );

        // Marca
        etiquetaMarca = new JLabel( "Marca: " );
        panelDatos.add( etiquetaMarca );
        txtMarca = new JTextField( "" );
        panelDatos.add( txtMarca );

        // Imagen
        etiquetaImagen = new JLabel( "Imagen: " );
        panelDatos.add( etiquetaImagen );
        txtImagen = new JTextField( "" );
        botonExaminar = new JButton( "Examinar" );
        botonExaminar.setActionCommand( BUSCAR );
        botonExaminar.addActionListener( this );

        JPanel panelImagen = new JPanel( new GridLayout( 1, 2 ) );
        panelImagen.add( txtImagen );
        panelImagen.add( botonExaminar );
        panelDatos.add( panelImagen );

        // Tipo
        etiquetaTipo = new JLabel( "Tipo: " );
        panelDatos.add( etiquetaTipo );
        cbbTipo = new JComboBox( TIPOS );
        panelDatos.add( cbbTipo );

        // Ao
        etiquetaAnio = new JLabel( "Ao: " );
        panelDatos.add( etiquetaAnio );
        txtAnio = new JTextField( "" );
        panelDatos.add( txtAnio );

        // Cilindrada
        etiquetaCilindrada = new JLabel( "Cilindrada: " );
        panelDatos.add( etiquetaCilindrada );
        txtCilindrada = new JTextField( "" );
        panelDatos.add( txtCilindrada );

        // Ejes
        etiquetaEjes = new JLabel( "Ejes: " );
        panelDatos.add( etiquetaEjes );
        txtEjes = new JTextField( "" );
        panelDatos.add( txtEjes );

        // Valor
        etiquetaValor = new JLabel( "Valor: " );
        panelDatos.add( etiquetaValor );
        txtValor = new JTextField( "" );
        panelDatos.add( txtValor );

        // Botn agregar
        JPanel panelBoton = new JPanel( );
        botonAgregar = new JButton( "Agregar vehiculo" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        panelBoton.add( botonAgregar );

        add( panelDatos, BorderLayout.CENTER );
        add( panelBoton, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Este es el mtodo que se ejecuta cuando se hace click sobre un botn
     * @param evento Es el evento del click sobre el botn - evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( AGREGAR.equals( comando ) )
        {
            try
            {
                String modelo = txtModelo.getText( );
                String marca = txtMarca.getText( );
                String imagen = txtImagen.getText( );
                String tipo = ( String )cbbTipo.getSelectedItem( );
                int anio = Integer.parseInt( txtAnio.getText( ) );
                int cilindrada = Integer.parseInt( txtCilindrada.getText( ) );
                int ejes = Integer.parseInt( txtEjes.getText( ) );
                int valor = Integer.parseInt( txtValor.getText( ) );
                dialogo.agregarVehiculo( modelo, marca, imagen, tipo, anio, cilindrada, ejes, valor );

                txtModelo.setText( "" );
                txtMarca.setText( "" );
                txtImagen.setText( "" );
                txtAnio.setText( "" );
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El ao, la cilindrada, los ejes, y el valor deben ser un nmero entero positivo", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "data" );
            fc.setDialogTitle( "Buscar imagen de vehiculo" );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                String imagen = fc.getSelectedFile( ).getAbsolutePath( );
                txtImagen.setText( imagen );
            }
        }

    }

}
