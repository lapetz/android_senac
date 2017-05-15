package prova.com.br.prova.domain;

/**
 * Created by CARINA on 08/05/2017.
 */
public class Empresa {

    private Integer id;

    private String nome;

    private String email;

    private String faturamento;

    public Integer getId() {
        return id;
    }

    public String getFaturamento() { return faturamento; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFaturamento(String faturamento) {
        this.faturamento = faturamento;
    }
}
