package br.com.escola;

public class AvaliacaoEscolaPrivada implements Avaliacao {

    @Override
    public void aplicar() {
        System.out.println("Avaliação contínua com prova, projeto e atividades online.");
    }
}
