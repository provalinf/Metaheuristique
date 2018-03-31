package metaheuristique;

import model.Solution;

import java.util.ArrayList;

public class Tabou {

    private ArrayList tabou;
    private Solution solutionInitiale;
    private int meilleurMouv;

    public Tabou(int[] tab, int nbProcesseurs) {
        tabou = new ArrayList();
        solutionInitiale = new Solution(nbProcesseurs);

        for (int i = 0; i < nbProcesseurs; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < tab.length / nbProcesseurs; j++) {
                a.add(tab[j + i * tab.length / nbProcesseurs]);
            }
            if (tab.length % 2 == 1 && i == nbProcesseurs - 1) {
                a.add(tab[tab.length-1]);
            }
            solutionInitiale.setSolProc(i, a);
        }
    }
}
