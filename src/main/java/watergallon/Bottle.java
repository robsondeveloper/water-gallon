package watergallon;

import java.util.Objects;

public class Bottle {

	private int id;
	private double volume;

	public Bottle(int id, double volume) {
		this.id = id;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public double getVolume() {
		return volume;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bottle other = (Bottle) obj;
		return Objects.equals(id, other.id);
	}

}
