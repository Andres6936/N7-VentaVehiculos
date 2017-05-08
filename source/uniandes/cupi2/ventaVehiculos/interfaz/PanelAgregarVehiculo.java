/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAgregarVehiculo.java,v 1.3 2007/04/05 00:31:11 carl-veg Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario S�nchez - 06/12/2005 
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
 * Este es el panel donde se agregan veh�culos
 */
public class PanelAgregarVehiculo extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String AGREGAR = "AgregarVeh�culo";

    private static final String BUSCAR = "BuscarImagen";

    private static final String[] TIPOS = new String[]{ Vehiculo.BUS, Vehiculo.AUTOMOVIL, Vehiculo.CAMION, Vehiculo.MOTOCICLETA };

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al di�logo que contiene el panel
     */
    private DialogoAgregarVehiculo dialogo;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el campo para la ruta hasta la imagen del veh�culo
     */
    private JTextField txtImagen;

    /**
     * Es el campo para el modelo del veh�culo
     */
    private JTextField txtModelo;

    /**
     * Es el campo para la marca del veh�culo
     */
    private JTextField txtMarca;

    /**
     * Es el campo para el a�o del veh�culo
     */
    private JTextField txtAnio;

    /**
     * Es el campo para la cilindrada del veh�culo
     */
    private JTextField txtCilindrada;

    /**
     * Es el campo para el n�mero de ejes del veh�culo
     */
    private JTextField txtEjes;

    /**
     * Es el campo para el valor comercial del veh�culo
     */
    private JTextField txtValor;

    /**
     * El combo para seleccionar el tipo del veh�culo
     */
    private JComboBox cbbTipo;

    /**
     * Es la etiqueta para la imagen del veh�culo
     */
    private JLabel etiquetaImagen;

    /**
     * Es la etiqueta para el modelo del veh�culo
     */
    private JLabel etiquetaModelo;

    /**
     * Es la etiqueta para la marca del veh�culo
     */
    private JLabel etiquetaMarca;

    /**
     * Es la etiqueta donde se muestra el tipo del veh�culo
     */
    private JLabel etiquetaTipo;

    /**
     * Es la etiqueta para el a�o del veh�culo
     */
    private JLabel etiquetaAnio;

    /**
     * Es la etiqueta para la cilindrada del veh�culo
     */
    private JLabel etiquetaCilindrada;

    /**
     * Es la etiqueta para el n�mero de ejes del veh�culo
     */
    private JLabel etiquetaEjes;

    /**
     * Es la etiqueta para el valor comercial del veh�culo
     */
    private JLabel etiquetaValor;

    /**
     * Es el bot�n que se usa para agregar un veh�culo
     */
    private JButton botonAgregar;

    /**
     * Es el bot�n que se usa para examinar el disco buscando la imagen del veh�culo
     */
    private JButton botonExaminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param dav Es una referencia al di�logo que contiene el panel- dav!=null
     */
    public PanelAgregarVehiculo( DialogoAgregarVehiculo dav )
    {
        dialogo = dav;

        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Agregar veh�culo" ) ) );

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

        // A�o
        etiquetaAnio = new JLabel( "A�o: " );
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

        // Bot�n agregar
        JPanel panelBoton = new JPanel( );
        botonAgregar = new JButton( "Agregar Veh�culo" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        panelBoton.add( botonAgregar );

        add( panelDatos, BorderLayout.CENTER );
        add( panelBoton, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Este es el m�todo que se ejecuta cuando se hace click sobre un bot�n
     * @param evento Es el evento del click sobre el bot�n - evento!=null
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
                JOptionPane.showMessageDialog( this, "El a�o, la cilindrada, los ejes, y el valor deben ser un n�mero entero positivo", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen de veh�culo" );
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
