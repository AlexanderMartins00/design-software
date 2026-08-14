package br.com.escola;

public class AvaliacaoEscolaPublica implements Avaliacao {

    @Override
    public void aplicar() {
        System.out.println("Avaliação bimestral padronizada da rede pública.");
    }
}
