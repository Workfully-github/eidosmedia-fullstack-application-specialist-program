package Projects.Products_List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class GUI {

    public GUI() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));;
    }
    
    public static void main(String[] args) {
        
        new GUI();
    }
}
