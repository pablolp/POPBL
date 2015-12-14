package Main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class AdminFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNombrefisio;
	private JLabel lblApellidofisio;
	private JLabel lblUsernamefisio;
	private JLabel lblCentrofisio;
	private JLabel lblApellidofisio_1;
	private JLabel lblNombrepaciente;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 466);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setActionCommand("Salir");
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFisios = new JLabel("Fisios");
		lblFisios.setBounds(30, 27, 46, 14);
		contentPane.add(lblFisios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 52, 162, 304);
		contentPane.add(scrollPane);
		
		JList<Fisio> listFisios = new JList<>();
		scrollPane.setViewportView(listFisios);
		
		JPanel pFisioAmd = new JPanel();
		pFisioAmd.setBounds(86, 11, 223, 30);
		contentPane.add(pFisioAmd);
		pFisioAmd.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pFisioAmd.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pFisioAmd.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pFisioAmd.add(btnEliminar);
		
		JPanel pFisioDatos = new JPanel();
		pFisioDatos.setBounds(202, 52, 162, 304);
		contentPane.add(pFisioDatos);
		pFisioDatos.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 11, 46, 14);
		pFisioDatos.add(lblNombre);
		
		JLabel lblApellido_1 = new JLabel("Apellido:");
		lblApellido_1.setBounds(10, 36, 46, 14);
		pFisioDatos.add(lblApellido_1);
		
		JLabel lblApellido_2 = new JLabel("Apellido 2:");
		lblApellido_2.setBounds(10, 61, 59, 14);
		pFisioDatos.add(lblApellido_2);
		
		JLabel lblCentro = new JLabel("Centro:");
		lblCentro.setBounds(10, 86, 46, 14);
		pFisioDatos.add(lblCentro);
		
		JLabel lblUserName = new JLabel("Nombre Usuario:");
		lblUserName.setBounds(10, 111, 88, 14);
		pFisioDatos.add(lblUserName);
		
		lblNombrefisio = new JLabel("NombreFisio");
		lblNombrefisio.setBounds(66, 11, 46, 14);
		pFisioDatos.add(lblNombrefisio);
		
		lblApellidofisio = new JLabel("ApellidoFisio");
		lblApellidofisio.setBounds(66, 36, 46, 14);
		pFisioDatos.add(lblApellidofisio);
		
		lblApellidofisio_1 = new JLabel("Apellido2Fisio");
		lblApellidofisio_1.setBounds(66, 61, 46, 14);
		pFisioDatos.add(lblApellidofisio_1);
		
		lblCentrofisio = new JLabel("CentroFisio");
		lblCentrofisio.setBounds(66, 86, 46, 14);
		pFisioDatos.add(lblCentrofisio);
		
		lblUsernamefisio = new JLabel("UserNameFisio");
		lblUsernamefisio.setBounds(106, 111, 46, 14);
		pFisioDatos.add(lblUsernamefisio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(374, 52, 162, 304);
		contentPane.add(scrollPane_1);
		
		JList<Paciente> listPacientes = new JList<>();
		scrollPane_1.setViewportView(listPacientes);
		
		JPanel pPacienteAmd = new JPanel();
		pPacienteAmd.setBounds(430, 11, 223, 30);
		contentPane.add(pPacienteAmd);
		pPacienteAmd.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton button = new JButton("Nuevo");
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pPacienteAmd.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pPacienteAmd.add(button_1);
		
		JButton button_2 = new JButton("Eliminar");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pPacienteAmd.add(button_2);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(374, 27, 46, 14);
		contentPane.add(lblPaciente);
		
		JPanel pDatosPaciente = new JPanel();
		pDatosPaciente.setLayout(null);
		pDatosPaciente.setBounds(546, 52, 162, 304);
		contentPane.add(pDatosPaciente);
		
		JLabel label = new JLabel("Nombre:");
		label.setBounds(10, 11, 46, 14);
		pDatosPaciente.add(label);
		
		JLabel label_1 = new JLabel("Apellido:");
		label_1.setBounds(10, 36, 46, 14);
		pDatosPaciente.add(label_1);
		
		JLabel label_2 = new JLabel("Apellido 2:");
		label_2.setBounds(10, 61, 59, 14);
		pDatosPaciente.add(label_2);
		
		JLabel label_3 = new JLabel("Centro:");
		label_3.setBounds(10, 86, 46, 14);
		pDatosPaciente.add(label_3);
		
		JLabel label_4 = new JLabel("Nombre Usuario:");
		label_4.setBounds(10, 111, 88, 14);
		pDatosPaciente.add(label_4);
		
		lblNombrepaciente = new JLabel("NombrePaciente");
		lblNombrepaciente.setBounds(66, 11, 46, 14);
		pDatosPaciente.add(lblNombrepaciente);
		
		JLabel lblApellidopaciente = new JLabel("ApellidoPaciente");
		lblApellidopaciente.setBounds(66, 36, 46, 14);
		pDatosPaciente.add(lblApellidopaciente);
		
		JLabel lblApellidopaciente_1 = new JLabel("Apellido2Paciente");
		lblApellidopaciente_1.setBounds(66, 61, 46, 14);
		pDatosPaciente.add(lblApellidopaciente_1);
		
		JLabel lblCentroFisio = new JLabel("Centro");
		lblCentroFisio.setBounds(66, 86, 46, 14);
		pDatosPaciente.add(lblCentroFisio);
		
		JLabel lblUsernamepaciente = new JLabel("UserNamePaciente");
		lblUsernamepaciente.setBounds(94, 111, 46, 14);
		pDatosPaciente.add(lblUsernamepaciente);
	}

	
}
