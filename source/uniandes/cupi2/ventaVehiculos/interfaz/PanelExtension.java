/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java,v 1.3 2007/04/05 00:41:15 carl-veg Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario Sánchez - 25/08/2005 
 * Autor: Daniel Romero - 17-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.ventaVehiculos.interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Es el panel que contiene los botones de extensión
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para el botón 1
     */
    private final String OPCION_1 = "opcion 1";

    /**
     * El comando para el botón 2
     */
    private final String OPCION_2 = "opcion 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la interfaz de la aplicación
     */
    private InterfazVentaVehiculos ventanaPrincipal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el botón 1
     */
    private JButton botonOpcion1;

    /**
     * Es el botón 2
     */
    private JButton botonOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con una referencia a la ventana principal de la aplicación
     * @param iec Referencia a la ventana principal - ie!=null
     */
    public PanelExtension( InterfazVentaVehiculos iec )
    {
        ventanaPrincipal = iec;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa los componentes del panel
     */
    private void inicializar( )
    {
        setBorder( new TitledBorder( "Puntos de Extensión" ) );

        setLayout( new FlowLayout( ) );
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );

        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );

        add( botonOpcion1 );
        add( botonOpcion2 );
    }

    /**
     * Este método se llama cuando se presiona uno de los botones
     * @param evento El evento del click en el botón - evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            ventanaPrincipal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            ventanaPrincipal.reqFuncOpcion2( );
        }
    }

}
