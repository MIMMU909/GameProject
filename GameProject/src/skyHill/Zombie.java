package skyHill;

import java.util.Random;

public class Zombie {
	Random rnd = new Random();
	String name;
	int maxHp;
	int hp;
	int att;
	int exp;

	public Zombie(String name, int maxHp, int att, int exp) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.att = att;
		this.exp = exp;
	}

	public void attack(Character character) {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();
		System.out.println(">> 좀비 턴");
		System.out.println();
		System.out.printf("%s가 반격한다.\n",this.name);
		System.out.println();
		int damage = this.att;
		if (rnd.nextInt(100) > (70 - character.luck))
			damage = 0;

		character.hp -= damage;
		character.hp = character.hp < 0 ? 0 : character.hp;
		if (damage == 0)
			System.out.println("당신은 운 좋게 피했다!");
		else
			System.out.printf("당신은 %s의 공격으로 %d만큼 데미지를 입었다. \n", this.name, damage);
		System.out.printf("\n현재 HP : %d\n",character.hp);
		System.out.println();
	}

}
