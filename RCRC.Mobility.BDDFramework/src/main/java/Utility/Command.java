package Utility;
import java.io.IOException;

public class Command {
private static Runtime runtime = Runtime.getRuntime();
  public static String  PROJECT_PATH=System.getProperty("user.dir"); 
  public static String STANDALONE_SERVER_PATH="\\JAR\\selenium-server-standalone-3.13.0.jar";
    private Command() {

    }

    public static void execCommand(String command) throws IOException, InterruptedException {
//    	To make selenium server act as node, we first need to have
//    	Address  of the hub(including port number)
//    	need to assign the role
      //String cmd="java -jar selenium-server-standalone-2.46.0.jar -role Webdriver -hub 	http://192.168.1.11:4444/grid/regiser -port 5557";
      //java -jar selenium-server-standalone-2.52.0.jar -role hub -hubConfig GridHub.json
     //java -jar selenium-server-standalone-2.52.0.jar -role node -Dwebdriver.chrome.driver="D:/chromedriver.exe" -nodeConfig GridNode.json
    	String cmd = "java -jar "+PROJECT_PATH + STANDALONE_SERVER_PATH+ " -role hub -hubConfig " + PROJECT_PATH +"/hubConfig.json";
        System.out.println("Command generated-----" +command);
        Process process = runtime.exec(cmd);
      //process.waitFor();
        System.out.println(process.exitValue());
       // process.
    }

    public static void runShellCommand(String cmd, String message, int sleepFor) {
        try {
        	System.out.println(message + " - '" + (cmd) + "'");
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            System.out.println("Done running command - '" + message + "' - " +(cmd) + "'");
        } 
        catch (Exception e)
        {
        	System.out.println("Error running command: '" + message + "' - '" + (cmd) + "'\n" + e.getMessage());
        }
    }
}