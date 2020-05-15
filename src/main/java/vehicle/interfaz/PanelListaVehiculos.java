package vehicle.interfaz;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vehicle.mundo.Vehicle;

/**
 * Es el panel donde se muestra la lista de vehiculos
 */
public class PanelListaVehiculos extends JPanel implements ListSelectionListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la java.vehicle.interfaz
     */
    private final InterfazVentaVehiculos ventanaPrincipal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la lista que se muestra
     */
    private final JList<Vehicle> listaVehiculos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param iec Es una referencia a la clase principal de la java.vehicle.interfaz - iec != null
     */
    PanelListaVehiculos( InterfazVentaVehiculos iec )
    {
        ventanaPrincipal = iec;

        setLayout( new BorderLayout( ) );

        JPanel panelBorder = new JPanel( );
        panelBorder.setLayout(new BorderLayout());
        panelBorder.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new TitledBorder("Outlet Vehicle")));

        listaVehiculos = new JList<>();
        listaVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaVehiculos.addListSelectionListener( this );

        JScrollPane scroll = new JScrollPane( );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new LineBorder(Color.LIGHT_GRAY, 1)));
        scroll.getViewport().add(listaVehiculos);

        panelBorder.add( scroll, BorderLayout.CENTER );
        add( panelBorder, BorderLayout.CENTER );

        setSize(new Dimension(250, 200));
    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de vehiculos que se est mostrando
     *
     * @param listaActualizadaVehiculos Es una lista con los vehiculos que deben mostrarse
     */
    void actualizarLista(ArrayList<Vehicle> listaActualizadaVehiculos)
    {
        listaVehiculos.setListData(new Vector<>(listaActualizadaVehiculos));
        listaVehiculos.setSelectedIndex(0);

    }

    /**
     * Selecciona un elemento de la lista
     * @param seleccionado La posicin del elemento que se debe seleccionar
     */
    void seleccionar( int seleccionado )
    {
        listaVehiculos.setSelectedIndex( seleccionado );
        listaVehiculos.ensureIndexIsVisible( seleccionado );
    }

    /**
     * Retorna el vehiculo seleccionado de la lista
     *
     * @return Se retorn el vehiculo seleccionado de la lista. Si no hay vehiculo seleccionado se retorn null
     */
    Vehicle darVehiculoSeleccionado()
    {
        Vehicle vSeleccionado = null;

        if (listaVehiculos.getSelectedValue() != null) {
            vSeleccionado = (Vehicle)listaVehiculos.getSelectedValue();
        }

        return vSeleccionado;
    }

    /**
     * Cambia la informacin del aspirante que se esta mostrando de acuerdo al nuevo aspirante seleccionado
     * @param e El evento de cambio del tem seleccionado en la lista. evento!=null
     */
    public void valueChanged( ListSelectionEvent e )
    {
        if( listaVehiculos.getSelectedValue( ) != null ) {
            Vehicle vehicle = (Vehicle)listaVehiculos.getSelectedValue();
            ventanaPrincipal.verDatos(vehicle);
        }

    }
}