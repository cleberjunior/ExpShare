package Modelos;

public class Participante {
    private int codigo;

    private String nome;

    private String email;

    public Participante() {

    }

    public Participante(int codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
