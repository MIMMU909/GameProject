package skyHill;

import java.util.Random;

public class Main {

	int input;
	int movementCount = 0;
	static int floorNumber;
	private final int MAX_FLOOR_NUMBER = 100;
	Opening opening;
	Character character;
	RoomMaker roomMaker;
	Random rnd = new Random();

	Room leftRoom;
	Room rightRoom;

	String location;

	boolean isFirstLeft;
	boolean isFirstRigth;
	boolean isHall;

	public Main() {
		floorNumber = MAX_FLOOR_NUMBER;
		opening = new Opening();
		character = new Character();
		leftRoom = new Room();
		rightRoom = new Room();
		roomMaker = new RoomMaker();
		isFirstLeft = true;
		isFirstRigth = true;
		isHall = true;
	}

	public static void main(String[] args) {

		new Main().start();
		System.out.println();
		System.out.println("게임을 종료합니다...");
	}

	private void start() {

		opening.showOpening();
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "          ⢀⣴⣿⣿⣿⣷⣦⠀⠀⣶⣶⡆⠀⠀⣰⣶⣴⡶⠀⢶⣶⣶⡄⠀ ⠀⣴⣶⣶⡄     ⢰⣶⣶⣦⠀⠀⠀⣶⣶⣶⡆   ⢰⣶⣶⡆⠀⣶⣶⣶⠀⠀⠀  ⠀⠀⣶⣶⣶⠀⠀⠀⠀\r\n"
				+ "          ⣾⣿⣿⡟⠻⠟⠋⠁⠀⣿⣿⡇⢀⣼⣿⣿⡟⠁⠀⠈⢿⣿⣿⣆⣼⣿⣿⡟⠀   ⢸⣿⣿⣿⠀⠀⠀⣿⣿⣿⡇  ⢸⣿⣿⡇⠀⣿⣿⣿⠀⠀ ⠀⠀⠀ ⣿⣿⣿⠀⠀⠀⠀\r\n"
				+ "          ⠹⣿⣿⣿⣶⣦⣄⠀⠀⣿⣿⣧⣿⣿⣿⠏⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⠏⠀  ⠀   ⢸⣿⣿⣿⣶⣶⣶⣿⣿⣿⡇⢸⣿⣿⡇⠀⣿⣿⣿⠀⠀⠀ ⠀ ⠀⣿⣿⣿⠀⠀⠀⠀\r\n"
				+ "          ⠀⠈⠛⠻⢿⣿⣿⡆⠀⣿⣿⡿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⢻⣿⣿⡏⠀⠀⠀     ⢸⣿⣿⣿⠿⠿⠿⣿⣿⣿⡇⢸⣿⣿⡇⠀⣿⣿⣿⠀⠀ ⠀ ⠀⠀⣿⣿⣿⠀⠀⠀⠀\r\n"
				+ "          ⢠⣾⣿⣶⣿⣿⣿⠃⠀⣿⣿⡇⠈⢿⣿⣿⣷⡀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀   ⠀⢸⣿⣿⣿⠀⠀⠀⣿⣿⣿⡇⢸⣿⣿⡇⠀⣿⣿⣿⣤⣤⣤⣄⠀⣿⣿⣿⣤⣤⣤⣄\r\n"
				+ "          ⠈⠛⠿⠿⠿⠟⠁⠀⠀⣿⢿⡇⠀⠀⠹⣿⠿⡿⠆⠀⠀⠀⢸⣿⣿⠇⠀⠀⠀   ⠸⣿⢿⡟⠀⠀⠀⢻⡿⣿⠇⠸⣿⢿⠇⠀⣿⣿⣿⣿⣿⣿⡷⠀⢿⣿⣿⣿⣿⣿⡿\r\n"
				+ "          ⢠⣤⣤⣤⣤⣤⣤⣄⣤⣤⣤⣤⣤⣠⣤⣤⣤⣤⣤⢠⣤⣤⣤⡄⣤⣤⣄⣤⣤⣤⣤⣤⣤⣤⣤⣤⣄⣤⣤⣤⣤⣤⣠⣤⣤⣤⣤⣤⢠⣤⣤⣤⡄⣤⣤⣄⣤⣤⣤⠄⠀\r\n"
				+ "          ⢸⡟⠛⣿⣴⣿⣿⡿⣿⢸⡇⠉⣿⢿⡿⢹⣿⣿⣿⣼⢿⡟⣿⢿⡟⣿⢿⡟⣿⣿⡄⢸⡟⠛⣿⣴⣿⣿⡿⣿⢸⡇⠉⣿⣿⣿⣼⢿⡟⣿⢿⡟⣿⢿⡟⣿⣿⡄\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		System.out.println();
		System.out.println("		   	     1. Start");
		System.out.println("			     0. Quit");
		System.out.print(">> ");
		input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			gameStart();
			break;
		case 0:
			break;
		default:
			break;
		}

	}

	private void gameStart() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println("이곳은 최상층입니다.");
		System.out.println("이 아래층부턴 배고픈 좀비들이 먹이를 찾아 헤매고 있죠.");
		System.out.println();
		System.out.println("당신의 모든 움직임은 당신을 배고프게 만들겁니다.");
		System.out.println("당신은 생존을 위해 방을 돌아다니며 생필품을 찾아야 합니다.");
		System.out.println();
		System.out.println("적어도 이 호텔에서 나간다면 조금이라도 살 희망이 보이겠죠.");
		System.out.println("당신이 1층까지 도달할 수 있을까요? 그럼, 행운을 빕니다.");
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println();

		game: while (true) {
			// 사망
			if (character.hp <= 0) {
				System.out.println(" -- 당신은 죽었습니다. --");
				break game;
			} else if (character.hp <= 0 && character.hunger <= 0) {
				System.out.println("-- 당신은 굶어죽었습니다. --");
				break game;
			}
			// 사망

			if (floorNumber == 1) { // 엔딩
				System.out.println();
				System.out.println("──────────────────────────────────────────────────────────────────────");
				System.out.println();
				System.out.println("당신은 1층에 도착했다.");
				System.out.println();
				System.out.println("당신 눈앞엔 이 지옥같은 호텔에서 나갈 수 있는 문이 있다.");
				System.out.println();
				System.out.println("이 밖은 안전할까? 확신할 수 없다.");
				System.out.println();
				System.out.println("──────────────────────────────────────────────────────────────────────");
				System.out.println(" 1.탈출한다.");
				System.out.println("──────────────────────────────────────────────────────────────────────");

				System.out.println();
				System.out.print(">> ");
				input = ScanUtil.nextInt();
				switch (input) {
				case 1:

					System.out.println("" + "	▓█████   ██████  ▄████▄   ▄▄▄       ██▓███  ▓█████ \r\n"
							+ "	▓█   ▀ ▒██    ▒ ▒██▀ ▀█  ▒████▄    ▓██░  ██▒▓█   ▀ \r\n"
							+ "	▒███   ░ ▓██▄   ▒▓█    ▄ ▒██  ▀█▄  ▓██░ ██▓▒▒███   \r\n"
							+ "	▒▓█  ▄   ▒   ██▒▒▓▓▄ ▄██▒░██▄▄▄▄██ ▒██▄█▓▒ ▒▒▓█  ▄ \r\n"
							+ "	░▒████▒▒██████▒▒▒ ▓███▀ ░ ▓█   ▓██▒▒██▒ ░  ░░▒████▒\r\n"
							+ "	░░ ▒░ ░▒ ▒▓▒ ▒ ░░ ░▒ ▒  ░ ▒▒   ▓▒█░▒▓▒░ ░  ░░░ ▒░ ░\r\n"
							+ "	 ░ ░  ░░ ░▒  ░ ░  ░  ▒     ▒   ▒▒ ░░▒ ░      ░ ░  ░\r\n"
							+ "	   ░   ░  ░  ░  ░          ░   ▒   ░░          ░   \r\n"
							+ "	   ░  ░      ░  ░ ░            ░  ░            ░  ░\r\n"
							+ "                ░                                  \r\n"
							+ "                                          ");
					System.out.println(

							"		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣶⣶⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣿⣿⣿⣆⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⡿⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⡃⠀⣿⣿⣿⣿⣿⣿⣿⣿⡏⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⡇⢰⣿⣿⣿⣿⣿⣿⣿⣿⡇⢿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣧⢸⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠘⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢰⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠱⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⢸⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⢸⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⠸⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠀⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠀⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣴⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠿⣿⣿⡿⢿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢼⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
									+ "		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "");
					break game;
				default:
					break;
				}
			}
			// 엔딩

			location = "복도";
			System.out.println();
			showFloorInfo(); // 현재 층, 체력, 배고픔 상태

			if (floorNumber == 100) {
				System.out.println("1.내려가기 : 한 층 아래로 내려갑니다. 복도에 좀비가 없기를 바래요.");
				System.out.println();
				System.out.println("2.쉬기     : 체력을 회복하고 굶주림을 얻습니다.");
				System.out.println();
				System.out.println("3.상태보기 : 당신의 상태와 가방을 볼 수 있습니다.");
				System.out.println();
				System.out.println("4.무기강화 : 강화부품을 얻으면 무기를 더욱 강하게 만들 수 있습니다.");
				System.out.println();
				System.out.println("0.끝내기   : 게임을 종료합니다.");
				System.out.println();
				System.out.println("──────────────────────────────────────────────────────────────────────");
			} else {
				System.out.println("1.내려가기 2.왼쪽방 3.오른쪽방 4.쉬기 5.상태보기 6.무기강화 0.끝내기");
				System.out.println();
				if (character.haveKey == true) {
					System.out.println();
					System.out.println("!! 당신은 호텔키를 이용해 엘리베이터를 이용할 수 있게 됐다.");
					System.out.println();
					System.out.println("7. 호텔키를 사용한다.");
					System.out.println();
				}
				System.out.println("──────────────────────────────────────────────────────────────────────");
				if (character.hp < 50)
					System.out.println(" 당신은 치료가 필요하다.");
				if (character.hunger < 50)
					System.out.println(" 당신은 음식이 필요하다.");
			}
			System.out.println();
			System.out.print(">> ");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				goDown();
				break;
			case 2:
				if (floorNumber == 100)
					rest();
				else
					enterRoom();
				break;
			case 3:
				if (floorNumber == 100)
					character.showInfo();
				else
					enterRoom();
				break;
			case 4:
				if (floorNumber == 100)
					character.weapon();
				else
					rest();
				break;
			case 5:
				if (floorNumber == 100)
					break;
				character.showInfo();
				break;
			case 6:
				if (floorNumber == 100)
					break;
				character.weapon();
				break;
			case 7: // 히든엔딩
				if (character.haveKey == false)
					break;
				System.out.println();
				System.out.println("당신은 키를 이용해 엘리베이터에 탄다.");
				floorNumber = 1;
				break;
			case 0:
				System.out.println();
				System.out.println("게임을 종료하면 처음부터 다시 해야 합니다.");
				System.out.println();
				System.out.println("게임을 종료하시겠습니까? (y/n)");
				System.out.println();
				System.out.print(">> ");
				String inputString = ScanUtil.nextLine();
				if (inputString.equals("y"))
					break game;
				else
					break;
			default:
				break;
			}
		}
	}

	private void enterRoom() {
		characterMovement();
		int num = input;
		Room room = null;
		isHall = false;
		System.out.println();
		System.out.println("당신은 조심스래 문을 연다...");
		System.out.println();
		if (num == 2) {
			location = "왼쪽방";
			if (isFirstLeft == true) {
				leftRoom = roomMaker.setRoom(character.luck);
				isFirstLeft = false;
			}
			room = new Room(leftRoom.healItem, leftRoom.foodItem, leftRoom.zombie, leftRoom.material, leftRoom.key);
		} else {
			location = "오른쪽방";
			if (isFirstRigth == true) {
				rightRoom = roomMaker.setRoom(character.luck);
				isFirstRigth = false;
			}
			room = new Room(rightRoom.healItem, rightRoom.foodItem, rightRoom.zombie, rightRoom.material,
					rightRoom.key);
		}

		if (room.zombie != null && room.zombie.hp != 0)
			fight(room.zombie);
		if (room.zombie != null && room.zombie.hp != 0)
			return;

		room: while (true) {
			showFloorInfo();
			System.out.println(room);
			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.println(" 1.아이템줍기 │ 2.쉬기 │ 3.상태보기 │ 4.무기강화 │ 0.나가기");
			System.out.println("──────────────────────────────────────────────────────────────────────");

			System.out.print(">> ");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				if (num == 2)
					leftRoom = character.getItem(room);
				else
					rightRoom = character.getItem(room);
				break;
			case 2:
				rest();
				break;
			case 3:
				character.showInfo();
				break;
			case 4:
				character.weapon();
				break;
			case 0:
				System.out.println("\n당신은 복도로 나간다.");
				isHall = true;
				break room;
			default:
				break;
			}
		}

		characterMovement();
	}

	private void fight(Zombie zombie) {
		System.out.println();
		System.out.println("어디선가 좀비 울음소리가 들린다.");
		System.out.println();
		System.out.println(zombie.name + "가 당신에게 달려든다!!");
		System.out.println();
		battle: while (true) {
			System.out.println("──────────────────────────────────────────────────────────────────────");

			if (isHall == true)
				System.out.println(" 1.머리(타격확률 : 40%) │ 2.몸통(타격확률 : 100%)");
			else
				System.out.println(" 1.머리(타격확률 : 40%) │ 2.몸통(타격확률 : 100%) │ 3.도망(확률 : 50%)");

			System.out.println("──────────────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.print(">> ");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
			case 2:
				character.attack(input, zombie);
				if (zombie.hp == 0) {
					System.out.printf("%s를 처치했습니다.\n", zombie.name);
					System.out.println();
					System.out.println("──────────────────────────────────────────────────────────────────────");
					System.out.println(" 승리!");
					System.out.println("──────────────────────────────────────────────────────────────────────");
					System.out.println();
					character.getExp(zombie.exp);
					break battle;
				}
				zombie.attack(character);
				if (character.hp == 0) {
					System.out.println(zombie.name + "에게 죽었습니다.");
					System.out.println();
					System.out.println("──────────────────────────────────────────────────────────────────────");
					System.out.println(" 패배");
					System.out.println("──────────────────────────────────────────────────────────────────────");

					break battle;
				}
				break;
			case 3:
				if (isHall == true)
					break;
				if (rnd.nextInt(100) > 55 - character.luck) { // 50퍼
					System.out.println("\n당신은 복도로 도망간다...");
					break battle;
				}
				System.out.println("\n당신은 도망가려 했지만 실패했다.\n");
				break;
			default:
				break;
			}

		}
	}

	private void rest() {
		System.out.println();
		System.out.println("당신은 잠깐 쉬기로 한다.");
		System.out.println();
		if (character.hp == 100 && character.hunger > 0) {
			System.out.println("당신은 배만 고파졌다. (배고픔 -1)");
			character.hunger--;
		} else if (character.hunger <= 0) {
			System.out.println("당신은 굶어 죽어간다. (체력 -1)");
			character.hp--;
		} else {
			System.out.println("당신은 조금 회복 됐지만 배고파졌다.(체력 + 1 │ 배고픔 - 1)\n");
			character.hp++;
			character.hunger--;
		}
	}

	private void showFloorInfo() {
		System.out.println("──────────────────────────────────────────────────────────────────────");
		System.out.printf(" 현재 위치 : %d층 │ %s		   체력 : %d │ 배고픔 : %d\n", floorNumber, location, character.hp,
				character.hunger);
		System.out.println("──────────────────────────────────────────────────────────────────────");
		System.out.println();
	}

	private void goDown() {
		System.out.println();
		System.out.println("한 층 아래로 내려간다...");
		System.out.println("\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⣸⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠧⣄⣀⣛⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣤⣤⣤⣤⣀⣀⣀⣽⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠛⠛⠛⠿⢿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣶⣶⣶⣶⣶⣶⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠙⠛⠛⠛⠛⠻⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣄⣀⣹⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣈⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣠⣤⣤⣶⣶⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠛⠛⠉⠉⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"

				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡛⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣶⣾⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷⡀⠀⠀⠀⠀⠀⣀⣠⣴⣶⣾⣿⣿⣿⣿⡿⠟⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣤⣤⣴⣶⣿⣿⣿⣿⣿⡿⠟⠛⠋⠁⠀⠀⢀⣀⣤⣴⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡿⠿⠟⠋⠁⠀⠀⠀⣀⣠⣤⣶⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣟⡋⠁⠀⠀⠀⠀⢀⣤⣶⣾⣿⣿⣿⣿⠿⠟⠋⠁⠀⠀⠀⣀⣤⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣶⣴⣾⣿⣿⣿⣿⣿⡿⠟⠉⠀⠀⠀⠀⣀⣴⣾⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠀⠀⠀⢀⣀⣴⣾⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀⠀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣯⣄⣀⠀⢀⣠⣴⣾⣿⣿⣿⣿⠿⠛⠉⠀⠀⠀⠀⢀⣠⣴⣾⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀⠀⠀⠀⢀⣤⣶⣿⣿⣿⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠛⠁⠀⠀⠀⠀⢀⣀⣤⣾⣿⣿⣿⣿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣄⣀⠀⢀⣠⣶⣿⣿⣿⣿⣿⠿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠛⠛⠻⠿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "");
		floorNumber--;
		isFirstLeft = true;
		isFirstRigth = true;
		Zombie z = roomMaker.setZombie(character.luck);
		characterMovement();
		if (z != null) {
			Zombie zombie = new Zombie(z.name, z.maxHp, z.att, z.exp);
			fight(zombie);
		}
	}

	private void characterMovement() {
		if (character.hunger == 0) {
			character.hp--;
		} else {
			character.hunger--;
		}
		movementCount++;
		if (movementCount == 15) {
			movementCount = 0;
			if (character.inventory.length != 0) {
				int i = rnd.nextInt(character.inventory.length);
				System.out.println();
				System.out.println(">> "+character.inventory[i].name+"을(를) 잃어버렸습니다. <<");
				character.desoryItem(i);
			}
		}
		try {
			Thread.sleep(300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
