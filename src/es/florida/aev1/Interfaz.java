package es.florida.aev1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtRuta;
	private JLabel lblInfoFile;
	private JLabel lblFile;
	private JButton btnCrear;
	private JButton btnRenombrar;
	private JButton btnCopiar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBuscarIReemplazar;
	private JTextField txtBuscar;
	private JLabel lblBuscar;
	private JLabel lblReemplaçar;
	private JTextField txtReemplazar;
	private JButton btnBuscar;
	private JButton btnReemplazar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_2;
	private JButton btnGuardarCanvis;
	private JTextField txtNouNom;
	private JButton btnGuardarNom;
	private JFrame mainFrame; 
	DefaultListModel <String> listaElements;
	private JList <String> list;

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
		setBounds(100, 100, 1391, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRuta = new JTextField();
		txtRuta.setBounds(340, 71, 477, 33);
		txtRuta.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRuta.setEnabled(false);
		contentPane.add(txtRuta);
		txtRuta.setColumns(10);
		
		
		JButton btnSeleccionar = new JButton("Seleccionar Ruta");
		btnSeleccionar.setBounds(839, 73, 131, 33);
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser seleccion = new JFileChooser(".");
				 btnSeleccionar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						seleccion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						int returnVal = seleccion.showSaveDialog(null);
						
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							txtRuta.setText(seleccion.getSelectedFile().getAbsolutePath());
							
							File elements = new  File (seleccion.getSelectedFile().getAbsolutePath());
							String[] listaDirectorio = elements.list(); 
							listaElements = new DefaultListModel<>();
							for (int i = 0; i < listaDirectorio.length; i++) {
								listaElements.addElement(listaDirectorio[i]);
							}
							list = new JList<String>(listaElements);
							add(list);

						}
						
					}
				});
			}
		});
		contentPane.add(btnSeleccionar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 158, 236, 350);
		contentPane.add(scrollPane);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(637, 158, 389, 350);
		contentPane.add(scrollPane_2);
		
		JLabel lblInfoDir = new JLabel("Elements del directori");
		lblInfoDir.setBounds(60, 132, 123, 22);
		contentPane.add(lblInfoDir);
		
		lblInfoFile = new JLabel("Informaci\u00F3 del fitxer");
		lblInfoFile.setBounds(339, 132, 123, 22);
		contentPane.add(lblInfoFile);
		
		lblFile = new JLabel("Contingut del fitxer");
		lblFile.setBounds(637, 132, 123, 22);
		contentPane.add(lblFile);
		
		btnCrear = new JButton("Nou document");
		btnCrear.setBounds(262, 591, 113, 33);
		contentPane.add(btnCrear);
		
		btnRenombrar = new JButton("Renombrar");
		btnRenombrar.setBounds(489, 591, 113, 33);
		contentPane.add(btnRenombrar);
		
		btnCopiar = new JButton("Copiar");
		btnCopiar.setBounds(262, 635, 113, 33);
		contentPane.add(btnCopiar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(489, 635, 113, 33);
		contentPane.add(btnEliminar);
		
		btnEditar = new JButton("Editar document");
		btnEditar.setBounds(1036, 158, 130, 33);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnEditar);
		
		btnBuscarIReemplazar = new JButton("Buscar i reempla\u00E7ar");
		btnBuscarIReemplazar.setBounds(1171, 158, 179, 33);
		btnBuscarIReemplazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnBuscarIReemplazar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(1036, 245, 179, 20);
		txtBuscar.setEnabled(false);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(1105, 220, 61, 14);
		lblBuscar.setEnabled(false);
		contentPane.add(lblBuscar);
		
		lblReemplaçar = new JLabel("Reempla\u00E7ar");
		lblReemplaçar.setBounds(1094, 276, 61, 14);
		lblReemplaçar.setEnabled(false);
		contentPane.add(lblReemplaçar);
		
		txtReemplazar = new JTextField();
		txtReemplazar.setBounds(1036, 298, 179, 20);
		txtReemplazar.setEnabled(false);
		txtReemplazar.setColumns(10);
		contentPane.add(txtReemplazar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(1240, 244, 89, 23);
		btnBuscar.setEnabled(false);
		contentPane.add(btnBuscar);
		
		btnReemplazar = new JButton("Reempla\u00E7ar");
		btnReemplazar.setBounds(1240, 297, 89, 23);
		btnReemplazar.setEnabled(false);
		contentPane.add(btnReemplazar);
		
		btnGuardarCanvis = new JButton("Guardar canvis");
		btnGuardarCanvis.setBounds(1065, 341, 123, 33);
		btnGuardarCanvis.setEnabled(false);
		contentPane.add(btnGuardarCanvis);
		
		txtNouNom = new JTextField();
		txtNouNom.setBounds(262, 547, 341, 33);
		contentPane.add(txtNouNom);
		txtNouNom.setColumns(10);
		
		btnGuardarNom = new JButton("Renombrar");
		btnGuardarNom.setBounds(637, 547, 113, 33);
		contentPane.add(btnGuardarNom);
		
		list = new JList();
		list.setBounds(57, 158, 162, 376);
		contentPane.add(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	}
}
