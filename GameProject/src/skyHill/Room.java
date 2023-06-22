package skyHill;

public class Room {
	Item healItem;
	Item foodItem;
	Zombie zombie;
	int material;
	boolean key;


	public Room(Item healItem, Item foodItem, Zombie zombie, int material, boolean key) {
		this.healItem = healItem;
		this.foodItem = foodItem;
		this.zombie = zombie;
		this.material = material;
		this.key = key;
	}

	public Room() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {

		if (zombie == null || zombie.hp == 0)
			System.out.println("조용하다...\n");

		if (healItem == null)
			System.out.println("치료에 도움되는 것은 없는 것 같다...\n");
		else
			System.out.println(healItem.name +"이 있다.\n");

		if (foodItem == null)
			System.out.println("배를 채울만한 것은 없는 것 같다...\n");
		else
			System.out.println(foodItem.name+"이 있다.\n");
		
		if (material == 0)
			System.out.println("강화에 도움되는 것은 없는 것 같다...");
		else
			System.out.println("강화 재료가 " + material + "개가 있다.");
		
		if (key == true)
			System.out.println("\n호텔키가 있다. 엘리베이터를 이용할 수 있을 수도...?");


		return "";
	}

}
