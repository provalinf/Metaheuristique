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
		Solution solu = new Solution(2);
		solu.soladdTaches(durees);

		System.out.println("Saisissez la valeur de température initiale pour le recuit simulé");
		float temperature = sc.nextFloat();
		RecuitSimule rs = new RecuitSimule(temperature, solu, 2);
		rs.start();
		rs.printResult();

		System.out.println("Saisissez la taille de la liste tabou");
		int taille = Integer.parseInt(sc.nextLine());
		Tabou t = new Tabou(solu, taille, 3);
	}
}
