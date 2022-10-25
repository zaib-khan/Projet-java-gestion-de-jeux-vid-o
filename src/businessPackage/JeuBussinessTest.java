package businessPackage;

import exceptionPackage.ConnexionException;
import org.junit.Before;
import org.junit.Test;

public class JeuBussinessTest {

    private JeuBussiness jeuBussiness;

    @Before
    public void setUp() throws Exception {
        jeuBussiness = new JeuBussiness();
    }

    @Test
    public void limiteAgeMoyenJeux() throws ConnexionException {
        jeuBussiness.limiteAgeMoyenJeux();
    }

    @Test
    public void prixBaseMoyen() throws ConnexionException {
        jeuBussiness.prixBaseMoyen();
    }
}