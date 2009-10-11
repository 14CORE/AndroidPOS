package com.mdss.pos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.mdss.pos.bo.ui.BackOfficeWindow;
import com.mdss.pos.bo.ui.explorer.CookingInstructionExplorer;
import com.mdss.pos.main.Application;

public class CookingInstructionExplorerAction extends AbstractAction {

	public CookingInstructionExplorerAction() {
		super("Cooking Instructions");
	}

	public CookingInstructionExplorerAction(String name) {
		super(name);
	}

	public CookingInstructionExplorerAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		BackOfficeWindow backOfficeWindow = Application.getInstance().getBackOfficeWindow();
		
		CookingInstructionExplorer explorer = null;
		JTabbedPane tabbedPane = backOfficeWindow.getTabbedPane();
		int index = tabbedPane.indexOfTab("Cooking Instructions");
		if (index == -1) {
			explorer = new CookingInstructionExplorer();
			tabbedPane.addTab("Cooking Instructions", explorer);
		}
		else {
			explorer = (CookingInstructionExplorer) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(explorer);
	}

}
