package br.com.guruDelivery.GuruDelivey.controller.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NovoProdutoRequest{

    private String nome;
    private MultipartFile foto;
    private Float preco;
    private String descricao;

}
