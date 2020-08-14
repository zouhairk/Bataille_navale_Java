package com.ibformation.app.service;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class StatusColumnCellRenderer extends DefaultTableCellRenderer {

	/**   pour l'utiliser 
	 *    Table.getColumnModel().getColumn(columnIndex).setCellRenderer(new StatusColumnCellRenderer());
	 */

	private static final long serialVersionUID = -8845686677830648956L;

	private Color color;

	public StatusColumnCellRenderer(Color r) {
		this.color = r;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		c.setBackground(this.color);

		return c;
	}

}
