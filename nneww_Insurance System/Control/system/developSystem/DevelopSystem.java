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
	protected IntISDataList<DeveloperData> developerList; //������ ����Ʈ
	protected IntISDataList<InsuranceRatePermitManData> insuranceRatePermitManList;  //�����������ϴ� ��� ����Ʈ
	protected IntISDataList<ProductPermitManData> productPermitManList; //���� ������ ����Ʈ
//	protected IntISDataList<AbsInsuranceData> insuranceList; //���� ������ ����Ʈ
	//insuranceList�� �������� ���ϱ� ISSystem���� �ø�. �׷��� SalesSystem���� ��밡��.
	
	protected IntISDataList<SalesManData> salesManList; //������ ����Ʈ
	protected IntISDataList<SalesManagerData> salesManagerList;  //�����������ϴ� ��� ����Ʈ
//	protected IntISDataList<CustomerData> customerList;
	protected IntISDataList<AbsInsuranceData> insuranceList; //���� ������ ����Ʈ
	protected IntISDataList<CustomerData> customerList; //���� ������ ����Ʈ
	protected IntISDataList<ActivityPlanData> activityPlanList; //���� ������ ����Ʈ
	
	
	// Initialize Time Use
	@Override @SuppressWarnings("unchecked")
	public void specificAssociateModel(IntISDataList<? extends ISData>[] datas) { //ISSystem�� specificAssociateModel�� �޾Ƹ�. //develop line ����� ��, �������� ����Ʈ���� dats�� �������.
		this.developerList=(IntISDataList<DeveloperData>) datas[0];
		this.insuranceRatePermitManList=(IntISDataList<InsuranceRatePermitManData>) datas[1];
		this.productPermitManList=(IntISDataList<ProductPermitManData>) datas[2];
		this.insuranceList=(IntISDataList<AbsInsuranceData>) datas[3];

		this.salesManList=(IntISDataList<SalesManData>) datas[4];
		this.salesManagerList=(IntISDataList<SalesManagerData>) datas[5];
	
		this.customerList=(IntISDataList<CustomerData>) datas[6];

	}
}
