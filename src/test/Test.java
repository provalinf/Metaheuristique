package test;

import metaheuristique.RecuitSimule;
import metaheuristique.Tabou;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] tab = {5, 4, 3, 6, 12, 7};
		System.out.println("Saisissez la valeur de température initiale ?");
		float temperature = sc.nextFloat();
        RecuitSimule rs = new RecuitSimule(temperature, 2);
        Tabou t = new Tabou(tab, 3);
    }
}
