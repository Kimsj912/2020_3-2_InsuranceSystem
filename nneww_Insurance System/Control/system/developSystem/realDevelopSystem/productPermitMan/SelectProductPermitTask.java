package system.developSystem.realDevelopSystem.productPermitMan;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import component.BasicButton;
import data.employeeData.developEmployeeData.ProductPermitManData;
import data.insuranceData.AbsInsuranceData;
import data.taskData.realTaskData.ProductPermit;
import system.developSystem.DevelopSystem;

public class SelectProductPermitTask extends DevelopSystem {

	// My Friend
	private ProductPermitManData jake;
		
	@Override
	public Vector<JComponent> getViewInfo() {
		this.jake = this.productPermitManList.getList().get(0);// ���ݸ� ó�� ���� �̾Ƽ� �Ѵ�!!
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("�ΰ��Ͻ� ������ ������ �ּ���"));
		for(ProductPermit task : this.jake.getTaskList().getList()) {
			AbsInsuranceData insuranceData = this.insuranceList.search(task.getTargetInsuranceID());
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(task.getID()), this.getAH()));
		}
		return viewInfo;
	}
	
	@Override
	public void processEvent(ActionEvent e) {
		this.startNewSystem(new ShowInsuranceForProductPermit(this.jake.getTaskList(), Integer.parseInt(e.getActionCommand())));
	}
}
