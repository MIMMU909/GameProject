package skyHill;

public class Item {
	String name;
	int hp;
	int hunger;

	public Item(String name, int hp, int hunger) {
		this.name = name;
		this.hp = hp;
		this.hunger = hunger;
	}

	@Override
	public String toString() {
		String info = this.name + "(";
		if (this.hp != 0)
			info += "체력 +" + this.hp;
		if (this.hunger > 0)
			info += "배고픔 +" + this.hunger;
		info+=")";
		return info;
	}

}
