import java.io.IOException;
import java.math.BigDecimal;



public class Run2
{
    public static int motors[] = new int[18];
    //public static int initPos[] = {336, 687, 298, 724, 412, 611, 355, 664, 504, 520, 394, 630, 278, 743, 616, 405, 512, 512};
    //public static int posicoes[]={336, 687, 298, 724, 412, 611, 355, 664, 504, 520, 394, 630, 278, 743, 616, 405, 512, 512};
    
    public static int initPos[] = {336, 687, 298, 724, 412, 611, 360, 660, 491, 530, 374, 650, 278, 743, 616, 405, 494, 520};
	public static int posicoes[]={336, 687, 298, 724, 412, 611, 360, 660, 491, 530, 374, 650, 278, 743, 616, 405, 494, 520};
    
    
    public static void initialPos(Bioloid teste) throws InterruptedException {
        //serial();
        
        for (int i=0;i<motors.length;i++){
        	motors[i]=initPos[i];
        	teste.move(i+1,motors[i]);
        	Thread.sleep(400);
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
        	Thread.sleep(400);
        }
    }
	
    public static void main(String[] args) throws InterruptedException {
    	
    	Bioloid Jason = new Bioloid(18);
    	//Thread.sleep(100);
    	
    	//Jason.move(14,394-20);
		//Jason.move(13,625+20);
    	
		//Jason.moveSpeed(13,512,10);
		//Jason.moveSpeed(14,512,10);
		//int batata=100;
    	//Gravador teste = new Gravador("DadosTeste.txt");
    	//teste.escrever("oi");
    	//teste.close();
    	clear(Jason);
    	Thread.sleep(200);
    	initialPos(Jason);
    	
    	//Jason.move(7, initPos[7-1]);
    	//Jason.move(8, initPos[8-1]);
    	
    	//Jason.move(9, 512);
    	//Jason.move(10, 512);
    	
    	//Jason.move(11, 402);
    	//Jason.move(12, 632);
    	
    	//Jason.move(14, 732);
    	//Jason.move(13, 292);
    	
    	//Jason.move(16, 402);
    	//Jason.move(15, 622);
    	
    	//Jason.move(17, 512);
    	//Jason.move(18, 512);
    	
    	//Jason.move(1, 212);
    	//Jason.move(2, 812);
    	//Thread.sleep(1500);
    	
	}
}
