package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Farmaceutico extends PessoaFisica {

    private String ofertaDia;

    public Farmaceutico() {
        this.ofertaDia = StringUtils.getRandomMed();
    }

    public Farmaceutico(final String nome, final LocalDate niver, final String cpf) {
        super(nome, niver, cpf);
        this.ofertaDia = StringUtils.getRandomMed();
    }

    public String getOfertaDia() {
        return ofertaDia;
    }
}