/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog.web.model;

/**
 *
 * @author root
 */
public class Notificacoes {
    
    private Integer notificacaoId;
    private Integer conexaoId;
    private String descricao;
    private String consultaMensagem;
    private String mensagem;
    private String tipoAlerta;
    private String peridicidade;
    private String servico;
    private String clasee;

    public Integer getNotificacaoId() {
        return notificacaoId;
    }

    public void setNotificacaoId(Integer notificacaoId) {
        this.notificacaoId = notificacaoId;
    }

    public Integer getConexaoId() {
        return conexaoId;
    }

    public void setConexaoId(Integer conexaoId) {
        this.conexaoId = conexaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConsultaMensagem() {
        return consultaMensagem;
    }

    public void setConsultaMensagem(String consultaMensagem) {
        this.consultaMensagem = consultaMensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getPeridicidade() {
        return peridicidade;
    }

    public void setPeridicidade(String peridicidade) {
        this.peridicidade = peridicidade;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getClasee() {
        return clasee;
    }

    public void setClasee(String clasee) {
        this.clasee = clasee;
    }

    
    
}
