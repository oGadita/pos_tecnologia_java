package teste;

import modelo.*;

public class TesteGeral {
    public static void main(String[] args) {

        Formacao formacao = new Formacao("Programação a partir do zero", AreaConhecimento.PROGRAMACAO, 10);

        Professor pf = new Professor("João Augusto", "joaoaugusto@email.com", "(24) 99874-3542", NivelDeFormacao.POS_GRADUADO);

        Curso c1 = new Curso("Lógica de Programação 1", 6, formacao, pf);
        Curso c2 = new Curso("Lógica de Programação 2: Laços e listas com JavaScript", 4, formacao, pf);
        Curso c3 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, formacao, pf);

        Aluno aluno1 = new Aluno("Adão", "adao@email.com", "(24) 99647-7896", 2023080101l);
        Aluno aluno2 = new Aluno("Marcos", "marcos@email.com", "(24) 99654-4215", 2023080102l);




        c1.setProfessor(pf);
        c2.setProfessor(pf);
        c3.setProfessor(pf);

        c1.matriculaAluno(aluno1);
        c1.matriculaAluno(aluno2);


        c2.matriculaAluno(aluno1);
        c2.matriculaAluno(aluno2);


        c3.matriculaAluno(aluno1);
        c3.matriculaAluno(aluno2);

//        System.out.println(aluno1.getCursosAtivos());

        pf.atribuiNota(c1, aluno1, 7.0);
        pf.atribuiNota(c2, aluno1, 9.0);
        pf.atribuiNota(c3, aluno1, 6.0);


//        System.out.println(c1.getNotaPorAluno());
//
        aluno1.listaNotasPorCurso();

        System.out.println(formacao);
        
//        System.out.println(aluno1);



//        pf.listaCursosQueLeciona();

//        c2.matriculaAluno(aluno1);
//        c3.matriculaAluno(aluno1);
//
//        System.out.println(aluno1.getCursosAtivos());


//        formacao.adicionaCurso(c1);
//        formacao.adicionaCurso(c2);
//        formacao.adicionaCurso(c3);
//
//        formacao.listaCursos();
//        System.out.println(formacao);
//
//        System.out.println("*************************************");
//
//        formacao.removeCurso(c2);
//        formacao.listaCursos();
//        System.out.println(formacao);
//
//        System.out.println("*************************************");



//        formacao.listaCursos();
//
//        if (c1.getCurso().equals(curso)) {
//            System.out.println("é igual");
//            System.out.println(curso);
//            System.out.println(c1.getCurso());
//        }



    }
}
