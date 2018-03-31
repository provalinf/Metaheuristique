package model;

import java.util.ArrayList;

public class Solution {
    private ArrayList<ArrayList> solution;
    private int nbProcesseurs;

    public Solution(int nbProcesseurs) {
        this.nbProcesseurs = nbProcesseurs;
        solution = new ArrayList<ArrayList>();
        for (int i = 0; i < nbProcesseurs; i++) {
            solution.add(new ArrayList<Integer>());
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


    private int sommeListe(ArrayList<Integer> a){
        int res = 0;
        for (int i = 0; i < a.size(); i++) {
            res += a.get(i);
        }
        return res;
    }

    public int getCMax(){
        int res = 0;
        ArrayList<Integer> maxList = new ArrayList<>(nbProcesseurs);
        for (int i = 0; i < nbProcesseurs; i++) {
            maxList.add(i, sommeListe(solution.get(i)));
        }
        res = getMax(maxList);
        return res;
    }

    private int getMax(ArrayList<Integer> maxList) {
        int max = maxList.get(0);
        for (int i = 1; i < maxList.size(); i++) {
            if(max<maxList.get(i)){
                max = maxList.get(i);
            }
        }
        return max;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < solution.size(); i++) {
            res.append("Processeur "+i+": "+solution.get(i));
            res.append("\n");
        }
        res.append("Temps max : " + getCMax());
        return res.toString();
    }
}
