package modelo;

import com.google.gson.*;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import excecoes.CargaHorariaExcedidaException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Curso {

    private Formacao formacao;
    private String nome;
    private int cargaHoraria;
    private Professor professor;

    /*O monitor será designado pelo professor.*/
    private Monitor monitor;

    /*Os alunos serão adicionados mediante matrícula.*/
    private List<Pessoa> alunos = new ArrayList<>();

    /*O conjunto de 'notaPorAluno' será povoado à medida que o professor do curso atribui notas aos respectivos alunos.*/
    private Map<Aluno, Double> notaPorAluno = new HashMap<>();


    public Curso(String nome, int cargaHoraria, Formacao formacao, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.formacao = formacao;
        setProfessor(professor);
        this.monitor = monitor;
        formacao.adicionaCurso(this);
    }

    public void matriculaAluno(Aluno aluno) {
        if (aluno.verificaDisponibilidade() == true) {
            alunos.add(aluno);
            aluno.adicionaCursoAtivo(this);
        }
    }

    public void listaAlunosMatriculados() {
        System.out.println("ALUNOS MATRICULADOS:");
        for (Pessoa p: alunos) {
            System.out.println(p);
        }
    }

    public void listaNotaPorAluno() {
        System.out.println("NOTAS POR ALUNO DO CURSO: " + this.nome + ", FORMAÇÃO: " + formacao.getNome());
        for (Map.Entry<Aluno, Double> notas : notaPorAluno.entrySet()) {
            System.out.println("[NOME: '" + notas.getKey().getNome() + "', NOTA: '" + notas.getValue() + "']");
        }
    }

    /*Importa as informações básicas de um aluno - nome, matrícula, telefone e email - a partir de um arquivo Json*/
    public Aluno importaAlunoJson(String nomeArquivoJson) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        FileReader leitor = new FileReader(nomeArquivoJson);

        AlunoJson alunoJson = gson.fromJson(leitor, AlunoJson.class);
        Aluno aluno = new Aluno(alunoJson);
        return aluno;
    }

    public void exportaAlunoJson(Aluno aluno) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        String nomeArquivo = aluno.getNome().replaceAll(" ", "") + ".json";

        try {
            FileWriter arquivoJson = new FileWriter(nomeArquivo);
            arquivoJson.write(gson.toJson(aluno));
            arquivoJson.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void exportaPDFNotaPorAluno() {
        Document documentPDF = new Document();
        String nomeArquivo = this.nome + "_NotaPorAluno.pdf";
        try {
            PdfWriter.getInstance(documentPDF, new FileOutputStream(nomeArquivo));
            documentPDF.open();
            documentPDF.add(new Paragraph("FORMAÇÃO: " + this.formacao.getNome().toUpperCase()));
            documentPDF.add(new Paragraph("CURSO: " + this.nome.toUpperCase()));
            documentPDF.add(new Paragraph("ÁREA DE FORMAÇÃO: " + this.formacao.getAreaConhecimento().toString().toUpperCase()));
            documentPDF.add(new Paragraph(" "));
            documentPDF.add(new Paragraph("RELATÓRIO FINAL DE NOTAS POR ALUNO"));
            documentPDF.add(new Paragraph(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            documentPDF.add(new Paragraph(" "));

            for (Map.Entry<Aluno, Double> notas : notaPorAluno.entrySet()) {
                documentPDF.add(new Paragraph("[NOME: '" + notas.getKey().getNome() + "', NOTA: '" + notas.getValue() + "']"));
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        documentPDF.close();
    }

    @Override
    public String toString() {
        String nomeMonitor;
        if (monitor != null) {
            nomeMonitor = monitor.getNome();
        } else {
            nomeMonitor = "Não informado";
        }

        return String.format("CURSO [NOME: %s, FORMAÇÃO: %s, CARGA HORÁRIA %dh, PROFESSOR: %s, MONITOR: %s]",
                nome, formacao.getNome(), cargaHoraria, professor.getNome(), nomeMonitor);
    }

    public void setProfessor(Professor professor) {
        if (professor.verificaDisponibilidade()) {
            this.professor = professor;
            professor.adicionaCursoLecionar(this);
        } else {
            throw new CargaHorariaExcedidaException("Este professor já leciona em 5 cursos.");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public List<Pessoa> getAlunos() {
        return alunos;
    }

    public Map<Aluno, Double> getNotaPorAluno() {
        return notaPorAluno;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
