package Modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Experiencia {

    private int codigo;

    private String nome;

    private String descricao;

    private LocalDate data;

    private LocalTime horario;

    private String local;

    private int totalParticipantes;

    private List<Participante> participantes;

    public Experiencia() {

    }

    public Experiencia(int codigo, String nome, String descricao, LocalDate data, LocalTime horario, String local,
                       int totalParticipantes) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.horario = horario;
        this.local = local;
        this.totalParticipantes = totalParticipantes;
        this.participantes = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getLocal() {
        return local;
    }

    public int getTotalParticipantes() {
        return totalParticipantes;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public boolean addParticipante(Participante participante) {
        if (this.participantes.add(participante)) {
            return true;
        }
        return false;
    }
}
