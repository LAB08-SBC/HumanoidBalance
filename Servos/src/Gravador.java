import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Gravador {

		private BufferedWriter gravador;
		private PrintWriter escritor;
		
		public Gravador(String nome){
			try{
				gravador = new BufferedWriter(new FileWriter(nome,false));
				escritor = new PrintWriter(gravador);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		public void escrever(int texto){
			escritor.print(texto);
		}
		
		public void escrever(String texto){
			escritor.print(texto);
		}
		
		public void escrever(double texto){
			escritor.print(texto);
		}
			
		public void pularLinha(){
			escritor.println("");
		}
		
		public void close(){
			escritor.close();
		}
		
}
