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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtRuta;
	private JLabel lblInfoFile;
	private JLabel lblFile;
	private JButton btnArchivo;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnBuscarIReemplazar;
	private JTextField txtBuscar;
	private JLabel lblBuscar;
	private JLabel lblReemplazar;
	private JTextField txtReemplazar;
	private JButton btnBuscar;
	private JButton btnReemplazar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_2;
	private JButton btnGuardarCanvis;
	private JTextField txtNouNom;
	private JButton btnGuardarNom;
	JFrame mainFrame;
	DefaultListModel<String> listaDefault;
	private JScrollPane spInfoDir;
	private JTextArea txtInfoDir;
	private JTextArea txtInfoFile;
	private JTextArea txtContenidoFile;
	private JScrollPane spContenidoFile;
	private JScrollPane spInfoFile;

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
				JFileChooser seleccion = new JFileChooser();
				btnSeleccionar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						seleccion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						int returnVal = seleccion.showOpenDialog(seleccion);

						if (returnVal == JFileChooser.APPROVE_OPTION) {

							txtRuta.setText(seleccion.getSelectedFile().getAbsolutePath());

							File elements = new File(seleccion.getSelectedFile().getAbsolutePath());
							String[] listaDirectorio = elements.list();
							String dirTxt = "";
							for (int i = 0; i < listaDirectorio.length; i++) {
								dirTxt += listaDirectorio[i] + "\n";
							}
							txtInfoDir.setText(dirTxt);

						}
					}
				});
			}
		});
		contentPane.add(btnSeleccionar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 158, 236, 350);
		contentPane.add(scrollPane);

		txtInfoFile = new JTextArea();
		txtInfoFile.setEditable(false);
		scrollPane.setViewportView(txtInfoFile);

		spInfoFile = new JScrollPane();
		scrollPane.setRowHeaderView(spInfoFile);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(637, 158, 389, 350);
		contentPane.add(scrollPane_2);

		txtContenidoFile = new JTextArea();
		txtContenidoFile.setEditable(false);
		scrollPane_2.setViewportView(txtContenidoFile);

		spContenidoFile = new JScrollPane();
		scrollPane_2.setRowHeaderView(spContenidoFile);

		JLabel lblInfoDir = new JLabel("Elements del directori");
		lblInfoDir.setBounds(60, 132, 123, 22);
		contentPane.add(lblInfoDir);

		lblInfoFile = new JLabel("Informaci\u00F3 del fitxer");
		lblInfoFile.setBounds(339, 132, 123, 22);
		contentPane.add(lblInfoFile);

		lblFile = new JLabel("Contingut del fitxer");
		lblFile.setBounds(637, 132, 123, 22);
		contentPane.add(lblFile);

		JButton btnCrear = new JButton("Nou document");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser seleccion = new JFileChooser();
				seleccion.setDialogTitle("Crea un document nou");
				btnCrear.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						seleccion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						int returnVal = seleccion.showSaveDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							File archivo = new File(seleccion.getSelectedFile().getAbsolutePath());
							try {
								archivo.createNewFile();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}
				});
			}
		});
		btnCrear.setBounds(262, 591, 131, 33);
		contentPane.add(btnCrear);

		JButton btnArchivo = new JButton("Abrir Document");
		btnArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser seleccion = new JFileChooser();
				seleccion.setDialogTitle("Selecciona un document");
				btnArchivo.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
						int returnVal = seleccion.showOpenDialog(null);

						if (returnVal == JFileChooser.APPROVE_OPTION) {

							txtRuta.setText(seleccion.getSelectedFile().getAbsolutePath());

							File arx = new File(seleccion.getSelectedFile().getAbsolutePath());
							FileReader fr;
							try {
								fr = new FileReader(arx);
								BufferedReader leerFile = new BufferedReader(fr);
								String line = leerFile.readLine();
								while (line != null) {
									txtContenidoFile.append(line + "\n");
									line = leerFile.readLine();
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							String fileTxt = "Name: " + arx.getName() + "\n" + "Path: " + arx.getPath() + "\n"
									+ "Absolute Path: " + arx.getAbsolutePath() + "\n" + "Can Write: " + arx.canWrite()
									+ "\n" + "Can Read: " + arx.canRead() + "\n" + "Length: " + arx.length();

							txtInfoFile.setText(fileTxt);

							;
						}
					}
				});

			}
		});
		btnArchivo.setBounds(471, 591, 131, 33);
		contentPane.add(btnArchivo);

		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser seleccion = new JFileChooser();
				seleccion.setDialogTitle("Copiar Document");
				btnCopiar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
						int returnVal = seleccion.showSaveDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							File archivo = new File(seleccion.getSelectedFile().getAbsolutePath());
							try {
								FileReader fr = new FileReader(archivo);
								FileWriter fw = new FileWriter("arxiuNou_copia.txt");
								BufferedReader br = new BufferedReader(fr);
								BufferedWriter bw = new BufferedWriter(fw);
								String linea = br.readLine();
								while (linea != null) {
									bw.write(linea);
									bw.newLine();
									linea = br.readLine();
								}
								bw.close();
								br.close();
								br.close();
								fr.close();

							} catch (IOException e2) {
								e2.printStackTrace();
							}
						}

					}
				});
			}
		});
		btnCopiar.setBounds(262, 635, 113, 33);
		contentPane.add(btnCopiar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser seleccion = new JFileChooser();
				seleccion.setDialogTitle("Borrar Document");
				btnEliminar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
						int returnVal = seleccion.showSaveDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							int confirmacion = JOptionPane.showConfirmDialog(null, "Segur que vols eliminar el fitxer?",
									"Confirmacio per a eliminar", JOptionPane.YES_NO_OPTION,
									JOptionPane.WARNING_MESSAGE, null);

							if (confirmacion == 0) {
								File archivo = new File(seleccion.getSelectedFile().getAbsolutePath());
								archivo.delete();
							}

						}

					}
				});
			}
		});
		btnEliminar.setBounds(489, 635, 113, 33);
		contentPane.add(btnEliminar);

		btnEditar = new JButton("Editar document");
		btnEditar.setBounds(1036, 158, 130, 33);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnEditar);

		btnBuscarIReemplazar = new JButton("Buscar i reemplaar");
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

		lblReemplazar = new JLabel("Reempla\u00E7ar");
		lblReemplazar.setBounds(1094, 276, 61, 14);
		lblReemplazar.setEnabled(false);
		contentPane.add(lblReemplazar);

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

		JButton btnGuardarNom = new JButton("Renombrar");
		btnGuardarNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser seleccion = new JFileChooser();
				seleccion.setDialogTitle("Renombrar document");
				btnGuardarNom.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
						int returnVal = seleccion.showSaveDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
								File archivo = new File(seleccion.getSelectedFile().getAbsolutePath());
								File nouName = new File(txtNouNom.getText() + ".txt");
								archivo.renameTo(nouName);
							}
						}

					}
				);
			}
		});
		btnGuardarNom.setBounds(637, 547, 113, 33);
		contentPane.add(btnGuardarNom);

		spInfoDir = new JScrollPane();
		spInfoDir.setBounds(60, 158, 220, 350);
		contentPane.add(spInfoDir);

		txtInfoDir = new JTextArea();
		txtInfoDir.setEditable(false);
		spInfoDir.setViewportView(txtInfoDir);
	}
}
