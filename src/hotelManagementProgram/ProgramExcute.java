package hotelManagementProgram;

import java.util.Scanner;

public class ProgramExcute {
	
	public static Scanner scanner = new Scanner(System.in);
	public static final int NUMBER_OF_CUSTOMER = 100;
	public static final int TEST_AUTOMATIC_INPUT = 5;
	public static int arrayCount = 0;
	
	public static void main(String[] args) {
		CustomerInfo[] customerArray = new CustomerInfo[NUMBER_OF_CUSTOMER];

		boolean loopFlag = false;
		while (!loopFlag) {
			int menuTask = displayMenu();
			switch (menuTask) {
			case 1:
				inputCustomerData(customerArray);
				break;
			case 2:
				outputCustomerData(customerArray);
				break;
			case 3:
				updateCustomerData(customerArray);
				break;
			case 4:
				deleteCustomerData(customerArray);
				break;
			case 5:
				searchCustomerData(customerArray);
				break;
			case 6:
				sortCustomerData(customerArray);
				break;
			case 7:
				searchCustomerGradeDetail(customerArray);
				break;
			case 8:
				loopFlag = true;
				break;
			default:
				System.out.println("보기를 확인 후 올바른 메뉴를 선택해주세요.");
				break;
			}
		}
		System.out.print("프로그램이 종료되었습니다.");
	}

	// Output customer's points details
	public static void searchCustomerGradeDetail(CustomerInfo[] customerArray) {
		if (arrayCount == 0) {
			System.out.println("세부사항을 검색할 고객 정보가 없습니다. 먼저 정보를 입력해주세요.");
			return;
		}
		
		scanner.nextLine();
		System.out.print("검색할 고객명을 입력해주세요 : ");
		String customerName = scanner.nextLine();
		int detailSearchLocate = -1;
		for (int i = 0; i < arrayCount; i++) {
			if (customerArray[i].getName().equals(customerName)) {
				detailSearchLocate = i;
				break;
			}
		}
		
		if (detailSearchLocate == -1) {
			System.out.println("해당되는 고객 정보를 찾지 못했습니다.");
			return;
		}
		
		if (customerArray[detailSearchLocate].getTotal() == 0) {
			System.out.println(customerArray[detailSearchLocate].getName() + "님의 작년도 미래 호텔 숙박 정보가 존재하지 않습니다.");
			return;
		} else {
			System.out.println(customerArray[detailSearchLocate].getName() + "님의 1분기 적립 포인트는 " + customerArray[detailSearchLocate].getFirstQuarter() + "점입니다.");
			System.out.println(customerArray[detailSearchLocate].getName() + "님의 2분기 적립 포인트는 " + customerArray[detailSearchLocate].getSecondQuarter() + "점입니다.");
			System.out.println(customerArray[detailSearchLocate].getName() + "님의 3분기 적립 포인트는 " + customerArray[detailSearchLocate].getThirdQuarter() + "점입니다.");
			System.out.println(customerArray[detailSearchLocate].getName() + "님의 4분기 적립 포인트는 " + customerArray[detailSearchLocate].getFourthQuarter() + "점입니다.");
			System.out.println(customerArray[detailSearchLocate].getName() + "님의 올해 멤버십 등급은 " + customerArray[detailSearchLocate].getGrade() + "입니다.");
		}
	}

	// Sort customer data
	public static void sortCustomerData(CustomerInfo[] customerArray) {
		if (arrayCount == 0) {
			System.out.println("정렬할 고객 정보가 없습니다. 먼저 정보를 입력해주세요.");
			return;
		}
		
		scanner.nextLine();
		System.out.println("정렬기준을 선택해주세요.");
		System.out.print("1. 고객명  |  2. 적립 포인트\n입력 > ");
		int criteria = scanner.nextInt();
		int successOrFailure = 0;
		switch (criteria) {
		case 1:
			successOrFailure = sortByNumber(customerArray);
			break;
		case 2:
			successOrFailure = sortByTotal(customerArray);
			break;
		default:
			System.out.println("보기를 확인 후 올바른 메뉴를 선택해주세요.");
			return;
		}
		
		if (successOrFailure == 1) {
			outputCustomerData(customerArray);
		} else {
			System.out.println("보기를 확인 후 올바른 메뉴를 선택해주세요.");
		}
	}

	// (1) Sort customer data by total
	public static int sortByTotal(CustomerInfo[] customerArray) {
		System.out.print("정렬 방법을 선택해주세요.\n1. 오름차순  |  2. 내림차순\n입력 > ");
		int method = scanner.nextInt();
		switch (method) {
		case 1:
			CustomerInfo tmp = null;
			for (int i = 0; i < arrayCount; i++) {
				for (int j = i + 1; j < arrayCount; j++) {
					if (customerArray[i].getTotal() < customerArray[j].getTotal()) {
						tmp = customerArray[i];
						customerArray[i] = customerArray[j];
						customerArray[j] = tmp;
					}
				}
			}
			return 1;
		case 2:
			for (int i = 0; i < arrayCount; i++) {
				for (int j = i + 1; j < arrayCount; j++) {
					if (customerArray[i].getTotal() > customerArray[j].getTotal()) {
						tmp = customerArray[i];
						customerArray[i] = customerArray[j];
						customerArray[j] = tmp;
					}
				}
			}
			return 1;
		default:
			return 0;
		}
	}

	// (2) Sort customer data by customer number
	public static int sortByNumber(CustomerInfo[] customerArray) {
		System.out.print("정렬 방법을 선택해주세요.\n1. 오름차순  |  2. 내림차순\n입력 > ");
		int method = scanner.nextInt();
		switch (method) {
		case 1:
			CustomerInfo tmp = null;
			for (int i = 0; i < arrayCount; i++) {
				for (int j = i + 1; j < arrayCount; j++) {
					if (customerArray[i].getName().compareToIgnoreCase(customerArray[j].getName()) > 0) {
						tmp = customerArray[i];
						customerArray[i] = customerArray[j];
						customerArray[j] = tmp;
					}
				}
			}
			return 1;
		case 2:
			for (int i = 0; i < arrayCount; i++) {
				for (int j = i + 1; j < arrayCount; j++) {
					if (customerArray[i].getName().compareToIgnoreCase(customerArray[j].getName()) < 0) {
						tmp = customerArray[i];
						customerArray[i] = customerArray[j];
						customerArray[j] = tmp;
					}
				}
			}
			return 1;
		default:
			return 0;
		}
	}

	// Search customer data
	public static void searchCustomerData(CustomerInfo[] customerArray) {
		if (arrayCount == 0) {
			System.out.println("검색할 고객 정보가 없습니다. 먼저 정보를 입력해주세요.");
			return;
		}
		
		scanner.nextLine();
		System.out.print("검색할 고객명을 입력해주세요 : ");
		String customerName = scanner.nextLine();
		int searchLocate = -1;
		for (int i = 0; i < arrayCount; i++) {
			if (customerArray[i].getName().equals(customerName)) {
				System.out.println("이름\t고객번호\t   생년월일\t성별\t전화번호\t\t멤버십등급\t  요청사항");
				System.out.println("----------------------------------------------------------------------------------------------");
				System.out.println(customerArray[i]);
				searchLocate = i;
				break;
			}
		}
		
		if (searchLocate == -1) {
			System.out.println("해당되는 고객 정보를 찾지 못했습니다.");
			return;
		}
	}

	// Delete customer data
	public static void deleteCustomerData(CustomerInfo[] customerArray) {
		if (arrayCount == 0) {
			System.out.println("삭제할 고객 정보가 존재하지 않습니다. 먼저 데이터를 입력해주세요.");
			return;
		}
		
		scanner.nextLine();
		System.out.print("삭제할 고객명을 입력해주세요 : ");
		String name = scanner.nextLine();
		int deleteLocate = -1;
		for (int i = 0; i < arrayCount; i++) {
			if (customerArray[i].getName().equals(name)) {
				customerArray[i] = null;
				deleteLocate = i;
				break;
			}
		}
		
		if (deleteLocate == -1) {
			System.out.println("해당되는 고객 데이터를 찾지 못했습니다.");
			return;
		}
		
		for (int i = deleteLocate; i < arrayCount; i++) {
			if (i == arrayCount - 1) {
				customerArray[i] = null;
				break;
			}
			customerArray[i] = customerArray[i + 1];
		}
		arrayCount--;
		System.out.println("고객 정보가 정상적으로 삭제되었습니다.");

	}
	
	// Update customer Data
	public static void updateCustomerData(CustomerInfo[] customerArray) {
		if (arrayCount == 0) {
			System.out.println("수정할 고객 정보가 없습니다. 먼저 정보를 입력해주세요.");
			return;
		}
		
		scanner.nextLine();
		System.out.print("수정할 고객명을 입력해주세요 : ");
		String customerName = scanner.nextLine();
		int updateLocate = -1;
		for (int i = 0; i < arrayCount; i++) {
			if (customerArray[i].getName().equals(customerName)) {
				System.out.println("이름\t고객번호\t   생년월일\t성별\t전화번호\t\t멤버십등급\t  요청사항");
				System.out.println("----------------------------------------------------------------------------------------------");
				System.out.println(customerArray[i]);
				updateLocate = i;
				break;
			}
		}
		
		if (updateLocate == -1) {
			System.out.println("해당되는 고객 정보를 찾지 못했습니다.");
			return;
		}
		
		System.out.println("\n" + customerArray[updateLocate].getName() + "님의 정보 중 어떤 내용을 수정하시겠습니까?");
		System.out.print("1. 작년도 적립포인트  |  2. 전화번호  |  3. 요청사항\n입력 > ");
		int updateTask = scanner.nextInt();
		switch (updateTask) {
		case 1:
			System.out.println("현재 입력된 1분기 적립포인트 " + customerArray[updateLocate].getFirstQuarter() + "점입니다.");
			System.out.print("수정할 1분기 적립포인트를 입력해주세요.\n입력 > ");
			int firstQuarter = scanner.nextInt();
			customerArray[updateLocate].setFirstQuarter(firstQuarter);
			System.out.println("현재 입력된 2분기 적립포인트 " + customerArray[updateLocate].getSecondQuarter() + "점입니다.");
			System.out.print("수정할 1분기 적립포인트를 입력해주세요.\n입력 > ");
			int secondQuarter = scanner.nextInt();
			customerArray[updateLocate].setSecondQuarter(secondQuarter);
			System.out.println("현재 입력된 3분기 적립포인트 " + customerArray[updateLocate].getThirdQuarter() + "점입니다.");
			System.out.print("수정할 1분기 적립포인트를 입력해주세요.\n입력 > ");
			int thirdQuarter = scanner.nextInt();
			customerArray[updateLocate].setThirdQuarter(thirdQuarter);
			System.out.println("현재 입력된 4분기 적립포인트 " + customerArray[updateLocate].getFourthQuarter() + "점입니다.");
			System.out.print("수정할 1분기 적립포인트를 입력해주세요.\n입력 > ");
			int fourthQuarter = scanner.nextInt();
			customerArray[updateLocate].setFourthQuarter(fourthQuarter);
			
			customerArray[updateLocate].calculateTotal();
			customerArray[updateLocate].calculateAvg();
			customerArray[updateLocate].calculateGrade();
			System.out.println("고객 정보가 정상적으로 수정되었습니다.");
			break;
		case 2:
			scanner.nextLine();
			System.out.println(customerArray[updateLocate].getName() + "님의 전화번호를 입력해주세요(-포함)");
			System.out.print("입력 > ");
			String telNumber = scanner.nextLine();
			customerArray[updateLocate].setTelNumber(telNumber);
			System.out.println("고객 정보가 정상적으로 수정되었습니다.");
			break;
		case 3:
			scanner.nextLine();
			System.out.println(customerArray[updateLocate].getName() + "님의 요청사항을 입력해주세요 : ");
			System.out.print("입력 > ");
			String specialRequest = scanner.nextLine();
			customerArray[updateLocate].setSpecialRequest(specialRequest);
			System.out.println("고객 정보가 정상적으로 수정되었습니다.");
			break;
		default:
			System.out.println("보기를 확인 후 올바른 메뉴를 선택해주세요.");
			break;
		}
	}

	// Output all customer data
	public static void outputCustomerData(CustomerInfo[] customerArray) {
		if (arrayCount == 0) {
			System.out.println("출력할 고객 정보가 없습니다. 먼저 정보를 입력해주세요.");
			return;
		}
		
		System.out.println("이름\t고객번호\t   생년월일\t성별\t전화번호\t\t멤버십등급\t  요청사항");
		System.out.println("----------------------------------------------------------------------------------------------");
		for (int i = 0; i < arrayCount; i++) {
			System.out.println(customerArray[i].toString());
		}
	}

	// Input customer data
	public static void inputCustomerData(CustomerInfo[] customerArray) {
		if (arrayCount >= NUMBER_OF_CUSTOMER) {
			System.out.println("입력 가능한 범위를 벗어났습니다. 추가로 입력을 희망하는 경우에는 프로그램 관리팀으로 연락바랍니다.");
			return;
		}
		
		for (int i = 0; i < TEST_AUTOMATIC_INPUT; i++) {
			String name = MakeRandomName();
			String customerNumber = createCusotmerNumber();
			String birth = createBirth();
			boolean gender = (createNumber(0, 1) == 0) ? false : true;
			String telNumber = "010-" + createNumber(1000, 9999) + "-" + createNumber(1000, 9999);
			int firstQuarter = createNumber(0, 100);
			int secondQuarter = createNumber(0, 100);
			int thirdQuarter = createNumber(0, 100);
			int fourthQuarter = createNumber(0, 100);
			String specialRequest = printSpecialRequest();

			customerArray[arrayCount] = new CustomerInfo(name, customerNumber, birth, gender, telNumber, firstQuarter, secondQuarter, thirdQuarter, fourthQuarter, specialRequest);
			customerArray[arrayCount].calculateTotal();
			customerArray[arrayCount].calculateAvg();
			customerArray[arrayCount].calculateGrade();

			arrayCount++;
			System.out.println("고객정보가 입력되었습니다.");
		}
	}

	// Create cusotmer's birth date
	public static String createBirth() {
		int year = createNumber(1922, 2022);
		int month = createNumber(1, 12);
		int day = 0;
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = createNumber(1, 30);
		} else if (month == 2) {
			day = createNumber(1, 28);
		} else {
			day = createNumber(1, 31);
		}

		return String.valueOf(year) + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
	}

	// Create customer's request
	public static String printSpecialRequest() {
		String[] specialRequestArray = { "복도 끝 객실", "냄새 제거", "레이트 체크인", "레이트 체크아웃", "갑각류 알레르기", "공기청정기 배치", "흡연가능객실", "낮은 층", "높은 층",
				"엘레베이터에서 가까운 객실", "배리어프리 객실", "없음" };
		String specialRequest = specialRequestArray[createNumber(0, 11)];
		return specialRequest;
	}

	// Create customer number
	public static String createCusotmerNumber() {
		return String.format("%07d", createNumber(1, 9999999));
	}

	// Create random number
	public static int createNumber(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	// Create customer name
	public static String MakeRandomName() {
		String[] lastName = { "김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송",
				"류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
				"우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염",
				"양", "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반",
				"왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용" };

		String[] firstName = { "가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다", "단",
				"달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
				"백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙",
				"순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원",
				"월", "위", "유", "윤", "율", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종",
				"주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해",
				"혁", "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황",
				"량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬",
				"들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술",
				"훔", "반", "빈", "실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬",
				"랑", "얀", "향", "울", "련" };

		String name1 = lastName[(int) (Math.random() * (lastName.length))];
		String name2 = firstName[(int) (Math.random() * (firstName.length))];
		String name3 = firstName[(int) (Math.random() * (firstName.length))];

		return name1 + name2 + name3;
	}

	// Display program menu
	public static int displayMenu() {
		System.out.println("==============================================================================================");
		System.out.println(" 1. 입력  |  2. 출력  |  3. 수정  |  4. 삭제  |  5. 검색  |  6. 정렬  |  7. 세부사항검색  |  8. 종료         ");
		System.out.println("==============================================================================================");
		System.out.print("희망하는 메뉴를 선택하세요.\n입력 > ");
		int selectNumber = scanner.nextInt();
		return selectNumber;
	}
}