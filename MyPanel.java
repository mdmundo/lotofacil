import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image image;
    public MyPanel() {
        this.initialize();
    }
    protected void initialize() {
        this.image = this.getImage("JLabel_Tabela.png");
        this.setLayout(new BorderLayout());
    }
    public Image getImage(String path) {
        URL imageURL = getClass().getResource(path);
        if (imageURL == null)
            return null;
        return new ImageIcon(imageURL).getImage();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dDesktop = this.getSize();
        double width = dDesktop.getWidth();
        double height = dDesktop.getHeight();
        Image background = new ImageIcon(this.image.getScaledInstance(
                (int) width, (int) height, 1)).getImage();
        g.drawImage(background, 0, 0, this);
    }
}
