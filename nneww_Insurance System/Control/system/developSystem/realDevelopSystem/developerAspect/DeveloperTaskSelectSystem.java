package system.developSystem.realDevelopSystem.developerAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import system.developSystem.DevelopSystem;

public class DeveloperTaskSelectSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {InsuranceDesign, WatchInsuranceData}
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("원하시는 업무를 선택하세요."));
		viewInfo.add(new BasicButton("보험 설계", EActionCommands.InsuranceDesign.name(), this.getAH()));
		viewInfo.add(new BasicButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), this.getAH()));
		return viewInfo;
	}
	
	@Override
	public void processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : this.startNewSystem(new DevelopInsuranceSystem());break;
		case WatchInsuranceData : this.startNewSystem(new SelecInsuranceToWatchSystem()); break;
		}
	}
}
