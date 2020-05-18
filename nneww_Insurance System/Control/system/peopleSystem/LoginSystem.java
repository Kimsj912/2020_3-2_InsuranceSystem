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
		viewInfo.add(new JLabel("로그인"));
		this.id = new JTextField(15);
		viewInfo.add(id);
		this.pw =new JPasswordField(15);
		viewInfo.add(pw);
		viewInfo.add(new BasicButton("로그인", EActionCommands.Login.name(), this.getAH()));
		
//		// view를 만들고 선택한 버튼에 따라서 각각의 시스템을 여는 것이잖아.
//		viewInfo.add(new BasicButton("개발자", EActionCommands.LogInDeveloper.name(), this.getAH()));
//		viewInfo.add(new BasicButton("요율 검증자", EActionCommands.LoginInsuranceRatePermitMan.name(), this.getAH()));
//		viewInfo.add(new BasicButton("상품 인가자", EActionCommands.LoginProductPermitMan.name(), this.getAH()));
		return viewInfo;
	}
	
	public void login() {
		String user = "";
		//일단 테스트로 여기서 식별하기 고고 나중엔 함수로 뺴버릴것.
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
		
		
		//---여기까지 아이디 식별해서 테스트하기 위한 용임.
		
		// 일단은 String으로 테스트
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
			//일단 로그인 결과에따라서 연결시키기위해 case를 삭제하니 default추가하래서 일단 추가해둠.
			break;
		}
	}
}
