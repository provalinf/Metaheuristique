package metaheuristique;

import java.util.ArrayList;

public class Tabou {

    private ArrayList tabou;
    private int[][] solutionInitiale;
    private int meilleurMouv;

    public Tabou(int[][] tab, int nbProcesseurs) {
        tabou = new ArrayList();
        solutionInitiale = new int[nbProcesseurs][tab.length];
        for (int i = 0; i < solutionInitiale[0].length/2; i++) {
            solutionInitiale[0][i] = tab[i][1];
            solutionInitiale[1][tab.length / 2 + i] = tab[tab.length / 2 + i][1];
        }

        for (int i = 0; i < solutionInitiale.length; i++) {
            for (int j = 0; j < solutionInitiale[0].length; j++) {
                System.out.println(solutionInitiale[i][j]);
            }
        }
    }
}
