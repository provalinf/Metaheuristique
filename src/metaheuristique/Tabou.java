package metaheuristique;

import model.Solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Tabou {

    private ArrayList<Solution> tabou;
    private Solution solutionEnCours;
    private Solution meilleureSolution;
    private int cMax;
    private int nbProcesseurs;
    private int[] tab;
    private int tailleListeTabou;
    private int iteration;

    public Tabou(int[] tab, int nbProcesseurs) {
        iteration = 0;
        this.nbProcesseurs = nbProcesseurs;
        this.tab = tab;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir la taille de la liste tabou :");
        tailleListeTabou = Integer.parseInt(sc.nextLine());
        tabou = new ArrayList<Solution>(tailleListeTabou);

        //Calcule de la solution initiale
        solInit();
        meilleureSolution = solutionEnCours;
        cMax = solutionEnCours.getCMax();
        tabou.add(solutionEnCours);

        //Calcule de la meilleure solution
        run();
        System.out.println(meilleureSolution);
        System.out.println("Nombre d'iterations : "+iteration);
    }

    private void run() {
        for (int o = 0; o < 5; o++) {

            ArrayList<Solution> voisin = solutionEnCours.getVoisin();
            for (int i = 0; i < voisin.size(); i++) {
                int duree = voisin.get(i).getCMax();
                if (duree < cMax && !tabou.contains(voisin.get(i))) {
                    cMax = duree;
                    solutionEnCours = voisin.get(i);
                    meilleureSolution = solutionEnCours;
                }
                iteration ++;
            }
        }
    }

    private void solInit() {
        solutionEnCours = new Solution(nbProcesseurs);
        for (int i = 0; i < nbProcesseurs; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < tab.length / nbProcesseurs; j++) {
                a.add(tab[j + i * tab.length / nbProcesseurs]);
            }
            if (tab.length % 2 == 1 && i == nbProcesseurs - 1) {
                a.add(tab[tab.length - 1]);
            }
            solutionEnCours.setSolProc(i, a);
        }
    }
}
