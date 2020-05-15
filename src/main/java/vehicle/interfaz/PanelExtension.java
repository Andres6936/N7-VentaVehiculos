package vehicle.interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Es el panel que contiene los botones de extensin
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para el botn 1
     */
    private final String OPCION_1 = "opcion 1";

    /**
     * El comando para el botn 2
     */
    private final String OPCION_2 = "opcion 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la java.vehicle.interfaz de la aplicacin
     */
    private final InterfazVentaVehiculos ventanaPrincipal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con una referencia a la ventana principal de la aplicacin
     * @param iec Referencia a la ventana principal - ie!=null
     */
    PanelExtension( InterfazVentaVehiculos iec )
    {
        ventanaPrincipal = iec;
        setBorder(new TitledBorder("Extension Point"));
        setLayout(new FlowLayout());

        JButton botonOpcion1 = new JButton("Option One");
        botonOpcion1.setActionCommand(OPCION_1);
        botonOpcion1.addActionListener(this);

        JButton botonOpcion2 = new JButton("Option Two");
        botonOpcion2.setActionCommand(OPCION_2);
        botonOpcion2.addActionListener(this);

        add(botonOpcion1);
        add(botonOpcion2);
    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Este mtodo se llama cuando se presiona uno de los botones
     * @param evento El evento del click en el botn - evento!=null
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
