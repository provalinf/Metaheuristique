package metaheuristique;

import model.Solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Tabou {

    private ArrayList<Solution> tabou;
    private Solution solu;
    private Solution meilleureSolution;
    private int cMax;
    private int nbProcesseurs;
    private int tailleListeTabou;
    private int iteration;

    public Tabou(Solution solu, int tailleListeTabou, int nbProcesseurs) {
        iteration = 0;
        this.nbProcesseurs = nbProcesseurs;
		this.tailleListeTabou = tailleListeTabou;
        tabou = new ArrayList<Solution>(tailleListeTabou);

        //Calcule de la solution initiale
		this.solu = solu;
        meilleureSolution = solu;
        cMax = solu.getCMax();
        tabou.add(solu);

        //Calcule de la meilleure solution
        run();
        System.out.println(meilleureSolution);
        System.out.println("Nombre d'iterations : "+iteration);
    }

    private void run() {
        for (int o = 0; o < 5; o++) {

            ArrayList<Solution> voisin = solu.getVoisin();
            System.out.println(voisin);
            for (int i = 0; i < voisin.size(); i++) {
                int duree = voisin.get(i).getCMax();
                if (duree < cMax && !tabou.contains(voisin.get(i))) {
                    cMax = duree;
					solu = voisin.get(i);
                    meilleureSolution = solu;
                }
                iteration ++;
            }
        }
    }
}
