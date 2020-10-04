package entidades;

public class Niveis {

    NivelEnum nomeNivel;
    String beneficios;

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public NivelEnum getNomeNivel() {
        return nomeNivel;
    }

    public void setNomeNivel(NivelEnum nomeNivel) {
        this.nomeNivel = nomeNivel;
        beneficios = visualizarVantagens(nomeNivel);
    }

    public String visualizarVantagens(NivelEnum nomeNivel) {
       if(nomeNivel.equals(NivelEnum.BRONZE)){
           return "Ganhe pontos a cada compra";
       }else if (nomeNivel.equals(NivelEnum.PRATA)){
           return "R$37,00 OFF em bebidas, R$19,00 OFF em farmacias, Cashback R$15,00 em beleza, Genhe pontos a cada compra, atendimento especializado";
       }else if (nomeNivel.equals(NivelEnum.OURO)){
           return "R$37,00 OFF em bebidas, R$25,00 OFF em farmacias, Atendimento especializado, Ganhe pontos a cada compra, tenha pedidos prioritários";
       }else if(nomeNivel.equals(NivelEnum.DIAMANTE)){
            return "R$50,00 OFF em bebidas, R$37,00 OFF em farmacias, Cashback R$20,00 em lar, ganhe pontos a cada compra, tenha pedidos prioritários, Atendimento especializado, Rapis avaliados como excelentes";
        }
       return "";
    }
}
