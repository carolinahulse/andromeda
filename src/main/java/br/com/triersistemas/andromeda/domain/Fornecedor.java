package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Fornecedor extends PessoaJuridica {

    private List<String> produtos;

    public Fornecedor() {
        this.produtos = StringUtils.getRandomMeds();
    }

    public Fornecedor(final String nome, final LocalDate niver, final String cnpj) {
        super(nome, niver, cnpj);
        this.produtos = StringUtils.getRandomMeds();
    }

    public List<String> getProdutos() {
        return produtos;
    }
}