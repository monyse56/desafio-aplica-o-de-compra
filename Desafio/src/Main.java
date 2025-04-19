import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite o limite do cartão: R$ ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
                    System.out.print("Descrição da compra: ");
                    String descricao = leitura.next();

                    System.out.print("Valor da compra: R$ ");
                    double valor = leitura.nextDouble();

                    Compra compra = new Compra( descricao, valor);
                    boolean compraRealizada = cartao.lancaCompra(compra);


                    if (compraRealizada) {
                        System.out.println("✅ Compra realizada com sucesso!");
                        System.out.println("Digite 0 para sair ou 1 para continuar.");
                        sair = leitura.nextInt();
                    } else {
                        System.out.println("Saldo insuficiente! ");
                        sair = 0;
                    }

                    System.out.println("*******************");
                    System.out.println("Compra realizadas:\n");
                    Collections.sort(cartao.getCompras());
                    for (Compra c : cartao.getCompras()) {
                            System.out.println("🛒 " + c.getDescricao() + " - R$ " + c.getValor());
                    }
                    System.out.println("\n****************");

                    System.out.println("\nSaldo do cartão: " +cartao.getSaldo());

            }
        }
}