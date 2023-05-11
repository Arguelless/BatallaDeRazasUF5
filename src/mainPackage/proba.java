package mainPackage;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class proba extends JFrame {

    private JTextArea textArea;
    private JScrollPane scrollPane;

    public proba() {
        super("Componente de texto con scrollbar");

        // Crear un JTextArea
        textArea = new JTextArea();

        // Añadir el JTextArea a un JScrollPane
        scrollPane = new JScrollPane(textArea);
        
        // Añadir el JScrollPane a un JPanel
        JPanel mainPanel = new JPanel();
        mainPanel.add(scrollPane,BorderLayout.CENTER);

        // Añadir el JPanel al JFrame
        getContentPane().add(mainPanel);

        // Configurar el JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	Database d = new Database();
    	try {
			for (String[] i:d.getAllWarrior()) {
				for (String i2:i) {
					System.out.println(i2);
				}
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	
    }

}
