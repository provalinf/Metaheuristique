package model;

import java.util.ArrayList;

/**
 * Created by Valentin.
 */
public class Etat {
	private ArrayList<Processeur> listProcesseurs;
	private int temperature;

	public Etat(int nbProc) {
		listProcesseurs = new ArrayList<>(nbProc);
	}

	public int getTemp() {
		return temperature;
	}

	public Etat getVoisin() {
		return null;
	}

	public float Cmax() {
		float max = 0;
		for (Processeur p:listProcesseurs)
			max = Math.max(max, p.getSommeDureeT());
		return max;
	}
}
