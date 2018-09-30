package ui;

import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import objects.GameObject;
import objects.GameText;

public class GameScene{
	
	public ArrayList<GameObject> objects;
	public ArrayList<GameText> texts; //Yes, the word "text" has no plural
	private ArrayList<String> keys;
	private BorderPane root;
	private Group screen;
	private Scene scene;
	private int nextId;
	Timeline timeline;
	
	public GameScene(){
		nextId=0;
		timeline=new Timeline(new KeyFrame(Duration.millis(20),ae->update()));
		timeline.setCycleCount(Animation.INDEFINITE);
		objects=new ArrayList<GameObject>();
		texts=new ArrayList<GameText>();
		keys=new ArrayList<String>();
	}
	
	public void run(String title,Stage stage){
		timeline.play();
		root=new BorderPane();
		screen=new Group();
		root.getChildren().add(screen);
		scene=new Scene(root,1280,960);
		scene.addEventHandler(KeyEvent.KEY_PRESSED,(key)->{
			if(!keys.contains(key.getCode().toString())){
				keys.add(key.getCode().toString());
			}
		});
		scene.addEventHandler(KeyEvent.KEY_RELEASED,(key)->{
			for(int i=0;i<keys.size();i++){
				if(keys.get(i)==key.getCode().toString()){
					keys.remove(i);
				}
			}
		});
		stage.setScene(scene);
		stage.setTitle(title);
		stage.setMinWidth(1280);
		stage.show();
	}
	
	public void clear(){
		objects.clear();
	}
	
	public boolean keyDown(String key){
		return keys.contains(key);
	}
	
	public void add(GameObject obj){
		obj.setId(nextId);
		objects.add(obj);
		obj.start();
		nextId++;
		sortObj();
	}
	
	public void add(GameText obj){
		obj.setId(nextId);
		texts.add(obj);
		nextId++;
	}
	
	public void remove(GameObject obj){
		for(int i=0;i<objects.size();i++){
			if(objects.get(i).getId()==obj.getId()){objects.remove(i);return;}
		}
	}
	
	public void remove(GameText obj){
		for(int i=0;i<texts.size();i++){
			if(texts.get(i).getId()==obj.getId()){texts.remove(i);return;}
		}
	}
	
	private void update(){
		for(GameObject i:objects){
			i.update();
		}
		screen.getChildren().clear();
		for(GameObject i:objects){ //Render After All Updates
			render(i);
		}
		for(GameText i:texts){ //Render After All Updates
			render(i);
		}
	}
	
	private void render(GameObject obj){
		screen.getChildren().add(obj.getRender());
	}
	
	private void render(GameText obj){
		screen.getChildren().add(obj.getRender());
	}
	
	private void sortObj(){
		int error=-1;
		while(error!=0){
			error=0;
			for(int i=0;i<objects.size()-1;i++){
				if(objects.get(i).layer>objects.get(i+1).layer){
					GameObject temp=objects.get(i);
					objects.set(i,objects.get(i+1));
					objects.set(i+1,temp);
					error++;
				}
			}
		}
	}
}
