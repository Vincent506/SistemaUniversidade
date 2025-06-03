import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        Funcionario escudo = new Funcionario(null, null, 0);
        List<Funcionario> testes = new ArrayList<>();
        escudo = escudo.cadastrar();
        testes.add(escudo);
        escudo = escudo.cadastrar();
        testes.add(escudo);
        escudo = escudo.cadastrar();
        testes.add(escudo);
        escudo.listar(testes);

        

        escudo.buscar(testes);
    }
}
