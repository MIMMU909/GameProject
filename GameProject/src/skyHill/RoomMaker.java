package skyHill;

import java.util.Random;

public class RoomMaker {
	Random rnd = new Random();

	Item[] healItems = new Item[4];
	Item[] foodItems = new Item[9];
	Zombie[] zombies = new Zombie[5];

	public RoomMaker() {
		healItems[0] = new Item("소형응급도구", 15, 0);
		healItems[1] = new Item("응급도구", 25, 0);
		healItems[2] = new Item("대형응급도구", 80, 0);
		healItems[3] = new Item("메디팩", 100, 0);

		foodItems[0] = new Item("사과", 0, 10);
		foodItems[1] = new Item("썩은과일", -5, 7);
		foodItems[2] = new Item("빵", 0, 15);
		foodItems[3] = new Item("통조림", 0, 25);
		foodItems[4] = new Item("애완동물먹이", 0, 20);
		foodItems[5] = new Item("초콜렛", 0, 10);
		foodItems[6] = new Item("썩은고기", -7, 25);
		foodItems[7] = new Item("주스", 0, 5);
		foodItems[8] = new Item("햄버거", 0, 100);

		zombies[0] = new Zombie("평범한 좀비", 30, 5, 30);
		zombies[1] = new Zombie("고깃덩어리", 30, 1, 40);
		zombies[2] = new Zombie("헬창 좀비", 50, 10, 50);
		zombies[3] = new Zombie("변형된 좀비", 100, 20, 80);
		zombies[4] = new Zombie("거인 좀비", 120, 40, 100);
	}

	public Room setRoom(int luck) {
		Room room = null;
		Item healItem = null;
		Item foodItem = null;
		Zombie zombie = null;
		int material = 0;
		boolean key = false;

		if (Main.floorNumber > 1) {
			if (rnd.nextInt(100) > 85 - luck) { // 20퍼
				healItem = healItems[rnd.nextInt(4)];
			}
			if (rnd.nextInt(100) > 85 - luck) { // 20퍼
				foodItem = foodItems[rnd.nextInt(9)];
			}
			if (rnd.nextInt(100) < 75 - luck) { // 60퍼
				if (Main.floorNumber > 80)
					zombie = zombies[0];
				else if (Main.floorNumber > 40)
					zombie = zombies[rnd.nextInt(3)];
				else if (Main.floorNumber > 15)
					zombie = zombies[rnd.nextInt(2) + 2];
				else
					zombie = zombies[rnd.nextInt(2) + 3];
			}
			if (rnd.nextInt(100)+1 == 24) { // 1퍼
			key = true;
			}
			material = rnd.nextInt(10);

			room = new Room(healItem, foodItem, zombie, material, key);

		}
		return room;
	}

	public Zombie setZombie(int luck) {

		Zombie z = null;

		if (rnd.nextInt(100) < 75 - luck) { // 70퍼
			if (Main.floorNumber > 80)
				z = zombies[0];
			else if (Main.floorNumber > 40)
				z = zombies[rnd.nextInt(3)];
			else if (Main.floorNumber > 15)
				z = zombies[rnd.nextInt(2) + 2];
			else
				z = zombies[rnd.nextInt(2) + 3];
		}

		return z;
	}
}
