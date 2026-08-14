package br.com.escola;

public class EscolaPublicaFactory implements EscolaFactory {

    @Override
    public Professor criarProfessor() {
        return new ProfessorEscolaPublica();
    }

    @Override
    public MaterialDidatico criarMaterialDidatico() {
        return new MaterialEscolaPublica();
    }

    @Override
    public Avaliacao criarAvaliacao() {
        return new AvaliacaoEscolaPublica();
    }
}
