package Interface;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Info.Person;
import Info.Vertex;
import Logic.Graph;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.DisplayMode;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PersonCreation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int width;
	private int height;
	private DisplayMode mode;
	private String [] person;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PersonCreation(Graph graph) {
		width = 300;
		height = 300;
		mode = this.getGraphicsConfiguration().getDevice().getDisplayMode();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds((mode.getWidth()/2)-(width/2), (mode.getHeight()/2)-(height/2), width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		person = new String[4];
		person[0] = "1";
		person[1] = "1";
		person[2] = "1";
		person[3] = "1";
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 11, 59, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(79, 12, 109, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Deportes:");
		lblNewLabel_1.setBounds(10, 81, 114, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Musica:");
		lblNewLabel_2.setBounds(10, 109, 114, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Noticias:");
		lblNewLabel_3.setBounds(10, 150, 114, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ciencia:");
		lblNewLabel_4.setBounds(10, 186, 114, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Intereses:");
		lblNewLabel_5.setBounds(10, 47, 114, 23);
		contentPane.add(lblNewLabel_5);
		
		String [] integerLvl = {"1","2","3","4","5"};
		
		JComboBox comboBox = new JComboBox(integerLvl);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String msg = (String) cb.getSelectedItem();
				person[0] = msg;
			}
		});
		comboBox.setBounds(117, 82, 46, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(integerLvl);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String msg = (String) cb.getSelectedItem();
				person[1] = msg;
			}
		});
		comboBox_1.setBounds(117, 117, 46, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(integerLvl);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String msg = (String) cb.getSelectedItem();
				person[2] = msg;
			}
		});
		comboBox_2.setBounds(117, 150, 46, 22);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(integerLvl);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String msg = (String) cb.getSelectedItem();
				person[3] = msg;
			}
		});
		comboBox_3.setBounds(117, 186, 46, 22);
		contentPane.add(comboBox_3);
		
		JButton btnNewButton = new JButton("Cargar Persona");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No se puede cargar una persona con el nombre vacio.");
				}
				else {
					Person newPerson = new Person(textField.getText(),Integer.parseInt(person[0]),
							Integer.parseInt(person[1]),
							Integer.parseInt(person[2]),
							Integer.parseInt(person[3]));
					Vertex v = new Vertex(newPerson);
					graph.addVertex(v);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(127, 227, 143, 23);
		contentPane.add(btnNewButton);
	}
}
