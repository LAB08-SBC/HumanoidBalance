import java.io.IOException;
import java.math.BigDecimal;



public class LocomocaoTeste
{
	public static Bioloid Jason;
    public static int motors[] = new int[18];
    //public static int initPos[] = {336, 687, 298, 724, 412, 611, 360, 660, 491, 530, 394, 630, 278, 743, 616, 405, 494, 520};
   	//public static int posicoes[]={336, 687, 298, 724, 412, 611, 360, 660, 491, 530, 394, 630, 278, 743, 616, 405, 494, 520};
    public static int initPos[] = {336, 687, 298, 724, 412, 611, 360, 660, 491, 530, 374, 650, 278, 743, 616, 405, 494, 520};
   	public static int posicoes[]={336, 687, 298, 724, 412, 611, 360, 660, 491, 530, 374, 650, 278, 743, 616, 405, 494, 520};
       
        
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
    
    static double anguloAtual=0;
    static double anguloAntes=LoopbackTest.anguloAtualX;
    static double velocidade;
    static double anguloSaida;
    static double auxiliar=999999999;
    static int contador=0;
    static int batata=0;
    static boolean teste=true;
    static long tempoAnterior=System.nanoTime()/1000000;
    static long tempoAtual;
    static double coeficiente;
    static long tempoAtual2;
    static long coeficiente2;
    static double anguloPadrao=LoopbackTest.anguloAtualX;
    static double saidas[];
	
    public static void main(String[] args) throws InterruptedException {
    	
    	Jason = new Bioloid(18);
    	LoopbackTest sensores = new LoopbackTest("/dev/ttyACM0"); 
    	try {
			sensores.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	for(int i=0;i<300;i++)
        	anguloPadrao =LoopbackTest.anguloAtualX;
    	
    	System.out.println(anguloPadrao);
    	Gravador gravador = new Gravador("DadosTeste.txt");
    	int contador2=0;
    	
    	while(teste){
		    Thread.sleep(100);
		    anguloAtual =LoopbackTest.anguloAtualX;
		    velocidade = anguloAtual-anguloAntes;
		    System.out.println("velocidade: " + Math.abs(velocidade));
		    System.out.println("Angulo: " + LoopbackTest.anguloAtualX);
		    
		   
		    BigDecimal i = new BigDecimal(1.00);
		    Jason.move( 9, initPos[9-1]); 
		    Thread.sleep(20);
	    	Jason.move(10, initPos[10-1]); 
	    	Thread.sleep(20);
	    	Jason.move(11, initPos[11-1]);
	    	Thread.sleep(20);
	    	Jason.move(13, initPos[13-1]);
	    	Thread.sleep(20);
	    	Jason.move(14, initPos[14-1]);
	    	Thread.sleep(20);
	    	Jason.move(15, initPos[15-1]); 
	    	Thread.sleep(20);
	    	Jason.move(16, initPos[16-1]);  
	    	Thread.sleep(20);
	    	Jason.move(17, initPos[17-1]);
	    	Thread.sleep(20);
	    	Jason.move(18, initPos[18-1]);
	    	Thread.sleep(20);
	    	
		    while (i.doubleValue()<14.7){
    			
		    	posicoes[9-1] = (int)(-0.000275921606029018*(Math.pow(i.doubleValue(),6))+0.0224866058355711*(Math.pow(i.doubleValue(),5))-0.554002659792176*(Math.pow(i.doubleValue(),4))+5.27359561063168*(Math.pow(i.doubleValue(),3))-16.6250714681205*(Math.pow(i.doubleValue(),2))+1.07731363098685*i.doubleValue()+492.577239841013);
		    	posicoes[10-1] = (int)(-0.000140124106979082*(Math.pow(i.doubleValue(),6))+0.00957747098059501*(Math.pow(i.doubleValue(),5))-0.17601617035749*(Math.pow(i.doubleValue(),4))+0.366976848153587*(Math.pow(i.doubleValue(),3))+13.7934195723444*(Math.pow(i.doubleValue(),2))-82.4753256531787*i.doubleValue()+597.355314009854);
		    	//posicoes[11-1] = (int)(0.00000140489885303541*(Math.pow(i.doubleValue(),12))-0.000137098037479588*(Math.pow(i.doubleValue(),11))+0.00593962266650624*(Math.pow(i.doubleValue(),10))-0.150467310047963*(Math.pow(i.doubleValue(),9))+2.47028882826084*(Math.pow(i.doubleValue(),8))-27.5207922276621*(Math.pow(i.doubleValue(),7))+211.699439008591*(Math.pow(i.doubleValue(),6))-1121.79501433143*(Math.pow(i.doubleValue(),5))+4012.95422656784*(Math.pow(i.doubleValue(),4))-9303.65422686671*(Math.pow(i.doubleValue(),3))+13044.0770540131*(Math.pow(i.doubleValue(),2))-9823.0075743571*i.doubleValue()+3401.38059312374);
		    	//posicoes[12-1] = (int)(0.00000011672084327608*(Math.pow(i.doubleValue(),14))-0.000012662080312946*(Math.pow(i.doubleValue(),13))+0.000615851466539234*(Math.pow(i.doubleValue(),12))-0.017737457506048*(Math.pow(i.doubleValue(),11))+0.336649535916704*(Math.pow(i.doubleValue(),10))-4.43504476680317*(Math.pow(i.doubleValue(),9))+41.6304852819428*(Math.pow(i.doubleValue(),8))-281.48687768283*(Math.pow(i.doubleValue(),7))+1370.97665082275*(Math.pow(i.doubleValue(),6))-4763.85605618472*(Math.pow(i.doubleValue(),5))+11574.9816970237*(Math.pow(i.doubleValue(),4))-18997.7828225834*(Math.pow(i.doubleValue(),3))+19842.4241425091*(Math.pow(i.doubleValue(),2))-11754.8617513084*i.doubleValue()+3597.71125928176);
		    	posicoes[13-1] = (int)(-0.0000148141287899076*(Math.pow(i.doubleValue(),10))+0.00119700195674767*(Math.pow(i.doubleValue(),9))-0.0415853177723568*(Math.pow(i.doubleValue(),8))+0.813243772863493*(Math.pow(i.doubleValue(),7))-9.8518102730438*(Math.pow(i.doubleValue(),6))+76.7204688187178*(Math.pow(i.doubleValue(),5))-385.724100593995*(Math.pow(i.doubleValue(),4))+1221.58291298422*(Math.pow(i.doubleValue(),3))-2295.15666871898*(Math.pow(i.doubleValue(),2))+2304.35552800843*i.doubleValue()-643.058578051134);
		    	posicoes[14-1]= (int)(0.00000083846544852191*(Math.pow(i.doubleValue(),10))-0.00000812251364211665*(Math.pow(i.doubleValue(),9))-0.00194976423616432*(Math.pow(i.doubleValue(),8))+0.0861933684303852*(Math.pow(i.doubleValue(),7))-1.69603346375747*(Math.pow(i.doubleValue(),6))+18.9297051399361*(Math.pow(i.doubleValue(),5))-127.429816133823*(Math.pow(i.doubleValue(),4))+517.304913254853*(Math.pow(i.doubleValue(),3))-1215.69884225685*(Math.pow(i.doubleValue(),2))+1501.00777573452*i.doubleValue()+34.6214069610031);
		    	posicoes[15-1] = (int)(0.0000217898674376092*(Math.pow(i.doubleValue(),10))-0.00168504911464163*(Math.pow(i.doubleValue(),9))+0.0556171425516435*(Math.pow(i.doubleValue(),8))-1.02212510842425*(Math.pow(i.doubleValue(),7))+11.4361911769592*(Math.pow(i.doubleValue(),6))-79.9218400189809*(Math.pow(i.doubleValue(),5))+343.33892677256*(Math.pow(i.doubleValue(),4))-852.044744171629*(Math.pow(i.doubleValue(),3))+1066.9698822212*(Math.pow(i.doubleValue(),2))-535.985198422995*i.doubleValue()+651.394169313619);
		    	posicoes[16-1] = (int)(0.0000248742798796263*(Math.pow(i.doubleValue(),10))-0.00191083364372945*(Math.pow(i.doubleValue(),9))+0.0626362655558014*(Math.pow(i.doubleValue(),8))-1.1448672116933*(Math.pow(i.doubleValue(),7))+12.8113562500397*(Math.pow(i.doubleValue(),6))-90.8916292359355*(Math.pow(i.doubleValue(),5))+410.536161792987*(Math.pow(i.doubleValue(),4))-1157.63710507665*(Math.pow(i.doubleValue(),3))+1944.09966170448*(Math.pow(i.doubleValue(),2))-1764.8116655254*i.doubleValue()+1056.68768177018);
		    	posicoes[17-1] = (int)(-0.000602821242505626*(Math.pow(i.doubleValue(),6))+0.0405315649727053*(Math.pow(i.doubleValue(),5))-0.916931723020958 *(Math.pow(i.doubleValue(),4))+8.3576698861698*(Math.pow(i.doubleValue(),3))-25.507120415259*(Math.pow(i.doubleValue(),2))-1.29495830014807*i.doubleValue()+497.088587623408);
		    	posicoes[18-1] = (int)(-0.00021958932773343*(Math.pow(i.doubleValue(),6))+0.0135980370756124*(Math.pow(i.doubleValue(),5))-0.239784506804081 *(Math.pow(i.doubleValue(),4))+0.466436883005924*(Math.pow(i.doubleValue(),3))+18.9979103475509*(Math.pow(i.doubleValue(),2))-113.421209371814*i.doubleValue()+620.07665583061);
		    	
		    	Jason.move( 9, posicoes[9-1]);
		    	arrumar();
		    	
		    	Jason.move(10, posicoes[10-1]); 
		    	arrumar();
		    	
		    	//Jason.move(11, posicoes[11-1]);
		    	//Jason.move(12, posicoes[12-1]);
		    	Jason.move(13, posicoes[13-1]);
		    	arrumar();
		    
		    	Jason.move(14, posicoes[14-1]); 
		    	arrumar();
		    	
		    	Jason.move(15, posicoes[15-1]); 
		    	arrumar();
		    	
		    	Jason.move(16, posicoes[16-1]); 
		    	arrumar();
		    	
		    	Jason.move(17, posicoes[17-1]);
		    	arrumar();
		    	
		    	Jason.move(18, posicoes[18-1]);
		    	arrumar();
		    	
		    	Thread.sleep(50);
		    	gravador.escrever(LoopbackTest.anguloAtualX);
				gravador.escrever(" ");
			    if(contador2==300){
			    	gravador.close();
			    	teste=false;
			    }
			    contador2++;
		    	BigDecimal result = i.add(new BigDecimal(0.1));
		    	i = result;
		    	
		    	
		    	System.out.println(i.doubleValue());
		    	
		    	
			    anguloAntes=anguloAtual;
			    }
    	}
    	
    }
    public static void arrumar(){
    	try{
    			int counter=0;
	    	//if(Math.abs(anguloPadrao-LoopbackTest.anguloAtual)>3){
	    		while(Math.abs(anguloPadrao-LoopbackTest.anguloAtualX)>4){
	    			saidas=LocomocaoComFCL.calcularAngulo(LoopbackTest.anguloAtualX, velocidade);
	    			batata=(int)Math.round(saidas[0]);
	    			System.out.println(LoopbackTest.anguloAtualX);
	    			if(auxiliar==999999999){
	    				auxiliar=batata;
	    			}
	    			if(batata==0)
	    				counter++;
	    			if(counter==5){
	    				counter=0;
	    				break;
	    			}
	    			System.out.println("Angulo Saida: " + batata + " Velocidade Saida: " + saidas[1]);
	    			tempoAtual=System.nanoTime()/1000000;
	    			coeficiente=tempoAtual-tempoAnterior;
	    			//contador++;
	    			//if(contador>4)
	    			//teste=false;
		    	
		    		mover(batata, saidas[1]);
		    		System.out.println("-------------------------------------------");
		    		System.out.println("---------------mexeu o motor---------------");
		    		System.out.println("-------------------------------------------");
		    		auxiliar=batata;
		    		//teste=false
	    		}
	    		//else{
	    			//tempoAtual2=System.nanoTime()/1000000;
	    			//coeficiente2=tempoAtual2-tempoAnterior;
	    			//if(Math.abs(anguloPadrao-LoopbackTest.anguloAtual)<4 && coeficiente2/3000>1){
	    				//posicoes[12-1]= initPos[12-1];
	    				//posicoes[11-1]= initPos[11-1];
	    				//Jason.move(11, posicoes[11-1]);
	    				//Jason.move(12, posicoes[12-1]);
	    				//coeficiente2--;
	    			//}
	    		//}
	    		//}
	    }catch(Exception e){
	    	System.out.println(e);
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
    			Thread.sleep(100);
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
    			Thread.sleep(100);
    		}
    	}



    	

    	
    }
}
