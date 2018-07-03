

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class ButtonHandler implements EventHandler<ActionEvent>
{
	private boolean toggle;
	private String originalTitle;
	private int counter;
	private static final String GOOFY_TITLE = "OOMPA LOOMPA";
	public ButtonHandler()
	{
		toggle = true;
		originalTitle = PrimaryStage.getInstance().getTitle();
		counter = 0;
	}
	@Override
	public void handle(ActionEvent event) {
		counter++;
		if(toggle)
		{
			PrimaryStage.getInstance().setTitle(GOOFY_TITLE);
			FirstScene.getInstance().setFill(Color.AQUA);
			toggle = false;
		}
		else
		{
			PrimaryStage.getInstance().setTitle(originalTitle);
			FirstScene.getInstance().setFill(Color.WHITE);
			toggle = true;
		}
		
	}

}
