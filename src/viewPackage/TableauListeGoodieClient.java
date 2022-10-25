package viewPackage;

import modelPackage.ModelRechercheGoodie;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TableauListeGoodieClient extends AbstractTableModel {

    private final List<ModelRechercheGoodie> listGodie;
    private final String[] entete = {"Libelle","Prix de base","Type de goodie","Date de facture","Nom du vendeur","Prénom du vendeur"};

    public TableauListeGoodieClient(ArrayList<ModelRechercheGoodie> goodie) {
        listGodie = goodie;
    }

    @Override
    public int getRowCount() {
        return listGodie.size();
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }
    public String getColumnName(int columnIndex){
        return entete[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listGodie.get(rowIndex).getLibelle();
            case 1:
                return  listGodie.get(rowIndex).getPrixbase();
            case 2:
                return listGodie.get(rowIndex).getType();
            case 3:
                Date date = listGodie.get(rowIndex).getDateFacture().getTime();
                return date;
            case 4:
                return listGodie.get(rowIndex).getNom();
            case 5:
                return listGodie.get(rowIndex).getPrenom();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return String.class;
            case 3:
                return Date.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            default:
                return null;
        }
    }



}