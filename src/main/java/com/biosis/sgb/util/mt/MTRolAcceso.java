/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.util.mt;

import com.biosis.sgb.entidades.RolAcceso;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Francis
 */
public class MTRolAcceso extends AbstractTableModel {

    private final List<RolAcceso> rolAccesoList;
    private final String[] columnas;

    public MTRolAcceso(List<RolAcceso> rolAccesoList) {
        this.columnas = new String[]{"Acceso", "Descripción", "Consultar", "Registrar", "Modificar", "Eliminar"};
        this.rolAccesoList = rolAccesoList;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }

    @Override
    public int getRowCount() {
        return rolAccesoList.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RolAcceso rolAcceso = this.rolAccesoList.get(rowIndex);
        String crud = rolAcceso.getCrud();
        switch (columnIndex) {
            case 0:
                return rolAcceso.getAcceso().getNombre();
            case 1:
                return rolAcceso.getAcceso().getDescripcion();
            case 2:
                return crud.charAt(1) == '1';
            case 3:
                return crud.charAt(0) == '1';
            case 4:
                return crud.charAt(2) == '1';
            case 5:
                return crud.charAt(3) == '1';
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        RolAcceso rolAcceso = this.rolAccesoList.get(rowIndex);
        if (rolAcceso.getAcceso().getId() == 35) {
            if (columnIndex == 2) {
                return true;
            }
        } else if (columnIndex >= 2) {
            return true;
        }
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex >= 2) {
            return Boolean.class;
        }
        return String.class; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex >= 2) {
            RolAcceso rolAcceso = this.rolAccesoList.get(rowIndex);
            StringBuilder crud = new StringBuilder(rolAcceso.getCrud());
            char valor = (Boolean) aValue ? '1' : '0';
            switch (columnIndex) {
                case 2:
                    //Read
                    crud.setCharAt(1, valor);
                    break;
                case 3:
                    //Create
                    crud.setCharAt(0, valor);
                    break;
                case 4:
                    //Update
                    crud.setCharAt(2, valor);
                    break;
                case 5:
                    //Delete
                    crud.setCharAt(3, valor);
                    break;
            }
            System.out.println(String.format("setValueAt(%s,%s) => crud: %s", rowIndex, columnIndex, crud.toString()));
            rolAcceso.setCrud(crud.toString());
            fireTableCellUpdated(rowIndex, columnIndex);
        }
        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

}
