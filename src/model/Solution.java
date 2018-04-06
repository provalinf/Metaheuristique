package model;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Tache> solution;
    private int nbProcesseurs;

    public Solution(int nbProcesseurs) {
        this.nbProcesseurs = nbProcesseurs;
        solution = new ArrayList<Tache>();
        for (int i = 0; i < nbProcesseurs; i++) {
            solution.add(new ArrayList<Tache>());
        }
    }

    public Solution(Solution solutionEnCours) {
        nbProcesseurs = solutionEnCours.nbProcesseurs;
        solution = new ArrayList<Tache>();
        for (int i = 0; i < nbProcesseurs; i++) {
            solution.add(new ArrayList<Tache>(solutionEnCours.getSolProc(i)));
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

	public ArrayList<Solution> getVoisin() {
		ArrayList<Solution> solutions = new ArrayList<>();
		for (int i = 0; i < nbProcesseurs; i++) {
			for (int j = 0; j < nbProcesseurs; j++) {
                for (int k = 0; k < getProc(j).size(); k++) {
                    if (i != j) {
                        Tache tache = getProc(i).get(k);
                        int tache = getProc(i).get(k);
                        getProc(j).add(getProc(i).);
                        getProc(i).remove(tache);
                        Solution s = new Solution(this);
                        solutions.add(s);
                        getProc(i).add(tache);
                        getProc(j).remove(getProc(j).size() - 1);
                    }
                }
			}
		}
		return solutions;
	}

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < solution.size(); i++) {
            res.append("Processeur "+i+": "+solution.get(i));
            res.append("\n");
        }
        res.append("Temps max : " + getCMax());
        return res.toString()+"\n\n";
    }

    public ArrayList<Tache> getProc(int proc){
        return solution.get(proc);
    }

    public void removeTask(int proc, int tache) {
        solution.get(proc).remove(tache);
    }

    public void copy(Solution solutionEnCours) {

    }

}
