/*
 * A licença MIT
 *
 * Copyright 2019 Viniciusalopes Tecnologia <suporte@viniciusalopes.com.br>.
 *
 * É concedida permissão, gratuitamente, a qualquer pessoa que obtenha uma cópia
 * deste software e dos arquivos de documentação associados (o "Software"), para
 * negociar o Software sem restrições, incluindo, sem limitação, os direitos de uso,
 * cópia, modificação e fusão, publicar, distribuir, sublicenciar e/ou vender cópias
 * do Software, e permitir que as pessoas a quem o Software é fornecido o façam,
 * sujeitas às seguintes condições:
 *
 * O aviso de copyright acima e este aviso de permissão devem ser incluídos em
 * todas as cópias ou partes substanciais do Software.
 *
 * O SOFTWARE É FORNECIDO "NO ESTADO EM QUE SE ENCONTRA", SEM NENHUM TIPO DE GARANTIA,
 * EXPRESSA OU IMPLÍCITA, INCLUINDO, MAS NÃO SE LIMITANDO ÀS GARANTIAS DE COMERCIALIZAÇÃO,
 * ADEQUAÇÃO A UM FIM ESPECÍFICO E NÃO VIOLAÇÃO. EM NENHUMA CIRCUNSTÂNCIA, OS AUTORES
 * OU PROPRIETÁRIOS DE DIREITOS DE AUTOR PODERÃO SER RESPONSABILIZADOS POR QUAISQUER
 * REIVINDICAÇÕES, DANOS OU OUTRAS RESPONSABILIDADES, QUER EM AÇÃO DE CONTRATO,
 * DELITO OU DE OUTRA FORMA, DECORRENTES DE, OU EM CONEXÃO COM O SOFTWARE OU O USO
 * OU OUTRAS NEGOCIAÇÕES NO PROGRAMAS.
 * ------------------------------------------------------------------------------------------
 * Projeto   : TelaConsole
 * Criado em : 02/11/2019
 * Autor     : Viniciusalopes (Vovolinux) <suporte@viniciusalopes.com.br>
 * Finalidade: Exemplos de utilização da classe 'Tela', para impressão de telas no console
 *             com título, subtítulo e bordas.
 * ------------------------------------------------------------------------------------------
 */
package bll;

import static app.Tela.*;
import static dao.Bordas.get_borda_atual;
import static dao.Textos.*;
import static util.ValidaInput.*;
import java.util.Scanner;

public class Bll {

    protected static Scanner sc = new Scanner(System.in);   // Leitor do input do console
    protected static String opcao;                          // Opção lida pelo Scanner
    protected static String[] textos;                       // Vetor com título, subtitulo e texto da tela
    protected static char tipo = 's';                       // Tipo da borda
    protected static int colunas = getQtd_colunas();        // Colunas da tela
    protected static int linhas = getQtd_linhas();          // Linhas da telaS

    /**
     * Exibe mensagem para voltar ao menu Principal, aguarda o [ENTER] do usuário.
     */
    private static void enter_para_voltar() {
        imprime("> Pressione [ENTER] para voltar ao menu...");
        sc.nextLine();      // Aguarda o [ENTER]
        menu_principal();   // Executa o menu_principal()
    }

    /**
     * Exibe mensagem para digitar novamente e aguarda o [ENTER] do usuário.
     */
    private static void enter_para_digitar() {
        imprime("> Pressione [ENTER] para digitar novamente...");
        sc.nextLine();  // Aguarda o [ENTER]
    }

    /**
     * Menu principal do sistema.
     */
    public static void menu_principal() {

        // Obtém título, subítulo e texto
        textos = get_textos("Menu  Principal");

        do {
            limpa_tela();
            desenha_tela(textos[0], textos[1], textos[2], colunas, linhas, tipo);
            imprime("> ");

            // Entrada
            opcao = sc.nextLine();

            // Validação
            if (!int_no_intervalo(opcao, 0, 3)) {
                desenha_mensagem("OPA! Opção inválida.", colunas, linhas, 'd', false);
                imprime("> Pressione [ENTER] para escolher novamente...");
                sc.nextLine();
            }
        } while (!int_no_intervalo(opcao, 0, 3));

        // Processamento e saída
        limpa_tela();
        switch (Integer.parseInt(opcao)) {
            case 0:
                break;
            case 1:
                configurar();
                menu_principal();
                break;
            case 2:
                mussum();
                enter_para_voltar();
                break;
            case 3:
                mensagem1linha();
                enter_para_voltar();
                break;
            default:
                break;
        }

    }

    /**
     * Menu de configurações de tela.
     */
    private static void configurar() {

        // Obtém título, subítulo e texto
        textos = get_textos("Configuração de tela");

        do {
            limpa_tela();
            desenha_tela(textos[0], textos[1], textos[2], colunas, linhas, tipo);
            imprime("> ");

            // Entrada
            opcao = sc.nextLine();

            // Validação
            if (!int_no_intervalo(opcao, 0, 3)) {
                desenha_mensagem("OPA! Opção inválida.", colunas, 1, 'd', false);
                imprime("> Pressione [ENTER] para escolher novamente...");
                sc.nextLine();
            }
        } while (!int_no_intervalo(opcao, 0, 3));

        // Processamento e saída
        limpa_tela();
        switch (Integer.parseInt(opcao)) {
            case 0:
                break;
            case 1:
                //1 - Bordas\n"
                //   + " 2 - Colunas\n"
                //   + " 3 - Linhas\n"
                //   + "\n 0 - Voltar.";
                configurar_bordas();
                configurar();
                break;
            case 2:
                configurar_colunas();
                configurar();
                break;
            case 3:
                configurar_linhas();
                configurar();
                break;
            default:
                break;
        }

    }

    /**
     * Menu de configuração de bordas da tela.
     */
    private static void configurar_bordas() {
        // Obtém título, subítulo e texto
        textos = get_textos("Bordas|" + get_borda_atual(tipo));

        do {
            limpa_tela();
            desenha_tela(textos[0], textos[1], textos[2], colunas, linhas, tipo);
            imprime("> ");

            // Entrada
            opcao = sc.nextLine();

            // Validação
            if (!int_no_intervalo(opcao, 0, 5)) {
                desenha_mensagem("OPA! Opção inválida.", colunas, 1, 'd', false);
                imprime("> Pressione [ENTER] para escolher novamente...");
                sc.nextLine();
            }
        } while (!int_no_intervalo(opcao, 0, 5));
        /*
         "\nOpções de bordas:\n"
                    + " 1 - Borda simples    ┌────┐\n"
                    + " 2 - Borda dupla      ╔════╗\n"
                    + " 3 - Borda tracejada  +----+\n"
                    + " 4 - Borda pontilhada ......\n"
                    + " 5 - Sem Bordas\n"
                    + "\n 0 - Voltar.";
         */
        // Processamento e saída
        limpa_tela();
        switch (Integer.parseInt(opcao)) {
            case 0:
                break;
            case 1:
                tipo = 's';
                configurar_bordas();
                break;
            case 2:
                tipo = 'd';
                configurar_bordas();
                break;
            case 3:
                tipo = 't';
                configurar_bordas();
                break;
            case 4:
                tipo = 'p';
                configurar_bordas();
                break;
            case 5:
                tipo = ' ';
                configurar_bordas();
                break;
            default:
                break;
        }
    }

    /**
     * Menu de configuração de colunas da tela.
     */
    private static void configurar_colunas() {

        // Variáveis
        boolean invalido;
        int qtd = colunas;  // Bova quantidade de colunas após a validação

        // Obtém título, subítulo e texto
        textos = get_textos("Colunas|" + colunas + " colunas X " + linhas + " linhas");

        do {
            invalido = false;
            String mensagem = "OPA! Digite +N, -N ou N para a quantidade de colunas.";
            limpa_tela();
            desenha_tela(textos[0], textos[1], textos[2], colunas, linhas, tipo);
            imprime("> ");

            // Entrada
            opcao = sc.nextLine();

            // Validação
            if (!opcao.equals("0")) {
                if (int_valido(opcao)) {
                    if (opcao.charAt(0) == '+' || opcao.charAt(0) == '-') {
                        qtd = colunas + Integer.parseInt(opcao);
                    } else {
                        qtd = Integer.parseInt(opcao);
                    }
                    if (qtd < getMin_colunas()) {
                        invalido = true;
                        mensagem = "OPA! Tamanho mínimo: " + getMin_colunas() + " colunas.";
                    }

                    if (qtd > getMax_colunas()) {
                        invalido = true;
                        mensagem = "OPA! Tamanho máximo: " + getMax_colunas() + " colunas.";
                    }
                } else {
                    invalido = true;
                }

                if (invalido) {
                    desenha_mensagem(mensagem, 60, 1, 'd', false);
                    enter_para_digitar();
                }
            }
        } while (invalido);

        // Processamento   
        if (!opcao.equals("0")) {
            limpa_tela();
            colunas = qtd;
            configurar_colunas();
        }
    }

    /**
     * Menu de configuração de linhas da tela.
     */
    private static void configurar_linhas() {

        // Variáveis
        boolean invalido;
        int qtd = linhas;

        // Obtém título, subítulo e texto
        textos = get_textos("Linhas|" + colunas + " colunas X " + linhas + " linhas"
                + " | Trunca Linhas: " + ((isTrunca_linhas()) ? "Sim" : "Não"));

        do {
            invalido = false;
            String mensagem = "OPA! Digite +N, -N ou N para a quantidade de linhas.";
            limpa_tela();
            desenha_tela(textos[0], textos[1], textos[2], colunas, linhas, tipo);
            imprime("> ");

            // Entrada
            opcao = sc.nextLine();

            // Validação
            if (!opcao.equals("0")) {
                if (int_valido(opcao)) {
                    if (opcao.charAt(0) == '+' || opcao.charAt(0) == '-') {
                        qtd = linhas + Integer.parseInt(opcao);
                    } else {
                        qtd = Integer.parseInt(opcao);
                    }
                    if (qtd < getMin_linhas()) {
                        invalido = true;
                        mensagem = "OPA! Tamanho mínimo: " + getMin_linhas() + " linhas.";
                    }

                    if (qtd > getMax_linhas()) {
                        invalido = true;
                        mensagem = "OPA! Tamanho máximo: " + getMax_linhas() + " linhas.";
                    }
                } else {
                    if (!opcao.equalsIgnoreCase("T") && !opcao.equalsIgnoreCase("A")) {
                        invalido = true;
                    }
                }

                if (invalido) {
                    desenha_mensagem(mensagem, 60, 1, 'd', false);
                    enter_para_digitar();
                }
            }
        } while (invalido);

        // Processamento e saída
        if (!opcao.equals("0")) {
            limpa_tela();

            if (opcao.equalsIgnoreCase("T")) {
                setTrunca_linhas(true);
            } else if (opcao.equalsIgnoreCase("A")) {
                setTrunca_linhas(false);
            } else {
                linhas = qtd;
            }

            configurar_linhas();
        }
    }

    /**
     * Exibe um texto do Mussum Ipsum.
     */
    private static void mussum() {
        // Obtém título, subítulo e texto
        textos = get_textos("Mussum Ipsum");

        // Saída
        limpa_tela();
        desenha_tela(textos[0], textos[1], textos[2], colunas, linhas, 's');
    }

    private static void mensagem1linha() {
        // Saída
        limpa_tela();
        desenha_mensagem("Mensagem de 1 linha, borda dupla", colunas, linhas, 'd', true);
    }
}
