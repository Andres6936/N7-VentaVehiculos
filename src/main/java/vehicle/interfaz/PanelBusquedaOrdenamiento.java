/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelBusquedaOrdenamiento.java,v 1.5 2007/04/05 00:31:11 carl-veg Exp $ 
 * Universidad de los Andes (Bogot - Colombia)
 * Departamento de Ingeniera de Sistemas y Computacin
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos
 * Autor: Daniel Romero - 17-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package vehicle.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con las operaciones de bsqueda y ordenamiento sobre la venta de vehiculos
 */
public class PanelBusquedaOrdenamiento extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String BUSCAR = "Buscar";

    private static final String ORDENAR_CILINDRADA = "OrdenarCilindrada";

    private static final String ORDENAR_ANIO = "OrdenarAo";

    private static final String ORDENAR_MARCA = "OrdenarMarca";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la java.vehicle.interfaz
     */
    private InterfazVentaVehiculos ventanaPrincipal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el botn para ordenar la lista de vehiculos por marca
     */
    private JButton botonOrdenarMarca;

    /**
     * Es el botn para ordenar la lista de vehiculos por cilindrada
     */
    private JButton botonOrdenarCilindrada;

    /**
     * Es el botn para ordenar la lista de vehiculos por ao
     */
    private JButton botonOrdenarAnio;

    /**
     * Es el botn para realizar una bsqueda
     */
    private JButton botonBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param iec Es una referencia a la clase principal de la java.vehicle.interfaz - iec != null
     */
    public PanelBusquedaOrdenamiento( InterfazVentaVehiculos iec )
    {
        ventanaPrincipal = iec;
        setLayout( new GridBagLayout( ) );

        setBorder( new TitledBorder( "Bsqueda y Ordenamientos" ) );

        botonOrdenarMarca = new JButton( "Ordenar por Marca" );
        botonOrdenarMarca.setActionCommand( ORDENAR_MARCA );
        botonOrdenarMarca.addActionListener( this );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 3, 3, 3, 3 );
        add( botonOrdenarMarca, gbc );

        botonOrdenarAnio = new JButton( "Ordenar por Ao" );
        botonOrdenarAnio.setActionCommand( ORDENAR_ANIO );
        botonOrdenarAnio.addActionListener( this );
        gbc.gridy = 1;
        add( botonOrdenarAnio, gbc );

        botonOrdenarCilindrada = new JButton( "Ordenar por Cilindrada" );
        botonOrdenarCilindrada.setActionCommand( ORDENAR_CILINDRADA );
        botonOrdenarCilindrada.addActionListener( this );
        gbc.gridx = 1;
        gbc.gridy = 0;
        add( botonOrdenarCilindrada, gbc );

        botonBuscar = new JButton( "Buscar vehiculo" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );
        gbc.gridy = 1;
        add( botonBuscar, gbc );

    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una accin segn el botn que se haya presionado
     * @param evento El evento de click sobre un botn - evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( ORDENAR_MARCA.equals( comando ) )
        {
            ventanaPrincipal.ordenarPorMarca( );
        }
        else if( ORDENAR_CILINDRADA.equals( comando ) )
        {
            ventanaPrincipal.ordenarPorCilindrada( );
        }
        else if( ORDENAR_ANIO.equals( comando ) )
        {
            ventanaPrincipal.ordenarPorAnio( );
        }
        else if( BUSCAR.equals( comando ) )
        {
            ventanaPrincipal.buscar( );
        }
    }
}
