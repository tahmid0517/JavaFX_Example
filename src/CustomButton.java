import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public abstract class CustomButton 
{
	ImageView imageView;
	Image onBtn,offBtn;
	public CustomButton(double width,double length,String onBtnPath,String offBtnPath)
	{
		imageView = new ImageView();
		onBtn = new Image(onBtnPath,width,length,true,true);
		offBtn = new Image(offBtnPath,width,length,true,true);
		imageView.setImage(offBtn);
		imageView.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				imageView.setImage(onBtn);
			}
		});
		imageView.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				imageView.setImage(offBtn);
			}
		});
		imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
	    {
			@Override
			public void handle(MouseEvent event)
			{
				onClick();
			}
	    });
	}
	
	public ImageView getNode()
	{
		return imageView;
	}
	
	public void setLocation(double x,double y)
	{
		imageView.setLayoutX(x);
		imageView.setLayoutY(y);
	}
	
	public double getWidth()
	{
		return onBtn.getWidth();
	}
	
	public double getHeight()
	{
		return onBtn.getHeight();
	}
	
	public abstract void onClick();
}
