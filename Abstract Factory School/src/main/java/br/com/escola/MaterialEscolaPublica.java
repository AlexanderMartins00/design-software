package br.com.escola;

public class MaterialEscolaPublica implements MaterialDidatico {

    @Override
    public void disponibilizar() {
        System.out.println("Livro didático e apostila fornecidos pela rede pública.");
    }
}
