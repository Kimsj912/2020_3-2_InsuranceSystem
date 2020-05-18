package system.developSystem.realDevelopSystem.developerAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import data.insuranceData.AbsInsuranceData;
import system.developSystem.DevelopSystem;

public class SelecInsuranceToWatchSystem extends DevelopSystem {

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("보험을 선택하세요."));
		for(AbsInsuranceData insuranceData : this.insuranceList.getList()) {
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), this.getAH()));
		}
		return viewInfo;
	}
	
	@Override
	public void processEvent(ActionEvent e) {
		this.startNewSystem(new ShowInsuranceInfoSystem(Integer.parseInt(e.getActionCommand())));
	}
}
