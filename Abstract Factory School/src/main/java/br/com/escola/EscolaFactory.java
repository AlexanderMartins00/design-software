package br.com.escola;

public interface EscolaFactory {
    Professor criarProfessor();
    MaterialDidatico criarMaterialDidatico();
    Avaliacao criarAvaliacao();
}
