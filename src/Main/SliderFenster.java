package Main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import observer.ChartSubject;


public class SliderFenster  {
    public ChartSubject Subject = new ChartSubject();

    private Slider slider;
    private Label titel;
    private Label v;

    public SliderFenster(int min,int max,double x,String t){
          slider = new Slider(min, max, x);
          titel = new Label("  " + t);
          v = new Label(String.format("%.0f", x) + "%   ");
    }

    public void setWert(int min,int max,double x){
        slider.setValue(x);
        slider.setMin(min);
        slider.setMax(max);
        v.setText(String.format("%.0f", x) + "%   ");
    }

    public void setMax(double max){
         slider.setMax(max);
    }



    public void show(int x ,int y){
        BorderPane root = new BorderPane();
        Group g = new Group();
        g.getChildren().add(slider);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                v.setText(String.format("%.0f", new_val) + "%   ");
                sendToAll();
            }
        });

        root.setCenter(g);
        root.setTop(titel);
        root.setRight(v);
        Scene scene = new Scene(root, 250, 50);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setX(x);
        stage.setY(y);
        stage.show();
    }

    public void sendToAll(){
        Subject.setWert(slider.getMin(),slider.getMax(),slider.getValue());
        Subject.notifyObserver();
    }

}
