public class Operacao {

    private TipoOperacao tipo;
    private double valor;

    public Operacao(char tipoChar, double valor) {
        this.tipo = TipoOperacao.fromCodigo(tipoChar);
        this.valor = valor;
    }

    public TipoOperacao getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public String toString() {
        return this.tipo.getDescricao() + ":\t" + this.valor;
    }
}
