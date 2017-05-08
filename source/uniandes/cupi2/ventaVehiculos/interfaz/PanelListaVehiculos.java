/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelListaVehiculos.java,v 1.6 2007/04/05 00:41:15 carl-veg Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
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
import java.awt.Color;
import java.util.ArrayList;

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

import uniandes.cupi2.ventaVehiculos.mundo.Vehiculo;

/**
 * Es el panel donde se muestra la lista de vehículos
 */
public class PanelListaVehiculos extends JPanel implements ListSelectionListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazVentaVehiculos ventanaPrincipal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la lista que se muestra
     */
    private JList listaVehiculos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param iec Es una referencia a la clase principal de la interfaz - iec != null
     */
    public PanelListaVehiculos( InterfazVentaVehiculos iec )
    {
        ventanaPrincipal = iec;
        setLayout( new BorderLayout( ) );

        JPanel panelListaYBotones = new JPanel( );
        panelListaYBotones.setLayout( new BorderLayout( ) );
        panelListaYBotones.setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Vehículos a la Venta" ) ) );

        listaVehiculos = new JList( );
        listaVehiculos.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaVehiculos.addListSelectionListener( this );

        JScrollPane scroll = new JScrollPane( );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        scroll.getViewport( ).add( listaVehiculos );

        panelListaYBotones.add( scroll, BorderLayout.CENTER );
        add( panelListaYBotones, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de vehículos que se está mostrando
     * @param listaActualizadaVehiculos Es una lista con los vehículos que deben mostrarse
     */
    public void actualizarLista( ArrayList listaActualizadaVehiculos )
    {
        listaVehiculos.setListData( listaActualizadaVehiculos.toArray( ) );
        listaVehiculos.setSelectedIndex( 0 );

    }

    /**
     * Selecciona un elemento de la lista
     * @param seleccionado La posición del elemento que se debe seleccionar
     */
    public void seleccionar( int seleccionado )
    {
        listaVehiculos.setSelectedIndex( seleccionado );
        listaVehiculos.ensureIndexIsVisible( seleccionado );
    }

    /**
     * Informa si hay algún índice seleccionado en la lista de vehiculos.
     * @return true si hay un ítem seleccionado, false de lo contrario
     */
    public boolean haySeleccionado( )
    {
        return !listaVehiculos.isSelectionEmpty( );
    }

    /**
     * Retorna el vehiculo seleccionado de la lista
     * @return Se retornó el vehiculo seleccionado de la lista. Si no hay vehículo seleccionado se retornó null
     */
    public Vehiculo darVehiculoSeleccionado( )
    {
        Vehiculo vSeleccionado = null;

        if( listaVehiculos.getSelectedValue( ) != null )
        {
            vSeleccionado = ( Vehiculo )listaVehiculos.getSelectedValue( );
        }

        return vSeleccionado;
    }

    /**
     * Cambia la información del aspirante que se esta mostrando de acuerdo al nuevo aspirante seleccionado
     * @param e El evento de cambio del ítem seleccionado en la lista. evento!=null
     */
    public void valueChanged( ListSelectionEvent e )
    {
        if( listaVehiculos.getSelectedValue( ) != null )
        {
            Vehiculo vehiculo = ( Vehiculo )listaVehiculos.getSelectedValue( );
            ventanaPrincipal.verDatos( vehiculo );
        }

    }
}