import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableViewExample extends Application 
{
	TableView<TableObject> table;
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage window)
	{
		//window.setHeight(400);
		//window.setWidth(700);
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		window.setScene(scene);
		TableColumn<TableObject, Double> column1 = new TableColumn<>("A");
		column1.setPrefWidth(100);
		column1.setCellValueFactory(new PropertyValueFactory<>("A"));
		TableColumn<TableObject, Double> column2 = new TableColumn<>("B");
		column2.setPrefWidth(100);
		column2.setCellValueFactory(new PropertyValueFactory<>("B"));
		TableColumn<TableObject, Double> column3 = new TableColumn<>("A");
		column3.setPrefWidth(100);
		column3.setCellValueFactory(new PropertyValueFactory<>("C"));
		table = new TableView<>();
		table.setItems(getObjects());
		table.getColumns().addAll(column1,column2,column3);
		rootNode.getChildren().add(table);
		window.show();
		Thread thread = new Thread(new Runnable()
				{
					@Override
					public void run() 
					{
						while(true)
						{
							addInputOrDeleteRow();
						}
					}
			
				});
		thread.start();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public ObservableList<TableObject> getObjects()
	{
		ObservableList<TableObject> list = FXCollections.observableArrayList();
		list.add(new TableObject(4,2,2));
		list.add(new TableObject(45,3433,44));
		list.add(new TableObject(22,1,3222));
		list.add(new TableObject(332,3232,323));
		return list;
	}
	
	public void addInputOrDeleteRow()
	{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		
		double a,b,c;
		try
		{
			String input = r.readLine();
			if(input.toLowerCase().equals("delete"))
			{
				table.getItems().remove(table.getItems().size() - 1);
				return;
			}
			StringTokenizer st = new StringTokenizer(input," ");
			a = Double.parseDouble(st.nextToken());
			b = Double.parseDouble(st.nextToken());
			c = Double.parseDouble(st.nextToken());
		}
		catch(IOException e)
		{
			System.out.println("Something weird happened with getting an input.");
			return;
		}
		catch(NumberFormatException e)
		{
			System.out.println("You probably entered a number incorrectly.");
			return;
		}
		catch(Exception e)
		{
			System.out.println("IDK what happened");
			return;
		}
		TableObject object = new TableObject(a,b,c);
		table.getItems().add(object);
	}
	
	public static class TableObject
	{
		double attributeA,attributeB,attributeC;
		public TableObject(double a,double b,double c)
		{
			attributeA = a;
			attributeB = b;
			attributeC = c;
		}
		public double getA()
		{
			return attributeA;
		}
		public double getB()
		{
			return attributeB;
		}
		public double getC()
		{
			return attributeC;
		}
	}
}
