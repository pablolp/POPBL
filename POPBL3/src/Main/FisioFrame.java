package Main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FisioFrame extends JDialog implements ActionListener {
	
	final static int ANCHOPANTALLA = 640;
	final static int LARGOPANTALLA = 480;
	final static int POSPANTALLAX = 100;
	final static int POSPANTALLAY = 100;
	JButton bAñadir, bEliminar, bModificar;
	JPanel jPrincipal, jIzkierda, jCentro, jBotones;
	JLabel lEjercicio;
	
	public FisioFrame(JFrame principal){
		super(principal, "Panel del Fisioterapeuta");
		bAñadir = new JButton("Añadir");
		bEliminar = new JButton("Eliminar");
		bModificar = new JButton("Modificar");
		jPrincipal = new JPanel(new BorderLayout());
		jIzkierda = new JPanel(new BorderLayout());
		jCentro = new JPanel();
		jBotones = new JPanel();
		lEjercicio = new JLabel();
		
		this.setSize(ANCHOPANTALLA, LARGOPANTALLA);
		this.setResizable(false);
		this.setLocation(POSPANTALLAX, POSPANTALLAY);
		meteListeners();
		llenaDialog();
		this.setModal(true);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}

	private void llenaDialog() {
		jBotones.add(creaBoton(bAñadir));
		jBotones.add(creaBoton(bEliminar));
		jBotones.add(creaBoton(bModificar));
		jIzkierda.add(jBotones, BorderLayout.NORTH);
		jPrincipal.add(jIzkierda, BorderLayout.WEST);
		jCentro.add(lEjercicio);
		jPrincipal.add(jCentro, BorderLayout.CENTER);
		this.setContentPane(jPrincipal);
		
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
		Paciente nuevo;
		if(evento.getActionCommand().equals("Añadir")){
			//AñadePacienteFrame paciente = new AñadePacienteFrame(this);
			//nuevo = paciente.getPaciente();
		}
		if(evento.getActionCommand().equals("Eliminar")){
			/*nt indice = lista.getSelectedIndex();
			if(indice != -1){
				
			}*/
		}
	}
}
