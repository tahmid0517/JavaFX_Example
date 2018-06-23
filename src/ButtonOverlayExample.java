
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class ButtonOverlayExample extends Application
{
	public void start(Stage window)
	{
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode,300,300);
		window.setScene(scene);
		Label button = new Label();
		button.setPrefSize(200,80);
		button.setLayoutX(50);
		button.setLayoutY(110);
		button.setText("   CLICK ME");
		button.setTextAlignment(TextAlignment.CENTER);
		String style = "-fx-border-style: solid; -fx-border-width: 4;";
		button.setStyle(style);
		Font font = new Font("Bodoni MT",30);
		button.setFont(font);
		rootNode.getChildren().add(button);
		window.show();
		Pane overlay = new Pane();
		overlay.setPrefSize(button.getWidth(),button.getHeight());
		overlay.setOpacity(0.2);
		overlay.setStyle("-fx-background-color : blue");
		overlay.setLayoutX(button.getLayoutX());
		overlay.setLayoutY(button.getLayoutY());
		addListeners(button,overlay,rootNode,scene);
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void addListeners(Label button, Pane overlay, Group root,Scene scene)
	{
		scene.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>()
	    {
			@Override
			public void handle(MouseEvent e)
			{
				if(e.getX() > button.getLayoutX() && e.getX() < button.getLayoutX() + button.getWidth())
				{
					if(e.getY() > button.getLayoutY() && e.getY() < button.getLayoutY() + button.getHeight())
					{
						if(!root.getChildren().contains(overlay))
						{
							root.getChildren().add(overlay);
							return;
						}
					}
				}
				if(e.getX() < button.getLayoutX())
					removeOverlay(root,overlay);
				if(e.getX() > button.getLayoutX() + button.getWidth())
					removeOverlay(root,overlay);
				if(e.getY() < button.getLayoutY())
					removeOverlay(root,overlay);
				if(e.getY() > button.getLayoutY() + button.getHeight())
					removeOverlay(root,overlay);
			}
	    });
		overlay.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				System.out.println("button was clicked");
			}
		});
	}
	
	public void removeOverlay(Group root,Pane overlay)
	{
		if(root.getChildren().contains(overlay))
			root.getChildren().remove(overlay);
	}
}
