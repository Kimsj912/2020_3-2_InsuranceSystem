package system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComponent;

import aConstant.ViewConstant;
import data.ISData;
import data.customerData.CustomerData;
import data.insuranceData.AbsInsuranceData;
import dataList.IntISDataList;
import frame.IntFrame;
import panel.BasicPanel;
import system.peopleSystem.LoginSystem;

public abstract class ISSystem {

	// Association
	private IntFrame mainFrame;
	private IntISDataList<? extends ISData>[] datas;
	private ISSystem beforeSystem;
	
	
	// Component
	private ActionHandler actionListener;
	private BasicPanel nowPanel;
	
	// Constructor
	public ISSystem() {
		// Create Component
		this.actionListener = new ActionHandler();
		this.nowPanel = new BasicPanel(); 
	}
	
	// Initialize Time Use
	public void initializePanel(ISSystem beforeSystem) {
		this.beforeSystem=beforeSystem;
		this.nowPanel.addComponents(this.getViewInfo());
		if(beforeSystem==null) {this.nowPanel.addEmptyToolSpace();}
		else {this.nowPanel.addBackButton(this.actionListener);}
	}
	public void associateMainFrame(IntFrame mainFrame) {this.mainFrame=mainFrame;}
	public void associateModel(IntISDataList<? extends ISData>[] datas) {this.datas=datas; this.specificAssociateModel(datas);} //datas = 개발관련 사람들 데이터리스트
	public abstract void specificAssociateModel(IntISDataList<? extends ISData>[] datas);// 이걸 그냥 다른 시스템들 다 합치면 좋을 텐데
	
	// Start Time Use
	public void start() {this.mainFrame.showPanel(this.nowPanel);} //showpanel을 부른다.
	
	// Any Time Use
	public void startNewSystem(ISSystem newSystem) {
		newSystem.associateModel(this.datas);
		newSystem.associateMainFrame(this.mainFrame);
		newSystem.initializePanel(this);
		newSystem.start();
	}
	public void updatePanel() {
		this.nowPanel = new BasicPanel(); 
		this.nowPanel.addComponents(this.getViewInfo());
		if(this.beforeSystem==null) {this.nowPanel.addEmptyToolSpace();}
		else {this.nowPanel.addBackButton(this.actionListener);}
		this.start();
	}
	
	// Getter & Setter
	public abstract Vector<JComponent> getViewInfo();
	public BasicPanel getPanel() {return this.nowPanel;}
	public ActionListener getAH() {return this.actionListener;}
		
	// Event Use
	public abstract void processEvent(ActionEvent e);
	public void gotoBack() {this.beforeSystem.updatePanel();}
	public void gotoLogin() {this.startNewSystem(new LoginSystem());}
	
	// Inner Class
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(ViewConstant.BackButtonIdentifier)) {gotoBack();} 
			else if(e.getActionCommand().equals(ViewConstant.LogoutButtonIdentifier)) {gotoLogin();} 
			else {processEvent(e);}
		}
	}
}
