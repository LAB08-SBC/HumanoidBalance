import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class LocomocaoComFCL
{
   public static double[] calcularAngulo(double angulo, double velocidade) throws Exception 
   {
      // Load from 'FCL' file
      String fileName = "fcl/gorjeta2.fcl";
      FIS fis = FIS.load(fileName, true);
      
      if (fis == null) 
      { // Error while loading
         System.err.println("Can't load file: '" + fileName + "'");
         double[] batata={0,-1982549898};
         return batata;
      }
      // Show variables
      FunctionBlock functionBlock = fis.getFunctionBlock(null);
      //JFuzzyChart.get().chart(functionBlock);
 
      // Set inputs
      functionBlock.setVariable("angulo", angulo);
      functionBlock.setVariable("velocidade",velocidade);
      
      // Evaluate 
      fis.evaluate();
      
      // Show output variables chart
      //Variable anguloSaida = functionBlock.getVariable("anguloSaida");
      double anguloSaida=fis.getVariable("anguloSaida").getValue();
      double velocidadeSaida=fis.getVariable("velocidadeSaida").getValue();
      //JFuzzyChart.get().chart(anguloSaida, anguloSaida.getDefuzzifier(), true);
      //System.out.println("Angulo Saida:" + fis.getVariable("anguloSaida").getValue());
      double retorno[]={anguloSaida,velocidadeSaida};
      return(retorno);
      //Print ruleSet
      //System.out.println("\n====================================\n");
      //System.out.println(fis);
   }
}