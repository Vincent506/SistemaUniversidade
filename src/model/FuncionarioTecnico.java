package model;

import java.util.List;

public class FuncionarioTecnico extends Funcionario{
    private String nivel;

    public void setNivel(String nivel){this.nivel = nivel;}
    public String getNivel(){return nivel;}

    public FuncionarioTecnico(String nome, String codigo, double Salario, String nivel){
        super(nome, codigo, Salario);
        setNivel(nivel);
    }

    @Override
    public Funcionario cadastrar() {
        System.out.println("============================Cadastro de Funcionario Tecnico============================");
        System.out.println("Digite o nome do Funcionario Tecnico:");
        String variable = input.nextLine();
        System.out.println("Digite o codigo do Funcionario Tecnico: ");
        String code = input.nextLine();
        System.out.println("Digite o Salario do Funcionario Tenico: ");
        double value = Double.parseDouble(input.nextLine());
        System.out.println("Digite o nivel do Funcionario Tecnico");
        String level = input.nextLine();
        Funcionario novo = new FuncionarioTecnico(variable, code, value, level);
        return novo;
    }

    @Override
    public void mostrar() {
        String exibir = "Nome: "+nome
        +"\nCodigo: "+codigo
        +"\nSalario: R$"+salario
        +"\nNivel: "+nivel;

        System.out.println(exibir);
    }
    
    @Override
    public void buscar(List<Funcionario> Operarios) {
        super.buscar(Operarios);
    }

    @Override
    public void listar(List<Funcionario> Operarios) {
        System.out.println("======================Listagem dos Funcionarios tecnicos======================");
        super.listar(Operarios);
    }
}
