package principal;

import com.google.gson.stream.MalformedJsonException;
import modelo.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Formacao formacao = new Formacao("Programação a partir do zero", AreaConhecimento.PROGRAMACAO, 10);

        Professor pfJoaoAugusto = new Professor("João Augusto", "pf_joaoaugusto@email.com", "(24) 99874-3542", NivelDeFormacao.POS_GRADUADO);
        Professor pfRodrigoAlencar = new Professor("Rodrigo Alencar", "pf_rodrigoreis@email.com", "(24) 99457-6532", NivelDeFormacao.GRADUADO);
        Professor pfMarceloReis = new Professor("Marcelo Reis", "pf_marceloreis@email.com", "(24) 99654-7845", NivelDeFormacao.MESTRADO);

        Monitor mtJuliaPereira = new Monitor("Julia Pereira", "juliapereira@email.com", "(24) 99475-6537", AreaConhecimento.PROGRAMACAO, 9.5);
        Monitor mtJairRodrigues = new Monitor("Jair Rodrigues", "jairrodrigues@email.com", "(24) 99495-5784", AreaConhecimento.PROGRAMACAO, 9.2);
        Monitor mtJoaoAlves = new Monitor("João Alves", "joaoalves@email.com", "(24) 99478-9546", AreaConhecimento.PROGRAMACAO, 9.7);

        Curso c1 = new Curso("Lógica de Programação 1", 6, formacao, pfRodrigoAlencar);
        Curso c2 = new Curso("Lógica de Programação 2: Laços e listas com JavaScript", 4, formacao, pfJoaoAugusto);
        Curso c3 = new Curso("Arquitetura de computadores: por trás de como seu programa funciona", 8, formacao, pfMarceloReis);
        Curso c4 = new Curso("Linux 1: conhecendo e utilizando o terminal", 4, formacao, pfJoaoAugusto);
        Curso c5 = new Curso("HTML e CSS: ambientes de desenvolvimento, estrutura de arquivos e tags", 8, formacao, pfRodrigoAlencar);
        Curso c6 = new Curso("HTML e CSS: classes, posicionamento flexbox", 8, formacao, pfRodrigoAlencar);
        Curso c7 = new Curso("HTML e CSS: cabeçalho, footer e variáveis CSS", 6, formacao, pfMarceloReis);
        Curso c8 = new Curso("HTML e CSS: trabalhando com responsividade e publicaçaõ de projetos", 6, formacao, pfJoaoAugusto);
        Curso c9 = new Curso("JavaScript para Web: crie páginas dinâmicas", 10, formacao, pfMarceloReis);
        Curso c10 = new Curso("Git e GitHub: repositório, commit e versões", 8, formacao, pfRodrigoAlencar);

        pfRodrigoAlencar.designarMonitor(c1, mtJairRodrigues);
        pfJoaoAugusto.designarMonitor(c2, mtJuliaPereira);
        pfMarceloReis.designarMonitor(c3, mtJoaoAlves);

        System.out.println("------------------------");
        formacao.listaCursos();

        Aluno alAdaoNunes = new Aluno("Adão Nunes", "adaonunes@email.com", "(24) 99647-7896", 2023080101l);
        Aluno alRogerioAlves = new Aluno("Rogerio Alves", "rogerioalves@email.com", "(24) 99574-1245", 2023080102l);
        Aluno alMarcosGomes = new Aluno("Marcos Gomes", "marcosgomes@email.com", "(24) 99695-5734", 2023080103l);
        Aluno alLeticiaSilva = new Aluno("Letícia Silva", "leticiasilva@email.com", "(24) 99675-9457", 2023080104l);
        Aluno alIsabelaSousa = new Aluno("Isabela Sousa", "isabelasousa@email.com", "(24) 99615-9567", 2023080105l);

        c1.matriculaAluno(alAdaoNunes);
        c1.matriculaAluno(alRogerioAlves);
        c1.matriculaAluno(alMarcosGomes);
        c1.matriculaAluno(alLeticiaSilva);
        c1.matriculaAluno(alIsabelaSousa);

        pfRodrigoAlencar.atribuiNota(c1, alAdaoNunes, 6.0);
        pfRodrigoAlencar.atribuiNota(c1, alIsabelaSousa, 7.5);
        pfRodrigoAlencar.atribuiNota(c1, alMarcosGomes, 6.5);
        pfRodrigoAlencar.atribuiNota(c1, alRogerioAlves, 8.0);
        pfRodrigoAlencar.atribuiNota(c1, alLeticiaSilva, 9.5);

        System.out.println("------------------------");
        c1.listaAlunosMatriculados();

        System.out.println("------------------------");
        c2.matriculaAluno(alAdaoNunes);
        c2.matriculaAluno(alRogerioAlves);
        c2.matriculaAluno(alMarcosGomes);
        c2.matriculaAluno(alLeticiaSilva);
        c2.matriculaAluno(alIsabelaSousa);

        c2.listaAlunosMatriculados();

        System.out.println("------------------------");
        pfJoaoAugusto.atribuiNota(c2, alAdaoNunes, 8.0);
        pfJoaoAugusto.atribuiNota(c2, alRogerioAlves, 9.0);
        pfJoaoAugusto.atribuiNota(c2, alIsabelaSousa, 10.0);
        pfJoaoAugusto.atribuiNota(c2, alLeticiaSilva, 6.0);
        pfJoaoAugusto.atribuiNota(c2, alMarcosGomes, 7.0);

        c2.listaNotaPorAluno();

        System.out.println("------------------------");
        c1.exportaPDFNotaPorAluno();
        c2.exportaPDFNotaPorAluno();

        c2.exportaAlunoJson(alAdaoNunes);

        Aluno alJson = c3.importaAlunoJson("AdãoNunes.json");
        c3.matriculaAluno(alJson);

        c3.listaAlunosMatriculados();

        System.out.println("------------------------");
        System.out.println(c10);
        c10.setProfessor(pfJoaoAugusto);
        System.out.println("------------------------");
        System.out.println(c10);

        alRogerioAlves.solicitaMonitoria(c1);
        alAdaoNunes.solicitaMonitoria(c1);

        System.out.println("------------------------");
        mtJairRodrigues.listaCursosQuePrestaMonitoria();
        System.out.println("Requisições de monitoria: " + mtJairRodrigues.getRequisicoesDeMonitoria());
    }
}