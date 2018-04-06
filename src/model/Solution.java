package model;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Processeur> listeProcesseurs;
    private int nbProcesseurs;

    public Solution(int nbProcesseurs) {
        this.nbProcesseurs = nbProcesseurs;
        listeProcesseurs = new ArrayList<Processeur>();
    }

    public Solution(Solution solutionEnCours) {
        nbProcesseurs = solutionEnCours.nbProcesseurs;
        listeProcesseurs = new ArrayList<Processeur>();
        for (int i = 0; i < nbProcesseurs; i++) {
            listeProcesseurs.get(i).setTaches_affectees(new ArrayList<Tache>(solutionEnCours.getSolProc(i)));
        }

    }

    public ArrayList getSolProc(int noProc) {
        assert 0 < noProc && noProc < nbProcesseurs : "noProc non reconnu";
        return listeProcesseurs.get(noProc).getTaches_affectees();
    }

    public void setSolProc(int noProc, ArrayList e){
        assert 0 < noProc && noProc < nbProcesseurs : "noProc non reconnu";
        listeProcesseurs.get(noProc).getTaches_affectees().addAll(e);
    }


    private int sommeListe(ArrayList<Tache> a){
        int res = 0;
        for (int i = 0; i < a.size(); i++) {
            res += a.get(i).getDuree_ope();
        }
        return res;
    }

    public int getCMax(){
        int res = 0;
        ArrayList<Integer> maxList = new ArrayList<>(nbProcesseurs);
        for (int i = 0; i < nbProcesseurs; i++) {
            maxList.add(i, sommeListe(listeProcesseurs.get(i).getTaches_affectees()));
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
                for (int k = 0; k < listeProcesseurs.get(j).getTaches_affectees().size(); k++) {
                    if (i != j) {
                        Tache tache = listeProcesseurs.get(i).getTaches_affectees().get(k);
                        listeProcesseurs.get(j).addTache(tache);
                        listeProcesseurs.get(i).removeTache(tache);
                        Solution s = new Solution(this);
                        solutions.add(s);
                        listeProcesseurs.get(i).addTache(tache);
                        listeProcesseurs.get(j).removeTache(tache);
                    }
                }
			}
		}
		return solutions;
	}

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < listeProcesseurs.size(); i++) {
            res.append("Processeur "+i+": "+ listeProcesseurs.get(i));
            res.append("\n");
        }
        res.append("Temps max : " + getCMax());
        return res.toString()+"\n\n";
    }

    public void copy(Solution solutionEnCours) {

    }

}
