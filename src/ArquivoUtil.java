import java.io.*;
import java.util.ArrayList;

public class ArquivoUtil {

    // ================= FUNCIONÁRIOS =================

    public static void salvarFuncionarios(
            ArrayList<Funcionario> funcionarios) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("funcionarios.txt")
                    );

            for (Funcionario f : funcionarios) {

                writer.write(f.toString());
                writer.newLine();
            }

            writer.close();

            System.out.println("Funcionários salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar funcionários.");
        }
    }

    public static void carregarFuncionarios(
            ArrayList<Funcionario> funcionarios) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("funcionarios.txt")
                    );

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                Funcionario f =
                        new Funcionario(
                                partes[0],
                                partes[1],
                                partes[2]
                        );

                funcionarios.add(f);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Arquivo funcionários não encontrado.");
        }
    }

    // ================= TALHÕES =================

    public static void salvarTalhoes(
            ArrayList<Talhao> talhoes) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("talhoes.txt")
                    );

            for (Talhao t : talhoes) {

                writer.write(t.toString());
                writer.newLine();
            }

            writer.close();

            System.out.println("Talhões salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar talhões.");
        }
    }

    public static void carregarTalhoes(
            ArrayList<Talhao> talhoes) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("talhoes.txt")
                    );

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                Talhao t =
                        new Talhao(
                                partes[0],
                                partes[1],
                                partes[2],
                                Double.parseDouble(partes[3])
                        );

                talhoes.add(t);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Arquivo talhões não encontrado.");
        }
    }

    // ================= TRATORES =================

    public static void salvarTratores(
            ArrayList<Trator> tratores) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("tratores.txt")
                    );

            for (Trator t : tratores) {

                writer.write(t.toString());
                writer.newLine();
            }

            writer.close();

            System.out.println("Tratores salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar tratores.");
        }
    }

    public static void carregarTratores(
            ArrayList<Trator> tratores) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("tratores.txt")
                    );

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                Trator t =
                        new Trator(
                                partes[0],
                                Double.parseDouble(partes[1])
                        );

                tratores.add(t);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Arquivo tratores não encontrado.");
        }
    }

    // ================= REGISTROS =================

    public static void salvarRegistros(
            ArrayList<RegistroColheita> registros) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("registros.txt")
                    );

            for (RegistroColheita r : registros) {

                writer.write(r.toString());
                writer.newLine();
            }

            writer.close();

            System.out.println("Registros salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar registros.");
        }
    }

    public static void carregarRegistros(
            ArrayList<RegistroColheita> registros) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("registros.txt")
                    );

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                RegistroColheita r =
                        new RegistroColheita(
                                partes[0],
                                partes[1],
                                partes[2],
                                partes[3],
                                Double.parseDouble(partes[4]),
                                partes[5]
                        );

                registros.add(r);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Arquivo registros não encontrado.");
        }
    }
}