package model;

/**
 * Created by Valentin.
 */
public class Tache {
	private int id;
	private int temperature;
	private float duree_ope;

	public Tache(int id, float duree_ope) {
		this.id = id;
		this.temperature = temperature;
		this.duree_ope = duree_ope;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public float getDuree_ope() {
		return duree_ope;
	}

	public void setDuree_ope(float duree_ope) {
		this.duree_ope = duree_ope;
	}

	@Override
	public String toString() {
		return "Tache{" +
				"id=" + id +
				", duree_ope=" + duree_ope +
				'}';
	}
}
