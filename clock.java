package clock;

import java.util.Calendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class clock extends Application{

	public static void main(String[] args) {
		 launch(args);
	}
	
	public int xhCalculate(int h,int m,int s) {
		double time = 3600 * (h%12) + 60 * m + s;
		double angle = (360*time)/43200;
		double arc = (angle * Math.PI)/180;
		return  (int)(50 * Math.sin(arc));
	}
	
	public int xmCalculate(int m,int s) {
		int time = 60 * m + s;
		double arc = time * Math.PI / 1800;
		return  (int)(50 * Math.sin(arc));
	}
	
	public int xsCalculate(int s) {
		int time = s;
		double arc = time * Math.PI / 30;
		return  (int)(50 * Math.sin(arc));
	}
	
	public int yhCalculate(int h,int m,int s) {
		double time = 3600 * (h%12) + 60 * m + s;
		double angle = (360*time)/43200;
		double arc = (angle * Math.PI)/180;
		return  (int)(50 * Math.cos(arc));
	}
	
	public int ymCalculate(int m,int s) {
		int time = 60 * m + s;
		double arc = time * Math.PI / 1800;
		return  (int)(50 * Math.cos(arc));
	}
	
	public int ysCalculate(int s) {
		int time = s;
		double arc = time * Math.PI / 30;
		return  (int)(50 * Math.cos(arc));
	}
	
	public int getH() {
		Calendar cal=Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);      
	}
	
	public int getM() {
		Calendar cal=Calendar.getInstance();
		return cal.get(Calendar.MINUTE); 
	}
	
	public int getS() {
		Calendar cal=Calendar.getInstance();
		return cal.get(Calendar.SECOND); 
	}
	
	public void start(Stage primaryStage) throws Exception { 
		
		primaryStage.setTitle("钟表");
		BorderPane basicPane = new BorderPane();
        Scene scene = new Scene(basicPane,600,700);
        primaryStage.setScene(scene);
		
		Line Hline = new Line(); 
		Line Mline  = new Line(); 
		Line Sline = new Line(); 
		
		Hline.setStrokeLineCap(StrokeLineCap.BUTT);
		Hline.setStrokeLineCap(StrokeLineCap.ROUND);
		Hline.setStrokeLineCap(StrokeLineCap.SQUARE);
		
		Circle circle = new Circle();
		
		Text delay = new Text(180,45,"BUILDING!");
		delay.setFont(Font.font ("Verdana", 50));
		basicPane.getChildren().add(delay);
		
		primaryStage.show();
		
		EventHandler<ActionEvent> eventHandler=e -> {
			
			basicPane.getChildren().clear();
			circle.setCenterX(300);
			circle.setCenterY(400);
			circle.setRadius(200);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
			basicPane.getChildren().add(circle);
			
			Text time = new Text(180,45,String.valueOf(getH()) + ":" + String.valueOf(getM()) + ":" + String.valueOf(getS()));
			time.setFont(Font.font ("Verdana", 50));
			basicPane.getChildren().add(time);
			
			for(int i=0;i<12;i++) {
				Text num = new Text(297+210*Math.sin((double)(i*Math.PI)/6),403-210*Math.cos((double)(i*Math.PI)/6),String.valueOf(i));
				basicPane.getChildren().add(num);
			}
			
			for(int i=0;i<60;i++) {
				Line tick = new Line();
				tick.setStroke(Color.ORANGE);
				tick.setStartX(300);
				tick.setStartY(400);
				tick.setEndX(300+200*Math.sin((double)(i*Math.PI)/30));
				tick.setEndY(400-200*Math.cos((double)(i*Math.PI)/30));
				basicPane.getChildren().add(tick);
			}
			
			for(int i=0;i<9;i++) {
				Arc docurate = new Arc();
				docurate.setType(ArcType.ROUND);
				docurate.setStartAngle(81-(360*(3600*(getH()%12)+60*getM()+getS()))/43200);
				docurate.setLength(18);
				docurate.setCenterX(300);
				docurate.setCenterY(400);
				docurate.setRadiusX(200-20*i);
				docurate.setRadiusY(200-20*i);
				docurate.setRadiusX(200-20*i);
				docurate.setStroke(Color.RED);
				docurate.setFill(Color.WHITE);
				basicPane.getChildren().add(docurate);
			}
			
			for(int i=0;i<9;i++) {
				Arc docurate = new Arc();
				docurate.setType(ArcType.ROUND);
				docurate.setStartAngle(81-(360*(60*getM()+getS()))/3600);
				docurate.setLength(18);
				docurate.setCenterX(300);
				docurate.setCenterY(400);
				docurate.setRadiusX(200-20*i);
				docurate.setRadiusY(200-20*i);
				docurate.setRadiusX(200-20*i);
				docurate.setStroke(Color.RED);
				docurate.setFill(Color.WHITE);
				basicPane.getChildren().add(docurate);
			}
			
			for(int i=0;i<9;i++) {
				Arc docurate = new Arc();
				docurate.setType(ArcType.ROUND);
				docurate.setStartAngle(81-(360*(getS()))/60);
				docurate.setLength(18);
				docurate.setCenterX(300);
				docurate.setCenterY(400);
				docurate.setRadiusX(200-20*i);
				docurate.setRadiusY(200-20*i);
				docurate.setRadiusX(200-20*i);
				docurate.setStroke(Color.RED);
				docurate.setFill(Color.WHITE);
				basicPane.getChildren().add(docurate);
			}
            
    		Hline.setStartX(300); 
    		Hline.setStartY(400); 
    		Mline.setStartX(300); 
    		Mline.setStartY(400); 
    		Sline.setStartX(300); 
    		Sline.setStartY(400); 
    		Hline.setEndX(300+2*xhCalculate(getH(),getM(),getS())); 
    		Hline.setEndY(400-2*yhCalculate(getH(),getM(),getS()));
    		Mline.setEndX(300+3*xmCalculate(getM(),getS())); 
    		Mline.setEndY(400-3*ymCalculate(getM(),getS()));
    		Sline.setEndX(300+4*xsCalculate(getS())); 
    		Sline.setEndY(400-4*ysCalculate(getS()));
     		basicPane.getChildren().add(Hline);
    		basicPane.getChildren().add(Mline);
    		basicPane.getChildren().add(Sline);
        };
		
		Timeline timeline=new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
		
	} 
}
