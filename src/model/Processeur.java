package model;

import java.util.ArrayList;

/**
 * Created by Valentin.
 */
public class Processeur {
	private ArrayList<Tache> taches_affectees;
	private int id;

	public Processeur(ArrayList<Tache> taches_affectees, int id) {
		this.taches_affectees = taches_affectees;
		this.id = id;
	}

	public float getSommeDureeT() {
		float tmp = 0;
		for (Tache tache : taches_affectees)
			tmp += tache.getDuree_ope();
		return tmp;
	}

	public void addTache(Tache t) {
		taches_affectees.add(t);
	}

	public void removeTache(Tache t){
		taches_affectees.remove(t);
	}

	public ArrayList<Tache> getTaches_affectees() {
		return taches_affectees;
	}

	public void setTaches_affectees(ArrayList<Tache> taches_affectees) {
		this.taches_affectees = taches_affectees;
	}
}
