package Interface;

import java.awt.DisplayMode;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Info.Vertex;
import Logic.Graph;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GraphInfo extends JFrame {

	private JPanel contentPane;
	private int width;
	private int height;
	private DisplayMode mode;
	private Graph graphN;

	/**
	 * Create the frame.
	 */
	public GraphInfo(Graph graph) {
		graphN = graph;
		width = 468;
		height = 350;
		mode = this.getGraphicsConfiguration().getDevice().getDisplayMode();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((mode.getWidth()/2)-(width/2), (mode.getHeight()/2)-(height/2), width, height);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Agregar Persona");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersonCreation person = new PersonCreation(graphN);
				person.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 26, 136, 35);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(156, 26, 287, 279);
		contentPane.add(scroll);
		
		
		JButton btnNewButton_1 = new JButton("Aplicar AGM");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(graph.size()==0) {
					JOptionPane.showMessageDialog(null, "No se puede aplicar AGM a un grafo vacio.");
				}
				if(graph.size()==1) {
					JOptionPane.showMessageDialog(null, "No se puede aplicar AGM a un grafo de un solo vertice.");
				}
				else {
					Prim prim = new Prim(graph);
					prim.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(10, 150, 136, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar grafo");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String st = "";
				for(Vertex v:graph.getGraph()) {
					st = st + v.getPerson().getName() 
							+"(Deportes:" + v.getPerson().getInterest("sports")
							+", Musica:" + v.getPerson().getInterest("music")
							+", Noticias:" + v.getPerson().getInterest("newsShow")
							+", Ciencia:" + v.getPerson().getInterest("science")
							+ ")"
							+ "\n";
				}
				textArea.setText(st);
			}
		});
		btnNewButton_2.setBounds(10, 72, 136, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(10, 316, 100, 23);
		contentPane.add(btnNewButton_3);
	}
}
