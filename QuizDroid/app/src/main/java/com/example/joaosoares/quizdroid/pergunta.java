package com.example.joaosoares.quizdroid;

/**
 * Created by joaosoares on 15/12/16.
 */

public class Pergunta {

    private int id;
    private String questao;
    private String opcao1;
    private String opcao2;
    private String opcao3;
    private String opcao4;

    public Pergunta() {}

    public Pergunta(int id, String fName, String lName) {
        this.id = id;
        this.questao = questao;
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.opcao3 = opcao3;
        this.opcao4 = opcao4;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getPrimeiraOpcao() {
        return opcao1;
    }

    public void setPrimeiraOpcao(String opcao2) {
        this.opcao1 = opcao1;
    }
    public String getSegundaOpcao() {
        return opcao1;
    }

    public void setSegundaOpcao(String opcao2) {
        this.opcao2 = opcao2;
    }
    public String getTerceiraOpcao() {
        return opcao3;
    }

    public void setTerceiraOpcao(String opcao3) {
        this.opcao3 = opcao3;
    }
    public String getQuartaOpcao() {
        return opcao4;
    }

    public void setQuartaOpcao(String opcao4) {
        this.opcao4 = opcao4;
    }

    @Override
    public String toString() {
        return questao + " " + opcao1 + " " + opcao2 + " " + opcao3 + " " + opcao4;
    }
}



