package vehicle.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

/**
 * Este es el dilogo usado para agregar un vehiculo
 */
public class DialogoAgregarVehiculo extends JDialog
{
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
     * Es el panel que se usa para introducir los datos del vehiculo
     */
    private PanelAgregarVehiculo panelAgregar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el dilogo e inicializa los componentes
     * @param ecv Es una referencia a la ventana principal de la java.vehicle.interfaz
     */
    public DialogoAgregarVehiculo( InterfazVentaVehiculos ecv )
    {
        super( ecv, true );
        ventanaPrincipal = ecv;

        setLayout( new BorderLayout( ) );

        panelAgregar = new PanelAgregarVehiculo( this );
        add( panelAgregar );

        setTitle( "Agregar vehiculo" );
        pack( );

        centrar( );
    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Centra el dilogo en la pantalla
     */
    private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }

    /**
     * Agrega un nuevo vehiculo
     * @param modeloV El modelo del vehiculo - modeloV != null
     * @param marcaV La marca del vehiculo - marcaV != null
     * @param imagenV La ruta a la imagen del vehiculo - imagenP != null
     * @param tipoV El tipo de vehiculo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El ao del vehiculo - anioV > 0
     * @param cilindradaV La cilindrada del vehiculo - cilindradaV > 0
     * @param ejesV El nmero de ejes del vehiculo - ejesV > 0
     * @param valorV El valor del vehiculo - valorV > 0
     */
    public void agregarVehiculo( String modeloV, String marcaV, String imagenV, String tipoV, int anioV, int cilindradaV, int ejesV, int valorV )
    {
        ventanaPrincipal.agregarVehiculo( this, modeloV, marcaV, imagenV, tipoV, anioV, cilindradaV, ejesV, valorV );
    }
}
