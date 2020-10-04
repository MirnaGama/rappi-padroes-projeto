package entidades;

import java.util.Date;

public class Transacao {

    private String descricao;
    private int quantidadePontos;
    private double preco;
    private Date dataTransacao;
    private Multiplicador multi;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadePontos() {
        return quantidadePontos;
    }

    public void setQuantidadePontos(int pontos) {

        if (this.multi != null) {
            this.quantidadePontos = this.multi.calcularPontos(pontos);
        } else {
            this.quantidadePontos = pontos;
        }

    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Multiplicador getMulti() {
        return multi;
    }

    public void setMulti(Multiplicador multi) {
        this.multi = multi;
    }

}
