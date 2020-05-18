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
		this.jake = this.insuranceRatePermitManList.getList().get(0);// ���ݸ� ó�� ���� �̾Ƽ� �Ѵ�!!
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("���� �����Ͻ� ������ ������ �ּ���"));
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
