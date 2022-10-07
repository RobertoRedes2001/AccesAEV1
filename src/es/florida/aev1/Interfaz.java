package es.florida.aev1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtRuta;
	private JTextField txtInfoDir;
	private JTextField txtInfoFile;
	private JTextField txtFile;
	private JLabel lblInfoFile;
	private JLabel lblFile;
	private JButton btnCrear;
	private JButton btnRenombrar;
	private JButton btnCopiar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBuscarIReemplaçar;
	private JTextField txtBuscar;
	private JLabel lblBuscar;
	private JLabel lblReemplaçar;
	private JTextField txtReemp;
	private JButton btnBuscar;
	private JButton btnReemplaçar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JButton btnGuardarCanvis;
	private JTextField txtNouNom;
	private JButton btnGuardarNom;
	private JFrame mainFrame; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setTitle("RoBoDoc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1595, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRuta = new JTextField();
		txtRuta.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRuta.setEnabled(false);
		txtRuta.setBounds(315, 30, 779, 33);
		contentPane.add(txtRuta);
		txtRuta.setColumns(10);
		
		JButton btnSeleccionar = new JButton("Seleccionar Ruta");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser seleccion = new JFileChooser(".");
				 btnSeleccionar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int returnVal = seleccion.showOpenDialog(null);
						
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							txtRuta.setText(seleccion.getSelectedFile().getAbsolutePath());
						}
						
					}
				});
			}
		});
		
		
		
		btnSeleccionar.setBounds(1105, 30, 131, 33);
		contentPane.add(btnSeleccionar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(90, 158, 236, 350);
		contentPane.add(scrollPane_1);
		
		txtInfoDir = new JTextField();
		scrollPane_1.setViewportView(txtInfoDir);
		txtInfoDir.setEnabled(false);
		txtInfoDir.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(428, 158, 236, 350);
		contentPane.add(scrollPane);
		
		txtInfoFile = new JTextField();
		scrollPane.setViewportView(txtInfoFile);
		txtInfoFile.setEnabled(false);
		txtInfoFile.setColumns(10);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(760, 158, 389, 350);
		contentPane.add(scrollPane_2);
		
		txtFile = new JTextField();
		txtFile.setEnabled(false);
		scrollPane_2.setViewportView(txtFile);
		txtFile.setColumns(10);
		
		JLabel lblInfoDir = new JLabel("Elements del directori");
		lblInfoDir.setBounds(90, 132, 123, 22);
		contentPane.add(lblInfoDir);
		
		lblInfoFile = new JLabel("Informaci\u00F3 del fitxer");
		lblInfoFile.setBounds(428, 132, 123, 22);
		contentPane.add(lblInfoFile);
		
		lblFile = new JLabel("Contingut del fitxer");
		lblFile.setBounds(760, 132, 123, 22);
		contentPane.add(lblFile);
		
		btnCrear = new JButton("Nou document");
		btnCrear.setBounds(376, 643, 113, 33);
		contentPane.add(btnCrear);
		
		btnRenombrar = new JButton("Renombrar");
		btnRenombrar.setBounds(528, 643, 113, 33);
		contentPane.add(btnRenombrar);
		
		btnCopiar = new JButton("Copiar");
		btnCopiar.setBounds(693, 643, 113, 33);
		contentPane.add(btnCopiar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(838, 643, 113, 33);
		contentPane.add(btnEliminar);
		
		btnEditar = new JButton("Editar document");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(1223, 158, 130, 33);
		contentPane.add(btnEditar);
		
		btnBuscarIReemplaçar = new JButton("Buscar i reempla\u00E7ar");
		btnBuscarIReemplaçar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarIReemplaçar.setBounds(1363, 158, 179, 33);
		contentPane.add(btnBuscarIReemplaçar);
		
		txtBuscar = new JTextField();
		txtBuscar.setEnabled(false);
		txtBuscar.setBounds(1223, 298, 179, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setEnabled(false);
		lblBuscar.setBounds(1289, 219, 61, 14);
		contentPane.add(lblBuscar);
		
		lblReemplaçar = new JLabel("Reempla\u00E7ar");
		lblReemplaçar.setEnabled(false);
		lblReemplaçar.setBounds(1278, 273, 61, 14);
		contentPane.add(lblReemplaçar);
		
		txtReemp = new JTextField();
		txtReemp.setEnabled(false);
		txtReemp.setColumns(10);
		txtReemp.setBounds(1223, 244, 179, 20);
		contentPane.add(txtReemp);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(1453, 244, 89, 23);
		contentPane.add(btnBuscar);
		
		btnReemplaçar = new JButton("Reempla\u00E7ar");
		btnReemplaçar.setEnabled(false);
		btnReemplaçar.setBounds(1453, 297, 89, 23);
		contentPane.add(btnReemplaçar);
		
		btnGuardarCanvis = new JButton("Guardar canvis");
		btnGuardarCanvis.setEnabled(false);
		btnGuardarCanvis.setBounds(1289, 347, 123, 33);
		contentPane.add(btnGuardarCanvis);
		
		txtNouNom = new JTextField();
		txtNouNom.setBounds(487, 566, 341, 33);
		contentPane.add(txtNouNom);
		txtNouNom.setColumns(10);
		
		btnGuardarNom = new JButton("Renombrar");
		btnGuardarNom.setBounds(838, 566, 113, 33);
		contentPane.add(btnGuardarNom);
	}
}
