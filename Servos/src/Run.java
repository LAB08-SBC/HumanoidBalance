import java.io.IOException;
import java.math.BigDecimal;

import org.jfree.data.category.DefaultCategoryDataset;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;



public class Run
{
	public static Bioloid Jason;
    public static int motors[] = new int[18];
    public static int initPos[] = {336, 687, 298, 724, 412, 611, 360, 660, 491, 530, 394, 630, 278, 743, 616, 405, 494, 520};
   	public static int posicoes[]={336, 687, 298, 724, 412, 611, 360, 660, 491, 530, 394, 630, 278, 743, 616, 405, 494, 520};
       
       
	public static void initialPos(Bioloid teste) throws InterruptedException {
        //serial();
        
        for (int i=0;i<motors.length;i++){
        	motors[i]=initPos[i];
        	teste.move(i+1,motors[i]);
        	Thread.sleep(1000);
        }
    }
    
    public static void clear(Bioloid teste) throws InterruptedException {
        //serial();
        
        for(int i=0;i<(motors.length);i++){
        	motors[i] = 512;	
        		if(i==(7-1))
        			motors[i] = 361;
        		if(i==(8-1))
        			motors[i] = 663;
        	teste.move(i+1,motors[i]);
        	Thread.sleep(1000);
        }
    }
	
    public static void main(String[] args) throws InterruptedException {
    	
    	Jason = new Bioloid(18);
    	LoopbackTest sensores = new LoopbackTest("/dev/ttyACM0"); 
    	try {
			sensores.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
   
    	double anguloAtual=0;
    	double anguloAntes=LoopbackTest.anguloAtualY;
    	double velocidade;
    	double anguloSaida;
    	double auxiliar=999999999;
    	int contador=0;
    	int batata=0;
    	boolean teste=true;
    	long tempoAnterior=System.nanoTime()/1000000;
    	long tempoAtual;
    	double coeficiente;
    	long tempoAtual2;
    	long coeficiente2;
    	double anguloPadrao=LoopbackTest.anguloAtualY;
    	
    	for(int i=0;i<300;i++)
	    	anguloPadrao =LoopbackTest.anguloAtualY;
    	
    	double saidas[];
    	
    	System.out.println(anguloPadrao);
//    	Gravador gravador = new Gravador("DadosTeste.txt");
//    	int contador2=0;
    	while(teste){
		    Thread.sleep(100);
		    anguloAtual =LoopbackTest.anguloAtualY;
		    velocidade = anguloAtual-anguloAntes;
		    System.out.println("velocidade: " + Math.abs(velocidade));
		    System.out.println("Angulo: " + LoopbackTest.anguloAtualY);
		    
//		    gravador.escrever(LoopbackTest.anguloAtual);
//		    gravador.escrever(" ");
//	    	if(contador2==100){
//	    		gravador.close();
//	    		teste=false;
//    		}
//	    	
//	    	contador2++;
		    try{
		    	if(Math.abs(anguloPadrao-LoopbackTest.anguloAtualY)>4){
		    		saidas=GorjetaComFCL.calcularAngulo(LoopbackTest.anguloAtualY, velocidade);
		    		batata=(int)Math.round(saidas[0]);
		    		if(auxiliar==999999999){
			    		auxiliar=batata;
			    	}
			    	
			    	System.out.println("Angulo Saida: " + batata + " Velocidade Saida: " + saidas[1]);
			    	tempoAtual=System.nanoTime()/1000000;
			    	coeficiente=tempoAtual-tempoAnterior;
//			    	contador++;
//			    	if(contador>4)
//		    			teste=false;
			    	System.out.println(coeficiente);
			    	if(coeficiente/400>1){
			    		tempoAnterior=tempoAtual;
			    		//mover(batata, saidas[1]);
			    		System.out.println("-------------------------------------------");
			    		System.out.println("---------------mexeu o motor---------------");
			    		System.out.println("-------------------------------------------");
			    		auxiliar=batata;
			    		//teste=false;
			    	}
		    	}
		    	else{
		    		tempoAtual2=System.nanoTime()/1000000;
		    		coeficiente2=tempoAtual2-tempoAnterior;
		    		if(Math.abs(anguloPadrao-LoopbackTest.anguloAtualY)<4 && coeficiente2/3000>1){
		    		posicoes[12-1]= initPos[12-1];
		    		posicoes[11-1]= initPos[11-1];
		    		Jason.move(11, posicoes[11-1]);
		    		Jason.move(12, posicoes[12-1]);
		    		coeficiente2--;
		    		}
		    	}
		    }catch(Exception e){
		    	System.out.println(e);
		    }
	    	anguloAntes=anguloAtual;
    	}
    }
    
    public static void mover(int anguloMovimento, double velocidade) throws InterruptedException{
    	
    	if(anguloMovimento>0){
    		double movimentoAuxiliar1=posicoes[11-1];
        	double movimentoAuxiliar2=posicoes[12-1];
        	for(double i=0;i<Math.abs(anguloMovimento);i+=velocidade){
        		movimentoAuxiliar1+=velocidade;
        		movimentoAuxiliar2-=velocidade;
    			posicoes[11-1]=(int)movimentoAuxiliar1;
    			posicoes[12-1]=(int)movimentoAuxiliar2;
    			Jason.move(11,(int)posicoes[11-1]);
    			Thread.sleep(5);
    			Jason.move(12,(int)posicoes[12-1]);
    			Thread.sleep(5);
    			System.out.println(posicoes[11-1] + " " +posicoes[12-1]);
    		}
    	}
    	
    	else if (anguloMovimento<0){
    		double movimentoAuxiliar1=posicoes[11-1];
        	double movimentoAuxiliar2=posicoes[12-1];
        	for(double i=0;i<Math.abs(anguloMovimento);i+=velocidade){
        		movimentoAuxiliar1-=velocidade;
        		movimentoAuxiliar2+=velocidade;
    			posicoes[11-1]=(int)movimentoAuxiliar1;
    			posicoes[12-1]=(int)movimentoAuxiliar2;
    			Jason.move(11,(int)posicoes[11-1]);
    			Thread.sleep(5);
    			Jason.move(12,(int)posicoes[12-1]);
    			Thread.sleep(5);
    			System.out.println(posicoes[11-1] + " " +posicoes[12-1]);
    		}
    	}



    	

    	
    }
}
