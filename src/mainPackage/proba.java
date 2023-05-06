package mainPackage;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class proba extends AbstractAction {
    
    private String data;
    
    public proba(String data) {
        this.data = data;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("El botón ha sido presionado. La data es: " + data);
    }
    
    public String getData() {
        return data;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(new proba("Botón " + (i+1)));
            panel.add(button);
        }
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
