package teste;

import modelo.*;

public class FormacaoTeste {
    public static void main(String[] args) {

        Formacao fm1 = new Formacao("Programação a partir do zero", AreaConhecimento.PROGRAMACAO, 10);
        Formacao fm2 = new Formacao("Construa aplicativos iOS com SwiftUI", AreaConhecimento.MOBILE, 4);
        Formacao fm3 = new Formacao("A partir do zero: HTML e CSS para projetos web", AreaConhecimento.FRONT_END, 6);

        Professor pfJoaoAugusto = new Professor("João Augusto", "pf_joaoaugusto@email.com", "(24) 99874-3542", NivelDeFormacao.POS_GRADUADO);

        Curso c1 = new Curso("Lógica de Programação 1", 6, fm1, pfJoaoAugusto);
        Curso c2 = new Curso("Lógica de Programação 2: Laços e listas com JavaScript", 4, fm1, pfJoaoAugusto);
        Curso c3 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, fm1, pfJoaoAugusto);

        System.out.println("--------------------------");
        fm1.listaCursos();

        System.out.println("--------------------------");
        fm1.removeCurso(c3);
        fm1.listaCursos();

        System.out.println("--------------------------");
        System.out.println(fm1);

        /* TESTE DE EXCEPTIONS*/
        /* 1. Não é possível criar uma formação sem indicar o número de cursos que ela irá possuir. */

//        Formacao fm4 = new Formacao("Azure", AreaConhecimento.DEVOPS, 0);

        /*------------------------------------*/

    }
}
