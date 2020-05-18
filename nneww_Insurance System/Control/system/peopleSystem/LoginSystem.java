package system.peopleSystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.BasicButton;
import system.developSystem.DevelopSystem;
import system.developSystem.realDevelopSystem.developerAspect.DeveloperTaskSelectSystem;
import system.developSystem.realDevelopSystem.insuranceRatePermitMan.SelectInsuranceRatePermitTask;
import system.developSystem.realDevelopSystem.productPermitMan.SelectProductPermitTask;
import system.salesSystem.realSalesSystem.SelectSalesManTask;

public class LoginSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {Login, LogInDeveloper, LoginInsuranceRatePermitMan, LoginProductPermitMan, SalesMan, SalesManager}

	private JTextField id;
	private JPasswordField pw;
		
	@Override
	public Vector<JComponent> getViewInfo() {
		
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("�α���"));
		this.id = new JTextField(15);
		viewInfo.add(id);
		this.pw =new JPasswordField(15);
		viewInfo.add(pw);
		viewInfo.add(new BasicButton("�α���", EActionCommands.Login.name(), this.getAH()));
		
//		// view�� ����� ������ ��ư�� ���� ������ �ý����� ���� �����ݾ�.
//		viewInfo.add(new BasicButton("������", EActionCommands.LogInDeveloper.name(), this.getAH()));
//		viewInfo.add(new BasicButton("���� ������", EActionCommands.LoginInsuranceRatePermitMan.name(), this.getAH()));
//		viewInfo.add(new BasicButton("��ǰ �ΰ���", EActionCommands.LoginProductPermitMan.name(), this.getAH()));
		return viewInfo;
	}
	
	public void login() {
		String user = "";
		//�ϴ� �׽�Ʈ�� ���⼭ �ĺ��ϱ� ��� ���߿� �Լ��� ��������.
		int testidnum = Integer.parseInt(id.getText());
		if(testidnum<10) {
			user = "LogInDeveloper";
		}else if(testidnum<100) {
			user = "LoginInsuranceRatePermitMan";
		} else if(testidnum<1000) {
			user = "LoginProductPermitMan";
		} else if(testidnum<10000) {
			user = "salesMan";
		} else if(testidnum<100000) {
			user = "salesManager";
		}
		
		
		//---������� ���̵� �ĺ��ؼ� �׽�Ʈ�ϱ� ���� ����.
		
		// �ϴ��� String���� �׽�Ʈ
		switch(user) {
		case "LogInDeveloper" : this.startNewSystem(new DeveloperTaskSelectSystem()); break;
		case "LoginInsuranceRatePermitMan" : this.startNewSystem(new SelectInsuranceRatePermitTask()); break;
		case "LoginProductPermitMan" : this.startNewSystem(new SelectProductPermitTask()); break;
		case "salesMan": this.startNewSystem(new SelectSalesManTask()); break;
//		case "salesManager": this.startNewSystem(new SelectSalesManagerTask()); break;
		}
	}
	
	@Override
	public void processEvent(ActionEvent e) {
		switch(EActionCommands.valueOf(e.getActionCommand())) {
		case Login : login();
		default:
			//�ϴ� �α��� ��������� �����Ű������ case�� �����ϴ� default�߰��Ϸ��� �ϴ� �߰��ص�.
			break;
		}
	}
}
