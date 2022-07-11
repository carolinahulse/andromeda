package br.com.triersistemas.andromeda.domain;

import br.com.triersistemas.andromeda.helper.StringUtils;
import org.apache.tomcat.jni.Local;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@MappedSuperclass
public abstract class Pessoa {

    @Id
    private UUID id;
    private String nome;
    private LocalDate niver;

    protected Pessoa() {
        this.id = UUID.randomUUID();
        this.nome = StringUtils.getRandomName();
        this.niver = LocalDate.now();
    }

    protected Pessoa(final String nome, final LocalDate niver) {
        this();
        this.nome = nome;
        this.niver = niver;
    }

    protected Pessoa editar(final String nome, final LocalDate niver) {
        this.nome = nome;
        this.niver = niver;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNiverString() {
        if (Objects.nonNull(niver)) {
            return niver.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return "";
    }

    public LocalDate getNiver() {
        return this.niver;
    }

    public Long getIdade() {
        return Objects.nonNull(niver) ? ChronoUnit.YEARS.between(niver, LocalDate.now()) : 0L;
    }

    public abstract String getDocumento();

    public abstract boolean getDocumentoValido();
}