package com.biblioteca.fuctura.enuns;

public enum Tamanho {

    PEQUENO(0),
    MEDIO(1),
    GRANDE(2)
    ;

    private Integer cod;

    Tamanho(Integer codigo) {
        this.cod = codigo;
    }
}
