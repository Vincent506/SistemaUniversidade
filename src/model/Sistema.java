package model;

import java.util.Scanner;

public class Sistema {
    public static void iniciar(){
        Scanner input = new Scanner(System.in);
        Universidade faculdade = new Universidade("IFMA", 3);
        String menu = "==========================SISTEMA UNIVERSIDADE=========================="
        +"\n1 - Cadastrar Departamento"
        +"\n2 - Cadastrar Funcionario Tecnico"
        +"\n3 - Cadastrar Funcionario Docente"
        +"\n4 - Buscar Departamento por Nome"
        +"\n5 - Buscar Funcionario por Nome"
        +"\n6 - Listar Departamentos com Funcionarios com Faixa Salarial Especifica"
        +"\n7 - Listar Funcionarios com Faixa Salarial Especifica"
        +"\n8 - Listar Departamentos cujo gasto total está entre uma Faixa de Valores Específica"
        +"\n9 - Listar todos Funcionarios da Universidade"
        +"\n10 - Listar todos os Departamentos da Universidade"
        +"\n11 - Listar todos os Departamentos da Universidade e seus Respectivos Funcionários"
        +"\n12 - Listar todos os Funcionarios Docentes"
        +"\n13 - Listar todos os Funcionarios Tecnicos"
        +"\n0 - FECHAR E SAIR DO PROGRAMA";
        int escolha = -1;
        String nome, codigo, especifico;
        double salario;
        do{
            System.out.println(menu);
            escolha = Integer.parseInt(input.nextLine());
            switch (escolha) {
                    case 1:
                    System.out.println("==CADASTRANDO NOVO DEPARTAMENTO==");
                    System.out.println("Nome: ");
                    nome = input.nextLine();
                    System.out.println("Codigo do Departamento: ");
                    codigo = input.nextLine();
                    System.out.println("Numero maximo de funcionarios o Departamento "+nome);
                    int numMax = Integer.parseInt(input.nextLine());
                    faculdade.criaDepartamento(nome, codigo, numMax);
                    System.out.println("==DEPARTAMENTO CRIADO COM SUCESSO==");
                    break;
                    case 2:
                    System.out.println("==CADASTRANDO FUNCIONARIO TÉCNICO==");
                    System.out.println("Nome do departamento: ");
                    String nomeDepartamento = input.nextLine();
                    if (faculdade.verificador(nomeDepartamento)) {
                        Departamento departamento;
                        departamento = faculdade.buscar(nomeDepartamento);

                        System.out.println("Nome: ");
                        nome = input.nextLine();
                        System.out.println("Codigo: ");
                        codigo = input.nextLine();
                        System.out.println("Salario:");
                        salario = Double.parseDouble(input.nextLine());
                        System.out.println("Nivel: ");
                        especifico = input.nextLine();

                        departamento.criarFuncionario(nome, codigo, salario, 1, especifico);

                        System.out.println("== FUNCIONARIO CADASTRADO COM SUCESSO ==");
                        
                    }else{
                        System.out.println("== DEPARTAMENTO NÃO ENCONTRADO ==");
                    }
                    break;
                    case 3:
                        System.out.println("==CADASTRANDO FUNCIONARIO DOCENTE==");
                        System.out.println("Nome do departamento: ");
                        String nomeDepartamento2 = input.nextLine();
                        if (faculdade.verificador(nomeDepartamento2)) {
                        Departamento departamento;
                        departamento = faculdade.buscar(nomeDepartamento2);
                        System.out.println("Nome: ");
                        nome = input.nextLine();
                        System.out.println("Codigo: ");
                        codigo = input.nextLine();
                        System.out.println("Salario:");
                        salario = Double.parseDouble(input.nextLine());
                        System.out.println("Titulação: ");
                        especifico = input.nextLine();
                        departamento.criarFuncionario(nome, codigo, salario, 2, especifico);
                        System.out.println("== FUNCIONARIO CADASTRADO COM SUCESSO ==");
                        
                        }else{
                        System.out.println("== DEPARTAMENTO NÃO ENCONTRADO ==");
                        }
                    break;
                    case 4:
                        System.out.println("== BUSCANDO DEPARTAMENTO PELO NOME ==");
                        System.out.println("Digite o nome: ");
                        nome = input.nextLine();
                        Departamento departamento = faculdade.buscar(nome);
                        if (departamento != null) {
                            departamento.mostrar();
                            
                        }else{
                            System.out.println("== DEPARTAMENTO NÃO ENCONTRADO ==");
                        }
                    break;
                    case 5:
                    System.out.println("== BUSCANDO FUNCIONARIO PELO NOME");
                    System.out.println("Digite o nome: ");
                    nome = input.nextLine();

                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        departamento = faculdade.departamentos[i];
                        if (departamento.buscar(nome)!= null) {
                            departamento.buscar(nome).mostrar();
                        }else{
                            System.out.println("Funcionario não encontrado");
                        }
                    }
                    break;
                    case 6:
                    System.out.println("== FAIXA SALARIAL ==");
                    System.out.println("Salario de: ");
                    double de = Double.parseDouble(input.nextLine());
                    System.out.println("ate: ");
                    double ate = Double.parseDouble(input.nextLine());
                    System.out.println("== Departamentos com faixa salarial de R$ "+de+" ate R$ "+ate+" ==");
                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        Departamento d = faculdade.departamentos[i];
                        if (d.calcularGastos() >= de && d.calcularGastos() <= ate) {
                            System.out.println(d.getNome());
                        }
                    }
                    System.out.println("");
                    break;
                    case 7:
                    System.out.println("== FAIXA SALARIAL ==");
                    System.out.println("Salario de: ");
                    de = Double.parseDouble(input.nextLine());
                    System.out.println("ate: ");
                    ate = Double.parseDouble(input.nextLine());
                    System.out.println("== Funcionarios com faixa salarial de R$ "+de+" ate R$ "+ate+" ==");
                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        Departamento d = faculdade.departamentos[i];
                        for (int j = 0; j < d.numberfuncionarios; j++) {
                            Funcionario f = d.funcionarios[j];
                            if (f.getSalario() >= de && f.getSalario() <= ate) {
                            System.out.println(f.getNome());
                            }
                        }
                    }
                    System.out.println("");
                    break;
                    case 8:
                    System.out.println("== FAIXA SALARIAL ==");
                    System.out.println("Salario de: ");
                    de = Double.parseDouble(input.nextLine());
                    System.out.println("ate: ");
                    ate = Double.parseDouble(input.nextLine());
                    System.out.println("== Departamentos com faixa salarial de R$ "+de+" ate R$ "+ate+" ==");
                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        Departamento d = faculdade.departamentos[i];
                        if (d.calcularGastos() >= de && d.calcularGastos() <= ate) {
                            System.out.println(d.getNome());
                        }
                    }
                    System.out.println("");
                    break;
                    case 9:
                    System.out.println("=== Universidade "+faculdade.getNome()+" ===");
                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        Departamento d = faculdade.departamentos[i];
                        for (int j = 0; j < d.numberfuncionarios; j++) {
                            Funcionario f = d.funcionarios[j];
                            System.out.println(" - "+ f.getNome());
                        }
                    }
                    break;
                    case 10:
                    System.out.println("=== DEPARTAMENTOS ===");
                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        Departamento d = faculdade.departamentos[i];
                            System.out.println(" - "+ d.getNome());
                    }
                    break;
                    case 11:
                    System.out.println("=== FUNCIONARIOS POR DEPARTAMENTOS ===");
                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        Departamento d = faculdade.departamentos[i];
                        System.out.println(" + "+d.getNome());

                        for (int j = 0; j < d.numberfuncionarios; j++) {
                            Funcionario f = d.funcionarios[j];
                            System.out.println("    -"+f.getNome());
                        }
                    }
                    break;
                    case 12:
                    System.out.println("=== FUNCIONARIOS DOCENTES ===");
                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        Departamento d = faculdade.departamentos[i];
                        for(int j = 0; j < d.numberfuncionarios; j++){
                            Funcionario f = d.funcionarios[j];
                            if (f.getClass().getSimpleName().equals("FuncionarioDocente")) {
                                System.out.println(f.getNome());
                            }
                        }
                    }
                    
                    break;
                    case 13:
                    System.out.println("=== FUNCIONARIOS TECNICOS ===");
                    for (int i = 0; i < faculdade.numberDepartamento; i++) {
                        Departamento d = faculdade.departamentos[i];
                        for(int j = 0; j < d.numberfuncionarios; j++){
                            Funcionario f = d.funcionarios[j];
                            if (f.getClass().getSimpleName().equals("FuncionarioTecnico")) {
                                System.out.println(f.getNome());
                            }
                        }
                    }
                    
                    break;
                    case 0:
                    System.out.println("FECHANDO........Saindo do programa......");
                    break;
            
                default:
                System.out.println("Digite uma opção valida do menu de opções");
                    break;
            }
        }while(escolha !=0);
        input.close();
    }
}
