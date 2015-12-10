package Main;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FisioFrame  implements ActionListener, ListSelectionListener{
	
	final static int ANCHOPANTALLA = 640;
	final static int LARGOPANTALLA = 480;
	final static int POSPANTALLAX = 100;
	final static int POSPANTALLAY = 100;
	final static int FALLO = -1;
	JButton bAñadir, bEliminar, bModificar;
	JPanel jPrincipal, jIzkierda, jCentro, jBotones;
	JLabel lEjercicio;
	JFrame ventana;
	JScrollPane spPacientes;
	JList<Paciente>pacientes;
	DefaultListModel <Paciente>modelo;
	
	public FisioFrame(JFrame principal){
		ventana = new JFrame("Panel del Fisioterapeuta");
		bAñadir = new JButton("Añadir");
		bEliminar = new JButton("Eliminar");
		bModificar = new JButton("Modificar");
		lEjercicio = new JLabel();
		ventana.setSize(ANCHOPANTALLA, LARGOPANTALLA);
		ventana.setResizable(true);
		ventana.setLocation(POSPANTALLAX, POSPANTALLAY);
		ventana.setContentPane(crearPanelVentana());
		meteListeners();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.repaint();
	}

	private Container crearPanelVentana() {
		jPrincipal = new JPanel(new BorderLayout());
		jPrincipal.add(crearIzkierda(), BorderLayout.WEST);
		jPrincipal.add(creaCentro(), BorderLayout.CENTER);
		return jPrincipal;
	}

	private Component creaCentro() {
		jCentro = new JPanel();
		return jCentro;
	}

	private Component crearIzkierda() {
		jIzkierda = new JPanel(new BorderLayout());
		jIzkierda.add(crearPanelBotones(), BorderLayout.NORTH);
		jIzkierda.add(creaPanelPacientes(), BorderLayout.CENTER);
		return jIzkierda;
	}

	private Component creaPanelPacientes() {
		int ancho = 270;
		int alto = 380;
		JPanel panel = new JPanel();
		spPacientes = new JScrollPane();
		spPacientes.setPreferredSize(new Dimension(ancho,alto));
		pacientes = new JList<>();
		modelo = new DefaultListModel<>();
		pacientes.addListSelectionListener(this);
		pacientes.setModel(modelo);
		spPacientes.setViewportView(pacientes);
		panel.add(spPacientes);
		return panel;
	}

	private Component crearPanelBotones() {
		jBotones = new JPanel();
		jBotones.add(creaBoton(bAñadir));
		jBotones.add(creaBoton(bEliminar));
		jBotones.add(creaBoton(bModificar));
		return jBotones;
	}	
	
	
	private Component creaBoton(JButton boton) {
		JPanel panel = new JPanel();
		panel.add(boton);
		return panel;
	}

	private void meteListeners() {
		bAñadir.addActionListener(this);
		bEliminar.addActionListener(this);
		bModificar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		Paciente nuevo = null;
		if(evento.getActionCommand().equals("Añadir")){
			AñadePacienteFrame paciente = new AñadePacienteFrame(ventana, nuevo);
			nuevo = paciente.getPaciente();
			if(nuevo != null)
				modelo.addElement(nuevo);
		}
		if(evento.getActionCommand().equals("Eliminar")){
			int indice = pacientes.getSelectedIndex();
			if(indice != FALLO){
				int reply = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar al paciente?", "",
					JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION)
					modelo.remove(indice);
	        }			
		}
		if(evento.getActionCommand().equals("Modificar")){
			int indice = pacientes.getSelectedIndex();
			if(indice != FALLO){
				AñadePacienteFrame paciente = new AñadePacienteFrame(ventana, modelo.getElementAt(indice));
				if(cambios(paciente.getPaciente(), modelo.getElementAt(indice))){
					modelo.getElementAt(indice).setPaciente(paciente.getPaciente());
					ventana.repaint();
				}
			}
		}
	}
	
	private boolean cambios(Paciente paciente, Paciente paciente2) {
		if(paciente.getNombre().equals(paciente2.getNombre())){
			if(paciente.getApellido1().equals(paciente2.getApellido1())){
				if(paciente.getApellido2().equals(paciente2.getApellido2())){
					if(paciente.getCentro().equals(paciente2.getCentro())){
						if(paciente.getUserName().equals(paciente2.getUserName())){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public void valueChanged(ListSelectionEvent evento) {
		
	}
	
}