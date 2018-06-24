import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	ServerSocket server;
	Socket serverSocket;
	BufferedReader reader;
	BufferedWriter writer;
	public Server(int port)
	{
		try
		{
			server = new ServerSocket(port);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void start() throws IOException
	{
		serverSocket = server.accept();
		reader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
		boolean isConnectionOpen = true;
		while(isConnectionOpen)
		{
			String input;
			while((input = reader.readLine()) == null)
			{
				//Waiting for input that isn't empty.
			}
			System.out.println(input);
			isConnectionOpen = handleInput(input);
			respondToClient(input);
		}
		closeServer();
	}
	
	public void writeMessage(String mssg) throws IOException
	{
		writer.write(mssg);
		writer.newLine();
		writer.flush();
		System.out.println("sent message");
	}
	
	public void closeServer() throws IOException
	{
		reader.close();
		writer.close();
		server.close();
		serverSocket.close();
	}
	
	public void respondToClient(String input) throws IOException
	{
		try
		{
			Thread.sleep(1);
		}
		catch(InterruptedException e) {}
		writeMessage("DONE");
	}
	
	public boolean handleInput(String input)
	{
		if(input.equals("CLOSE"))
		{
			return false;
		}
		// Add code here to send commands to robot.
		return true;
	}
	
	public static void main(String args[]) throws IOException
	{
		Server server = new Server(6852);
		server.start();
	}
}
