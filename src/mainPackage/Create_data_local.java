package mainPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Create_data_local {
	
	public void crear_datos() {
		Characters enano=new Characters("Nan", 60, 6, 4, 5, 3);
		Characters humano=new Characters("Humà", 50, 5, 3, 6, 5);
		Characters elfo=new Characters("Elf", 40, 4, 2, 7, 7);
		//
		//[0]=velocitat, [1]=Força
		//[0]=Huma, [1]=Elf, [2]=Nan
		Weapons daga=new Weapons("Daga", new ArrayList<Integer>(Arrays.asList(3,0)), new ArrayList<String>(Arrays.asList("Huma","Elf",null)));
		Weapons espasa=new Weapons("Espasa", new ArrayList<Integer>(Arrays.asList(1,1)), new ArrayList<String>(Arrays.asList("Huma","Elf","Nan")));
		Weapons destral=new Weapons("Destral", new ArrayList<Integer>(Arrays.asList(0,3)), new ArrayList<String>(Arrays.asList("Huma",null,"Nan")));
		Weapons espases_dobles=new Weapons("Espases dobles", new ArrayList<Integer>(Arrays.asList(2,2)), new ArrayList<String>(Arrays.asList("Huma","Elf",null)));
		Weapons simitarra=new Weapons("Espases dobles", new ArrayList<Integer>(Arrays.asList(2,1)), new ArrayList<String>(Arrays.asList("Huma","Elf",null)));
		Weapons arc=new Weapons("Arc", new ArrayList<Integer>(Arrays.asList(5,1)), new ArrayList<String>(Arrays.asList(null,"Elf",null)));
		Weapons katana=new Weapons("katana", new ArrayList<Integer>(Arrays.asList(3,2)), new ArrayList<String>(Arrays.asList("Huma",null,null)));
		Weapons punyal=new Weapons("Punyal", new ArrayList<Integer>(Arrays.asList(4,0)), new ArrayList<String>(Arrays.asList("Huma","Elf","Nan")));
		Weapons destral_de_dues_mans=new Weapons("Destral de dues mans", new ArrayList<Integer>(Arrays.asList(0,5)), new ArrayList<String>(Arrays.asList(null,null,"Nan")));


		
		
	}
	
	
	public static void main(String[] args) {
		Weapons pepe_enano = new Weapons(null, null, null) ;
		System.out.println("pepe");

	}

}
