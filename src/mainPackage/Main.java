package mainPackage;

public class Main {

	public static void main(String[] args) {
		Starting_Window Start=new Starting_Window();

		while (true) {
			try {
				System.out.println(Start.return_data().toString());
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
