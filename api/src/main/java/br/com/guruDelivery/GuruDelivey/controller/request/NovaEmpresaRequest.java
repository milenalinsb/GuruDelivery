package br.com.guruDelivery.GuruDelivey.controller.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NovaEmpresaRequest {

    private String nome;
    private String cnpj;
    private String email;
    private String senha;
    private MultipartFile fotoPerfil;
    private String telefone;
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;

}
