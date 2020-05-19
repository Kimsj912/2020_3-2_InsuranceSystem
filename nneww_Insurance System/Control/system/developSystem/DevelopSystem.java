package system.developSystem;

import data.ISData;
import data.activityPlanData.ActivityPlanData;
import data.customerData.CustomerData;
import data.employeeData.developEmployeeData.DeveloperData;
import data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import data.employeeData.developEmployeeData.ProductPermitManData;
import data.employeeData.salesEmployeeData.SalesManData;
import data.employeeData.salesEmployeeData.SalesManagerData;
import data.insuranceData.AbsInsuranceData;
import dataList.IntISDataList;
import system.ISSystem;

public abstract class DevelopSystem extends ISSystem {

	// Associate
	protected IntISDataList<DeveloperData> developerList; //개발자 리스트
	protected IntISDataList<InsuranceRatePermitManData> insuranceRatePermitManList;  //보험요율계산하는 사람 리스트
	protected IntISDataList<ProductPermitManData> productPermitManList; //요율 검증사 리스트
//	protected IntISDataList<AbsInsuranceData> insuranceList; //보험 데이터 리스트
	//insuranceList는 위에서도 쓰니까 ISSystem으로 올림. 그래야 SalesSystem에서 사용가능.
	
	protected IntISDataList<SalesManData> salesManList; //개발자 리스트
	protected IntISDataList<SalesManagerData> salesManagerList;  //보험요율계산하는 사람 리스트
//	protected IntISDataList<CustomerData> customerList;
	protected IntISDataList<AbsInsuranceData> insuranceList; //보험 데이터 리스트
	protected IntISDataList<CustomerData> customerList; //보험 데이터 리스트
	protected IntISDataList<ActivityPlanData> activityPlanList; //보험 데이터 리스트
	
	
	// Initialize Time Use
	@Override @SuppressWarnings("unchecked")
	public void specificAssociateModel(IntISDataList<? extends ISData>[] datas) { //ISSystem의 specificAssociateModel을 받아몸. //develop line 사람들 및, 데이터의 리스트들이 dats에 담겨있음.
		this.developerList=(IntISDataList<DeveloperData>) datas[0];
		this.insuranceRatePermitManList=(IntISDataList<InsuranceRatePermitManData>) datas[1];
		this.productPermitManList=(IntISDataList<ProductPermitManData>) datas[2];
		this.insuranceList=(IntISDataList<AbsInsuranceData>) datas[3];

		this.salesManList=(IntISDataList<SalesManData>) datas[4];
		this.salesManagerList=(IntISDataList<SalesManagerData>) datas[5];
	
		this.customerList=(IntISDataList<CustomerData>) datas[6];

	}
}
