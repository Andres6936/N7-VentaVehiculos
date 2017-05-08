/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoAgregarVehiculo.java,v 1.4 2007/04/05 00:31:11 carl-veg Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario Sánchez - 6/12/2005 
 * Autor: Daniel Romero - 17-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.ventaVehiculos.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

/**
 * Este es el diálogo usado para agregar un vehículo
 */
public class DialogoAgregarVehiculo extends JDialog
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
     * Es el panel que se usa para introducir los datos del vehículo
     */
    private PanelAgregarVehiculo panelAgregar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo e inicializa los componentes
     * @param ecv Es una referencia a la ventana principal de la interfaz
     */
    public DialogoAgregarVehiculo( InterfazVentaVehiculos ecv )
    {
        super( ecv, true );
        ventanaPrincipal = ecv;

        setLayout( new BorderLayout( ) );

        panelAgregar = new PanelAgregarVehiculo( this );
        add( panelAgregar );

        setTitle( "Agregar Vehículo" );
        pack( );

        centrar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Centra el diálogo en la pantalla
     */
    private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }

    /**
     * Agrega un nuevo vehículo
     * @param modeloV El modelo del vehículo - modeloV != null
     * @param marcaV La marca del vehículo - marcaV != null
     * @param imagenV La ruta a la imagen del vehículo - imagenP != null
     * @param tipoV El tipo de vehículo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El año del vehículo - anioV > 0
     * @param cilindradaV La cilindrada del vehículo - cilindradaV > 0
     * @param ejesV El número de ejes del vehículo - ejesV > 0
     * @param valorV El valor del vehículo - valorV > 0
     */
    public void agregarVehiculo( String modeloV, String marcaV, String imagenV, String tipoV, int anioV, int cilindradaV, int ejesV, int valorV )
    {
        ventanaPrincipal.agregarVehiculo( this, modeloV, marcaV, imagenV, tipoV, anioV, cilindradaV, ejesV, valorV );
    }
}
