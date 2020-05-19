package system.developSystem.realDevelopSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import component.BasicButton;
import component.TitledTextArea;
import data.customerData.CustomerData;
import data.insuranceData.AbsInsuranceData;
import system.developSystem.DevelopSystem;

public class ShowInsuranceInfoToCustomerSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {SigninProduct}

	// Attribute
	private int insuranceID;
	private AbsInsuranceData searchedInsuranceData;
	private CustomerData customerData; 

	// Constructor
	public ShowInsuranceInfoToCustomerSystem(int insuranceID, CustomerData customerData) {this.insuranceID=insuranceID; this.customerData = customerData;}

	@Override
	public Vector<JComponent> getViewInfo() {
		this.searchedInsuranceData = this.insuranceList.search(this.insuranceID);
		
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new BasicButton("보험 가입", EActionCommands.SigninProduct.name(), this.getAH()));
		
		viewInfo.add(new JLabel("고객님이 가입하실 수 있는 보험 정보 입니다."));
		viewInfo.add(new TitledTextArea("아이디", 1, Integer.toString(searchedInsuranceData.getID()), false));
		viewInfo.add(new TitledTextArea("보험명", 1, searchedInsuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("내용", 10, searchedInsuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("보험요율", 10, searchedInsuranceData.getInsuranceRateInfo(), false));
		
		// 클다엔 이익, 계약조건(보험금, 보험료, 보험금 지불 만기일, 보험료 지불일)이 더있는데 여긴 없다.
		return viewInfo;
	}

	//no use
	@Override
	public void processEvent(ActionEvent e) {
		switch(EActionCommands.valueOf(e.getActionCommand())) {
		case SigninProduct : 
            int result = JOptionPane.showConfirmDialog(null, "보험가입을 진행하시겠습니까?", "SignInProduct", JOptionPane.YES_NO_OPTION);
            if(result==0) { //yes
            	JOptionPane.showMessageDialog(null, "보험가입이 완료되었습니다.", "SignInProduct", JOptionPane.INFORMATION_MESSAGE);
//            } else { //no
//            	// 이거 약간 이상함. 일단은 주석해둘 것.
            }
            this.gotoBack();
			break;
		default:
			break;
		}
	}
}
