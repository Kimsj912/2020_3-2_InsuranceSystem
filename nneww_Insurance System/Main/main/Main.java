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

	// ���� �� ������ �����. ����� �ڵ����� ��ü�� ����ϰ� ����.
	// ���� ����, ���� �μ� ���� �ϳ��� ������ ���������� ���--- �α��� �����....
	
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
		//login system���� dev, sales, rw�� �˾Ƽ� ����ǵ��� �Ѵ�. �� ������ ��� ���� ��.

		//create System - develop line
		ISDataList<DeveloperData> developerDataList = new ISDataList<DeveloperData>(); //������ ����Ʈ �����
		developerDataList.add(developer); //������ �߰��ϱ�

		ISDataList<InsuranceRatePermitManData> insuranceRatePermitManDataList = new ISDataList<InsuranceRatePermitManData>(); //�������������? ����Ʈ �����
		insuranceRatePermitManDataList.add(insuranceRatePermitManData); //�߰��ϱ�

		ISDataList<ProductPermitManData> productPermitManDataList = new ISDataList<ProductPermitManData>(); //��ǰ��������� ����Ʈ �����
		productPermitManDataList.add(productPermitManData); //�߰��Ϥ�

		ISDataList<AbsInsuranceData> insuranceDataList = new ISDataList<AbsInsuranceData>();

		// create System - sales line
		ISDataList<SalesManData> salesManDataList = new ISDataList<SalesManData>(); //������� ����Ʈ �����
		salesManDataList.add(salesManData); //������� �߰��ϱ�

		ISDataList<SalesManagerData> salesManagerDataList = new ISDataList<SalesManagerData>(); //������� ����Ʈ �����
		salesManagerDataList.add(salesManagerData); //������� �߰��ϱ�
		
		ISDataList<CustomerData> customerDataList = new ISDataList<CustomerData>(); //�� ����Ʈ �����
		customerDataList.add(customerData); //�� �߰��ϱ�
		
		
	// Associate System
		system.initializePanel(null);
		system.associateModel(
				new ISDataList<?>[] { developerDataList, insuranceRatePermitManDataList, productPermitManDataList,
						insuranceDataList, salesManDataList, salesManagerDataList, customerDataList });
		system.associateMainFrame(view);
		system.start();
	}
}
