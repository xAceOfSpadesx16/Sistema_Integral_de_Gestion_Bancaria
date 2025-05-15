import Banco.Banco;
import Banco.BancoSantander;
import Clientes.Cliente;
import Empleados.Cajero;
import Empleados.Empleado;
import Productos.Cuentas.Cuenta;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creando Banco Santander");
        Banco banco = new BancoSantander("Banco Santander", "Calle 123");
        System.out.println();

        System.out.println("Creando Cajero 1");
        Empleado cajero1 = banco.crearYContratarEmpleado("Juan", "Perez", 30, 5000, "cajero");
        System.out.println();

        System.out.println("Creando Cliente 1");
        Cliente cliente1= cajero1.crearYAtenderCliente("Hernesto", "Calle 456", List.of("123456789", "987654321"), 12345678, "Persona");
        System.out.println();

        System.out.println("Buscando cuentas y obteniendo la primera del cliente 1");
        Cuenta cuenta1 = cajero1.buscarCuentasCliente().getFirst();
        System.out.println(cuenta1);
        System.out.println();

        System.out.println("Saldo inicial: " + cuenta1.getSaldo());
        System.out.println(cuenta1.getSaldo());

        System.out.println("Depositando dinero (500) en la cuenta mediante instancia");
        ((Cajero) cajero1).depositarEnCuenta(500, cuenta1);

        System.out.println("Depositando dinero (200) en la cuenta mediante numero de cuenta");
        ((Cajero) cajero1).depositarEnCuenta(200, cuenta1.getNumeroCuenta());

        System.out.println("Saldo despues de depositar: " + cuenta1.getSaldo());
        System.out.println();

        System.out.println("Retirando dinero de la cuenta (100) mediante instancia");
        ((Cajero) cajero1).retirarDeCuenta(100, cuenta1);

        System.out.println("Retirando dinero de la cuenta (100) mediante numero de cuenta " + cuenta1.getNumeroCuenta());
        ((Cajero) cajero1).retirarDeCuenta(100, cuenta1.getNumeroCuenta());
        System.out.println("Saldo despues de retirar: " + cuenta1.getSaldo());
        System.out.println();

        System.out.println("Creando Nueva Cuenta");
        Cuenta cuenta2 = cajero1.crearCuenta("436875", 0, 0 , Banco.ProductoType.CAJA_AHORRO);
        System.out.println();

        System.out.println("Transferiendo dinero de la cuenta 1 a la cuenta 2 (100) mediante instancia");
        System.out.println("Saldo cuenta 1 antes: " + cuenta1.getSaldo());
        System.out.println("Saldo cuenta 2 antes: " + cuenta2.getSaldo());

        ((Cajero) cajero1).ejecutarTransferencia(100, cuenta1.getNumeroCuenta(), cuenta2.getNumeroCuenta());

        System.out.println("Saldo cuenta 1 despues: " + cuenta1.getSaldo());
        System.out.println("Saldo cuenta 2 despues: " + cuenta2.getSaldo());
        System.out.println();

        System.out.println("//////////////////////////////");
        System.out.println("Creando nuevo Cliente");
        Cliente cliente2 = cajero1.crearYAtenderCliente("Pedro", "Calle 126", List.of("123456789", "987654321"), 321456987, "Persona");
        System.out.println();

        System.out.println("Buscando cuentas y obteniendo la primera del cliente 2");
        Cuenta cuenta3 = cajero1.buscarCuentasCliente().getFirst();
        System.out.println(cuenta3.getTitular().getNombre());
        System.out.println();

        System.out.println("Depositando dinero (500) en la cuenta mediante instancia");
        ((Cajero) cajero1).depositarEnCuenta(500, cuenta3);
        System.out.println();

        System.out.println("Transferiendo dinero de la cuenta 3 a la cuenta 2 (300) mediante instancia");
        System.out.println("Saldo cuenta 3 antes: " + cuenta3.getSaldo());
        System.out.println("Saldo cuenta 2 antes: " + cuenta2.getSaldo());

        ((Cajero) cajero1).ejecutarTransferencia(300, cuenta3.getNumeroCuenta(), cuenta2.getNumeroCuenta());

        System.out.println("Saldo cuenta 3 despues: " + cuenta3.getSaldo());
        System.out.println("Saldo cuenta 2 despues: " + cuenta2.getSaldo());
        System.out.println("//////////////////////////////");

        System.out.println("Imprimiendo todos los productos del banco");
        banco.getProductos().forEach(System.out::println);
        System.out.println();

        System.out.println("Imprimiendo todos los clientes del banco");
        banco.getClientes().forEach(System.out::println);
        System.out.println();

        System.out.println("Imprimiendo todos los empleados del banco");
        banco.getEmpleados().forEach(System.out::println);
        System.out.println();
    }
}

