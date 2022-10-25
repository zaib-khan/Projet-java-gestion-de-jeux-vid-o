package viewPackage;

import modelPackage.ModelRechercheJeuAchete;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TableauListeJeuClient  extends AbstractTableModel {

    private final List<ModelRechercheJeuAchete> listJeu;

    private final String[] entete = {"Titre","Edition","Thème","Année sortie","Limite age","Numéro rayon","Numéro étagère","Date facture"};

    public TableauListeJeuClient(ArrayList<ModelRechercheJeuAchete> jeu){
        listJeu = jeu;
    }

    @Override
    public int getRowCount() {
        return listJeu.size();
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
                return listJeu.get(rowIndex).getTitre();
            case 1:
                return  listJeu.get(rowIndex).getEdition();
            case 2:
                return listJeu.get(rowIndex).getTheme();
            case 3:
                return listJeu.get(rowIndex).getAnneeSortie();
            case 4:
                return listJeu.get(rowIndex).getLimiteAge();
            case 5:
                return listJeu.get(rowIndex).getNumRayon();
            case 6:
                return listJeu.get(rowIndex).getNumEtagere();
            case 7:
                Date date = listJeu.get(rowIndex).getDateFacture().getTime();
                return date;
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
                return  String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return Integer.class;
            case 6:
                return Integer.class;
            case 7:
                return Date.class;
            default:
                return null;
        }
    }
}
