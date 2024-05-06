import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                ConverteMoeda conversor = new ConverteMoeda();


                while (true) {
                    System.out.println("""
                    *******************************************************
                    Seja bem-vindo(a) ao Conversor de Moeda
                    *******************************************************
                    1- Dólar           => Real brasileiro;
                    2- Real brasileiro => Dólar;
                    3- Dólar           => Peso argentino;
                    4- Peso argentino  => Dólar;
                    5- Dólar           => Peso colombiano;
                    6- Peso colombiano => Dólar;
                    7- Sair;
                    """);
                    System.out.println("Escolha uma opção válida: ");
                    //*******************************************************
                    //""");
                    int opcao = sc.nextInt();

                    if (opcao >= 1 && opcao <= 6) {
                        try {
                            System.out.println("Digite um valor que deseja converter: ");
                            double valor = sc.nextDouble();

                            String moedaOrigem = "";
                            String moedaDestino = "";

                            switch (opcao) {
                                case 1:
                                    moedaOrigem = "USD";
                                    moedaDestino = "BRL";
                                    break;
                                case 2:
                                    moedaOrigem = "BRL";
                                    moedaDestino = "USD";
                                    break;
                                case 3:
                                    moedaOrigem = "USD";
                                    moedaDestino = "ARS";
                                    break;
                                case 4:
                                    moedaOrigem = "ARS";
                                    moedaDestino = "USD";
                                    break;
                                case 5:
                                    moedaOrigem = "USD";
                                    moedaDestino = "COP";
                                    break;
                                case 6:
                                    moedaOrigem = "COP";
                                    moedaDestino = "USD";
                                    break;
                            }

                            double valorConvertido = conversor.converteMoeda(moedaOrigem, moedaDestino, valor).
                                    conversion_result();
                            System.out.printf("O valor %.5f %s corresponde ao valor final de %.5f %s%n\n",
                                    valor, moedaOrigem, valorConvertido, moedaDestino);


                        } catch (InputMismatchException e) {
                            System.out.println("O valor inserido é inválido.");
                        }

                    } else if (opcao == 7) {
                        System.out.println("Finalizando o programa...");
                        break;
                    } else {
                        System.out.println("Opção inválida! Finalizando o programa...");
                        break;
                    }
                }
            }

        }