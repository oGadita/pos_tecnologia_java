package excecoes;

public class ProfessorNaoPossuiPermissaoException extends RuntimeException {
    public ProfessorNaoPossuiPermissaoException(String s) {
        System.out.println(s);
    }
}
