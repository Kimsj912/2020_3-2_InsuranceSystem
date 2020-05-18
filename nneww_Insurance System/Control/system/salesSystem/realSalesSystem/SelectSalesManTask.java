package system.salesSystem.realSalesSystem;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import data.employeeData.salesEmployeeData.SalesManData;
import data.insuranceData.AbsInsuranceData;
import data.taskData.realTaskData.InsuranceRatePermit;
import system.developSystem.realDevelopSystem.developerAspect.DevelopInsuranceSystem;
import system.developSystem.realDevelopSystem.developerAspect.SelecInsuranceToWatchSystem;
import system.developSystem.realDevelopSystem.insuranceRatePermitMan.ShowInsuranceForInsuranceRatePermit;
import system.salesSystem.SalesSystem;

public class SelectSalesManTask extends SalesSystem {

	// Static
	private enum EActionCommands {SigninCustomer, LookupAvailableProduct}

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("원하시는 업무를 선택하세요."));
		viewInfo.add(new BasicButton("고객 가입시키기", EActionCommands.SigninCustomer.name(), this.getAH()));
		viewInfo.add(new BasicButton("가입 가능한 보험 조회", EActionCommands.LookupAvailableProduct.name(), this.getAH()));
		return viewInfo;
	}
	@Override
	public void processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : this.startNewSystem(new SinginCustomerSystem());break;
		case LookupAvailableProduct : this.startNewSystem(new ShowCustomerSystem()); break;
		}
	}
}
