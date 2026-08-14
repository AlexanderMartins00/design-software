package br.com.escola;

public class MaterialEscolaTecnica implements MaterialDidatico {

    @Override
    public void disponibilizar() {
        System.out.println("Apostila técnica, equipamentos e material de laboratório disponibilizados.");
    }
}