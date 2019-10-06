/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelConsultasOperaciones.java,v 1.4 2007/04/05 00:41:15 carl-veg Exp $ 
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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con diferentes operaciones y consultas sobre la venta de vehiculos
 */
public class PanelConsultasOperaciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String AGREGAR = "Agregarvehiculo";

    private static final String COMPRAR = "ComprarVehiculo";

    private static final String MAS_ANTIGUO = "MasAntiguo";

    private static final String MAS_ECONOMICO = "MasEconomico";

    private static final String MAS_POTENTE = "MasPotente";

    private static final String DISMINUIR_PRECIO = "DisminuirPrecio";

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
     * Es el botn que se usa para agregar un vehiculo
     */
    private JButton botonAgregar;

    /**
     * Es el botn que se usa para buscar el vehiculo mas antiguo
     */
    private JButton botonMasAntiguo;

    /**
     * Es el botn que se usa para buscar el vehiculo mas antiguo
     */
    private JButton botonMasEconomico;

    /**
     * Es el botn que se usa para buscar el vehiculo mas potente
     */
    private JButton botonMasPotente;

    /**
     * Es el botn que se usa para disminuir el precio de los vehiculos
     */
    private JButton botonDisminuirPrecio;

    /**
     * Es el botn que se usa para comprar un vehiculo
     */
    private JButton botonComprar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param iec Es una referencia a la clase principal de la java.vehicle.interfaz - iec != null
     */
    public PanelConsultasOperaciones( InterfazVentaVehiculos iec )
    {
        ventanaPrincipal = iec;
        setLayout( new GridBagLayout( ) );

        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Consultas y Operaciones" ) ) );

        botonAgregar = new JButton( "Agregar vehiculo" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 0, 0, 5, 5 );
        add( botonAgregar, gbc );

        botonComprar = new JButton( "Comprar vehiculo" );
        botonComprar.setActionCommand( COMPRAR );
        botonComprar.addActionListener( this );
        gbc.gridy = 1;
        add( botonComprar, gbc );

        botonDisminuirPrecio = new JButton( "Disminuir Precio" );
        botonDisminuirPrecio.setActionCommand( DISMINUIR_PRECIO );
        botonDisminuirPrecio.addActionListener( this );
        gbc.gridx = 1;
        gbc.gridy = 0;
        add( botonDisminuirPrecio, gbc );

        botonMasAntiguo = new JButton( "Ms Antiguo" );
        botonMasAntiguo.setActionCommand( MAS_ANTIGUO );
        botonMasAntiguo.addActionListener( this );
        gbc.gridy = 1;
        add( botonMasAntiguo, gbc );

        botonMasEconomico = new JButton( "Ms Econmico" );
        botonMasEconomico.setActionCommand( MAS_ECONOMICO );
        botonMasEconomico.addActionListener( this );
        gbc.gridx = 2;
        gbc.gridy = 0;
        add( botonMasEconomico, gbc );

        botonMasPotente = new JButton( "Ms Potente" );
        botonMasPotente.setActionCommand( MAS_POTENTE );
        botonMasPotente.addActionListener( this );
        gbc.gridy = 1;
        add( botonMasPotente, gbc );
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

        if( AGREGAR.equals( comando ) )
        {
            ventanaPrincipal.mostrarDialogoAgregarVehiculo( );
        }
        else if( MAS_ANTIGUO.equals( comando ) )
        {
            ventanaPrincipal.buscarMasAntiguo( );
        }
        else if( MAS_ECONOMICO.equals( comando ) )
        {
            ventanaPrincipal.buscarMasEconomico( );
        }
        else if( MAS_POTENTE.equals( comando ) )
        {
            ventanaPrincipal.buscarMasPotente( );
        }
        else if( COMPRAR.equals( comando ) )
        {
            ventanaPrincipal.comprarVehiculo( );
        }
        else if( DISMINUIR_PRECIO.equals( comando ) )
        {
            ventanaPrincipal.disminuirPrecio( );
        }
    }
}
