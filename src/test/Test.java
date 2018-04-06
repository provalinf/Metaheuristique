package test;

import metaheuristique.RecuitSimule;
import metaheuristique.Tabou;
import model.Solution;
import model.Tache;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
		int[] durees = new int[]{5, 4, 3, 6, 12, 7};
		ArrayList<Tache> taches = new ArrayList<>(durees.length);
		for (int id = 0; id < durees.length; id++)
			taches.add(new Tache(id, durees[id]));
		Solution solu = new Solution(2, taches);
		System.out.println("Saisissez la valeur de température initiale ?");
		float temperature = sc.nextFloat();
        RecuitSimule rs = new RecuitSimule(temperature, solu, 2);
        Tabou t = new Tabou(solu, 3);
    }
}
