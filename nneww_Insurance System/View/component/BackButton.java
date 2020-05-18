package component;

import java.awt.event.ActionListener;

import aConstant.ViewConstant;

@SuppressWarnings("serial")
public class BackButton extends BasicButton {
	
	// Constructor
	public BackButton(ActionListener actionListener) {
		super(ViewConstant.BackButtonText, ViewConstant.BackButtonIdentifier, actionListener);
		this.setPreferredSize(ViewConstant.BackButtonSize);
		this.setBackground(ViewConstant.BackButtonBackground);
	}
}
