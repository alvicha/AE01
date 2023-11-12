package Exercicis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Order extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPecaI;
	private JTextField txtNomArxiu;
	private JTextField txtPecaO;
	private JTextField txtPecaT;
	private JTextField txtPecaJ;
	private JTextField txtPecaL;
	private JTextField txtPecaS;
	private JTextField txtPecaZ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() {
		setTitle("GESTIÓ DE PEÇES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQuantitatPeca = new JLabel("QUANTITAT DE PECA");
		lblQuantitatPeca.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantitatPeca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantitatPeca.setBounds(41, 0, 172, 31);
		contentPane.add(lblQuantitatPeca);

		JLabel lblNomArxiu = new JLabel("NOM D´ARXIU:");
		lblNomArxiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomArxiu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomArxiu.setBounds(69, 306, 111, 31);
		contentPane.add(lblNomArxiu);

		txtNomArxiu = new JTextField();
		txtNomArxiu.setColumns(10);
		txtNomArxiu.setBounds(41, 332, 172, 20);
		contentPane.add(txtNomArxiu);

		JButton btnRealitzarPeca = new JButton("REALITZAR PECA");
		btnRealitzarPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidadI = Integer.parseInt(txtPecaI.getText());
				int cantidadO = Integer.parseInt(txtPecaO.getText());
				int cantidadT = Integer.parseInt(txtPecaT.getText());
				int cantidadJ = Integer.parseInt(txtPecaJ.getText());
				int cantidadL = Integer.parseInt(txtPecaL.getText());
				int cantidadS = Integer.parseInt(txtPecaS.getText());
				int cantidadZ = Integer.parseInt(txtPecaZ.getText());

				String arxiu = txtNomArxiu.getText();
				ManuFacture manufacturer = new ManuFacture(cantidadI, cantidadO, cantidadT, cantidadJ, cantidadL,
						cantidadS, cantidadZ);
				manufacturer.escriureArxiu(arxiu);
			}
		});
		btnRealitzarPeca.setBounds(51, 361, 146, 23);
		contentPane.add(btnRealitzarPeca);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"TIPUS DE PE\u00C7ES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 34, 207, 265);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblQuantitatPeca_1 = new JLabel("I");
		lblQuantitatPeca_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitatPeca_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantitatPeca_1.setBounds(30, 33, 13, 25);
		panel.add(lblQuantitatPeca_1);

		txtPecaI = new JTextField();
		txtPecaI.setBounds(46, 37, 122, 20);
		panel.add(txtPecaI);
		txtPecaI.setColumns(10);

		JLabel lblQuantitatPeca_1_1 = new JLabel("O");
		lblQuantitatPeca_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitatPeca_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantitatPeca_1_1.setBounds(30, 64, 13, 25);
		panel.add(lblQuantitatPeca_1_1);

		JLabel lblQuantitatPeca_1_2 = new JLabel("T");
		lblQuantitatPeca_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitatPeca_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantitatPeca_1_2.setBounds(30, 100, 13, 25);
		panel.add(lblQuantitatPeca_1_2);

		JLabel lblQuantitatPeca_1_3 = new JLabel("J");
		lblQuantitatPeca_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitatPeca_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantitatPeca_1_3.setBounds(30, 127, 13, 25);
		panel.add(lblQuantitatPeca_1_3);

		JLabel lblQuantitatPeca_1_4 = new JLabel("L");
		lblQuantitatPeca_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitatPeca_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantitatPeca_1_4.setBounds(30, 158, 13, 25);
		panel.add(lblQuantitatPeca_1_4);

		JLabel lblQuantitatPeca_1_5 = new JLabel("S");
		lblQuantitatPeca_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitatPeca_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantitatPeca_1_5.setBounds(30, 189, 13, 25);
		panel.add(lblQuantitatPeca_1_5);

		JLabel lblQuantitatPeca_1_6 = new JLabel("Z");
		lblQuantitatPeca_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantitatPeca_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantitatPeca_1_6.setBounds(30, 220, 13, 25);
		panel.add(lblQuantitatPeca_1_6);

		txtPecaO = new JTextField();
		txtPecaO.setColumns(10);
		txtPecaO.setBounds(46, 68, 122, 20);
		panel.add(txtPecaO);

		txtPecaT = new JTextField();
		txtPecaT.setColumns(10);
		txtPecaT.setBounds(46, 100, 122, 20);
		panel.add(txtPecaT);

		txtPecaJ = new JTextField();
		txtPecaJ.setColumns(10);
		txtPecaJ.setBounds(46, 131, 122, 20);
		panel.add(txtPecaJ);

		txtPecaL = new JTextField();
		txtPecaL.setColumns(10);
		txtPecaL.setBounds(46, 162, 122, 20);
		panel.add(txtPecaL);

		txtPecaS = new JTextField();
		txtPecaS.setColumns(10);
		txtPecaS.setBounds(46, 193, 122, 20);
		panel.add(txtPecaS);

		txtPecaZ = new JTextField();
		txtPecaZ.setColumns(10);
		txtPecaZ.setBounds(46, 224, 122, 20);
		panel.add(txtPecaZ);
	}
}
