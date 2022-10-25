package viewPackage;

import modelPackage.ModelRechercheFacture;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class TableauListeFactureDate extends AbstractTableModel {


    private final List<ModelRechercheFacture> listFacture;
    private final String[] entete = {"Date facture","Numéro Facture","Nom vendeur","Prénom vendeur","Nom établissement"};

    public TableauListeFactureDate(ArrayList<ModelRechercheFacture> facture) {
        listFacture = facture;

    }
    public String getColumnName(int columnIndex){
        return entete[columnIndex];
    }

    @Override
    public int getRowCount() {
        return listFacture.size();
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                Date date = listFacture.get(rowIndex).getDateFacture().getTime();
                return date;
            case 1:
                return listFacture.get(rowIndex).getNumeroFacture() ;
            case 2:
                return listFacture.get(rowIndex).getNomVendeur();
            case 3:
                return listFacture.get(rowIndex).getPrenomVendeur();
            case 4 :
                return  listFacture.get(rowIndex).getNomEtablissement();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return Date.class;
            case 1:
                return  Integer.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            default:
                return null;
        }
    }
}