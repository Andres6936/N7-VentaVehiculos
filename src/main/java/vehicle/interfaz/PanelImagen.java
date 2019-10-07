package vehicle.interfaz;

import java.awt.*;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Es el panel donde se muestra una imagen decorativa
 */
class PanelImagen extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     */
    PanelImagen( )
    {
        Image imageIcon = new ImageIcon( getFileFromResource( ) ).getImage( );
        Image scaleIcon = imageIcon.getScaledInstance( 800, 100, Image.SCALE_SMOOTH );

        JLabel imagen = new JLabel( );
        imagen.setIcon( new ImageIcon( scaleIcon ) );

        add( imagen );

        setMinimumSize( new Dimension( 800, 100 ) );
        setBorder( new LineBorder( Color.GRAY ) );
    }

    /**
     * Método utilizado para cargar archivos desde el directorio /resource, es decir,
     * la estructura de proyectos basados en Maven y Gradle.
     *
     * @return Referencia al archivo.
     */
    private URL getFileFromResource( )
    {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource( "data/titulo.png" );

        if (resource == null)
        {
            throw new IllegalArgumentException( "File is not found." );
        }
        else
        {
            return resource;
        }
    }
}