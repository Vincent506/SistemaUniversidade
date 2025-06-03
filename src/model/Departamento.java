package model;

import java.util.Scanner;

public class Departamento extends Object{
    Scanner input = new Scanner(System.in);
    private String codigo;
    protected String nome;
    protected int numberfuncionarios;
    protected int maximo;
    protected Funcionario[] funcionarios; 

    public void setCodigo(String codigo){this.codigo = codigo;}
    public String getCodigo(){return codigo;}
    public void setNome(String nome){this.nome = nome;}
    public String getNome(){return nome;}
    public void setMaximo(int maximo){this.maximo = maximo;}
    public int getMaximo(){return maximo;}
    public void setNF(int numberfuncionarios){this.numberfuncionarios = numberfuncionarios;}
    public int getNF(){return numberfuncionarios;}
    public void setFuncionarios(Funcionario[] funcionarios){this.funcionarios = funcionarios;}
    public Funcionario[] getFuncionarios(){return funcionarios;}

    public Departamento(String nome, String codigo, int maximo){
        this.codigo = codigo;
        this.nome = nome;
        this.numberfuncionarios = 0;
        this.maximo = maximo;
        this.funcionarios = new Funcionario[maximo];
    }


    public void adicionarFuncionario(Funcionario funcionario){
        if (getNF()==getMaximo()) {
            System.out.println("Maximo de funcionarios cadastrado!!!");
        }

        funcionarios[getNF()] = funcionario.cadastrar();
        numberfuncionarios++;
    }

    public void criarFuncionario(String nome, String codigo,double salario, int tipo, String especifico){
        
        if (tipo == 2) {
            FuncionarioDocente escolhido = new FuncionarioDocente(nome, codigo,salario , especifico);
            adicionarFuncionario(escolhido);
        }else if (tipo == 1) {
            FuncionarioTecnico escolhido2 = new FuncionarioTecnico(nome, codigo, salario, especifico);
            adicionarFuncionario(escolhido2);
        }else{
            System.out.println("Opção Invalida");
        }
    }

    public Funcionario buscar(String procurado){
        int verificador = -1;
        Funcionario achado = new Funcionario(null, null, 0);
        for (int i = 0; i < getNF(); i++) {
            if (procurado.equalsIgnoreCase(funcionarios[i].getNome())) {
                achado = funcionarios[i];
                verificador++;
            }
        }
        if (verificador == 0) {
            System.out.println("Funcionario encotrado");
        }else{
            System.out.println("Funcionario nao encontrado");
        }
        return achado;
    }

    public double calcularGastos(){
        double gasto = 0;
        for (int i = 0; i < getNF(); i++) {
            gasto += funcionarios[i].salario;
        }
        return gasto;
    }

    public void mostrar(){
        String exibir = "   DEPARTAMENTO"
        +"\nNome"+nome
        +"\nCodigo: "+codigo
        +"\nQuantidade de Funcionarios: "+numberfuncionarios;

        System.out.println(exibir);
    }

}
