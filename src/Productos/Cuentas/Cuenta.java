package Productos.Cuentas;

import Clientes.Cliente;
import Productos.Producto;

import java.util.Random;

public abstract class Cuenta extends Producto {
    public String numeroCuenta;
    public double saldo;


    public static String crearNumeroCuenta() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10)); // Genera un dígito aleatorio (0-9)
        }
        return sb.toString();
    }
    //Constructor
    public Cuenta(Cliente titular, String numeroCuenta, double saldoInicial) {
        super(titular);
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    //Depostiar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else{
            System.out.println("El monto debe ser mayor a 0.");
        }
    }

    //Extraer
    public abstract boolean extraer(double monto);

    //Transferir
    public boolean transferir(Cuenta destino, double monto) {
        if (this.extraer(monto)) {
            destino.depositar(monto);
            return true;
        }
        return false;
    }

    //Setters y Getters

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() +"{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}