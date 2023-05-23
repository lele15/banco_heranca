package ifpr.pgua.eic.tads.banco.entidades;

public class ContaPoupanca extends ContaBancaria{

    private double rendimento;
    private double txRendimento;
    
    public ContaPoupanca(String agencia, String numero, 
                        Pessoa cliente, double saldo, 
                        double txRendimento) {
        super(agencia, numero, cliente, saldo);
        this.txRendimento = txRendimento;
    }

    public void setTxRendimento(double txRendimento){
        this.txRendimento = txRendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public double getTxRendimento() {
        return txRendimento;
    }

    @Override
    public String gerarExtrato(){
        String texto = "";

        texto = super.gerarExtrato();
        texto += " txRendimento: "+txRendimento+" Rendimentos:"+rendimento;

        return texto;
    }

    @Override
    public String tipo(){
        return "Conta Poupança";
    }
    
    public void render(){
        rendimento = rendimento + (saldo * txRendimento);
    }
    
    
}