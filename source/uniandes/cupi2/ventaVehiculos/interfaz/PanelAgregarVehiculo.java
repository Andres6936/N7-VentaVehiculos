/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAgregarVehiculo.java,v 1.3 2007/04/05 00:31:11 carl-veg Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
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

import uniandes.cupi2.ventaVehiculos.mundo.Vehiculo;

/**
 * Este es el panel donde se agregan vehículos
 */
public class PanelAgregarVehiculo extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String AGREGAR = "AgregarVehículo";

    private static final String BUSCAR = "BuscarImagen";

    private static final String[] TIPOS = new String[]{ Vehiculo.BUS, Vehiculo.AUTOMOVIL, Vehiculo.CAMION, Vehiculo.MOTOCICLETA };

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al diálogo que contiene el panel
     */
    private DialogoAgregarVehiculo dialogo;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el campo para la ruta hasta la imagen del vehículo
     */
    private JTextField txtImagen;

    /**
     * Es el campo para el modelo del vehículo
     */
    private JTextField txtModelo;

    /**
     * Es el campo para la marca del vehículo
     */
    private JTextField txtMarca;

    /**
     * Es el campo para el año del vehículo
     */
    private JTextField txtAnio;

    /**
     * Es el campo para la cilindrada del vehículo
     */
    private JTextField txtCilindrada;

    /**
     * Es el campo para el número de ejes del vehículo
     */
    private JTextField txtEjes;

    /**
     * Es el campo para el valor comercial del vehículo
     */
    private JTextField txtValor;

    /**
     * El combo para seleccionar el tipo del vehículo
     */
    private JComboBox cbbTipo;

    /**
     * Es la etiqueta para la imagen del vehículo
     */
    private JLabel etiquetaImagen;

    /**
     * Es la etiqueta para el modelo del vehículo
     */
    private JLabel etiquetaModelo;

    /**
     * Es la etiqueta para la marca del vehículo
     */
    private JLabel etiquetaMarca;

    /**
     * Es la etiqueta donde se muestra el tipo del vehículo
     */
    private JLabel etiquetaTipo;

    /**
     * Es la etiqueta para el año del vehículo
     */
    private JLabel etiquetaAnio;

    /**
     * Es la etiqueta para la cilindrada del vehículo
     */
    private JLabel etiquetaCilindrada;

    /**
     * Es la etiqueta para el número de ejes del vehículo
     */
    private JLabel etiquetaEjes;

    /**
     * Es la etiqueta para el valor comercial del vehículo
     */
    private JLabel etiquetaValor;

    /**
     * Es el botón que se usa para agregar un vehículo
     */
    private JButton botonAgregar;

    /**
     * Es el botón que se usa para examinar el disco buscando la imagen del vehículo
     */
    private JButton botonExaminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param dav Es una referencia al diálogo que contiene el panel- dav!=null
     */
    public PanelAgregarVehiculo( DialogoAgregarVehiculo dav )
    {
        dialogo = dav;

        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Agregar vehículo" ) ) );

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

        // Año
        etiquetaAnio = new JLabel( "Año: " );
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

        // Botón agregar
        JPanel panelBoton = new JPanel( );
        botonAgregar = new JButton( "Agregar Vehículo" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        panelBoton.add( botonAgregar );

        add( panelDatos, BorderLayout.CENTER );
        add( panelBoton, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este es el método que se ejecuta cuando se hace click sobre un botón
     * @param evento Es el evento del click sobre el botón - evento!=null
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
                JOptionPane.showMessageDialog( this, "El año, la cilindrada, los ejes, y el valor deben ser un número entero positivo", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen de vehículo" );
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
