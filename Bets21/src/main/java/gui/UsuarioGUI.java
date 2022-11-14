package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Event;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class UsuarioGUI extends JFrame {
	private JPanel contentPane;
	
	private final JButton jButtonClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));
	private final JButton jButtonBet = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Bet")); //$NON-NLS-1$ //$NON-NLS-2$
	private final JButton JButtonVerPronos = new JButton(ResourceBundle.getBundle("Etiquetas").getString("ViewForecasts")); //$NON-NLS-1$ //$NON-NLS-2$
	private final JButton jButtonLogout = new JButton(ResourceBundle.getBundle("Etiquetas").getString("LogOut")); //$NON-NLS-1$ //$NON-NLS-2$
	private final JButton jButtonViewCupon = new JButton(ResourceBundle.getBundle("Etiquetas").getString("ViewCoupon"));
	private final JButton jButtonPerfil = new JButton();
	private final JButton jButtonForo=new JButton(ResourceBundle.getBundle("Etiquetas").getString("Foro"));
	private final JButton jButtonMisApuestas = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MisApuestas")); //$NON-NLS-1$ //$NON-NLS-2$

	private domain.Usuario user;
	
	public UsuarioGUI(domain.Usuario user){
		try{
			Usuario(user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	private void Usuario(domain.Usuario user) {
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		jButtonBet.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				jButtonBet_actionPerformed(e);			
			}
		});
		jButtonBet.setBounds(49, 28, 326, 40);
		contentPane.add(jButtonBet);
		
		
		JButtonVerPronos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButtonVerPronos_actionPerformed(e);
			}
		});
		JButtonVerPronos.setBounds(49, 78, 326, 40);
		contentPane.add(JButtonVerPronos);
		
		jButtonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonClose_actionPerformed(e);
			}
		});
		jButtonClose.setBounds(232, 297, 139, 28);
		contentPane.add(jButtonClose);
		jButtonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonLogout_actionPerformed(e);
			}
		});
		
		jButtonLogout.setBounds(52, 297, 139, 28);
		contentPane.add(jButtonLogout);
		jButtonViewCupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonViewCupon_actionPerformed(e);
			}
		});
		
		jButtonForo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonForo(e);
			}
		});
		jButtonForo.setBounds(49, 178, 326, 40);
		
		contentPane.add(jButtonForo);
		

		jButtonViewCupon.setBounds(49, 128, 326, 40);
		contentPane.add(jButtonViewCupon);
		
		
		jButtonPerfil.setIcon(new ImageIcon("C:\\Users\\Propietario\\Pictures\\Saved Pictures\\IS_Perfil.jpg"));
		jButtonPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonPerfil_actionPerformed(e);
			}
		});
		jButtonPerfil.setBounds(389, 0, 47, 28);
		contentPane.add(jButtonPerfil);
		jButtonMisApuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonMisApuestas_actionPerformed(e);
			}
		});
		
		jButtonMisApuestas.setBounds(49, 228, 326, 40);
		contentPane.add(jButtonMisApuestas);
	}
	
	private void jButtonBet_actionPerformed(ActionEvent e) {
		JFrame a = new SeleccionGUI(user);
		a.setVisible(true);
	}
	
	private void JButtonVerPronos_actionPerformed(ActionEvent e) {
		JFrame a = new VerPronosticosGUI();
		a.setVisible(true);
	}
	
	private void jButtonClose_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		System.exit(0);
	}
	
	private void jButtonViewCupon_actionPerformed(ActionEvent e) {
		JFrame a = new ViewCuponGUI(user);
		a.setVisible(true);
	}
	
	private void jButtonPerfil_actionPerformed(ActionEvent e) {
		JFrame a = new PerfilGUI(user);
		a.setVisible(true);
	}
	
	private void jButtonForo(ActionEvent e) {
		this.setVisible(false);
		JFrame a= new ForoGUI(user);
		a.setVisible(true);
	}
	
	private void jButtonLogout_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		JFrame a= new MainGUI();
		a.setVisible(true);
	}
	
	private void jButtonMisApuestas_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		JFrame a= new WindowTableGUI(user);
		a.setVisible(true);
	}
}