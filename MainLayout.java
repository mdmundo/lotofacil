import java.io.IOException;

public class MainLayout {
	
	public static void main(String[] args) throws IOException {
		Endereco e = new Endereco();
		LerArquivo l = new LerArquivo();
		LayoutMatrizInicial J = new LayoutMatrizInicial();
		J.JanelaP(l.dados(e.GetEndereco()));
	}
}
