import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestingRuntime 
{
	public static void main(String args[]) throws IOException
	{
		//System.out.println(executeCommand("cmd.exe /c start fart.bat"));
		Process p = new ProcessBuilder("cmd.exe","/c","C:\\Users\\owner\\Desktop\\Test\\fart.bat").start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		while(line != null)
		{
			System.out.println(line);
			line = r.readLine();
		}
		r.close();
	}
	
	public static String executeCommand(String command)
	{
		System.out.println("executing command");
		StringBuffer output = new StringBuffer();
		Process p;
		try
		{
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while(line != null)
			{
				output.append(line + "\n");
				line = r.readLine();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return output.toString();
	}

}
