package excecoes;

public class ErroDeCadastroException extends RuntimeException {
    public ErroDeCadastroException(String s) {
        System.out.println(s);
    }
}
