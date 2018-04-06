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
	private static final float temperatureFinale = 0.9f;
	private Solution etat_actu;
	private int pourc_accept;
	private int iterations;
	private static final float coeff = 0.9f;
	public static final Random RANDOM = new Random();

	public RecuitSimule(float temperature, Solution solInit, int nbProc) {
		this.temperature = temperature;
		etat_actu = solInit;
	}

	public void start() {
		iterations = 0;
		do {
			iterations++;
			int nb_dep = 0;
			Solution voisin = getVoisin();
			if (critMetropolis(voisin.getCMax() - etat_actu.getCMax(), temperature)) {
				etat_actu = voisin;
				nb_dep++;
			}
			pourc_accept = iterations / nb_dep;
			temperature *= coeff;
		} while (temperature < temperatureFinale);
	}

	private Solution getVoisin() {
		ArrayList<Solution> voisins = etat_actu.getVoisin();
		int idVoisin = 0;
		int tmpMax = voisins.get(idVoisin).getCMax();
		for (int j = 0; j < voisins.size(); j++)
			if (voisins.get(j).getCMax() > tmpMax) idVoisin = j;
		return voisins.get(idVoisin);
	}

	public void printResult() {
		System.out.println("Nombre d'itérations : " + iterations);
		System.out.println("Meilleur configuration courante : " + etat_actu.toString());
		System.out.println("Evolution val -> meilleur config : " + etat_actu.getCMax());
		System.out.println("Pourcentage d'acceptation : " + pourc_accept);
	}

	private boolean critMetropolis(int delta, float temperature) {
		if (delta < 0) return true;
		return ThreadLocalRandom.current().nextFloat() < Math.exp(-delta / temperature);
	}
}
