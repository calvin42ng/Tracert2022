package test01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class TracertUtil {
	
	String runIP = "";
	
    String tracert = "tracert -d";	// 模拟tracert命令
    List<String> list = new ArrayList();

    /**
	 * tracert命令运行并输出结果
	 * @param ip
	 */
    public void Tracert(String ip, String maxnum, String overtime) {
    	
    	runIP = ip;
    	
    	// 最大跃点数
        if (!"".equals(maxnum)) {
        	tracert = tracert + " -h " + maxnum;
        }
        // 超时时间
        if (!"".equals(overtime)) {
        	tracert = tracert + " -w " + maxnum;
        }
        tracert = tracert + " " + ip;
        System.out.println("Tracing route to: " + tracert);
        try {
            command(tracert);	// 执行tracert命令
            list.remove(0);		// 删除结果中的第一行空行
            
            // 输出结果
//            for (String s:list) {      
//            	System.out.println(s);	//输出cmd的内容
//            }
            
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 执行 tracert 命令 
     * @param tracerCommand
     * @return
     * @throws IOException
     */
    private void command(String tracerCommand) throws IOException{ 
        // 通过Runtime类的getRuntime().exec()传入需要运行的命令参数
        Process process = Runtime.getRuntime().exec(tracerCommand);
        // 读取命令执行结果
        readResult(process.getInputStream());
        process.destroy();
    }

    /**
     * 通过输入流来将命令执行结果赋值给list
     * @param inputStream
     * @return
     * @throws IOException
     */

    public static String finalResult = "";
    
    
    private void readResult(InputStream inputStream) throws IOException{
        String commandInfo = null;		// 定义用于接收命令行执行结果的字符串
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ( (commandInfo = bufferedReader.readLine()) != null)  {
            list.add(commandInfo);	// 将运行结果添加到 list 中
        }
        bufferedReader.close();
        
        
        Object[] listData = list.toArray();
        String finalResult2 = "";
        for (int i = 3; i<list.size()-2; i++) {
        	String[] updateSplit = ((String) listData[i]).split("[\\s]+"); //正则表达去除空格split
        	for(int j = 8; j < updateSplit.length; j++) {
        		finalResult2 = finalResult2 + updateSplit[j] + "/";
        		//System.out.print(updateSplit[j]+"/");
        		 
        	}
        	
        	//System.out.println(finalResult);
//            for (String retval: ((String) listData[i]).split("[\\s]+")){
//                System.out.println(retval);
//            } 	
        	//System.out.println("转换数组迭代输出：" + i + " " + "is :" + listData[i]);
        }
        //System.out.println(finalResult2);
        finalResult = finalResult2;
        
        String strTemp[] = finalResult.split("[\\.\\/]");
        for(int i = 0; i < strTemp.length; i++) {  //用0向左补齐三位数
        	strTemp[i] = String.format("%3s" , strTemp[i]);
        	strTemp[i] = strTemp[i].replaceAll("\\s", "0");
        	//System.out.println(strTemp[i]);
        }
        
        String strTempIp[] = runIP.split("[\\.\\/]");
        for(int i = 0; i < strTempIp.length; i++) {  //用0向左补齐三位数
        	strTempIp[i] = String.format("%3s" , strTempIp[i]);
        	strTempIp[i] = strTempIp[i].replaceAll("\\s", "0");
        	//System.out.println(strTempIp[i]);
        }        
        
        
        
        
        String strTemp2 = "";
        for(int i = 12; i < strTemp.length; i++) {
        	if (i == 12) strTemp2 = strTemp[i];   	
        	if(i%4 != 0) strTemp2 = strTemp2 + "." + strTemp[i];     	
        	if (i!= 12 && i%4 == 0) strTemp2 = strTemp2 + "/" + strTemp[i];		
        }
        
        for(int i = 0; i < strTempIp.length; i++) {
        	if(i == 0) strTemp2 = strTemp2 + "/" + strTempIp[i];
        	else{
	        	strTemp2 = strTemp2 + "." + strTempIp[i];
	        }
        	
        }
        finalResult = strTemp2;
    }


    public static void main(String[] args) {
    	test01.WarnIp ip = new test01.WarnIp();
    	String newIP = ip.getIP();
    	TracertUtil util = new TracertUtil();
    	util.Tracert(newIP, "20", "10");
    	//pdSentIP();
    	
	}  
 
	public static String pdSentIP() {
		//System.out.println(finalResult);
		return finalResult;	
	}     
    
}
