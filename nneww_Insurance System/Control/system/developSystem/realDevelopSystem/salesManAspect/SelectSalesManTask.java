package system.developSystem.realDevelopSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import system.developSystem.DevelopSystem;

public class SelectSalesManTask extends DevelopSystem {

	// Static
	private enum EActionCommands {SigninCustomer, LookupAvailableProduct}

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("���Ͻô� ������ �����ϼ���."));
		viewInfo.add(new BasicButton("�� ���Խ�Ű��", EActionCommands.SigninCustomer.name(), this.getAH()));
		viewInfo.add(new BasicButton("���� ������ ���� ��ȸ", EActionCommands.LookupAvailableProduct.name(), this.getAH()));
		return viewInfo;
	}
	@Override
	public void processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : this.startNewSystem(new SinginCustomerSystem());break;
		case LookupAvailableProduct : this.startNewSystem(new SearchCustomerSystem()); break;
		}
	}
}
