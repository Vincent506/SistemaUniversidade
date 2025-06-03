package model;

import java.util.List;

public class FuncionarioDocente extends Funcionario{
    private String titulacao;

    public void setTitulacao(String titulacao){this.titulacao = titulacao;}
    public String getTitulacao(){return titulacao;}

    public FuncionarioDocente(String nome, String codigo, double salario, String titulacao){
        super(nome, codigo, salario);
        setTitulacao(titulacao);
    }

    @Override
    public Funcionario cadastrar() {
        System.out.println("============================Cadastro de Funcionario Docente============================");
        System.out.println("Digite o nome do Funcionario Docente:");
        String variable = input.nextLine();
        System.out.println("Digite o codigo do Funcionario Docente: ");
        System.out.println("Digite o codigo do Funcionario Docente: ");
        String code = input.nextLine();
        System.out.println("Digite o Salario do Funcionario Docente: ");
        double value = Double.parseDouble(input.nextLine());
        System.out.println("Digite o titulação do Funcionario Docente");
        String patente = input.nextLine();
        Funcionario novo = new FuncionarioDocente(variable, code, value, patente);
        return novo;
    }

    @Override
    public void mostrar() {
        String exibir = "Nome: "+nome
        +"\nCodigo: "+codigo
        +"\nSalario: R$"+salario
        +"\nTitulação: "+titulacao;

        System.out.println(exibir);
    }

    @Override
    public void buscar(List<Funcionario> Operarios) {
        super.buscar(Operarios);
    }

    @Override
    public void listar(List<Funcionario> Operarios) {
        System.out.println("======================Listagem dos Funcionarios Docentes======================");
        super.listar(Operarios);
    }
}

  
