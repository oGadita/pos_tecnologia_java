package modelo;

public class Formacao {

    private String nome;
    private AreaConhecimento areaConhecimento;
    private Curso[] cursos;
    /*A carga horária será contabilizada a partir dos objetos do tipo Curso*/
    private int cargaHoraria = 0;

    public Formacao(String nome, AreaConhecimento areaConhecimento, int numeroDeCursosNaFormacao) {
        this.nome = nome;
        this.areaConhecimento = areaConhecimento;
        if (numeroDeCursosNaFormacao > 0 && numeroDeCursosNaFormacao <= 10) {
            cursos = new Curso[numeroDeCursosNaFormacao];
        } else {
            throw new IllegalArgumentException("O número de cursos indicados para a formação não é válido.");
        }
    }

    public void adicionaCurso(Curso curso) {
        int i;
        for (i=0; i< cursos.length; i++) {
            if(cursos[i] == null) {
                cursos[i] = curso;
                cargaHoraria += curso.getCargaHoraria();
                break;
            }
        }
    }

    public void removeCurso(Curso curso) {
        int i;
        for (i=0; i< cursos.length; i++) {
            if(cursos[i] == curso) {
                cursos[i] = null;
                cargaHoraria -= curso.getCargaHoraria();
                break;
            }
        }
    }

    public void listaCursos() {
        System.out.println("CURSOS DA FORMAÇÃO:");
        for (Curso c: cursos) {
            if(c != null) {
            System.out.println(c);
            }
        }
    }

    @Override
    public String toString() {
        String area = areaConhecimento.retornaArea(areaConhecimento);
        return String.format("FORMAÇÃO: {NOME: '%s', ÁREA DE CONHECIMENTO: '%s', CARGA HORÁRIA: %dh}", nome.toUpperCase(), area, cargaHoraria);
    }

    public String getNome() {
        return nome;
    }

    public AreaConhecimento getAreaConhecimento() {return areaConhecimento;}
}
