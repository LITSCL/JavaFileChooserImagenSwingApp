package cl.inacap.javafilechooserimagenswingapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class StartFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textImagenSeleccionada;
	private JButton btnSeleccionarImagen;
	private JLabel lblVisualizacionImagenSeleccionada;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setTitle("JavaFileChooserImagenSwingApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ruta");
		lblNewLabel.setBounds(10, 33, 39, 14);
		contentPane.add(lblNewLabel);
		
		textImagenSeleccionada = new JTextField();
		textImagenSeleccionada.setBounds(38, 30, 200, 20);
		contentPane.add(textImagenSeleccionada);
		textImagenSeleccionada.setColumns(10);
		
		btnSeleccionarImagen = new JButton("Seleccionar");
		btnSeleccionarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser archivo = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Imagen (*.PNG,*.JPG,*.JPEG)", "png", "jpg", "jpeg");
				archivo.addChoosableFileFilter(filtro); //Se le añade el filtro al JFileChooser (Para que al usuario se le sea mas fácil buscar una imagen).
				archivo.setDialogTitle("Busque la imagen");
				int ventana = archivo.showOpenDialog(null); //Esta instrucción habre la ventana que permite seleccionar el archivo.
				if (ventana == JFileChooser.APPROVE_OPTION) { //Aca se esta consultando si el usuario le dio click al boton "Abrir" (En el caso de que lo haya hecho se ejecuta el código).
					File fi = archivo.getSelectedFile(); //Esta instrucción contiene la ruta del archivo.
					textImagenSeleccionada.setText(String.valueOf(fi)); //Se modifica el texto con la ruta seleccionada (También se puede utilizar el toString para refindir el dato).
					
					Image imagen = getToolkit().getImage(textImagenSeleccionada.getText());
					imagen = imagen.getScaledInstance(140, 140, Image.SCALE_DEFAULT); //Se establece el tamaño de la imagen (Deben ser las mismas dimensiones que el label).
					lblVisualizacionImagenSeleccionada.setIcon(new ImageIcon(imagen)); //Se añade la imagen al label para que se muestre.
				}
			}
		});
		btnSeleccionarImagen.setBounds(248, 29, 104, 23);
		contentPane.add(btnSeleccionarImagen);
		
		lblVisualizacionImagenSeleccionada = new JLabel("");
		lblVisualizacionImagenSeleccionada.setBounds(10, 83, 140, 140);
		contentPane.add(lblVisualizacionImagenSeleccionada);
		
		lblNewLabel_1 = new JLabel("Visualizaci\u00F3n");
		lblNewLabel_1.setBounds(10, 58, 104, 14);
		contentPane.add(lblNewLabel_1);
	}
}
