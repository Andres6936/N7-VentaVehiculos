package vehicle.interfaz;

import vehicle.mundo.TypeVehicle;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Este es el panel donde se agregan vehiculos
 */
public class PanelAgregarVehiculo extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String AGREGAR = "Agregarvehiculo";

    private static final String BUSCAR = "BuscarImagen";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al dilogo que contiene el panel
     */
    private final DialogoAgregarVehiculo dialogo;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el campo para la ruta hasta la imagen del vehiculo
     */
    private final JTextField txtImagen;

    /**
     * Es el campo para el modelo del vehiculo
     */
    private final JTextField txtModelo;

    /**
     * Es el campo para la marca del vehiculo
     */
    private final JTextField txtMarca;

    /**
     * Es el campo para el ao del vehiculo
     */
    private final JTextField txtAnio;

    /**
     * Es el campo para la cilindrada del vehiculo
     */
    private final JTextField txtCilindrada;

    /**
     * Es el campo para el nmero de ejes del vehiculo
     */
    private final JTextField txtEjes;

    /**
     * Es el campo para el valor comercial del vehiculo
     */
    private final JTextField txtValor;

    /**
     * El combo para seleccionar el tipo del vehiculo
     */
    private final JComboBox<TypeVehicle> cbbTipo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param dav Es una referencia al dilogo que contiene el panel- dav!=null
     */
    public PanelAgregarVehiculo( DialogoAgregarVehiculo dav )
    {
        dialogo = dav;

        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new EmptyBorder(4, 3, 3, 3), new TitledBorder("Agregar vehiculo")));

        JPanel panelDatos = new JPanel(new GridLayout(8, 2));

        // Modelo
        JLabel etiquetaModelo = new JLabel("Modelo: ");
        panelDatos.add(etiquetaModelo);
        txtModelo = new JTextField("");
        panelDatos.add(txtModelo);

        // Marca
        JLabel etiquetaMarca = new JLabel("Marca: ");
        panelDatos.add(etiquetaMarca);
        txtMarca = new JTextField("");
        panelDatos.add(txtMarca);

        // Imagen
        JLabel etiquetaImagen = new JLabel("Imagen: ");
        panelDatos.add(etiquetaImagen);
        txtImagen = new JTextField("");

        JButton botonExaminar = new JButton("Examinar");
        botonExaminar.setActionCommand(BUSCAR);
        botonExaminar.addActionListener(this);

        JPanel panelImagen = new JPanel(new GridLayout(1, 2));
        panelImagen.add(txtImagen);
        panelImagen.add(botonExaminar);
        panelDatos.add(panelImagen);

        // Tipo
        JLabel etiquetaTipo = new JLabel("Tipo: ");
        panelDatos.add(etiquetaTipo);
        cbbTipo = new JComboBox<>(TypeVehicle.values());
        panelDatos.add(cbbTipo);

        // Ao

        JLabel etiquetaAnio = new JLabel("Ao: ");
        panelDatos.add(etiquetaAnio);
        txtAnio = new JTextField("");
        panelDatos.add(txtAnio);

        // Cilindrada
        JLabel etiquetaCilindrada = new JLabel("Cilindrada: ");
        panelDatos.add(etiquetaCilindrada);
        txtCilindrada = new JTextField("");
        panelDatos.add(txtCilindrada);

        // Ejes
        JLabel etiquetaEjes = new JLabel("Ejes: ");
        panelDatos.add(etiquetaEjes);
        txtEjes = new JTextField("");
        panelDatos.add(txtEjes);

        // Valor
        JLabel etiquetaValor = new JLabel("Valor: ");
        panelDatos.add(etiquetaValor);
        txtValor = new JTextField("");
        panelDatos.add(txtValor);

        // Botn agregar
        JPanel panelBoton = new JPanel();

        JButton botonAgregar = new JButton("Agregar vehiculo");
        botonAgregar.setActionCommand(AGREGAR);
        botonAgregar.addActionListener(this);
        panelBoton.add(botonAgregar);

        add(panelDatos, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    // -----------------------------------------------------------------
    // Mtodos
    // -----------------------------------------------------------------

    /**
     * Este es el mtodo que se ejecuta cuando se hace click sobre un botn
     *
     * @param event Es el evento del click sobre el botn - evento!=null
     */
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();

        if (AGREGAR.equals(command)) {
            try {
                String modelo = txtModelo.getText();
                String marca = txtMarca.getText();
                String imagen = txtImagen.getText();

                TypeVehicle type = (TypeVehicle)cbbTipo.getSelectedItem();

                int anio = Integer.parseInt(txtAnio.getText());
                int cilindrada = Integer.parseInt(txtCilindrada.getText());
                int ejes = Integer.parseInt(txtEjes.getText());
                int valor = Integer.parseInt( txtValor.getText( ) );
                dialogo.agregarVehiculo(modelo, marca, imagen, type, anio, cilindrada, ejes, valor );

                txtModelo.setText("");
                txtMarca.setText("");
                txtImagen.setText("");
                txtAnio.setText("");
            } catch (NumberFormatException e) {
                String message = "The year, displacement, axes, and the value should be a number greater that 0.";
                JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else
            if (BUSCAR.equals(command)) {
                JFileChooser fc = new JFileChooser("data");
                fc.setDialogTitle("Buscar imagen de vehiculo");
                fc.setMultiSelectionEnabled(false);

                int resultado = fc.showOpenDialog(this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    String imagen = fc.getSelectedFile().getAbsolutePath();
                    txtImagen.setText(imagen );
            }
        }

    }

}
