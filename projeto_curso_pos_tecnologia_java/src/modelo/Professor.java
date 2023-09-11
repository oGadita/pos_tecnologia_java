package modelo;

import excecoes.CargaHorariaExcedidaException;
import excecoes.ErroDeCadastroException;
import excecoes.ProfessorNaoPossuiPermissaoException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Professor extends Pessoa{

    private NivelDeFormacao nivelDeFormacao;
    private int cargaHoraria;
    private double salario;
    private Set<Curso> cursosQueLeciona = new HashSet<>();

    public Professor(String nome, String email, String telefone, NivelDeFormacao nivelDeFormacao) {
        super(nome, email, telefone);
        this.nivelDeFormacao = nivelDeFormacao;
    }

    @Override
    public boolean verificaDisponibilidade() {
        if (cursosQueLeciona.size() < 5) {
            return true;
        } else {
            throw new CargaHorariaExcedidaException("Este professor já leciona em 5 cursos.");
        }
    }

    public void adicionaCursoLecionar (Curso curso) {
        if (verificaDisponibilidade()) {
            cursosQueLeciona.add(curso);
            this.cargaHoraria += curso.getCargaHoraria();
            calculaSalario();
        }
    }

    public void designarMonitor(Curso curso, Monitor monitor) {
        if (curso.getFormacao().getAreaConhecimento() == monitor.getAreaConhecimento() &&
        monitor.verificaDisponibilidade()) {
            curso.setMonitor(monitor);
            monitor.getCursosQuePrestaMonitoria().add(curso);
        }
    }

    private void calculaSalario() {
        Double salarioFixo = 1600.0;
        Double salarioBaseHora = 1600.0 / 100;
        switch (nivelDeFormacao) {
            case GRADUADO: {
                salario = salarioFixo + (salarioBaseHora * cargaHoraria);
                break;
            }
            case POS_GRADUADO: {
                salario = (salarioFixo + (salarioBaseHora * cargaHoraria)) * 1.15;
                break;
            }
            case MESTRADO: {
                salario = (salarioFixo + (salarioBaseHora * cargaHoraria)) * 1.25;
                break;
            }
            case DOUTORADO: {
                salario = (salarioFixo + (salarioBaseHora * cargaHoraria)) * 1.5;
                break;
            }
            case POS_DOUTORADO: {
                salario = (salarioFixo + (salarioBaseHora * cargaHoraria)) * 1.75;
                break;
            }
        }
    }

    public void atribuiNota(Curso curso, Aluno aluno, double nota) {
        if (! curso.getProfessor().equals(this)) {
            throw new ProfessorNaoPossuiPermissaoException("Somente o professor do curso pode atribuir nota aos alunos.");
        } if (! curso.getAlunos().contains(aluno)) {
            throw new ErroDeCadastroException("O Aluno informado não está matriculado neste curso.");
        } if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar no intervalo entre 0.0 e 10.0.");
        } else {
            aluno.guardaNota(curso, nota);
            curso.getNotaPorAluno().put(aluno, nota);
        }
    }

    public void listaCursosQueLeciona () {
        System.out.println("CURSOS QUE LECIONA:");
        Iterator<Curso> iterator = cursosQueLeciona.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return String.format("PROFESSOR [NOME: '%s', EMAIL: '%s', TELEFONE: '%s', FORMAÇÃO: '%s', SALÁRIO: R$ %.2f]",
                this.getNome(), this.getEmail(), this.getTelefone(), this.nivelDeFormacao, this.salario);
    }

    public Set<Curso> getCursosQueLeciona() {
        return cursosQueLeciona;
    }
}
