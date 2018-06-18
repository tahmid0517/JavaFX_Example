import javafx.application.Application;
import javafx.stage.Stage;

public class Prank extends Application
{
	static String link = "http://google.com";
	static int numberOfTimes = 3;
	static int waitTime = 3000;
	@Override
	public void start(Stage window)
	{
		try
		{
			for(int i = 0;i < numberOfTimes;i++)
			{
				new ProcessBuilder("cmd.exe","/c","explorer " + link).start();
				Thread.sleep(waitTime);
			}
			System.exit(0);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}
