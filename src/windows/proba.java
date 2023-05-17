package windows;

import java.sql.SQLException;
import java.util.ArrayList;

import playerClasses.Database;

public class proba {

	public static void main(String[] args) {
		new Ranking();
		/*
		Database d =new Database();
		ArrayList<Object[]>  data = new ArrayList<Object[]>();
		try {

			//{2, "Ana", 150},
			for (int i=1; i<d.getRankingTotal()+1; i++) {
			    data.add(new Object[] {d.getRanking(i)[0],d.getWarrior(d.getRanking(i)[1])[0],d.getRanking(i)[2]} );
			    
			}
			
			for (Object[] o: data) {
				for (Object o1: o) {
					System.out.println(o1.toString());
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
