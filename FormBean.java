package beans;

import java.io.Serializable;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import modelos.Opcao;
import modelos.Questao;
import regrasdenegocio.QuestaoRN;

@ManagedBean(name="questionario")
@SessionScoped
public class FormBean implements Serializable{
    
    private static final long serialVersionUID = 0xce82626b8c35c8bL;
    private QuestaoRN questao;
    private List questoes = new ArrayList();
    private DataModel dataModelQuestoes;
    private static Map opcoes;
    private String resposta;
    private List respostas;


    public FormBean()
    {
        questoes = new ArrayList();
        questao = new QuestaoRN();
        questao = questao.criarQuestaoModelo();
        questoes.add(questao);
        dataModelQuestoes = new ListDataModel(questoes);
       
        respostas = new ArrayList();
    }

    public QuestaoRN novaQuestao()
    {
        QuestaoRN q = questao.criarQuestaoModelo();
        q.getQuestao().getOpcoes().add(new Opcao());
        q.setModelOpcao(new ListDataModel(q.getQuestao().getOpcoes()));
        return q;
    }

    public void escolhaTipoDeQuestao(ValueChangeEvent event)
    {
        questao.getQuestao().setTipoDeQuestao((new Integer(event.getNewValue().toString())).intValue());
    }

    public void editarQuestao(ActionEvent event)
    {
        questao = (QuestaoRN)dataModelQuestoes.getRowData();
        questao.getQuestao().setEditavel(true);
        questao = new QuestaoRN();
    }

    public void salvarQuestao(ActionEvent event)
    {
        questao = (QuestaoRN)dataModelQuestoes.getRowData();
        questao.salvarQuestao(questao);
        questao = new QuestaoRN();
    }

    public void adicionarQuestao(ActionEvent event)
    {
        questoes.add(novaQuestao());
    }

    public void adicionarOpcao(ActionEvent event)
    {
        questao = (QuestaoRN)dataModelQuestoes.getRowData();
        questao.adicionarOpcao(questao);
        questao = new QuestaoRN();
    }

    public void removerOpcao(ActionEvent event)
    {
        questao = (QuestaoRN)dataModelQuestoes.getRowData();
        questao.removerOpcao(questao, questao.getModelOpcao().getRowIndex());
    }

    public DataModel getDataModelQuestoes()
    {
        return dataModelQuestoes;
    }

    public void setDataModelQuestoes(DataModel dataModelQuestoes)
    {
        this.dataModelQuestoes = dataModelQuestoes;
    }

    public Map getOpcoes()
    {
        return opcoes;
    }

    public QuestaoRN getQuestao()
    {
        return questao;
    }

    public void setQuestao(QuestaoRN questao)
    {
        this.questao = questao;
    }

    public List getQuestoes()
    {
        return questoes;
    }

    public void setQuestoes(List questoes)
    {
        this.questoes = questoes;
    }

    public String getResposta()
    {
        return resposta;
    }

    public void setResposta(String resposta)
    {
        this.resposta = resposta;
    }

    public List getRespostas()
    {
        return respostas;
    }

    public void setRespostas(List respostas)
    {
        this.respostas = respostas;
    }

  
    static 
    {
        opcoes = new LinkedHashMap();
        opcoes.put("Texto", Integer.valueOf(1));
        opcoes.put("M\372ltipla escolha", Integer.valueOf(2));
        opcoes.put("\332nica escolha", Integer.valueOf(3));
    }
}
