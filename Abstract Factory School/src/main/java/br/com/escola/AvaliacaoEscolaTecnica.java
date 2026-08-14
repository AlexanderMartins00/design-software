package br.com.escola;

public class AvaliacaoEscolaTecnica implements Avaliacao {

    @Override
    public void aplicar() {
        System.out.println("Avaliação prática realizada por meio de projeto e atividade de laboratório.");
    }
}