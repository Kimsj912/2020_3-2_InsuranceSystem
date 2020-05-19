package system.developSystem.realDevelopSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import data.customerData.CustomerData;
import data.insuranceData.AbsInsuranceData;
import dataList.IntISDataList;
import dataList.realDataList.ISDataList;
import system.developSystem.DevelopSystem;
import system.developSystem.realDevelopSystem.developerAspect.ShowInsuranceInfoSystem;

public class ShowAvailableProduct extends DevelopSystem {

	private CustomerData customerData;
	
	public ShowAvailableProduct(CustomerData customerData) {
		this.customerData = customerData;
		
	}
	public IntISDataList<AbsInsuranceData> searching() {
		IntISDataList<AbsInsuranceData> availableInsuranceList= new ISDataList<AbsInsuranceData>();
		
		// 고객 식 마련해서 가능한 것 찾아서 availableInsuranceList에 넣기
		// 일단은 전체 보험 상품을 보여주려고 함.
		for (AbsInsuranceData insuranceData:this.insuranceList.getList()) {
			availableInsuranceList.add(insuranceData);
		}
		return availableInsuranceList;
	}
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("보험을 선택하세요."));
		//여기도 테이블로 보여줘야함. ㅎㅎ.... (보험 아이디, 보험명, 내용)
		for (AbsInsuranceData insuranceData : searching().getList()) {
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), this.getAH()));
		}
		return viewInfo;
	}

	@Override
	public void processEvent(ActionEvent e) {
		// showInsuranceInfoSystem에 true false이런거 넣어서 설정할수도 있을 것 같은데, 있는건 안건들이는게 좋으니까 일단 나눠둠.
		this.startNewSystem(new ShowInsuranceInfoToCustomerSystem(Integer.parseInt(e.getActionCommand()), this.customerData));

	}

}
