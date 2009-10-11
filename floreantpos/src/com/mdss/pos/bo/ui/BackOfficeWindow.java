/*
 * BackOfficeWindow.java
 *
 * Created on August 16, 2006, 12:43 PM
 */

package com.mdss.pos.bo.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;

import com.mdss.pos.bo.actions.CategoryExplorerAction;
import com.mdss.pos.bo.actions.ConfigureRestaurantAction;
import com.mdss.pos.bo.actions.CookingInstructionExplorerAction;
import com.mdss.pos.bo.actions.CouponExplorerAction;
import com.mdss.pos.bo.actions.DrawerPullReportExplorerAction;
import com.mdss.pos.bo.actions.GroupExplorerAction;
import com.mdss.pos.bo.actions.ItemExplorerAction;
import com.mdss.pos.bo.actions.ModifierExplorerAction;
import com.mdss.pos.bo.actions.ModifierGroupExplorerAction;
import com.mdss.pos.bo.actions.ShiftExplorerAction;
import com.mdss.pos.bo.actions.UserExplorerAction;
import com.mdss.pos.bo.actions.UserTypeExplorerAction;
import com.mdss.pos.bo.actions.ViewGratuitiesAction;
import com.mdss.pos.main.Application;
import com.mdss.pos.model.User;
import com.mdss.pos.model.UserPermission;
import com.mdss.pos.model.UserType;
import com.mdss.pos.ui.report.actions.CreditCardReportAction;
import com.mdss.pos.ui.report.actions.HourlyLaborReportAction;
import com.mdss.pos.ui.report.actions.JournalReportAction;
import com.mdss.pos.ui.report.actions.KeyStatisticsSalesReportAction;
import com.mdss.pos.ui.report.actions.MenuUsageReportAction;
import com.mdss.pos.ui.report.actions.OpenTicketSummaryReportAction;
import com.mdss.pos.ui.report.actions.PayrollReportAction;
import com.mdss.pos.ui.report.actions.SalesAnalysisReportAction;
import com.mdss.pos.ui.report.actions.SalesBalanceReportAction;
import com.mdss.pos.ui.report.actions.SalesDetailReportAction;
import com.mdss.pos.ui.report.actions.SalesExceptionReportAction;
import com.mdss.pos.ui.report.actions.SalesReportAction;
import com.mdss.pos.ui.report.actions.ServerProductivityReportAction;

/**
 *
 * @author  MShahriar
 */
public class BackOfficeWindow extends javax.swing.JFrame {

	/** Creates new form BackOfficeWindow */
	public BackOfficeWindow() {
		initComponents();

		createMenus();

		tabbedPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					JPopupMenu menu = new JPopupMenu();
					menu.add(new AbstractAction("Close") {

						public void actionPerformed(ActionEvent e) {
							int index = tabbedPane.getSelectedIndex();
							tabbedPane.remove(index);
						}

					});
					menu.show(tabbedPane, e.getX(), e.getY());
				}
			}
		});

		setSize(800, 600);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 800) >> 1, (screenSize.height - 600) >> 1);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Application.getInstance().setBackOfficeWindow(null);
				dispose();
			}
		});

		setTitle(Application.getTitle() + ": Back Office");
	}

	private void createMenus() {
		User user = Application.getCurrentUser();
		UserType newUserType = user.getNewUserType();

		Set<UserPermission> permissions = null;

		if (newUserType != null) {
			permissions = newUserType.getPermissions();
		}

		JMenuBar menuBar = new JMenuBar();

		if (newUserType == null) {
			createAdminMenu(menuBar);
			createExplorerMenu(menuBar);
			createReportMenu(menuBar);
		}
		else {
			if(permissions != null && permissions.contains(UserPermission.PERFORM_ADMINISTRATIVE_TASK)) {
				createAdminMenu(menuBar);
			}
			if(permissions != null && permissions.contains(UserPermission.VIEW_EXPLORERS)) {
				createExplorerMenu(menuBar);
			}
			if(permissions != null && permissions.contains(UserPermission.VIEW_REPORTS)) {
				createReportMenu(menuBar);
			}
		}

		setJMenuBar(menuBar);
	}

	private void createReportMenu(JMenuBar menuBar) {
		JMenu reportMenu = new JMenu("Reports");
		reportMenu.add(new SalesReportAction());
		reportMenu.add(new OpenTicketSummaryReportAction());
		reportMenu.add(new HourlyLaborReportAction());
		reportMenu.add(new PayrollReportAction());
		reportMenu.add(new KeyStatisticsSalesReportAction());
		reportMenu.add(new SalesAnalysisReportAction());
		reportMenu.add(new CreditCardReportAction());
		reportMenu.add(new MenuUsageReportAction());
		reportMenu.add(new ServerProductivityReportAction());
		reportMenu.add(new JournalReportAction());
		reportMenu.add(new SalesBalanceReportAction());
		reportMenu.add(new SalesExceptionReportAction());
		reportMenu.add(new SalesDetailReportAction());
		menuBar.add(reportMenu);
	}

	private void createExplorerMenu(JMenuBar menuBar) {
		JMenu explorerMenu = new JMenu("Explorers");
		explorerMenu.add(new CategoryExplorerAction());
		explorerMenu.add(new GroupExplorerAction());
		explorerMenu.add(new ItemExplorerAction());
		explorerMenu.add(new ModifierGroupExplorerAction());
		explorerMenu.add(new ModifierExplorerAction());
		explorerMenu.add(new ShiftExplorerAction());
		explorerMenu.add(new CouponExplorerAction());
		explorerMenu.add(new CookingInstructionExplorerAction());
		menuBar.add(explorerMenu);
	}

	private void createAdminMenu(JMenuBar menuBar) {
		JMenu adminMenu = new JMenu("Admin");
		adminMenu.add(new ConfigureRestaurantAction());
		adminMenu.add(new UserExplorerAction());
		adminMenu.add(new UserTypeExplorerAction());
		adminMenu.add(new ViewGratuitiesAction());
		adminMenu.add(new DrawerPullReportExplorerAction());
		menuBar.add(adminMenu);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		tabbedPane = new javax.swing.JTabbedPane();

		getContentPane().setLayout(new java.awt.BorderLayout(5, 0));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jPanel1.setLayout(new java.awt.BorderLayout(5, 0));

		jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jPanel1.add(tabbedPane, java.awt.BorderLayout.CENTER);

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BackOfficeWindow().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTabbedPane tabbedPane;

	// End of variables declaration//GEN-END:variables

	public javax.swing.JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

}
