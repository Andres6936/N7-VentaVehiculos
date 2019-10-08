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

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param iec Es una referencia a la clase principal de la java.vehicle.interfaz - iec != null
     */
    PanelConsultasOperaciones( InterfazVentaVehiculos iec )
    {
        ventanaPrincipal = iec;
        setLayout( new GridBagLayout( ) );

        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Consultas y Operaciones" ) ) );

        JButton botonAgregar = new JButton( "Agregar vehiculo" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 0, 0, 5, 5 );
        add( botonAgregar, gbc );

        JButton botonComprar = new JButton( "Comprar vehiculo" );
        botonComprar.setActionCommand( COMPRAR );
        botonComprar.addActionListener( this );
        gbc.gridy = 1;
        add( botonComprar, gbc );

        JButton botonDisminuirPrecio = new JButton( "Disminuir Precio" );
        botonDisminuirPrecio.setActionCommand( DISMINUIR_PRECIO );
        botonDisminuirPrecio.addActionListener( this );
        gbc.gridx = 1;
        gbc.gridy = 0;
        add( botonDisminuirPrecio, gbc );

        JButton botonMasAntiguo = new JButton( "Ms Antiguo" );
        botonMasAntiguo.setActionCommand( MAS_ANTIGUO );
        botonMasAntiguo.addActionListener( this );
        gbc.gridy = 1;
        add( botonMasAntiguo, gbc );

        JButton botonMasEconomico = new JButton( "Ms Econmico" );
        botonMasEconomico.setActionCommand( MAS_ECONOMICO );
        botonMasEconomico.addActionListener( this );
        gbc.gridx = 2;
        gbc.gridy = 0;
        add( botonMasEconomico, gbc );

        JButton botonMasPotente = new JButton( "Ms Potente" );
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
