package test;

import metaheuristique.Tabou;
import src.metaheuristique.RecuitSimule;

import java.util.ArrayList;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        int[][] tab = {{1, 2, 3, 4, 5, 6}, {5, 4, 3, 6, 5, 7}};
        //RecuitSimule rs = new RecuitSimule(2);
        Tabou t = new Tabou(tab, 2);
    }
}
