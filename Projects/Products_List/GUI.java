package Projects.Products_List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private int count = 0;
    JLabel label;
    JFrame frame;
    JButton button;
    JPanel panel;

    public GUI() {

        frame = new JFrame();
        button = new JButton("Run program");
        button.addActionListener(this);
        label = new JLabel("Number of clicks in the button: 0");
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Eidostore");
        frame.pack();
        frame.setVisible(true);
    }
    
    /* public static void main(String[] args) {
        
        new GUI();
    } */

    @Override
    public void actionPerformed(ActionEvent e) {
        count ++;
        label.setText("Number of clicks in the button: " + count);
    }

}
