package br.com.fuctura.biblioteca.exeptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//classe de validação e extende padrões de erro
public class ValidationError extends StandardError {

// armazena lista de erros ao preenchar os campos.
    public List<FeildMessage> erros = new ArrayList<>();

    // construtor da classe e seus atributos.
    public ValidationError(LocalDateTime timestamp, Integer status, String message, String path, List<FeildMessage> erro) {
        super(timestamp, status, message, path);
        this.erros = erro;
    }
    // contrutor vazio para compo
    public ValidationError() {
    }

    public ValidationError(LocalDateTime now, int value, String erroNaValidaçãoDosCampos, String requestURI) {
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
