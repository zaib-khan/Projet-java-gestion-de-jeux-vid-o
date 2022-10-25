package viewPackage;

import controllerPackage.Control;
import exceptionPackage.*;
import modelPackage.Client;

import javax.swing.table.AbstractTableModel;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class TableauListeClient extends AbstractTableModel {



    private final List<Client> clients ;

    private final String[] entetes = {"Identifiant", "Etablissement", "Nom", "Prenom", "CP","Ville","Rue","Numero","Date Naissance","Telephone","Email","Carte Fidelite","Taille Lunette","Taille Ceinture","Taille Vetement"};


    public TableauListeClient()throws NomException, PrenomException, ConnexionException, ParseException, CodePostalException, RueException,DateNaissanceException,IdentifiantException
            ,VilleException,NumeroException,IdentifiantException,TelephoneException,EmailException
    {
        super();
        clients = new Control().getEnsembleClient();
    }

    public int getRowCount() {
        return clients.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }



    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:

                return clients.get(rowIndex).getIdentifiant();
            case 1:

                return clients.get(rowIndex).getMatricule();
            case 2:
                return clients.get(rowIndex).getNom();
            case 3:
                return clients.get(rowIndex).getPrenom();
            case 4:
                return clients.get(rowIndex).getCodePostal();
            case 5:
                return clients.get(rowIndex).getVille();
            case 6:
                return clients.get(rowIndex).getRue();
            case 7:
                return clients.get(rowIndex).getNumero();
            case 8:
                return clients.get(rowIndex).affichageDateNaissance();

            case 9:
                return clients.get(rowIndex).getTelephone();
            case 10:
                return clients.get(rowIndex).getEmail();
            case 11:
                return clients.get(rowIndex).getCarteFidelite();
            case 12:
                return clients.get(rowIndex).getTailleLunette();
            case 13:
                return clients.get(rowIndex).getTailleCeinture();
            case 14:
                return clients.get(rowIndex).getTailleVetement();
            default:
                return null; //Ne devrait jamais arriver
        }
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Integer.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
                return Integer.class;
            case 8:
                return Date.class;
            case 9:
                return String.class;
            case 10:
                return String.class;
            case 11:
                return Boolean.class;
            case 12:
                return Double.class;
            case 13:
                return Double.class;
            case 14:
                return String.class;
            default:
                return null;
        }
    }

}





