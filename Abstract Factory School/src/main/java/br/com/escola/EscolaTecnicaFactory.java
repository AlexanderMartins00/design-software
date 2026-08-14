package br.com.escola;

public class EscolaTecnicaFactory implements EscolaFactory {

    @Override
    public Professor criarProfessor() {
        return new ProfessorEscolaTecnica();
    }

    @Override
    public MaterialDidatico criarMaterialDidatico() {
        return new MaterialEscolaTecnica();
    }

    @Override
    public Avaliacao criarAvaliacao() {
        return new AvaliacaoEscolaTecnica();
    }
}