import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MoveBlockWithMouse extends Application
{
	final double SCENE_WIDTH = 500;
	final double SCENE_HEIGHT = 500;
	final String APP_TITLE = "Mouse Control Example";
	final double BLOCK_WIDTH = 50;
	final double BLOCK_HEIGHT = 50;
	Stage window;
	Scene scene;
	Group rootNode;
	Rectangle block;
	@Override
	public void start(Stage window)
	{
		this.window = window;
		rootNode = new Group();
		scene = new Scene(rootNode,SCENE_WIDTH,SCENE_HEIGHT);
		scene.setFill(Color.YELLOW);
		window.setScene(scene);
		window.sizeToScene();
		window.setResizable(false);
		window.setTitle(APP_TITLE);
		window.show();
		createBlock();
		addMouseControl();
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void createBlock()
	{
		block = new Rectangle();
		block.setWidth(BLOCK_WIDTH);
		block.setHeight(BLOCK_HEIGHT);
		block.setLayoutX(SCENE_WIDTH / 2 - (BLOCK_WIDTH / 2));
		block.setLayoutY(SCENE_HEIGHT / 2 - (BLOCK_HEIGHT / 2));
		block.setFill(Color.BLUE);
	}

	public void addMouseControl()
	{
		scene.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>()
	    {
			@Override
			public void handle(MouseEvent event)
			{
				if(!rootNode.getChildren().contains(block))
					rootNode.getChildren().add(block);
				double coordX = event.getX();
				double coordY = event.getY();
				translateBlock(coordX,coordY);
			}
	    });
		scene.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				scene.setCursor(Cursor.NONE);
			}
		});
		scene.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				rootNode.getChildren().remove(block);
			}
		});
	}
	
	public void translateBlock(double x,double y)
	{
		double blockTopLeftX = x - (BLOCK_WIDTH / 2);
		double blockTopLeftY = y - (BLOCK_HEIGHT / 2);
		block.setLayoutX(blockTopLeftX);
		block.setLayoutY(blockTopLeftY);
	}
}
