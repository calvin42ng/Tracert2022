package test01;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendDemo {

	public static void main(String[] args) throws Exception {
	    TracertUtil.main(args); //先运行TracertUtil.java获取字符串
	    //Thread.sleep(10000);
    	test01.TracertUtil ipcontent = new test01.TracertUtil();
    	String pdcontent = ipcontent.pdSentIP();
    	System.out.println(pdcontent);		
		
        //System.out.println("-----启动客户端------");
        //1.创建发送端对象：发送端自带默认端口号
        DatagramSocket socket = new DatagramSocket(2222);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("- Please press 'ENTER' to continue （input any other characters to exit） -");
            String msg = sc.nextLine();
            
            if("".equals(msg)) {
            	
                //2.创建一个数据包对象封装数据
                byte[] buffer = pdcontent.getBytes();
                DatagramPacket packet = new DatagramPacket( buffer,buffer.length, InetAddress.getLocalHost(),3333);
     
                //3.发送数据出去
                socket.send(packet);
                System.out.println("//SEND SUCCESSFULLY");
            	
            }

 
            else{   //if ("exit".equals(msg))
                System.out.println("//EXIT SUCCESSFULLY");
                socket.close();
                break;
            }
 

        }
    }


}
