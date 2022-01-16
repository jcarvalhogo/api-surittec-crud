package br.com.jcarvalho.api.surittec.dto;

import lombok.Data;

@Data
public class MessageDto<T> {

    private T result;
    private String msg;
    private boolean erro;

    public MessageDto() {
    }

    public MessageDto(T result, String msg, boolean erro) {
        this.result = result;
        this.msg = msg;
        this.erro = erro;
    }

    public MessageDto messageSucess(T result) {
        this.erro = false;
        this.msg = "Sucess";
        this.result = result;
        return this;
    }

    public MessageDto messageErrorSave(T result) {
        this.erro = true;
        this.msg = "Error: Não foi possível salvar";
        this.result = result;
        return this;
    }

    public MessageDto messageErrorSave(T result, String msg) {
        this.erro = true;
        this.msg = msg;
        this.result = result;
        return this;
    }
}
