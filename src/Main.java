import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<Funcionario> funcionarios =
            new ArrayList<>();

    public static ArrayList<Talhao> talhoes =
            new ArrayList<>();

    public static ArrayList<Trator> tratores =
            new ArrayList<>();

    public static ArrayList<RegistroColheita> registros =
            new ArrayList<>();

    public static void main(String[] args) {

           // public static void main(String[] args) {

        // ================= CARREGAR DADOS =================

        ArquivoUtil.carregarFuncionarios(funcionarios);

        ArquivoUtil.carregarTalhoes(talhoes);

        ArquivoUtil.carregarTratores(tratores);

        ArquivoUtil.carregarRegistros(registros);

        int opcao;

      //  int opcao;

        do {

            System.out.println("\n===== FAZENDA ESPERANÇA =====");

            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Cadastrar Talhão");
            System.out.println("3 - Cadastrar Trator");
            System.out.println("4 - Registrar Colheita");
            System.out.println("5 - Relatório Funcionários");
            System.out.println("6 - Relatório Talhões");
            System.out.println("7 - Relatório Secagem");
            System.out.println("8 - Salvar Dados");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarFuncionario();
                    break;

                case 2:
                    cadastrarTalhao();
                    break;

                case 3:
                    cadastrarTrator();
                    break;

                case 4:
                    registrarColheita();
                    break;

                case 5:
                    relatorioFuncionarios();
                    break;

                case 6:
                    relatorioTalhoes();
                    break;

                case 7:
                    relatorioSecagem();
                    break;

                case 8:
                    salvarDados();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    // ================= FUNCIONÁRIO =================

    public static void cadastrarFuncionario() {

        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Matrícula:");
        String matricula = sc.nextLine();

        System.out.println("Tipo de contrato:");
        String tipo = sc.nextLine();

        Funcionario funcionario =
                new Funcionario(nome, matricula, tipo);

        funcionarios.add(funcionario);

        System.out.println("Funcionário cadastrado!");
    }

    // ================= TALHÃO =================

    public static void cadastrarTalhao() {

        System.out.println("Código:");
        String codigo = sc.nextLine();

        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Variedade do café:");
        String variedade = sc.nextLine();

        System.out.println("Estimativa produção:");
        double estimativa = sc.nextDouble();
        sc.nextLine();

        Talhao talhao =
                new Talhao(codigo, nome,
                        variedade, estimativa);

        talhoes.add(talhao);

        System.out.println("Talhão cadastrado!");
    }

    // ================= TRATOR =================

    public static void cadastrarTrator() {

        System.out.println("Placa:");
        String placa = sc.nextLine();

        System.out.println("Capacidade máxima:");
        double capacidade = sc.nextDouble();
        sc.nextLine();

        Trator trator =
                new Trator(placa, capacidade);

        tratores.add(trator);

        System.out.println("Trator cadastrado!");
    }

    // ================= REGISTRO =================

    public static void registrarColheita() {

        System.out.println("Data:");
        String data = sc.nextLine();

        System.out.println("Matrícula funcionário:");
        String matricula = sc.nextLine();

        if (!funcionarioExiste(matricula)) {

            System.out.println("Funcionário não encontrado!");
            return;
        }

        System.out.println("Código talhão:");
        String codigoTalhao = sc.nextLine();

        if (!talhaoExiste(codigoTalhao)) {

            System.out.println("Talhão não encontrado!");
            return;
        }

        System.out.println("Placa trator:");
        String placa = sc.nextLine();

        Trator trator = buscarTrator(placa);

        if (trator == null) {

            System.out.println("Trator não encontrado!");
            return;
        }

        System.out.println("Quantidade litros:");
        double litros = sc.nextDouble();
        sc.nextLine();

        if (litros > trator.getCapacidadeMaxima()) {

            System.out.println("Carga acima da capacidade!");
            return;
        }

        System.out.println("Destino:");
        String destino = sc.nextLine();

        RegistroColheita registro =
                new RegistroColheita(
                        data,
                        matricula,
                        codigoTalhao,
                        placa,
                        litros,
                        destino
                );

        registros.add(registro);

        System.out.println("Registro realizado!");
    }

    // ================= VALIDAÇÕES =================

    public static boolean funcionarioExiste(String matricula) {

        for (Funcionario f : funcionarios) {

            if (f.getMatricula().equals(matricula)) {
                return true;
            }
        }

        return false;
    }

    public static boolean talhaoExiste(String codigo) {

        for (Talhao t : talhoes) {

            if (t.getCodigo().equals(codigo)) {
                return true;
            }
        }

        return false;
    }

    public static Trator buscarTrator(String placa) {

        for (Trator t : tratores) {

            if (t.getPlaca().equals(placa)) {
                return t;
            }
        }

        return null;
    }

    // ================= RELATÓRIOS =================

    public static void relatorioFuncionarios() {

        System.out.println("\n=== RELATÓRIO FUNCIONÁRIOS ===");

        for (Funcionario f : funcionarios) {

            double total = 0;

            for (RegistroColheita r : registros) {

                if (r.getMatriculaFuncionario()
                        .equals(f.getMatricula())) {

                    total += r.getLitros();
                }
            }

            System.out.println(
                    f.getNome() +
                    " - Total litros: " + total
            );
        }
    }

    public static void relatorioTalhoes() {

        System.out.println("\n=== RELATÓRIO TALHÕES ===");

        for (Talhao t : talhoes) {

            double total = 0;

            for (RegistroColheita r : registros) {

                if (r.getCodigoTalhao()
                        .equals(t.getCodigo())) {

                    total += r.getLitros();
                }
            }

            System.out.println(
                    t.getNome() +
                    " - Produção: " + total +
                    " / Estimativa: " +
                    t.getEstimativaProducao()
            );
        }
    }

    public static void relatorioSecagem() {

        double terreiro = 0;
        double secador = 0;

        for (RegistroColheita r : registros) {

            if (r.getDestino()
                    .equalsIgnoreCase("Terreiro")) {

                terreiro += r.getLitros();

            } else {

                secador += r.getLitros();
            }
        }

        System.out.println("\n=== RELATÓRIO SECAGEM ===");

        System.out.println("Terreiro: " + terreiro);
        System.out.println("Secador: " + secador);
    }

    // ================= SALVAR =================

    public static void salvarDados() {

        ArquivoUtil.salvarFuncionarios(funcionarios);

        ArquivoUtil.salvarTalhoes(talhoes);

        ArquivoUtil.salvarTratores(tratores);

        ArquivoUtil.salvarRegistros(registros);

        System.out.println("Todos os dados foram salvos!");
    }
}