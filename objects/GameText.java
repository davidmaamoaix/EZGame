package objects;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ui.GameScene;

public class GameText extends SceneObject{
	
	Text text;
	int size;
	private GameScene scene;
	
	public GameText(){
		size=20;
		text=new Text();
	}
	
	public void addToScene(GameScene inScene){
		scene=inScene;
		scene.add(this);
	}
	
	public void destroy(){
		scene.remove(this);
		scene=null;
	}
	
	public void setText(String inText){
		text.setText(inText);
	}
	
	public void setSize(int inSize){
		size=inSize;
		text.setFont(new Font(size));
	}
	
	public int getSize(){
		return size;
	}
	
	public String getText(){
		return text.getText();
	}
	
	public Text getRender(){
		text.setX(getX());
		text.setY(getY());
		return text;
	}
}
