package system.developSystem;

import data.ISData;
import data.employeeData.developEmployeeData.DeveloperData;
import data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import data.employeeData.developEmployeeData.ProductPermitManData;
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

	// Initialize Time Use
	@Override @SuppressWarnings("unchecked")
	public void specificAssociateModel(IntISDataList<? extends ISData>[] datas) { //ISSystem�� specificAssociateModel�� �޾Ƹ�. //develop line ����� ��, �������� ����Ʈ���� dats�� �������.
		this.developerList=(IntISDataList<DeveloperData>) datas[0];
		this.insuranceRatePermitManList=(IntISDataList<InsuranceRatePermitManData>) datas[1];
		this.productPermitManList=(IntISDataList<ProductPermitManData>) datas[2];
		this.insuranceList=(IntISDataList<AbsInsuranceData>) datas[3];
	}
}
