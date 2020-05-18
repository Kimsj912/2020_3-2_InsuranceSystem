package component;

import java.awt.event.ActionListener;

import aConstant.ViewConstant;

@SuppressWarnings("serial")
public class LogoutButton extends BasicButton {
	
	// Constructor
	public LogoutButton(ActionListener actionListener) {
		super(ViewConstant.LogoutButtonText, ViewConstant.LogoutButtonIdentifier, actionListener);
		this.setPreferredSize(ViewConstant.LogoutButtonSize);
		this.setBackground(ViewConstant.LogoutButtonBackground);
	}
}
