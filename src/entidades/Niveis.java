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
           return "\n- Ganhe pontos a cada compra.\n";
       }else if (nomeNivel.equals(NivelEnum.PRATA)){
           return "\n- R$37,00 OFF em bebidas.\n- R$19,00 OFF em farmacias.\n- Cashback R$15,00 em beleza.\n- Ganhe pontos a cada compra.\n- Atendimento especializado.\n";
       }else if (nomeNivel.equals(NivelEnum.OURO)){
           return "\n- R$37,00 OFF em bebidas.\n- R$25,00 OFF em farmacias.\n- Atendimento especializado.\n- Ganhe pontos a cada compra.\n- Tenha pedidos prioritários.\n";
       }else if(nomeNivel.equals(NivelEnum.DIAMANTE)){
            return "\n- R$50,00 OFF em bebidas.\n- R$37,00 OFF em farmacias.\n- Cashback R$20,00 em lar.\n- ganhe pontos a cada compra.\n- Tenha pedidos prioritários.\n- Atendimento especializado.\n- Rappis avaliados como excelentes.\n";
        }
       return "";
    }
}
