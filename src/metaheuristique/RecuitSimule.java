package metaheuristique;

import model.Solution;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Valentin.
 */
public class RecuitSimule {
	private float temperature;
	private static final float temperatureFinale = 0.1f;
	private Solution etat_actu;
	private int taux_accept;
	private static final float coeff = 0.9f;
	public static final Random RANDOM = new Random();


	public RecuitSimule(float temperature, Solution solInit,int nbProc) {
		this.temperature = temperature;
		etat_actu = solInit;
	}

	public void recuitSimule() {
		int i = 0;
		do {
			i++;
			int nb_dep = 0;
			ArrayList<Solution> voisins = etat_actu.getVoisin();
			int idVoisin = 0;
			int tmpMax = voisins.get(idVoisin).getCMax();
			for (int j = 0; j < voisins.size(); j++) {
				if (voisins.get(j).getCMax() > tmpMax) idVoisin = j;
			}
			Solution voisin = voisins.get(idVoisin);
			if (critMetropolis(voisin.getCMax() - etat_actu.getCMax(), temperature)) {
				etat_actu = voisin;
				nb_dep++;
			}
			taux_accept = i / nb_dep;
			temperature *= coeff;
		} while (temperature < temperatureFinale);
	}

	public boolean critMetropolis(int delta, float temperature) {
		if (delta < 0) return true;
		return ThreadLocalRandom.current().nextFloat() < Math.exp(-delta / temperature);
	}
}
