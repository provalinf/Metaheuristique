package model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Valentin.
 */
public class RecuitSimule {
	private int temperature;
	private int temperatureFinale;

	public RecuitSimule(int temperature, int temperatureFinale) {
		this.temperature = temperature;
		this.temperatureFinale = temperatureFinale;
	}

	public boolean critMetropolis(int delta, float temperature) {
		if (delta < 0) return true;
		return ThreadLocalRandom.current().nextFloat() < Math.exp(-delta / temperature);
	}
}
