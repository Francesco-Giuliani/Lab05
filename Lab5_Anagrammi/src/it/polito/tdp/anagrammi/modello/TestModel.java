package it.polito.tdp.anagrammi.modello;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model model = new Model();
		model.generaAnagrammi("mora");
		
		System.out.println("Corretti:");
		for(Anagramma a: model.getAnagrammiCorretti()) {
			System.out.println(a.toString());
		}
		System.out.println("Errati:");
		for(Anagramma a: model.getAnagrammiErrati()) {
			System.out.println(a);
		}
		System.out.println("Parziali:");
		for(Anagramma a: model.getAnagrammiParziali()) {
			System.out.println(a.toString());
		}
	}

}
