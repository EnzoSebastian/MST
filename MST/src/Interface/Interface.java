package Interface;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.Graph;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Interface extends JFrame {

	private JPanel contentPane;
	private int width;
	private int height;
	private DisplayMode mode;
	/**
	 * Create the frame.
	 */
	public Interface() {
		width = 350;
		height = 300;
		mode = this.getGraphicsConfiguration().getDevice().getDisplayMode();
		setForeground(Color.BLACK);
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((mode.getWidth()/2)-(width/2), (mode.getHeight()/2)-(height/2), width, height);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Grafo");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GraphInfo graph = new GraphInfo(new Graph());
				graph.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(125, 80, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(125, 170, 100, 30);
		contentPane.add(btnNewButton_1);
	}
}
