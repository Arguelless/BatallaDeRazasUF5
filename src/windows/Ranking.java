package windows;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import playerClasses.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Ranking extends JFrame implements ActionListener {
    private int position = 0;
    private BufferedImage icon;
    private Database d;
    private ArrayList<Object[]> data = new ArrayList<Object[]>();
    private JButton exit;
    public Ranking() {
        super("Ranking");
        loadIcon();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(icon);
        
        exit = new JButton("Exit");
        // Create sample data for the ranking
        d = new Database();

        try {
            for (int i = 1; i <= d.getRankingTotal(); i++) {
                data.add(new Object[] { 0,d.getRanking(i)[0], d.getWarrior(d.getRanking(i)[1])[0], d.getRanking(i)[2] });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create a custom Comparator to sort the data by score
        Comparator<Object[]> scoreComparator = new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                // Get the scores from the objects
                int score1 = (int) o1[3];
                int score2 = (int) o2[3];
                // Compare the scores and return the result
                return Integer.compare(score2, score1); // Sort in descending order
            }
        };

        // Sort the data using the custom Comparator
        data.sort(scoreComparator);
        for (Object[] o : data) {
            position += 1;
            o[0] = position;
        }

        // Create the data model for the table
        String[] columnNames = new String[] { "Position", "Player ID","Name", "Score" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (Object[] o : data) {
            tableModel.addRow(o);
        }

        // Create the table using the data model
        JTable table = new JTable(tableModel);

        // Add the table to a JScrollPane to allow scrolling
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        add(exit,BorderLayout.SOUTH);
        // For exit button
        exit.addActionListener(this);
        // Show the ranking window
        setVisible(true);
    }

    public void loadIcon() {
        try {
            icon = ImageIO.read(new File("./src/Images/Game_icon.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
				new Starting_Window();
				this.dispose();
				
			}
			
		}
		
	}

