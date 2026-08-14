package br.com.escola;

public class ProfessorEscolaPublica implements Professor {

    @Override
    public void apresentar() {
        System.out.println("Professor da escola pública se apresenta à turma.");
    }

    @Override
    public void ensinar() {
        System.out.println("Ensino com foco no currículo da rede pública.");
    }
}
