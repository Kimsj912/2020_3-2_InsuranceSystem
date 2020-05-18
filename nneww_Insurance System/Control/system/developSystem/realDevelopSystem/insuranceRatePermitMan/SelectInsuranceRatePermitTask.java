package system.developSystem.realDevelopSystem.insuranceRatePermitMan;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import data.insuranceData.AbsInsuranceData;
import data.taskData.realTaskData.InsuranceRatePermit;
import system.developSystem.DevelopSystem;

public class SelectInsuranceRatePermitTask extends DevelopSystem {

	// My Friend
	private InsuranceRatePermitManData jake;
		
	@Override
	public Vector<JComponent> getViewInfo() {
		this.jake = this.insuranceRatePermitManList.getList().get(0);// 지금만 처음 직원 뽑아서 한다!!
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("요율 검증하실 보험을 선택해 주세요"));
		for(InsuranceRatePermit task : this.jake.getTaskList().getList()) {
			AbsInsuranceData insuranceData = this.insuranceList.search(task.getTargetInsuranceID());
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(task.getID()), this.getAH()));
		}
		return viewInfo;
	}
	
	@Override
	public void processEvent(ActionEvent e) {
		this.startNewSystem(new ShowInsuranceForInsuranceRatePermit(this.jake.getTaskList(), Integer.parseInt(e.getActionCommand())));
	}
}
