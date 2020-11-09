package Interface;

import java.awt.DisplayMode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Implementation.MST;
import Info.Vertex;
import Logic.Graph;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Prim extends JFrame {

	private JPanel contentPane;
	private int width;
	private int height;
	private DisplayMode mode;
	private Graph graphPrim;


	/**
	 * Create the frame.
	 */
	public Prim(Graph graph) {
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
		
		JButton btnNewButton = new JButton("Quitar mayor arista");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SplitEdges edges = new SplitEdges(graphPrim,graph);
				edges.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(137, 266, 162, 34);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(23, 11, 405, 236);
		contentPane.add(scroll);
		
		graphPrim = prim(graph,textArea);
		
	}
	
	private Graph prim(Graph graph,JTextArea textArea) {
		Graph primImplemented = MST.prim(graph);
		String st = "";
		for(int i = 0;i < primImplemented.getGraph().size()-1;i++) {
			Vertex v = primImplemented.getGraph().get(i);
			if(v.getEdges().size()!=0) {
				st = st + v.getPerson().getName() + " se relaciona con: \n";
				for(Vertex ver:v.getEdges()) {
					st = st + "(" + ver.getPerson().getName() + ", Valor de arista: " + v.getEdgeSimilarityIndex(ver) + ") \n";
				}
			}
		}
		textArea.setText(st);
		return primImplemented;
	}

}
