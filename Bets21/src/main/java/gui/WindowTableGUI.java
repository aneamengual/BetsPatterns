package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

import domain.Usuario;

public class WindowTableGUI extends JFrame {
	private Usuario user;
	private JTable tabla;

	public WindowTableGUI(Usuario user) {
		super("Apuestas	realizadas por " + user.getNombreUsuario() + ":");
		this.setBounds(100, 100, 700, 200);
		this.user = user;
		UserAdapter adapt = new UserAdapter(user);
		tabla = new JTable(adapt);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(tabla);
		//Agregamos el	JScrollPane	al contenedor
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}

