package modelos;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import modelos.*;
import regrasdenegocio.*;

@ManagedBean
public class Opcao implements Serializable{

    public Opcao()
    {
        campo = "";
    }

    public Opcao(String campo)
    {
        this.campo = campo;
    }

    public String getCampo()
    {
        return campo;
    }

    public void setCampo(String campo)
    {
        this.campo = campo;
    }

    public String toString()
    {
        return campo;
    }

    private static final long serialVersionUID = 0x31ef306b6588fcc9L;
    private String campo;
}

