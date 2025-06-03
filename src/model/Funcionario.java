package model;

import java.util.List;
import java.util.Scanner;

public class Funcionario extends Object{
    Scanner input = new Scanner(System.in);
    protected String nome;
    protected String codigo;
    protected double salario;

    public void setNome(String nome){this.nome = nome;}
    public String getNome(){return nome;}
    public void setCodigo(String codigo){this.codigo = codigo;}
    public String getCodigo(){return codigo;}
    public void setSalario(double salario ){this.salario = salario;}
    public double getSalario(){return salario;}

    public Funcionario(String nome, String codigo, double salario){
        this.nome = nome;
        this.salario = salario;
        this.codigo = codigo;
    }

    public Funcionario cadastrar(){
        System.out.println("Digite o nome do Funcionario:");
        String variable = input.nextLine();
        System.out.println("Digite o codigo do Funcionario: ");
        String code = input.nextLine();
        System.out.println("Digite o Salario do Funcionario: ");
        double value = Double.parseDouble(input.nextLine());
        Funcionario novo = new Funcionario(variable, code, value);

        return novo;
    }

    public void mostrar(){
        String exibir = "Nome: "+nome
        +"\nCodigo: "+codigo
        +"\nSalario: R$"+salario;

        System.out.println(exibir);
    }

    public void buscar(List<Funcionario> Operarios){

        System.out.println("Digite o nome do funcionario que esta buscando:");
        String procurado = input.nextLine();

        int verificador = -1;
        for (int i = 0; i < Operarios.size(); i++) {
            if ((Operarios.get(i).getNome()).equalsIgnoreCase(procurado)) {
                Operarios.get(i).mostrar();
                verificador++;
            }
        }
        if (verificador == 0) {
            System.out.println("Encontrado!!!");    
        }else{
            System.out.println("FUncionario não encotrado");
            
        }
        
    }

    public void listar(List<Funcionario> Operarios){
        int i =0;
        while (i<Operarios.size()) {
            Operarios.get(i).mostrar();
            i++;
        }
    }
}
