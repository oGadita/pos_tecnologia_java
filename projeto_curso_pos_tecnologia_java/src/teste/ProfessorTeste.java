package teste;

import modelo.*;

public class ProfessorTeste {
    public static void main(String[] args) {

        Formacao formacao = new Formacao("Programação a partir do zero", AreaConhecimento.PROGRAMACAO, 10);

        Professor pfJoaoAugusto = new Professor("João Augusto", "pf_joaoaugusto@email.com", "(24) 99874-3542", NivelDeFormacao.POS_GRADUADO);
        Professor pfRodrigoAlencar = new Professor("Rodrigo Alencar", "pf_rodrigoreis@email.com", "(24) 99457-6532", NivelDeFormacao.GRADUADO);
        Professor pfMarceloReis = new Professor("Marcelo Reis", "pf_marceloreis@email.com", "(24) 99654-7845", NivelDeFormacao.MESTRADO);

        Curso c1 = new Curso("Lógica de Programação 1", 6, formacao, pfJoaoAugusto);
        Curso c2 = new Curso("Lógica de Programação 2: Laços e listas com JavaScript", 4, formacao, pfJoaoAugusto);
        Curso c3 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, formacao, pfJoaoAugusto);
        Curso c4 = new Curso("Linux 1: conhecendo e utilizando o terminal", 4, formacao, pfJoaoAugusto);
        Curso c5 = new Curso("HTML5 e CSS3 parte 1: crie uma página Web", 8, formacao, pfJoaoAugusto);


        Monitor mtJuliaPereira = new Monitor("Julia Pereira", "juliapereira@email.com", "(24) 99475-6537", AreaConhecimento.PROGRAMACAO, 9.5);

        Aluno alRogerioAlves = new Aluno("Rogerio Alves", "rogerioalves@email.com", "(24) 99574-1245", 2023080102l);
        Aluno alAdaoNunes = new Aluno("Adão Nunes", "adaonunes@email.com", "(24) 99647-7896", 2023080101l);
        c1.matriculaAluno(alAdaoNunes);

        pfJoaoAugusto.designarMonitor(c1, mtJuliaPereira);
        System.out.println(c1.getMonitor());

        System.out.println("------------------------");
        pfJoaoAugusto.listaCursosQueLeciona();

        System.out.println("------------------------");
        System.out.println("Nota atribuida pelo professor:");
        pfJoaoAugusto.atribuiNota(c1, alAdaoNunes, 7.0);
        alAdaoNunes.listaNotasPorCurso();

        System.out.println("------------------------");
        System.out.println(pfJoaoAugusto);

        /* TESTE DE EXCEPTIONS*/
        /* 1. O professor só pode lecionar em até 5 cursos. */

//        Curso c6 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, formacao, pfJoaoAugusto);

        /* 2. Somente o professor do curso pode atribuir nota aos alunos. */

//        pfMarceloReis.atribuiNota(c1, alAdaoNunes, 7);

        /* 3. O professor só pode atribuir nota a um aluno matriculado. */

//        pfJoaoAugusto.atribuiNota(c1, alRogerioAlves, 8);

        /* 4. A nota atribuida a um aluno deve estar no internalo entre 0 e 10. */

//        pfJoaoAugusto.atribuiNota(c1, alAdaoNunes, -3);

        /*------------------------------*/

    }
}
