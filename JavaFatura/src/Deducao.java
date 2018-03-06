import java.io.IOException;
import java.util.Scanner;

public class Deducao {

	public static void menuCliente(Model model) throws IOException {
		
		Scanner input = new Scanner (System.in);
		int caso = input.nextInt();
		
		switch(caso) { 
     	//Sai do menu de logIn cliente para o principal 
     	case 0: { 
            System.out.println("Saida do menu cliente com sucesso"); 
     		Controller.guardaModel(model);
             break;
         }
         
         //Efetuar logIn Cliente 
         case 1: {
             
        	 	Cliente cliente;
        	 	int nif;
             String password = new String();
             
             System.out.print("Insira o seu nif: ");
             nif = input.nextInt();
             
             System.out.print("Insira a Palavra-Passe: ");
             password = input.next();
             
             //verifica se os dados do cliente estão registados
             cliente = Controller.logInCliente(nif,password,model);
             if(cliente==null) {
                 System.out.println ("Cliente não existe ou nif/palavra-passe incorretos. Tente outra vez");
             }
             else
             {
                 View.loginC(nif,model);
                 caso=-1;
             }
             break;
         }
         
         // Registar um novo cliente 
         case 2: {
             Controller.RegistarCliente(model);
             break;
         }    
     }
     
 }

	}

