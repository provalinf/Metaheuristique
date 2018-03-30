package src.test;

import src.metaheuristique.RecuitSimule;
import src.metaheuristique.Tabou;

import javax.swing.text.TabableView;
import java.util.ArrayList;

public class Test {
    private int[][] tab = { {1,2,3,4,5,6},{5,4,3,6,5,7} };

    public Test() {
    }

    public static void main(String[] args) {
        //RecuitSimule rs = new RecuitSimule(2);
        Tabou t = new Tabou(2);
    }
}
