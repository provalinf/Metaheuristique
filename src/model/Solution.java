package model;

import java.util.ArrayList;

public class Solution {
    private ArrayList<ArrayList> solution;
    private int nbProcesseurs;

    public Solution(int nbProcesseurs) {
        this.nbProcesseurs = nbProcesseurs;
        solution = new ArrayList<ArrayList>();
        for (int i = 0; i < nbProcesseurs; i++) {
            solution.add(new ArrayList());
        }
    }

    public ArrayList getSolProc(int noProc) {
        assert 0 < noProc && noProc < nbProcesseurs : "noProc non reconnu";
        return solution.get(noProc);
    }

    public void setSolProc(int noProc, ArrayList e){
        assert 0 < noProc && noProc < nbProcesseurs : "noProc non reconnu";
        solution.get(noProc).addAll(e);
    }
}
