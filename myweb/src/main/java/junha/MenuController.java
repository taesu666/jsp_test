package junha;
import java.util.Scanner;

import exception.SelectInputException;
import exception.SelectNumberException;

public class MenuController {
	static Scanner scan;
	static DBController db;
	
	static public void run() {
		scan = new Scanner(System.in);
		db = new DBController();
		while(true) { // 숫자 이외의 문자 입력시 오류
			System.out.println("📋 어떤 정보를 보고 싶으신가요? 📋\n");
			System.out.println("==아래 항목 중 하나를 숫자로 선택하세요==");
			System.out.println("1. 직원이름으로 직원정보 검색하기");
			System.out.println("2. 입사년도로 직원정보 검색하기");
			System.out.println("3. 부서번호로 직원정보 검색하기");
			System.out.println("4. 직무로 직원정보 검색하기");
			System.out.println("5. 도시이름으로 직원정보 검색하기");
			System.out.println("6. 통계자료 출력하기");
			System.out.println("7. 부서장 성으로 부서원 정보 검색하기");
			System.out.println("8. 나라이름으로 직원정보 검색하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.println("선택 >>");
			String num = scan.nextLine();
			int number= 0;
			
			try {
			    number = Integer.parseInt(num);
			    if (number < 0 || number > 8) {
			        throw new SelectNumberException(number);
			    }
			} catch (NumberFormatException e) { // 포멧오류 캐치
			    System.out.println(new SelectInputException(num).getMessage());
			    continue;
			} catch (SelectNumberException e) { // 숫자 범위오류 캐치
			    System.out.println(e.getMessage());
			}
			switch (number) {
				case 1 -> { 
					System.out.print("직원 이름을 입력하세요 [ex (first_name + last_name)] : ");
					String fullName = scan.nextLine();
					DBMethod.findEmpInfoByEmpName(fullName);
				}					
				case 2 -> {
					System.out.print("입사년도를 입력하세요 [ex : 2013] : ");
					int year;
					try {
						year = Integer.parseInt(num);
						DBMethod.findEmpInfoByHireYear(year);	
					
					} catch (NumberFormatException e) {
					    System.out.println(new SelectInputException(num).getMessage());
					    continue;					
					}
				}
				case 3 -> {
					System.out.println("부서번호를 입력하세요 [ex : 100] : ");
					int dpId;
					try {
						dpId = Integer.parseInt(num);
						DBMethod.findEmpInfoByDeptId(dpId);	
					} catch (NumberFormatException e) {
					    System.out.println(new SelectInputException(num).getMessage());
					    continue;					
					}
				}
				case 4 -> {
					System.out.print("직무를 입력하세요 [ex : IT_PROG] : ");
					String job = scan.nextLine();
					DBMethod.findEmpInfoByJobId(job);
				}
				case 5 -> {
					System.out.print("도시명을 입력하세요 [ex : Seattle] : ");
					String cityName = scan.nextLine();
					DBMethod.findEmpInfoByCity(cityName);
				}
				case 6 -> {
					System.out.println("📋 어떤 연봉 통계자료를 출력할까요? 📋\n");
					System.out.println("==아래 항목 중 하나를 숫자로 선택하세요==");
					System.out.println("1. 부서별");
					System.out.println("2. 직무별");
					System.out.println("3. 도시별");
					System.out.println("4. 나라별");
					System.out.println("5. 대륙별");
					num = scan.nextLine();
					int selectSummry = 0;
					int selectOrderBy = 0;
					try {
						selectSummry = Integer.parseInt(num);
						DBMethod.getEmpSummaryData(selectSummry, selectOrderBy);	
						if (selectSummry < 0 || selectSummry > 5) {
							throw new SelectNumberException(selectSummry);
						}
					} catch (NumberFormatException e) {
					    System.out.println(new SelectInputException(num).getMessage());
					    continue;					
					} catch (SelectNumberException e) {
					    System.out.println(e.getMessage());
					}
					System.out.println("📋 어떤 항목에 대해 정렬할까요? 📋\n");
					System.out.println("==아래 항목 중 하나를 숫자로 선택하세요==");
					System.out.println("1. id");
					System.out.println("2. avg");
					System.out.println("3. max");
					System.out.println("4. min");
					System.out.println("5. sum");
					num = scan.nextLine();
					try {
						selectOrderBy = Integer.parseInt(num);
						DBMethod.getEmpSummaryData(selectSummry, selectOrderBy);	
						if (selectOrderBy < 0 || selectOrderBy > 5) {
							throw new SelectNumberException(selectOrderBy);
						}
					} catch (NumberFormatException e) {
					    System.out.println(new SelectInputException(num).getMessage());
					    continue;					
					} catch (SelectNumberException e) {
					    System.out.println(e.getMessage());
					}

				}
				
				case 7 -> {
					System.out.print("부서장 성을 입력하세요 : ");
					String managerLastName = scan.nextLine();
					DBMethod.findEmpInfoByManagerLastName(managerLastName);
				}
				case 8 -> {
					System.out.print("나라이름을 입력하세요 : ");
					String countryName = scan.nextLine();
					DBMethod.findEmpInfoByCountryName(countryName);
				}
				case 0 -> { 
					db.close();
					System.out.println("프로그램 종료");
						return;
				}
			
			}	
		} 
	} 
}



