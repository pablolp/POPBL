package Main;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AñadePacienteFrame extends JDialog implements ActionListener {
	
	final static int ANCHOPANTALLA = 640;
	final static int LARGOPANTALLA = 480;
	final static int POSPANTALLAX = 100;
	final static int POSPANTALLAY = 100;
	JTextField tfNombre, tfApellido, tfApellido2, tfCentro, tfUserName;
	JPanel panelPrincipal, panelSecundario, panelTerciario;
	JButton ok, cancelar;
	
	public AñadePacienteFrame(JFrame fisio, Paciente paciente){
		super(fisio, "Añade Alumno");
		
		ok = new JButton("ok");
		cancelar = new JButton("cancelar");
		
		mirarPaciente(paciente);
		
		this.setSize(ANCHOPANTALLA, LARGOPANTALLA);
		this.setResizable(false);
		this.setLocation(POSPANTALLAX, POSPANTALLAY);
		
		agregarListeners();
		
		this.setContentPane(crearPanelVentana());
		
		this.setModal(true);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}
	
	private Container crearPanelVentana() {
		panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panelPrincipal.add(crearPanelSecundario(), BorderLayout.CENTER);
		panelPrincipal.add(crearPanelTerciario(), BorderLayout.SOUTH);
		return panelPrincipal;
	}

	private Component crearPanelTerciario() {
		panelTerciario = new JPanel(new GridLayout(1,2));
		panelTerciario.add(creaBoton(ok));
		panelTerciario.add(creaBoton(cancelar));
		panelTerciario.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));
		return panelTerciario;
	}

	private Component crearPanelSecundario() {
		panelSecundario = new JPanel(new GridLayout(5,1));
		panelSecundario.add(creaTextField("Nombre", tfNombre));
		panelSecundario.add(creaTextField("Primer Apellido", tfApellido));
		panelSecundario.add(creaTextField("Segundo Apellido", tfApellido2));
		panelSecundario.add(creaTextField("Centro", tfCentro));
		panelSecundario.add(creaTextField("User Name", tfUserName));
		panelSecundario.setBorder(BorderFactory.createEmptyBorder(10, 20, 50, 20));
		return panelSecundario;
	}

	private void mirarPaciente(Paciente paciente){
		if(paciente == null)nuevoPaciente();
		else pacienteExistente(paciente);
	}
	
	private void nuevoPaciente(){
		tfNombre = new JTextField("");
		tfApellido = new JTextField("");
		tfApellido2 = new JTextField("");
		tfCentro = new JTextField("");
		tfUserName = new JTextField("");
	}
	
	private void pacienteExistente(Paciente paciente){
		tfNombre = new JTextField(paciente.getNombre());
		tfApellido = new JTextField(paciente.getApellido1());
		tfApellido2 = new JTextField(paciente.getApellido2());
		tfCentro = new JTextField(paciente.getCentro());
		tfUserName = new JTextField(paciente.getUserName());
	}
	
	private Component creaTextField(String titulo, JTextField text) {
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(), titulo));
		panel.add(text);
		return panel;
	}
	
	private Component creaBoton(JButton boton) {
		JPanel panel = new JPanel();
		panel.add(boton);
		return panel;
	}

	private void agregarListeners() {
		ok.addActionListener(this);
		cancelar.addActionListener(this);		
	}

	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("ok")){
			if(comprobacion())
				this.dispose();
			else
				JOptionPane.showMessageDialog(this,"Rellene todos los campos","ERROR",JOptionPane.ERROR_MESSAGE);	
		}
		if(evento.getActionCommand().equals("cancelar")){
			tfNombre.setText("");
			tfApellido.setText("");
			tfApellido2.setText("");
			tfCentro.setText("");
			this.dispose();
		}
		
		
	}

	private boolean comprobacion() {
		if(0!=tfNombre.getText().compareTo("")){
			if(0!=tfApellido.getText().compareTo("")){
				if(0!=tfApellido2.getText().compareTo("")){
					if(0!=tfCentro.getText().compareTo("")){
						if(0!=tfUserName.getText().compareTo("")){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public Paciente getPaciente(){
		Paciente nuevo = null;
		TablaEjercicios ariketak = new TablaEjercicios();
		nuevo = new Paciente(tfUserName.getText(),
				tfNombre.getText(),
				tfApellido.getText(),
				tfApellido2.getText(),
				tfCentro.getText(),
				ariketak);
		return nuevo;
	}
	
}

