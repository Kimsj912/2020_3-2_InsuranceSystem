package frame.realFrame;

import javax.swing.JFrame;

import aConstant.ViewConstant;
import frame.IntFrame;
import panel.BasicPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements IntFrame {

	// Working Variable
	private BasicPanel nowPanel;
	
	// Constructor
	public MainFrame() {
		// Set Attribute
		this.setTitle(ViewConstant.MainFrameTitle);
		this.getContentPane().setPreferredSize(ViewConstant.MainFrameSize); this.pack(); // Set Frame Size By Set ContentPane Size
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	// Any Time Use
	@Override public void showPanel(BasicPanel view) {
		if(this.nowPanel!=null) {this.remove(this.nowPanel);} //�׸��� ������ ����� �ٽñ׸��� ����.
		this.nowPanel = view;
		this.add(view);
		this.revalidate();
		this.repaint();
	}
}
