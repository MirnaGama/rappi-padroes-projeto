package entidades;

import java.util.Date;

public class Transacao {

    private int quantidadePontos;
    private float preco;
    private Date dataTransacao;
    private Multiplicador multi;

    public int getQuantidadePontos() {
        return quantidadePontos;
    }

    public void setQuantidadePontos(int quantidadePontos) {
        this.quantidadePontos = quantidadePontos;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
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
