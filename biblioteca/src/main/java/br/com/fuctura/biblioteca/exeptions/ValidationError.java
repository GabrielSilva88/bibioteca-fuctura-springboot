package br.com.fuctura.biblioteca.exeptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
// armazena lista de erros ao preenchar os campos.
    public List<FeildMessage> erros = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, Integer status, String message, String path, List<FeildMessage> erro) {
        super(timestamp, status, message, path);
        this.erros = erro;
    }
    // contrutor vazio para compo
    public ValidationError() {
    }
    // busca erro na lista "erros"
    public List<FeildMessage> getErro() {
        return erros;
    }
    // adicionar erro a lista de erro.
    public void addErro(String feildName, String message) {
        this.erros.add(new FeildMessage(feildName, message));
    }
}
