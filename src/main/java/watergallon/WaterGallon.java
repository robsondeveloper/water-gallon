package watergallon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WaterGallon {

	private double totalVolume;
	private List<Bottle> bottles;
	private List<Bottle> usedBottles;
	private double gallonVolume;
	private double leftover;

	public WaterGallon(double totalVolume, List<Bottle> bottles) {
		this.totalVolume = totalVolume;
		this.bottles = bottles;
		this.usedBottles = new ArrayList<Bottle>();
		this.gallonVolume = 0.0;
		this.leftover = 0.0;
	}

	public void fillGallon() {
		Collections.sort(bottles, Comparator.comparing(Bottle::getVolume, Comparator.reverseOrder()));

		while (gallonVolume < totalVolume) {
			for (Bottle bottle : bottles) {
				if (bottle.getVolume() <= (totalVolume - gallonVolume)) {
					gallonVolume += bottle.getVolume();
					usedBottles.add(bottle);
				}
			}
			if (gallonVolume < totalVolume) {
				var bottleSmallerVolume = bottles.get(bottles.size() - 1);
				var neededVolume = totalVolume - gallonVolume;
				gallonVolume += neededVolume;
				leftover = bottleSmallerVolume.getVolume() - neededVolume;
				usedBottles.add(bottleSmallerVolume);
			}
		}

		Collections.sort(usedBottles, Comparator.comparing(Bottle::getId));
	}

	public List<Bottle> getUsedBottles() {
		return usedBottles;
	}

	public double getGallonVolume() {
		return gallonVolume;
	}

	public double getLeftover() {
		return leftover;
	}

}
