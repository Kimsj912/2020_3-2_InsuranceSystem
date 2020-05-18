package main;

import data.customerData.CustomerData;
import data.employeeData.developEmployeeData.DeveloperData;
import data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import data.employeeData.developEmployeeData.ProductPermitManData;
import data.employeeData.salesEmployeeData.SalesManData;
import data.employeeData.salesEmployeeData.SalesManagerData;
import data.insuranceData.AbsInsuranceData;
import dataList.realDataList.ISDataList;
import frame.realFrame.MainFrame;
import system.peopleSystem.LoginSystem;

public class Main {

	// 보험 별 페이지 만들기. 현재는 자동차가 전체를 대신하고 있음.
	// 요율 검증, 보험 인수 지금 하나의 계정을 고정적으로 사용--- 로그인 만들기....
	
	public static void main(String[] args) {
	// Create Data
		// Create Data - develop line
		DeveloperData developer = new DeveloperData();
		developer.setName("Developer");

		InsuranceRatePermitManData insuranceRatePermitManData = new InsuranceRatePermitManData();
		insuranceRatePermitManData.setName("InsuranceRatePermitManData");

		ProductPermitManData productPermitManData = new ProductPermitManData();
		productPermitManData.setName("ProductPermitManData");

		// Create Data - sales line
		SalesManData salesManData = new SalesManData();
		salesManData.setName("SalesMan");

		SalesManagerData salesManagerData = new SalesManagerData();
		salesManagerData.setName("SalesManager");
		
		CustomerData customerData = new CustomerData();
		customerData.setName("customer");

	// Create System?
		MainFrame view = new MainFrame();

		LoginSystem system = new LoginSystem();
		//login system이후 dev, sales, rw로 알아서 연결되도록 한다. 그 전까지 모두 만들 것.

		//create System - develop line
		ISDataList<DeveloperData> developerDataList = new ISDataList<DeveloperData>(); //개발자 리스트 만들기
		developerDataList.add(developer); //개발자 추가하기

		ISDataList<InsuranceRatePermitManData> insuranceRatePermitManDataList = new ISDataList<InsuranceRatePermitManData>(); //보혐요율계산자? 리스트 만들고
		insuranceRatePermitManDataList.add(insuranceRatePermitManData); //추가하기

		ISDataList<ProductPermitManData> productPermitManDataList = new ISDataList<ProductPermitManData>(); //제품요율계산자 리스트 만들고
		productPermitManDataList.add(productPermitManData); //추가하ㅣ

		ISDataList<AbsInsuranceData> insuranceDataList = new ISDataList<AbsInsuranceData>();

		// create System - sales line
		ISDataList<SalesManData> salesManDataList = new ISDataList<SalesManData>(); //영업사원 리스트 만들기
		salesManDataList.add(salesManData); //영업사원 추가하기

		ISDataList<SalesManagerData> salesManagerDataList = new ISDataList<SalesManagerData>(); //영업사원 리스트 만들기
		salesManagerDataList.add(salesManagerData); //영업사원 추가하기
		
		ISDataList<CustomerData> customerDataList = new ISDataList<CustomerData>(); //고객 리스트 만들기
		customerDataList.add(customerData); //고객 추가하기
		
		
	// Associate System
		system.initializePanel(null);
		system.associateModel(
				new ISDataList<?>[] { developerDataList, insuranceRatePermitManDataList, productPermitManDataList,
						insuranceDataList, salesManDataList, salesManagerDataList, customerDataList });
		system.associateMainFrame(view);
		system.start();
	}
}
