package br.com.escola;

public class ProfessorEscolaPrivada implements Professor {

    @Override
    public void apresentar() {
        System.out.println("Professor da escola privada se apresenta à turma.");
    }

    @Override
    public void ensinar() {
        System.out.println("Ensino com recursos digitais e metodologia personalizada.");
    }
}
