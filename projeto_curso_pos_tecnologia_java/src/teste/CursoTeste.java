package teste;

import modelo.*;

import java.io.FileNotFoundException;

public class CursoTeste {
    public static void main(String[] args) throws FileNotFoundException {

        Formacao formacao = new Formacao("Programação a partir do zero", AreaConhecimento.PROGRAMACAO, 10);

        Professor pfJoaoAugusto = new Professor("João Augusto", "pf_joaoaugusto@email.com", "(24) 99874-3542", NivelDeFormacao.POS_GRADUADO);

        Monitor mtJuliaPereira = new Monitor("Julia Pereira", "juliapereira@email.com", "(24) 99475-6537", AreaConhecimento.PROGRAMACAO, 9.5);

        Curso c1 = new Curso("Lógica de Programação 1", 6, formacao, pfJoaoAugusto);
        Curso c2 = new Curso("Lógica de Programação 2: Laços e listas com JavaScript", 4, formacao, pfJoaoAugusto);
        Curso c3 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, formacao, pfJoaoAugusto);
        Curso c4 = new Curso("Linux 1: conhecendo e utilizando o terminal", 4, formacao, pfJoaoAugusto);
        Curso c5 = new Curso("HTML5 e CSS3 parte 1: crie uma página Web", 8, formacao, pfJoaoAugusto);

        pfJoaoAugusto.designarMonitor(c1, mtJuliaPereira);

        Aluno alAdaoNunes = new Aluno("Adão Nunes", "adaonunes@email.com", "(24) 99647-7896", 2023080101l);
        Aluno alRogerioAlves = new Aluno("Rogerio Alves", "rogerioalves@email.com", "(24) 99574-1245", 2023080102l);
        Aluno alMarcosGomes = new Aluno("Marcos Gomes", "marcosgomes@email.com", "(24) 99695-5734", 2023080103l);
        Aluno alLeticiaSilva = new Aluno("Letícia Silva", "leticiasilva@email.com", "(24) 99675-9457", 2023080104l);
        Aluno alIsabelaSousa = new Aluno("Isabela Sousa", "isabelasousa@email.com", "(24) 99615-9567", 2023080105l);

        c1.matriculaAluno(alIsabelaSousa);
        c1.matriculaAluno(alAdaoNunes);
        c1.matriculaAluno(alLeticiaSilva);
        c1.matriculaAluno(alMarcosGomes);
        c1.matriculaAluno(alRogerioAlves);

        System.out.println("------------------------");
        c1.listaAlunosMatriculados();

        pfJoaoAugusto.atribuiNota(c1, alIsabelaSousa, 8);
        pfJoaoAugusto.atribuiNota(c1, alAdaoNunes, 7);
        pfJoaoAugusto.atribuiNota(c1, alLeticiaSilva, 5);
        pfJoaoAugusto.atribuiNota(c1, alMarcosGomes, 9);
        pfJoaoAugusto.atribuiNota(c1, alRogerioAlves, 8);

        System.out.println("------------------------");
        c1.listaNotaPorAluno();

        System.out.println("------------------------");
        c1.exportaPDFNotaPorAluno();
        System.out.println(c1);

        System.out.println("------------------------");
        c1.exportaAlunoJson(alIsabelaSousa);

        Aluno alIsabelaJson = c2.importaAlunoJson("IsabelaSousa.json");
        c2.matriculaAluno(alIsabelaJson);
        c2.listaAlunosMatriculados();

        /* TESTE DE EXCEPTIONS*/
        /* 1. Ao utilizar o SetProfessor, também será realizada a verificação de disponibilidade do Professor. */

//        Curso c6 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, formacao, pfJoaoAugusto);

        /* Em caso de problemas com a geração ou leitura dos arquivos, será lançada uma FileNotFoundException ou uma IOException. */

//        alIsabelaJson = c2.importaAlunoJson("Isabela.json");

        /*------------------------------------*/
    }
}
