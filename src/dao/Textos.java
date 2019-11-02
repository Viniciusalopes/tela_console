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
 * Finalidade: Fornecer textos prontos e dados fixos para a aplicação.
 * ------------------------------------------------------------------------------------------
 */
package dao;

import static app.Tela.getMin_colunas;
import static app.Tela.getMax_colunas;
import static app.Tela.getMin_linhas;
import static app.Tela.getMax_linhas;
import static app.Tela.getLinhas_impressas;

public class Textos {

    /**
     * Textos para menus e para exibiãção em tela.
     *
     * @param titulo String para selecionar o subtítulo e o texto.
     * @return vetor[0]: titulo; vetor[1]: subtitulo; vetor[2]: texto.
     */
    public static String[] get_textos(String titulo) {
        String[] ret = new String[3];

        // ifs por ordem alfabetica de titulo
        /*
        private static String[] borda_dupla = {"╔", "╗", "╚", "╝", "╠", "╣", "╬", "╦", "╩", "═", "║"};
        private static String[] borda_simples = {"┌", "┐", "└", "┘", "├", "┤", "┼", "┬", "┴", "─", "│"};
        private static String[] borda_tracejada = {"+", "+", "+", "+", "+", "+", "+", "+", "+", "-", "|"};
        private static String[] borda_pontilhada = {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ":"};
         */
        if (titulo.contains("Bordas|")) {
            ret[0] = "Configuração de tela";
            ret[1] = titulo.replace("Bordas|", "");
            ret[2] = "\nOpções de bordas:\n"
                    + " 1 -> Borda simples    ┌────┐\n"
                    + " 2 -> Borda dupla      ╔════╗\n"
                    + " 3 -> Borda tracejada  +----+\n"
                    + " 4 -> Borda pontilhada ......\n"
                    + " 5 -> Sem Bordas\n"
                    + "\n 0 <- Voltar.";
        }

        if (titulo.contains("Colunas|")) {
            ret[0] = "Configuração de tela";
            ret[1] = titulo.replace("Colunas|", "");
            ret[2] = "\nInstruções:\n"
                    + "+NN -> Aumenta a quantidade de colunas para [colunas + NN]\n"
                    + "-NN -> Diminui a quantidade de colunas para [colunas - NN]\n"
                    + "NN  -> Redimensiona a quantidade de colunas para [NN]\n"
                    + "\n0 <- Voltar.\n\n"
                    + "NN deve ser um número inteiro entre " + getMin_colunas() + " e " + getMax_colunas() + "\n";
        }

        if (titulo.equals("Configuração de tela")) {
            ret[0] = titulo;
            ret[1] = "";
            ret[2] = " 1 -> Bordas\n"
                    + " 2 -> Colunas\n"
                    + " 3 -> Linhas\n"
                    + "\n 0 <- Voltar.";
        }

        if (titulo.contains("Linhas|")) {
            ret[0] = "Configuração de tela";
            ret[1] = titulo.replace("Linhas|", "");
            ret[2] = "\nInstruções:\n"
                    + "+NN -> Aumenta a quantidade de linhas para [linhas + NN]\n"
                    + "-NN -> Diminui a quantidade de linhas para [linhas - NN]\n"
                    + "NN  -> Redimensiona a quantidade de linhas para [NN]\n"
                    + "A   -> Adiciona linhas quando o texto for maior que linhas [NN]\n"
                    + "T   -> Trunca os textos para quantidade de linhas [NN]\n"
                    + "\n0 <- Voltar.\n\n"
                    + "NN deve ser um número inteiro entre " + getMin_linhas() + " e " + getMax_linhas() + "\n";
        }
        if (titulo.equals("Menu  Principal")) {
            ret[0] = titulo;
            ret[1] = "© 2019 - Viniciusalopes Tecnologia";
            ret[2] = " 1 -> Configurar tela\n"
                    + " 2 -> Texto do Mussum Ipsum, borda simples\n"
                    + " 3 -> Mensagem de 1 linha, MAIÚSCULAS e borda dupla\n"
                    + "\n 0 <- Encerrar programa.";
        }

        if (titulo.equals("Mussum Ipsum")) {
            ret[0] = titulo;
            ret[1] = "http://mussumipsum.com/";
            ret[2] = "Mussum Ipsum, cacilds vidis litro abertis. Vehicula non. Ut sed ex "
                    + "eros. Vivamus sit amet nibh non tellus tristique interdum. Manduma"
                    + " pindureta quium dia nois paga. A ordem dos tratores não altera o "
                    + "pão duris. Interessantiss quisso pudia ce receita de bolis, mais "
                    + "bolis eu num gostis.\n"
                    + "\n"
                    + "Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! "
                    + "Cevadis im ampola pa arma uma pindureta. Suco de cevadiss deixa as "
                    + "pessoas mais interessantis. Viva Forevis aptent taciti sociosqu ad "
                    + "litora torquent.\n"
                    + "\n"
                    + "Quem num gosta di mé, boa gentis num é. Si num tem leite então "
                    + "bota uma pinga aí cumpadi! Admodum accumsan disputationi eu sit. "
                    + "Vide electram sadipscing et per. Interagi no mé, cursus quis, "
                    + "vehicula ac nisi.\n"
                    + "\n"
                    + "Mé faiz elementum girarzis, nisi eros vermeio. Em pé sem cair, "
                    + "deitado sem dormir, sentado sem cochilar e fazendo pose. Praesent "
                    + "malesuada urna nisi, quis volutpat erat hendrerit non. Nam "
                    + "vulputate dapibus. Delegadis gente finis, bibendum egestas augue "
                    + "arcu ut est.";
        }

        return ret;
    }
}
