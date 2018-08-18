import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
  
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
  
/**
 * This version of the TwoWaySerialComm example makes use of the
 * SerialPortEventListener to avoid polling.
 *
 */
public class LoopbackTest{
	public static String angulo;
	public static double anguloAtual;
	public static double anguloAnterior;
	public static double velocidadeAngular;
	public static double calibracao =0.0025;
	public static int multiplicador = 1;
	public static String portName;
	
    public LoopbackTest(String portName) {
        super();
        this.portName=portName;
    }
  
    void connect() throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);
  
            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
  
                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();
  
                (new Thread(new SerialWriter(out))).start();
  
                serialPort.addEventListener(new SerialReader(in));
                serialPort.notifyOnDataAvailable(true);
  
            } else {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }
    }
  
    /**
     * Handles the input coming from the serial port. A new line character is
     * treated as the end of a block in this example.
     */
    public static class SerialReader implements SerialPortEventListener {
  
        private final InputStream in;
        private final byte[] buffer = new byte[1024];
  
        public SerialReader(InputStream in) {
            this.in = in;
        }
  
        @Override
        public void serialEvent(SerialPortEvent arg0) {
            int data;
  
            try {
                int len = 0;
                while ((data = in.read()) > -1) {                    
                    if (data == '\n') {
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
                
                //System.out.print(new String(buffer, 0, len));
                angulo = new String(buffer, 0, len);
                double anguloDouble = Double.parseDouble(angulo);
                anguloAtual=anguloDouble;
                //System.out.println(anguloDouble);
                
                while ((data = in.read()) > -1) {                    
                    if (data == '\n') {
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
                
                //System.out.print(new String(buffer, 0, len));
                angulo = new String(buffer, 0, len);
                anguloDouble = Double.parseDouble(angulo);
                anguloAtual=anguloDouble;
                //System.out.println(anguloDouble);
                
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
  
    public static class SerialWriter implements Runnable {
  
        private final OutputStream out;
  
        public SerialWriter(OutputStream out) {
            this.out = out;
        }
  
        @Override
        public void run() {
            try {
                int c;
                while ((c = System.in.read()) > -1) {                    
                    this.out.write(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
      }
  
   // public static void main(String[] args) {
        //try {
         //   (new LoopbackTest()).connect("/dev/ttyACM1");
       // } catch (Exception e) {
            // TODO Auto-generated catch block
         //   e.printStackTrace();
        //}
    //}
}