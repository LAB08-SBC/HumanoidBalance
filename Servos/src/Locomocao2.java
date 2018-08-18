import java.io.IOException;
import java.math.BigDecimal;



public class Locomocao2
{
    public static int motors[] = new int[18];
    //public static int initPos[] = {336, 687, 298, 724, 412, 611, 355, 664, 504, 520, 394, 630, 278, 743, 616, 405, 512, 512};
    //public static int posicoes[]={336, 687, 298, 724, 412, 611, 355, 664, 504, 520, 394, 630, 278, 743, 616, 405, 512, 512};
    
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
    	
    	Bioloid Jason = new Bioloid(18);
    	//Thread.sleep(100);
    	Thread.sleep(1000);
    	posicoes[11-1]-=60;
    	posicoes[12-1]+=60;
    	posicoes[13-1]-=40;
    	posicoes[14-1]+=40;
    	Jason.move(11, posicoes[11-1]);
    	Jason.move(13, posicoes[13-1]);
    	Jason.move(12, posicoes[12-1]);
    	Jason.move(14, posicoes[14-1]);
    	Jason.move(15, posicoes[15-1]);
    	Jason.move(16, posicoes[16-1]);
    	Thread.sleep(1000);

    	posicoes[9-1]+=30;
    	posicoes[10-1]+=30;
    	Jason.move(9, posicoes[9-1]);
    	Jason.move(10, posicoes[10-1]);
    	Thread.sleep(1000);
    	
    	posicoes[13-1]+=20;
    	posicoes[15-1]+=20;
    	Jason.move(13, posicoes[13-1]);
    	Jason.move(15, posicoes[15-1]);
    	Thread.sleep(1000);
    	
    	posicoes[14-1]+=20;
    	Jason.move(14, posicoes[14-1]);
    	Thread.sleep(1000);
    	
    	posicoes[12-1]+=60;
    	Jason.move(12, posicoes[12-1]);
    	Thread.sleep(1000);
    	/*
    	posicoes[14-1]-=70;
    	Jason.move(14, posicoes[14-1]);
    	posicoes[16-1]+=70;
    	Jason.move(16, posicoes[16-1]);
    	Thread.sleep(1000);*/
    	
    	
	}
}