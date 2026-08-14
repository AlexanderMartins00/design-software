package br.com.escola;

public class ProfessorEscolaTecnica implements Professor {

    @Override
    public void apresentar() {
        System.out.println("Professor da escola técnica se apresenta à turma.");
    }

    @Override
    public void ensinar() {
        System.out.println("Ensino com atividades práticas e uso de laboratório.");
    }
}