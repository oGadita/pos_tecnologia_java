package teste;

import modelo.*;

public class AlunoTeste {
    public static void main(String[] args) {

        Formacao formacao = new Formacao("Programação a partir do zero", AreaConhecimento.PROGRAMACAO, 10);

        Professor pfJoaoAugusto = new Professor("João Augusto", "pf_joaoaugusto@email.com", "(24) 99874-3542", NivelDeFormacao.POS_GRADUADO);

        Monitor mtJuliaPereira = new Monitor("Julia Pereira", "juliapereira@email.com", "(24) 99475-6537", AreaConhecimento.PROGRAMACAO, 9.5);

        Curso c1 = new Curso("Lógica de Programação 1", 6, formacao, pfJoaoAugusto);
        Curso c2 = new Curso("Lógica de Programação 2: Laços e listas com JavaScript", 4, formacao, pfJoaoAugusto);
        Curso c3 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, formacao, pfJoaoAugusto);
        Curso c4 = new Curso("Linux 1: conhecendo e utilizando o terminal", 4, formacao, pfJoaoAugusto);

        Aluno alAdaoNunes = new Aluno("Adão Nunes", "adaonunes@email.com", "(24) 99647-7896", 2023080101l);
        Aluno alRogerioAlves = new Aluno("Rogerio Alves", "rogerioalves@email.com", "(24) 99574-1245", 2023080102l);
        Aluno alMarcosGomes = new Aluno("Marcos Gomes", "marcosgomes@email.com", "(24) 99695-5734", 2023080103l);

        pfJoaoAugusto.designarMonitor(c1, mtJuliaPereira);

        c1.matriculaAluno(alAdaoNunes);
        c1.matriculaAluno(alMarcosGomes);
        c1.matriculaAluno(alRogerioAlves);

        c2.matriculaAluno(alAdaoNunes);
        c3.matriculaAluno(alAdaoNunes);

        /* TESTE DE EXCEPTIONS */

        /* 1. O Aluno não pode estar com mais de 3 cursos em aberto */

//        c4.matriculaAluno(alAdaoNunes);

        /* 2. O aluno só pode solicitar monitoria se houver monitor designado para o curso */

//        alAdaoNunes.solicitaMonitoria(c4);

        /*-----------------------------------*/

        alAdaoNunes.solicitaMonitoria(c1);

        pfJoaoAugusto.atribuiNota(c1, alAdaoNunes, 8);
        pfJoaoAugusto.atribuiNota(c2, alAdaoNunes, 7);
        pfJoaoAugusto.atribuiNota(c3, alAdaoNunes, 9);

        alAdaoNunes.listaNotasPorCurso();

        System.out.println(alAdaoNunes);








    }
}
