package model;


public class Universidade{
   protected String nome;
   protected int maximo;
   protected Departamento[] departamentos;
   protected int numberDepartamento;

   public void setNome(String nome){this.nome = nome;}
   public String getNome(){return nome;}
   public void setMaximo(int maximo){this.maximo = maximo;}
   public int getMaximo(){return maximo;}
   public void setDepartamento(Departamento[] departamento){this.departamentos = departamento;}
   public Departamento[] getDepartamentos(){return departamentos;}
   public void setND(int numberDepartamento){this.numberDepartamento = numberDepartamento;}
   public int getND(){return numberDepartamento;}

   public Universidade(String nome, int maximo){
        this.nome = nome;
        this.maximo = maximo;
        this.departamentos = new Departamento[maximo];
        this.numberDepartamento = 0;
   }

   public void addDepartamento(Departamento nova){
      if (numberDepartamento == maximo) {
         System.out.println("Numero maximo de departamentos atingido!!!");
      }else{
         this.departamentos[numberDepartamento] = nova;
         this.numberDepartamento++;
      }
   }

   public void criaDepartamento(String nome, String codigo, int maximo){
      Departamento novoDepartamento = new Departamento(nome, codigo, maximo);
      addDepartamento(novoDepartamento);
   }

   public boolean verificador(String nome){
      boolean sim = false;
      for (int i = 0; i < numberDepartamento; i++) {
         if (departamentos[i].getNome().equalsIgnoreCase(nome)) {
            sim = true;
         }
      }
      return sim;
   }
    
   public Departamento buscar(String procurado){
      int verif = -1;
      Departamento achado = new Departamento(null, null, 0); 
      for (int i = 0; i < numberDepartamento; i++) {
         if (departamentos[i].getNome().equalsIgnoreCase(procurado)) {
            achado = departamentos[i];
            verif++;
         }
      }

      if (verif == 0) {
         System.out.println("Departamento Encontrado");
      }else{
         System.out.println("Departamento inexistente.");
      }
      return achado;
   }
   
    
}
