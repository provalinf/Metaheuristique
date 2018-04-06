package model;

import java.util.ArrayList;

/**
 * Created by Valentin.
 */
public class Etat {
	private ArrayList<Processeur> listProcesseurs;
	private int temperature;
	private int nbProc;

	public Etat(int nbProc) {
		listProcesseurs = new ArrayList<>(nbProc);
		this.nbProc = nbProc;
	}

	public int getTemp() {
		return temperature;
	}

	public float Cmax() {
		float max = listProcesseurs.get(0).getSommeDureeT();
		for (Processeur p : listProcesseurs)
			max = Math.max(max, p.getSommeDureeT());
		return max;
	}


}
