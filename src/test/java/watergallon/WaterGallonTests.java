package watergallon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class WaterGallonTests {

	@Test
	void fillGallonNoLeftover() {
		var totalVolume = 7.0;

		var bottles = new ArrayList<Bottle>();
		bottles.add(new Bottle(1, 1.0));
		bottles.add(new Bottle(2, 3.0));
		bottles.add(new Bottle(3, 4.5));
		bottles.add(new Bottle(4, 1.5));
		bottles.add(new Bottle(5, 3.5));

		var waterGallon = new WaterGallon(totalVolume, bottles);
		waterGallon.fillGallon();

		var volumesExpected = List.of(1.0, 4.5, 1.5);
		var volumes = waterGallon.getUsedBottles().stream().map(Bottle::getVolume)
				.collect(Collectors.toUnmodifiableList());

		assertEquals(volumesExpected, volumes);
		assertEquals(totalVolume, waterGallon.getGallonVolume());
		assertEquals(0.0, waterGallon.getLeftover());
	}

	@Test
	void fillGallonWithLeftover() {
		var totalVolume = 5.0;

		var bottles = new ArrayList<Bottle>();
		bottles.add(new Bottle(1, 1.0));
		bottles.add(new Bottle(2, 3.0));
		bottles.add(new Bottle(3, 4.5));
		bottles.add(new Bottle(4, 1.5));

		var waterGallon = new WaterGallon(totalVolume, bottles);
		waterGallon.fillGallon();

		var volumesExpected = List.of(1.0, 4.5);
		var volumes = waterGallon.getUsedBottles().stream().map(Bottle::getVolume)
				.collect(Collectors.toUnmodifiableList());

		assertEquals(volumesExpected, volumes);
		assertEquals(totalVolume, waterGallon.getGallonVolume());
		assertEquals(0.5, waterGallon.getLeftover());
	}

	@Test
	void fillGallonWith2BottlesNoLeftover() {
		var totalVolume = 4.9;

		var bottles = new ArrayList<Bottle>();
		bottles.add(new Bottle(1, 4.5));
		bottles.add(new Bottle(2, 0.4));

		var waterGallon = new WaterGallon(totalVolume, bottles);
		waterGallon.fillGallon();

		var volumesExpected = List.of(4.5, 0.4);
		var volumes = waterGallon.getUsedBottles().stream().map(Bottle::getVolume)
				.collect(Collectors.toUnmodifiableList());

		assertEquals(volumesExpected, volumes);
		assertEquals(totalVolume, waterGallon.getGallonVolume());
		assertEquals(0.0, waterGallon.getLeftover());
	}

}
