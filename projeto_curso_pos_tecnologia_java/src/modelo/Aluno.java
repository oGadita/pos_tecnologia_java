package modelo;

import excecoes.CargaHorariaExcedidaException;
import excecoes.CursoSemMonitorDesignadoException;

import java.util.*;

public class Aluno extends Pessoa{

    private long matricula;
    private double notaMedia;
    private Map<Curso, Double> notasPorCurso = new HashMap<>();
    private Set<Curso> cursosAtivos = new HashSet<>();

    public Aluno(String nome, String email, String telefone, long matricula) {
        super(nome, email, telefone);
        this.matricula = matricula;
    }

    public Aluno(AlunoJson alunoJson) {
        this.setNome(alunoJson.nome());
        this.setEmail(alunoJson.email());
        this.setTelefone(alunoJson.telefone());
        this.matricula = Long.parseLong(alunoJson.matricula());
    }

    @Override
    public boolean verificaDisponibilidade() {
        if(cursosAtivos.size() < 3) {
            return true;
        } else {
            throw new CargaHorariaExcedidaException("O Aluno já está com matrícula ativa em 3 cursos.");
        }
    }

    public void solicitaMonitoria(Curso curso) {
        if (curso.getMonitor() == null) {
            throw new CursoSemMonitorDesignadoException("Este curso ainda não possui um monitor designado.");
        } else {
            curso.getMonitor().registraMonitoria();
        }
    }


    public void adicionaCursoAtivo(Curso curso) {
        if(verificaDisponibilidade()) {
            cursosAtivos.add(curso);
        }
    }
    
    public void guardaNota(Curso curso, double nota) {
        notasPorCurso.put(curso, nota);
        calculaNotaMedia();
        finalizaCurso(curso);
    }

    private void calculaNotaMedia() {
        double somaNotas = 0;

        List<Double> notas = new ArrayList<>();
        notas.addAll(this.notasPorCurso.values());

        for (Double n:notas) {somaNotas += n;}

        notaMedia = somaNotas / notas.size();
    }

    private void finalizaCurso(Curso curso) {
        if (notasPorCurso.containsKey(curso)) {
            cursosAtivos.remove(curso);
        }
    }

    public void listaNotasPorCurso () {
        for (Map.Entry<Curso, Double> notas : notasPorCurso.entrySet()) {
            System.out.println("CURSO: " + notas.getKey().getNome() + ", NOTA: " + notas.getValue());
        }
    }

    @Override
    public String toString() {
        return "(NOME: " + this.getNome() +
                ", MATRÍCULA: " + this.matricula +
                ", EMAIL: " + this.getEmail() +
                ", TELEFONE: " + this.getTelefone() +
                ", NOTA MÉDIA: " + this.notaMedia + ")";
    }

    public Map<Curso, Double> getNotasPorCurso() {
        return notasPorCurso;
    }

    public Set<Curso> getCursosAtivos() {
        return cursosAtivos;
    }

}


