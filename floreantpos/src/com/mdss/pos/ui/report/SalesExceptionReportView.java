package com.mdss.pos.ui.report;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

import org.jdesktop.swingx.JXDatePicker;

import com.mdss.pos.main.Application;
import com.mdss.pos.model.util.DateUtil;
import com.mdss.pos.report.SalesExceptionReport;
import com.mdss.pos.report.SalesReportModelFactory;
import com.mdss.pos.report.services.ReportService;
import com.mdss.pos.ui.dialog.POSMessageDialog;

public class SalesExceptionReportView extends JPanel {
	private SimpleDateFormat fullDateFormatter = new SimpleDateFormat("yyyy MMM dd, hh:mm a");
	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat("yyyy MMM dd");
	
	private JXDatePicker fromDatePicker = new JXDatePicker();
	private JXDatePicker toDatePicker = new JXDatePicker();
	private JButton btnGo = new JButton("GO");
	private JPanel reportContainer;
	
	public SalesExceptionReportView() {
		super(new BorderLayout());
		
		JPanel topPanel = new JPanel(new MigLayout());
		
		topPanel.add(new JLabel("From:"), "grow");
		topPanel.add(fromDatePicker,"wrap");
		topPanel.add(new JLabel("To:"), "grow");
		topPanel.add(toDatePicker,"wrap");
		topPanel.add(btnGo, "skip 1, al right");
		add(topPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBorder(new EmptyBorder(0, 10,10,10));
		centerPanel.add(new JSeparator(), BorderLayout.NORTH);
		
		reportContainer = new JPanel(new BorderLayout());
		centerPanel.add(reportContainer);
		
		add(centerPanel);
		
		btnGo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					viewReport();
				} catch (Exception e1) {
					POSMessageDialog.showError(SalesExceptionReportView.this, POSMessageDialog.ERROR_MESSAGE, e1);
				}
			}
			
		});
	}
	
	private void viewReport() throws Exception {
		Date fromDate = fromDatePicker.getDate();
		Date toDate = toDatePicker.getDate();
		
		if(fromDate.after(toDate)) {
			POSMessageDialog.showError(Application.getInstance().getBackOfficeWindow(), "From date cannot be greater than to date.");
			return;
		}
		
		fromDate = DateUtil.startOfDay(fromDate);
		toDate = DateUtil.endOfDay(toDate);
		
		ReportService reportService = new ReportService();
		SalesExceptionReport report = reportService.getSalesExceptionReport(fromDate, toDate);
		
		JasperReport voidReport = (JasperReport) JRLoader.loadObject(SalesReportModelFactory.class.getResource("/com/mdss/pos/ui/report/sales_summary_exception_voids.jasper"));
		JasperReport discountReport = (JasperReport) JRLoader.loadObject(SalesReportModelFactory.class.getResource("/com/mdss/pos/ui/report/sales_summary_exception_discounts.jasper"));
		
		HashMap map = new HashMap();
		ReportUtil.populateRestaurantProperties(map);
		map.put("fromDate", shortDateFormatter.format(fromDate));
		map.put("toDate", shortDateFormatter.format(toDate));
		map.put("reportTime", fullDateFormatter.format(new Date()));
		map.put("voidReport", voidReport);
		map.put("voidReportDataSource", new JRTableModelDataSource(report.getVoidTableModel()));
		map.put("discountReport", discountReport);
		map.put("discountReportDataSource", new JRTableModelDataSource(report.getDiscountTableModel()));
		
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/com/mdss/pos/ui/report/sales_summary_exception.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JREmptyDataSource());
		JRViewer viewer = new JRViewer(jasperPrint);
		reportContainer.removeAll();
		reportContainer.add(viewer);
		reportContainer.revalidate();
		
	}
}
