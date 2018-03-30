package model;

/**
 * Created by Valentin.
 */
public class Tache {
	private int temperature;
	private float temps;

	public Tache(int temperature, float temps) {
		this.temperature = temperature;
		this.temps = temps;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public float getTemps() {
		return temps;
	}

	public void setTemps(float temps) {
		this.temps = temps;
	}
}
