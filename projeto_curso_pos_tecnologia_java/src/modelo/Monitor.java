package modelo;

import excecoes.CargaHorariaExcedidaException;

import java.util.ArrayList;
import java.util.List;

public class Monitor extends Pessoa {


    private AreaConhecimento areaConhecimento;
    private List<Curso> cursosQuePrestaMonitoria = new ArrayList<>();
    private double notaMedia;
    private int requisicoesDeMonitoria;


    public Monitor(String nome, String email, String telefone, AreaConhecimento areaConhecimento, double notaMedia) {
        super(nome, email, telefone);
        this.areaConhecimento = areaConhecimento;
        this.notaMedia = notaMedia;
    }

    @Override
    protected boolean verificaDisponibilidade() {
        if (cursosQuePrestaMonitoria.size() < 2) {
            return true;
        } else {
            throw new CargaHorariaExcedidaException("Este monitor já está designado para 2 cursos.");
        }
    }

    public void registraMonitoria() {
        requisicoesDeMonitoria++;
    }

    public void listaCursosQuePrestaMonitoria() {
        System.out.println("CURSOS EM QUE PRESTA MONITORIA:");
        for (Curso c: cursosQuePrestaMonitoria) {
            System.out.println(c);
        }
    }

    @Override
    public String toString() {
        return String.format("MONITOR: [NOME: '%s', EMAIL: '%s', TELEFONE: '%s', ÁREA DE CONHECIMENTO: '%s', NOTA MÉDIA: '%.2f', REQUISIÇÕES DE MONITORIA: '%d'",
                this.getNome(), this.getEmail(), this.getTelefone(), this.getAreaConhecimento(), this.notaMedia, this.requisicoesDeMonitoria);
    }

    public AreaConhecimento getAreaConhecimento() {
        return areaConhecimento;
    }

    public List<Curso> getCursosQuePrestaMonitoria() {
        return cursosQuePrestaMonitoria;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public int getRequisicoesDeMonitoria() {
        return requisicoesDeMonitoria;
    }
}
