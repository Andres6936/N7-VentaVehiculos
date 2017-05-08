/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoAgregarVehiculo.java,v 1.4 2007/04/05 00:31:11 carl-veg Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_ventaVehiculos 
 * Autor: Mario S�nchez - 6/12/2005 
 * Autor: Daniel Romero - 17-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.ventaVehiculos.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

/**
 * Este es el di�logo usado para agregar un veh�culo
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
     * Es el panel que se usa para introducir los datos del veh�culo
     */
    private PanelAgregarVehiculo panelAgregar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el di�logo e inicializa los componentes
     * @param ecv Es una referencia a la ventana principal de la interfaz
     */
    public DialogoAgregarVehiculo( InterfazVentaVehiculos ecv )
    {
        super( ecv, true );
        ventanaPrincipal = ecv;

        setLayout( new BorderLayout( ) );

        panelAgregar = new PanelAgregarVehiculo( this );
        add( panelAgregar );

        setTitle( "Agregar Veh�culo" );
        pack( );

        centrar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Centra el di�logo en la pantalla
     */
    private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }

    /**
     * Agrega un nuevo veh�culo
     * @param modeloV El modelo del veh�culo - modeloV != null
     * @param marcaV La marca del veh�culo - marcaV != null
     * @param imagenV La ruta a la imagen del veh�culo - imagenP != null
     * @param tipoV El tipo de veh�culo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El a�o del veh�culo - anioV > 0
     * @param cilindradaV La cilindrada del veh�culo - cilindradaV > 0
     * @param ejesV El n�mero de ejes del veh�culo - ejesV > 0
     * @param valorV El valor del veh�culo - valorV > 0
     */
    public void agregarVehiculo( String modeloV, String marcaV, String imagenV, String tipoV, int anioV, int cilindradaV, int ejesV, int valorV )
    {
        ventanaPrincipal.agregarVehiculo( this, modeloV, marcaV, imagenV, tipoV, anioV, cilindradaV, ejesV, valorV );
    }
}
