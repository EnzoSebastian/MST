package Interface;

import java.awt.DisplayMode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Info.Vertex;
import Logic.Graph;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class SplitEdges extends JFrame {

	private JPanel contentPane;
	private int width;
	private int height;
	private DisplayMode mode;
	Graph graphN;

	/**
	 * Create the frame.
	 */
	public SplitEdges(Graph graphPrim,Graph graph) {
		graphN = graphPrim;
		Vertex vert = graphN.removeBiggerEdge();
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
		
		JTextArea textArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(10, 11, 432, 109);
		contentPane.add(scroll);
		
		JTextArea textArea_1 = new JTextArea();
		
		JScrollPane scroll2 = new JScrollPane(textArea_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setBounds(10, 179, 432, 109);
		contentPane.add(scroll2);
		
		separateGroups(graphN.getGraph().get(0),textArea);
		separateGroups(vert,textArea_1);
		
		JButton btnNewButton = new JButton("Volver al grafo");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GraphInfo gr = new GraphInfo(graph);
				gr.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(122, 139, 190, 29);
		contentPane.add(btnNewButton);
	}
	
	public void separateGroups(Vertex v,JTextArea textArea) {
		String st = "";
		st = st + v.getPerson().getName() + " esta relacionado con: \n";
		if(v.getEdges().size()==0) {
			st = st + "()";
			textArea.setText(textArea.getText() + st);
		}
		else {
			for(Vertex ver:v.getEdges()) {
				st = st + "(" + ver.getPerson().getName() + ", Valor de arista: " + v.getEdgeSimilarityIndex(ver) + ") \n";
			}
			textArea.setText(textArea.getText() + st);
			for(Vertex vert:v.getEdges()) {
				separateGroups(vert, textArea);
			}
		}
	}
}
