import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private DadosConta dadosConta;
    private double saldo;
    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double saldoInicial) {
        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.dadosConta = new DadosConta(numAgencia, numConta, gerente);
        this.saldo = saldoInicial;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    public void realizarOperacao(char tipo, int valor) {
        registrarOperacao(tipo, valor);
        atualizarSaldo(tipo, valor);
    }

    private void registrarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);
    }

    private void atualizarSaldo(char tipo, int valor) {
        if (tipo == 'd')
            this.saldo += valor;
        else if(tipo == 's')
            this.saldo -= valor;
    }

    private String gerarExtrato() {
        StringBuilder extrato = new StringBuilder();
        for(Operacao op : this.operacoes) {
            extrato.append(op.toString()).append("\n");
        }
        return extrato.toString();
    }

    public String toString() {
        String dadosClienteStr = this.cliente.toString();
        String dadosContaStr = this.dadosConta.toString() + String.format("\nSaldo: %.2f", this.saldo);
        String dadosExtrato = gerarExtrato();

        return "-----CLIENTE-----\n" +
                dadosClienteStr +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosContaStr +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}
