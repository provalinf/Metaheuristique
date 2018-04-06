package test;

import metaheuristique.Tabou;

import java.util.ArrayList;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        int[] tab = {5, 4, 3, 12, 7, 8, 6, 8};
        //RecuitSimule rs = new RecuitSimule(2);
        Tabou t = new Tabou(tab, 3);
    }
}
