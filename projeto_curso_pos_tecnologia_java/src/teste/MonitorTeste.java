package teste;

import modelo.*;

public class MonitorTeste {
    public static void main(String[] args) {

        Formacao formacao = new Formacao("Programação a partir do zero", AreaConhecimento.PROGRAMACAO, 10);

        Professor pfJoaoAugusto = new Professor("João Augusto", "pf_joaoaugusto@email.com", "(24) 99874-3542", NivelDeFormacao.POS_GRADUADO);

        Monitor mtJuliaPereira = new Monitor("Julia Pereira", "juliapereira@email.com", "(24) 99475-6537", AreaConhecimento.PROGRAMACAO, 9.5);
        Monitor mtJairRodrigues = new Monitor("Jair Rodrigues", "jairrodrigues@email.com", "(24) 99495-5784", AreaConhecimento.PROGRAMACAO, 9.2);
        Monitor mtJoaoAlves = new Monitor("João Alves", "joaoalves@email.com", "(24) 99478-9546", AreaConhecimento.PROGRAMACAO, 9.7);

        Curso c1 = new Curso("Lógica de Programação 1", 6, formacao, pfJoaoAugusto);
        Curso c2 = new Curso("Lógica de Programação 2: Laços e listas com JavaScript", 4, formacao, pfJoaoAugusto);
        Curso c3 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, formacao, pfJoaoAugusto);

        Aluno alRogerioAlves = new Aluno("Rogerio Alves", "rogerioalves@email.com", "(24) 99574-1245", 2023080102l);
        c1.matriculaAluno(alRogerioAlves);

        pfJoaoAugusto.designarMonitor(c1, mtJuliaPereira);
        pfJoaoAugusto.designarMonitor(c2, mtJuliaPereira);

        mtJuliaPereira.listaCursosQuePrestaMonitoria();

        alRogerioAlves.solicitaMonitoria(c1);
        System.out.println("Requisições de monitoria: " + mtJuliaPereira.getRequisicoesDeMonitoria());

        System.out.println("--------------------------");
        System.out.println(mtJuliaPereira);

        /* TESTE DE EXCEPTIONS*/
        /* 1. O monitor só pode prestar monitoria em até 2 cursos. */

//        pfJoaoAugusto.designarMonitor(c1, mtJuliaPereira);

        /*------------------------------------*/

    }
}
