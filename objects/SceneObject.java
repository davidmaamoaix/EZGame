package objects;

import ui.GameScene;

public abstract class SceneObject{

	int x;
	int y;
	int rotation;
	int scaleX;
	int scaleY;
	public GameScene scene;
	public int id;
	public abstract void addToScene(GameScene inScene);
	public abstract void destroy();
	
	public SceneObject(){
		x=0;
		y=0;
		scaleX=1;
		scaleY=1;
	}
	
	public void setId(int inId){
		id=inId;
	}
	
	public int getId(){
		return id;
	}
	public int getX(){
		return x;
	}
	public void setX(int inX){
		x=inX;
	}
	public int getY(){
		return y;
	}
	public void setY(int inY){
		y=inY;
	}
	public int getRotation(){
		return rotation;
	}
	public void setRotation(int inRotation){
		rotation=inRotation;
	}
	public int getScaleX(){
		return scaleX;
	}
	public void setScaleX(int inScaleX){
		scaleX=inScaleX;
	}
	public int getScaleY(){
		return scaleY;
	}
	public void setScaleY(int inScaleY){
		scaleY=inScaleY;
	}
}
