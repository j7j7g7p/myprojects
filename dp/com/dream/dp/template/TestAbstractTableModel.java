package com.dream.dp.template;

import javax.swing.table.AbstractTableModel;

public class TestAbstractTableModel extends AbstractTableModel{

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		int i = 1;
		String binaryString = Integer.toBinaryString(10);
		System.out.println(binaryString);
	}
}
