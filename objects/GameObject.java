package objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ui.GameScene;

public abstract class GameObject extends SceneObject{
	
	public int layer;
	public Image img;
	public double alpha;
	public abstract void start();
	public abstract void update();
	
	public GameObject(){
		alpha=1;
		layer=0;
	}
	
	public void setImg(String path){
		//System.out.println(path);
		img=new Image(getClass().getResource(path).toExternalForm());
	}
	
	public ImageView getRender(){
		ImageView iv=new ImageView();
		iv.setImage(img);
		iv.setFitWidth(img.getWidth()*scaleX);
		iv.setFitHeight(img.getHeight()*scaleY);
		iv.setX(x-(scaleX*img.getWidth()/2));
		iv.setY(y-(scaleY*img.getHeight()/2));
		iv.setRotate(rotation);
		iv.setOpacity(alpha);
		return iv;
	}
	
	public void addToScene(GameScene inScene){
		scene=inScene;
		scene.add(this);
	}
	
	public void destroy(){
		scene.remove(this);
		scene=null;
	}
	
	public void setAlpha(double a){
		alpha=a;
	}
	
	public double getAlpha(){
		return alpha;
	}
}
