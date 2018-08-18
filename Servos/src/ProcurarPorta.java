import gnu.io.CommPortIdentifier;
import java.util.Enumeration;
  
public class ProcurarPorta {
    public static void main(String[] args) {
          
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
  
        while (portList.hasMoreElements()) {
            CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println(portId.getName());
            }
        }
    }
}