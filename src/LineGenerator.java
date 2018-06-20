import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineGenerator extends Application
{
	int numberOfDots;
	Pane canvas;
	ArrayList<Circle> points;
	ArrayList<Line> lines;
	public void start(Stage window)
	{
		window.setHeight(550);
		window.setWidth(500);
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode);
		canvas = new Pane();
		canvas.setPrefSize(300,300);
		canvas.setLayoutX(100);
		canvas.setLayoutY(100);
		Button clearButton = new Button();
		clearButton.setText("CLEAR");
		clearButton.setPrefSize(80,40);
		clearButton.setLayoutX(210);
		clearButton.setLayoutY(408);
		clearButton.setOnAction(e -> clearCanvas());
		Button deleteButton = new Button();
		deleteButton.setText("DELETE");
		deleteButton.setPrefSize(80,40);
		deleteButton.setLayoutX(210);
		deleteButton.setLayoutY(454);
		deleteButton.setOnAction(e -> removeLastLine());
		Button printInfoButton = new Button();
		printInfoButton.setText("PRINT");
		printInfoButton.setPrefSize(80,40);
		printInfoButton.setLayoutX(310);
		printInfoButton.setLayoutY(408);
		printInfoButton.setOnAction(e -> printInfo());
		window.setScene(scene);
		rootNode.getChildren().addAll(canvas,clearButton,deleteButton,printInfoButton);
		scene.setFill(Color.web("#42f477"));
		canvas.setStyle("-fx-background-color:white");
		points = new ArrayList<Circle>();
		lines = new ArrayList<Line>();
		numberOfDots = 0;
		canvas.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				addPoint(e.getX(),e.getY());
			}
		});
		window.show();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void addPoint(double x,double y)
	{
		System.out.println("Point: " + x +"," + y);
		Circle newPoint = new Circle();
		newPoint.setRadius(7);
		newPoint.setFill(Color.YELLOW);
		newPoint.setLayoutX(x);
		newPoint.setLayoutY(y);
		numberOfDots++;
		points.add(newPoint);
		canvas.getChildren().addAll(newPoint);
		if(numberOfDots > 1)
		{
			Line newLine = new Line();
			newLine.setStrokeWidth(4);
			Circle prevPoint = points.get(numberOfDots - 2);
			newLine.setStartX(prevPoint.getLayoutX());
			newLine.setStartY(prevPoint.getLayoutY());
			newLine.setEndX(x);
			newLine.setEndY(y);
			lines.add(newLine);
			canvas.getChildren().add(newLine);
			newPoint.toFront();
		}
		for(int i = 0;i < points.size();i++)
		{
			points.get(i).toFront();
		}
	}
	
	public void clearCanvas()
	{
		while(canvas.getChildren().size() > 0)
		{
			canvas.getChildren().remove(0);
		}
		numberOfDots = 0;
		points = new ArrayList<Circle>();
		lines = new ArrayList<Line>();
	}
	
	public void removeLastLine()
	{
		if(canvas.getChildren().size() == 0)
		{
			return;
		}
		canvas.getChildren().remove(points.get(points.size() - 1));
		points.remove(points.size() - 1);
		if(numberOfDots > 1)
		{
			canvas.getChildren().remove(lines.get(lines.size() - 1));
			lines.remove(lines.size() - 1);
		}
		numberOfDots--;
	}
	
	public void printInfo()
	{
		for(int i = 0;i < lines.size();i++)
		{
			Line line = lines.get(i);
			double yDiff = Math.abs(line.getEndY() - line.getStartY());
			double xDiff = Math.abs(line.getEndX() - line.getStartX());
			double length = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
			System.out.println("Length "+ (i+1) + ": " + length);
		}
		if(points.size() >= 3)
		{
			for(int i = 1;i < points.size() - 1;i++)
			{
				Circle currentPoint = points.get(i);
				Circle pointBefore = points.get(i - 1);
				Circle pointAhead = points.get(i + 1);
				double vectorA_x = currentPoint.getLayoutX() - pointBefore.getLayoutX();
				double vectorA_y = pointBefore.getLayoutY() - currentPoint.getLayoutY();
				double vectorB_x = pointAhead.getLayoutX() - currentPoint.getLayoutX();
				double vectorB_y = currentPoint.getLayoutY() - pointAhead.getLayoutY();
				double absAngle1 = getAbsoluteAngle(vectorA_x,vectorA_y);
				double absAngle2 = getAbsoluteAngle(vectorB_x,vectorB_y);
				double turnAngle = absAngle1 - absAngle2;
				if(turnAngle > 180)
				{
					turnAngle -= 360;
				}
				else if(turnAngle < -180)
				{
					turnAngle += 360;
				}
				System.out.println("Turn " + i + ": " + turnAngle);
			}
		}
	}
	
	public double getLengthBetweenPoints(Circle a,Circle b)
	{
		double yDiff = a.getLayoutY() - b.getLayoutY();
		double xDiff = a.getLayoutX() - b.getLayoutX();
		double length = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
		return length;
	}
	
	public double getAbsoluteAngle(double vect_x,double vect_y)
	{
		if(vect_x == 0)
		{
			if(vect_y > 0)
			{
				return 90;
			}
			if(vect_y < 0)
			{
				return 270;
			}
			return -1;
		}
		else if(vect_y == 0)
		{
			if(vect_x > 1)
			{
				return 0;
			}
			if(vect_x < 1)
			{
				return 180;
			}
		}
		double angleInRadiansFromHorizontal = Math.atan(vect_y / vect_x);
		double absAngleInDegreesFromHorizontal = Math.toDegrees(Math.abs(angleInRadiansFromHorizontal));
		if(vect_x > 0 && vect_y > 0)
		{
			return absAngleInDegreesFromHorizontal;
		}
		else if(vect_x < 0 && vect_y > 0)
		{
			return 180 - absAngleInDegreesFromHorizontal;
		}
		else if(vect_x < 0 && vect_y < 0)
		{
			return absAngleInDegreesFromHorizontal - 180;
		}
		else if(vect_x > 0 && vect_y < 0)
		{
			return -absAngleInDegreesFromHorizontal;
		}
		return -1;
	}
}
