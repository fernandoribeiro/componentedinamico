// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 11/09/2013 02:18:38
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Questao.java

package modelos;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import modelos.*;

@ManagedBean(name="questao")
public class Questao  implements Serializable{

    public Questao()
    {
        setEditavel(true);
    }
private static final long serialVersionUID = 0xf534de3f97d0fb0aL;
    private String pergunta;
    private String textoDeAjuda;
    private List opcoes;
    private int tipoDeQuestao;
    private boolean editavel;

    public boolean isEditavel() {
        return editavel;
    }

    public boolean getEditavel() {
        return editavel;
    }
    public void setEditavel(boolean editavel) {
        this.editavel = editavel;
    }
    
    
    public Questao(String pergunta, String textoDeAjuda, int tipoDeQuestao, boolean editavel)
    {
        this.editavel = editavel;
        this.pergunta = pergunta;
        this.textoDeAjuda = textoDeAjuda;
        this.tipoDeQuestao = tipoDeQuestao;
    }

    public List getOpcoes()
    {
        return opcoes;
    }

    public void setOpcoes(List opcoes)
    {
        this.opcoes = opcoes;
    }

  

    public String getPergunta()
    {
        return pergunta;
    }

    public void setPergunta(String pergunta)
    {
        this.pergunta = pergunta;
    }

    public String getTextoDeAjuda()
    {
        return textoDeAjuda;
    }

    public void setTextoDeAjuda(String textoDeAjuda)
    {
        this.textoDeAjuda = textoDeAjuda;
    }

    public int getTipoDeQuestao()
    {
        return tipoDeQuestao;
    }

    public void setTipoDeQuestao(int tipoDeQuestao)
    {
        this.tipoDeQuestao = tipoDeQuestao;
    }

    
}
