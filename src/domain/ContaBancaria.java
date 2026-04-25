package domain;

public class ContaBancaria {

    private float saldo;
    private float limiteCheque;
    private float chequeUsado;

    public ContaBancaria(float depositoInicial){
        this.saldo = depositoInicial;
        chequeUsado = 0;

        if (depositoInicial <= 500.00F){
            limiteCheque = 50.00F;
        } else {
            limiteCheque = 0.5F * depositoInicial;
        }
    }

    public float getLimiteCheque() {
        return limiteCheque - chequeUsado;
    }

    public float getSaldo() {
        return saldo + getLimiteCheque();
    }

    public void depositar(float deposito){
        if (chequeUsado > 0){
            float taxa = chequeUsado * 0.2f;
            if (deposito >= chequeUsado + taxa){
                deposito -= (chequeUsado + taxa);
                chequeUsado = 0;
            } else if (deposito >= taxa){
                chequeUsado -= (deposito - taxa);
                deposito = 0;
            } else{
                chequeUsado -= 0;
                deposito = 0;
            }
        }
        saldo += deposito;
    }

    public void sacar(float valor){
        if (valor <= getSaldo()){
            saldo -= valor;
        } else if (valor <= getSaldo() + getLimiteCheque()){
            float restante = valor - saldo;
            valor = 0;
            chequeUsado += restante;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void pagarBoleto(float valorBoleto){
        sacar(valorBoleto);
    }

    public boolean checkChequeEspecial() {
        return chequeUsado > 0;
    }

}
