package modelPackage;

import exceptionPackage.NumeroException;
import org.junit.Assert;

public class ClientTest {

    private Client client;

    @org.junit.Before
    public void setUp(){
        client = new Client();

    }

    @org.junit.Test
    public void setNumero() throws NumeroException {
        client.setNumero("10");
        Assert.assertEquals("10", client.getNumero() );
        client.setNumero("1");
        Assert.assertEquals("1", client.getNumero() );
        client.setNumero("105");
        Assert.assertEquals("105", client.getNumero() );
    }
}