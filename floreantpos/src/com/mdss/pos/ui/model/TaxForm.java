/*
 * TaxEditor.java
 *
 * Created on August 3, 2006, 1:49 AM
 */

package com.mdss.pos.ui.model;

import com.mdss.pos.model.Tax;
import com.mdss.pos.model.dao.TaxDAO;
import com.mdss.pos.swing.MessageDialog;
import com.mdss.pos.ui.BeanEditor;
import com.mdss.pos.util.POSUtil;

/**
 *
 * @author  MShahriar
 */
public class TaxForm extends BeanEditor {
    
    /** Creates new form TaxEditor */
    public TaxForm() throws Exception {
        this(new Tax());
    }
    
    public TaxForm(Tax tax) throws Exception {
    	initComponents();
    	
    	setBean(tax);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfName = new com.mdss.pos.swing.FixedLengthTextField();
        tfRate = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Name:");

        jLabel2.setText("Rate:");

        tfRate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("%");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(tfRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3))
                    .add(tfName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 208, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(tfName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(tfRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.mdss.pos.swing.FixedLengthTextField tfName;
    private javax.swing.JFormattedTextField tfRate;
    // End of variables declaration//GEN-END:variables
	@Override
	public boolean save() {
		
		try {
			if(!updateModel()) return false;
			
			Tax tax = (Tax) getBean();
			TaxDAO dao = new TaxDAO();
			dao.saveOrUpdate(tax);
		} catch (Exception e) {
			MessageDialog.showError(e);
			return false;
		}
		
		return true;
	}

	@Override
	public void dispose() {
	}

	@Override
	protected void updateView() {
		Tax tax = (Tax) getBean();
		tfName.setText(tax.getName());
		tfRate.setValue(Double.valueOf(tax.getRate()));
	}

	@Override
	protected boolean updateModel() {
		Tax tax = (Tax) getBean();
		
		String name = tfName.getText();
    	if(POSUtil.isBlankOrNull(name)) {
    		MessageDialog.showError("Name is required");
    		return false;
    	}
		
		tax.setName(name);
		tax.setRate(new Double(tfRate.getValue().toString()).doubleValue());
		
		return true;
	}
    
	public String getDisplayText() {
    	Tax tax = (Tax) getBean();
    	if(tax.getId() == null) {
    		return "New tax rate";
    	}
    	return "Edit tax rate";
    }
}