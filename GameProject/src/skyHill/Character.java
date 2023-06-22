package skyHill;

import java.util.Random;

public class Character {
	int input;

	Random rnd = new Random();
	int hunger;
	int hp;
	int str;
	int luck;
	int exp;
	int nextExp;
	int level;
	int skillPoint = 0;
	Item[] inventory = new Item[0];
	int[] itemCount = new int[0];
	int material = 0;
	int weaponGrade = 9;
	boolean haveKey = false;
	boolean isDead = false;
	String[] weaponStrings = new String[] { "너덜너덜하다.", "약하다.", "조금 약하다.", "평범하다.", "조금 강하다.", "강력하다.", "매우 강력하다.",
			"스치면 죽을 것 같다.", "살상무기다." };


	public Character() {
		this.str = 5;
		this.luck = 5;
		this.exp = 0;
		this.nextExp = 100;
		this.level = 1;
		this.hp = 100;
		this.hunger = 100;
	}

	public void showInfo() {
		inventory: while (true) {
			System.out.println();
			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.println("		상태         ");
			System.out.println("──────────────────────────────────────────────────────────────────────");

			System.out.println();
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⠀⠠⣴⣦⣤⣄⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀");
			System.out.printf("	레  벨	:  " + this.level);
			System.out.println("\t\t\t     ⠀⠀⢿⣿⣿⣏⡀⠀⠀⠀⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⣷⣄⡀⠀⠀⠀⠀");
			System.out.print("	체  력	:  " + this.hp + "/" + 100);
			System.out.println("\t\t⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀");
			System.out.print("	배고픔	:  " + this.hunger + "/" + 100);
			System.out.println("\t\t⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡧⠀⠀");
			System.out.print("	힘	:  " + this.str);
			System.out.println("\t\t\t⠀⠀⠀⢠⣿⡿⣿⣿⣿⣿⣿⣿⡿⢽⣿⡇⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⢀⣼⣿⢅⣿⣿⣿⣿⣿⣿⡇⢹⣿⠇⠀⠀");
			System.out.print("	행  운	:  " + this.luck);
			System.out.println("\t\t\t⠀⠀⠈⠻⠷⠱⣿⣿⣿⣿⣿⣿⣧⣾⣿⡄⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⠟⠛⠋⠀⠀⠀");
			System.out.print("	경험치	:  " + this.exp + "/" + this.nextExp);
			System.out.println("\t\t⠀⠀⠀⠀⠀⠀⣿⣿⣟⢸⣿⣿⡀⠀⠀⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⠀⢺⣿⣯⠈⣿⣿⡇⠀⠀⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⣿⣿⣿⠀⠀⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⠀⢸⣿⣿⡄⣿⣿⣿⠀⠀⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⣀⣤⣼⣿⣿⠇⣿⣿⣿⠀⠀⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠉⠉⠉⠉⣉⣼⣿⣿⡟⠀⠀⠀⠀⠀");
			System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀");

			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.println("		아이템         ");
			System.out.println("──────────────────────────────────────────────────────────────────────");
			for (int i = 0; i < this.inventory.length; i++) {
				if ((i + 1) % 3 == 0)
					System.out.println("\n");
				System.out.printf("%d. %s\t: %d개\t", (i + 1), inventory[i].name, itemCount[i]);
			}
			System.out.println();
			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.print(" 1.아이템사용 │ ");
			if (this.skillPoint != 0) {
				System.out.printf("2.스킬포인트사용(%d) │ ", this.skillPoint);
			}
			System.out.println("0.나가기");
			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.print(">> ");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				if (this.inventory.length == 0)
					System.out.println("\n아이템이 없다.");
				else {
					isDead = useItem();
					if (isDead)
						break inventory;
				}
				break;
			case 2:
				if (this.skillPoint == 0)
					break;
				useSkillPoint();
				break;
			case 0:
				break inventory;
			default:
				break;
			}
		}
	}

	private boolean useItem() {
		useItem: while (true) {
			System.out.println("\n사용할 아이템 번호를 입력");
			System.out.println();
			System.out.print(">> ");
			input = ScanUtil.nextInt();
			System.out.println();
			if (input <= 0 || input > this.inventory.length) {
				System.out.println("\n잘못 입력했다...");
				continue;
			}
			System.out.printf(" %s : 체력 : %d │ 배고픔 : %d\n", inventory[input - 1].name, inventory[input - 1].hp,
					inventory[input - 1].hunger);
			System.out.println();
			System.out.println("사용하겠습니까?(y/n)");
			System.out.println();
			System.out.print(">> ");
			String inputString = ScanUtil.nextLine();
			if (inputString.equals("y")) {
				this.hp += inventory[input - 1].hp;
				System.out.printf("\n%s을(를) 사용했다. (체력 : %d up │ 배고픔 : %d up)\n", inventory[input - 1].name,
						inventory[input - 1].hp, inventory[input - 1].hunger);
				if (this.hp > 100)
					this.hp = 100;
				else if (this.hp <= 0)
					return true;
				this.hunger += inventory[input - 1].hunger;
				if (this.hunger > 100)
					this.hunger = 100;
				 desoryItem(input-1);
				return false;
			} else
				return false;
		}
	}
	
	public void desoryItem(int num) {
		this.itemCount[num]--;
		if (this.itemCount[num] == 0) {
			Item[] temp = new Item[this.inventory.length - 1];
			int[] tempInt = new int[this.itemCount.length - 1];
			int tune = 0;
			for (int i = 0; i < temp.length; i++) {
				if (i == num)
					tune++;
				temp[i] = this.inventory[i + tune];
				tempInt[i] = this.itemCount[i + tune];
			}
			
			inventory = temp;
			itemCount = tempInt;
		}
	}
	
	

	private void useSkillPoint() {
		skill: while (this.skillPoint != 0) {
			System.out.printf("\n───── 사용 가능한 스킬포인트 : %d ─────\n", this.skillPoint);
			System.out.println();
			System.out.println(" 힘	:  " + this.str);
			System.out.println();
			System.out.println(" 행  운	:  " + this.luck);
			System.out.println();
			System.out.println("────────────────────────────────────────");
			System.out.println();
			System.out.println("──────────────────────────────────────────────────────────────────────");

			System.out.println(" 1.힘 (공격력 + 1) │ 2.행운 (랜덤 행운 + 1) │ 0.나가기");
			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.print(">> ");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				System.out.println();
				System.out.println("더 강해진 기분이다.");
				this.str++;
				this.skillPoint--;
				break;
			case 2:
				System.out.println();
				System.out.println("좋은 일이 일어날 것만 같다.");
				this.luck++;
				this.skillPoint--;
				break;
			case 0:
				break skill;
			default:
				break;
			}
		}
	}

	public void attack(int input, Zombie zombie) {
		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────────");

		System.out.printf(" 전투 중                                    체력 : %d │ 배고픔 : %d\n", this.hp, this.hunger);
		System.out.println("──────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println(">> 내 턴");
		System.out.println();
		int damage = this.str - (int) Math.round(this.str*0.5);
		if (input == 1) {
			damage = 0;
			if (rnd.nextInt(100) > (65 - this.luck)) // 40퍼
				damage = this.str + rnd.nextInt((int) Math.round(this.str * 1.5)) + 1;
			System.out.println("당신은 적의 머리를 공격한다.\n");
		} else
			System.out.println("당신은 적의 몸통을 공격한다.\n");
		zombie.hp -= damage;
		zombie.hp = zombie.hp < 0 ? 0 : zombie.hp;

		if (damage == 0)
			System.out.printf("%s가 공격을 회피했다!\n", zombie.name);
		else
			System.out.printf("%s에게 %d만큼 데미지를 줬다.\n", zombie.name, damage);
		System.out.println();
		System.out.printf("%s의 남은 HP : %d\n", zombie.name, zombie.hp);
		System.out.println();

	}

	public void getExp(int exp) {
		System.out.printf("%dexp를 얻었다.", exp);
		System.out.println();
		this.exp += exp;
		int i = 0;
		while (this.exp >= this.nextExp) {
			this.exp -= this.nextExp;
			levelUp();
			i++;
		}
		this.skillPoint += i * 5;
		if (i != 0)
			System.out.printf("\n%d만큼 레벨업 했다.\n\n올릴 수 있는 스킬 포인트 : %d\n", i, this.skillPoint);

	}

	private void levelUp() {
		this.level++;
		this.nextExp = (int) Math.round(this.nextExp * 1.5);

	}

	public Room getItem(Room room) {
		if (room.healItem == null && room.foodItem == null && room.material == 0) {
			System.out.println();
			System.out.println("가져갈 만한 물건이 없다...\n");
		}
		if (room.healItem != null) {
			System.out.println();
			System.out.println(room.healItem.name + "을(를) 얻었다.");
			storeItem(room.healItem);
		}
		if (room.foodItem != null) {
			System.out.println();
			System.out.println(room.foodItem.name + "을(를) 얻었다.");
			storeItem(room.foodItem);
		}
		if (room.material != 0) {
			System.out.println();
			System.out.println("강화재료 " + room.material + "개를 얻었다.\n");
			this.material += room.material;
		}
		if(room.key==true) {
			this.haveKey=true;
		}
		room.healItem = null;
		room.foodItem = null;
		room.material = 0;
		room.key = false;

		return room;

	}

	private void storeItem(Item item) {
		for (int i = 0; i < this.inventory.length; i++) {
			if (this.inventory[i].name.equals(item.name)) {
				this.itemCount[i]++;
				return;
			}
		}
		Item[] temp = new Item[this.inventory.length + 1];
		int[] tempInt = new int[itemCount.length + 1];

		for (int i = 0; i < this.inventory.length; i++) {
			temp[i] = inventory[i];
			tempInt[i] = itemCount[i];
		}
		temp[temp.length - 1] = new Item(item.name, item.hp, item.hunger);
		tempInt[tempInt.length - 1] = 1;
		this.inventory = temp;
		this.itemCount = tempInt;

	}

	public void weapon() {
		weapon: while (true) {
			System.out.println();
			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.println("		무기강화         ");
			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.println("최대 1등급까지 강화 가능하다.");
			System.out.println();
			int upgradePercentage = (this.weaponGrade + 1) * 10;
			int upgradeCost = (10 - this.weaponGrade) * 10;
			System.out.print("현재 당신의 야구방망이는 ");
			System.out.print(weaponStrings[9 - weaponGrade]);
			System.out.printf(" (%d등급)\n", this.weaponGrade);
			System.out.println();
			System.out.printf("강화에 필요한 재료 개수 : %d\n", upgradeCost);
			System.out.println();
			System.out.printf("현재 강화 재료 개수 : %d\n", this.material);
			System.out.println();
			System.out.println("──────────────────────────────────────────────────────────────────────");
			if (this.weaponGrade == 1)
				System.out.println(" 0.나가기");
			else
				System.out.printf(" 1.강화(확률 : %d%s) │ 0.나가기\n", upgradePercentage, "%");
			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.print(">> ");
			input = ScanUtil.nextInt();
			System.out.println();
			switch (input) {
			case 1:
				if (this.weaponGrade == 1) {
					System.out.println("당신의 무기는 최대로 강화됐다.");
					break;
				}
				if (this.material < upgradeCost) {
					System.out.println("강화 재료가 부족하다...");
				} else if (rnd.nextInt(95) + 1 <= upgradePercentage + this.luck) {
					System.out.println("강화 성공!");
					System.out.println();
					System.out.println("당신의 공격력이 올랐다. (+5)");
					this.material -= upgradeCost;
					this.weaponGrade--;
					this.str += 5;
				} else {
					System.out.println("강화 실패...");
					this.material -= upgradeCost;
				}
				break;
			case 0:
				break weapon;
			default:
				break;
			}

		}

	}
}
