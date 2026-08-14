package br.com.escola;

public class SalaDeAula {

    private final Professor professor;
    private final MaterialDidatico material;
    private final Avaliacao avaliacao;

    public SalaDeAula(EscolaFactory factory) {
        this.professor = factory.criarProfessor();
        this.material = factory.criarMaterialDidatico();
        this.avaliacao = factory.criarAvaliacao();
    }

    public void iniciarAula() {
        System.out.println("\n=== INÍCIO DA AULA ===");
        professor.apresentar();
        professor.ensinar();
        material.disponibilizar();
        avaliacao.aplicar();
        System.out.println("=== FIM DA AULA ===");
    }
}
