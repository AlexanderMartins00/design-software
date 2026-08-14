package br.com.escola;

public class EscolaPrivadaFactory implements EscolaFactory {

    @Override
    public Professor criarProfessor() {
        return new ProfessorEscolaPrivada();
    }

    @Override
    public MaterialDidatico criarMaterialDidatico() {
        return new MaterialEscolaPrivada();
    }

    @Override
    public Avaliacao criarAvaliacao() {
        return new AvaliacaoEscolaPrivada();
    }
}
