package br.com.guruDelivery.GuruDelivey.domain;

public enum Status {

    EM_PRODUCAO ("Em produção"),
    A_CAMINHO("A caminho"),
    ENTREGUE("Entregue");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
