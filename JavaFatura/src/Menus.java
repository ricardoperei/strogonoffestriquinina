
public class Menus {

	protected static void menuPrincipal() {
		
		System.out.println("Bem vindo a Java Fatura\n\n");
		
		System.out.println("1 - Contribuinte Individual");
		System.out.println("2 - Empresa");
		System.out.println("\n0 - Sair");
	
	}
	
	protected static void menu2cliente() {
		System.out.println("1 - Entrar");
		System.out.println("2 - Registar novo cliente");
		
		System.out.println("0 - Voltar atrás");

	}
	
	protected static void menu2empresa() {
		System.out.println("1 - Entrar");
		System.out.println("2 - Registar nova empresa");
		
		System.out.println("0 - Voltar atrás");

	}
	
	@SuppressWarnings("unused")
	protected static void menuCliente() {
		
		System.out.println("Java Fatura\n\n");
		
		System.out.println("1 - Editar perfil"); //Não será possivel editar NIF
		System.out.println("2 - Faturas por validar");
		System.out.println("3 - Editar Agregado");
		System.out.println("4 - Consultar faturas");
		System.out.println("5 - Cálculo Deduções");
		System.out.println("6 - Ver perfil"); // consta toda a informação pessoal mais o agregado familiar se tiver
		System.out.println("\n0 - Sair");
	
	}
	protected static void menuClienteAltDados() {
		System.out.println("Qual a informação que quer alterar");
		System.out.println("1 - Nome");
		System.out.println("2 - Password");
		System.out.println("3 - Morada");
		System.out.println("4 - Agregado Familiar");
		System.out.println("5 - Coeficiente");
		System.out.println("0 - Voltar atrás");

	}
	protected static void menuTipoAtividade() {
		System.out.println("Qual o setor de Atividade:");
		System.out.println("1 - Saude");
		System.out.println("2 - Alimentação");
		System.out.println("3 - Restauração");
		System.out.println("4 - Educação");
		System.out.println("5 - Hotelaria");
		System.out.println("6 - Bens essenciais");
		System.out.println("7 - Transportes");
		System.out.println("8 - Outros");
		

	}
	protected static void menuCliente3() {
		System.out.println("1 - Inserir pessoa ao agregado");
		System.out.println("2 - Eliminar pessoa do meu agregado");
		
		System.out.println("0 - Voltar atrás");

	}
	protected static void menuCliente4() {
		System.out.println("1 - Consultar faturas por Valor");
		System.out.println("2 - Consultar faturas por Empresa");
		System.out.println("3 - Consultar faturas entre Datas");
		
		System.out.println("0 - Voltar atrás");

	}
	protected static void menuCliente6() {
		System.out.println("Informação do cliente:");
		
		System.out.println("0 - Voltar atrás");

	}
	
	@SuppressWarnings("unused")
	protected static void menuEmpresa() {
		
		System.out.println("Java Fatura\n\n");
		
		System.out.println("1 - Editar perfil"); //Não será possivel editar NIF
		System.out.println("2 - Emitir fatura");
		System.out.println("3 - Calcular dedução Cliente"); //Cálculo feito individualmente a cada cliente
		System.out.println("4 - Consultar faturas"); //Faturas por valor, por cliente ou entre datas
		System.out.println("5 - Ver perfil");
		System.out.println("\n0 - Sair");
	
	}
	
	protected static void menuEmpresaAltDados() {
		System.out.println("Qual a informação que quer alterar");
		System.out.println("1 - Email");
		System.out.println("2 - Password");
		System.out.println("3 - Morada");
		System.out.println("0 - Voltar atrás");
	}
	
	protected static void menuFatura() {
		System.out.println("Emitir fatura");
		System.out.println("Insira o nif");
		System.out.println("Inserir valor");
		System.out.println("Inserir setor de atividade");
		System.out.println("Deseja inserir mais produtos? (S/N)");
		
		System.out.println("0 - Voltar atrás");

	}
	protected static void menuEmpresa4() {
		System.out.println("1 - Consultar faturas por Valor");
		System.out.println("2 - Consultar faturas por Cliente");
		System.out.println("3 - Consultar faturas entre Datas");
		
		System.out.println("0 - Voltar atrás");

	}
	protected static void menuEmpresa5() {
		System.out.println("Informação da empresa:");
		
		System.out.println("0 - Voltar atrás");

	}

	@SuppressWarnings("unused")
	private static void menuAdmin() {
		System.out.println("1 - Eliminar Cliente");
		System.out.println("2 - Editar Cliente");
		System.out.println("3 - Ver faturação de Cliente");
		System.out.println("4 - Eliminar Empresa");
		System.out.println("5 - Editar Empresa");
		System.out.println("6 - Ver faturação de Empresa");
		System.out.println("0 - Voltar atrás");

		}
	
}

