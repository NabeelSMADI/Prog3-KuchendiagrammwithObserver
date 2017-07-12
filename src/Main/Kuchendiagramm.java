package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import observer.ChartObserver;

public class Kuchendiagramm  extends Application{

    double p1 = 69;
    double p2 = 12;
    double p3 = 19;

    static  PieChart.Data slice1;
    static  PieChart.Data slice2;
    static  PieChart.Data slice3;

    static  ChartObserver o1;
    static  ChartObserver o2;

    static SliderFenster Slider1;
    static SliderFenster Slider2;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Main.Kuchendiagramm");
        PieChart pieChart = new PieChart();
        slice1 = new PieChart.Data("Zugehörigen Bachelorstudiengang", p1);
        slice2 = new PieChart.Data("Anderen Studiengängen"  , p2);
        slice3 = new PieChart.Data("Rest" , p3);
        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        BorderPane root = new BorderPane();
        root.setCenter(pieChart);
        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();


         Slider1 = new SliderFenster(0,88,69,"Zugehörigen Bachelorstudiengang");
        Slider1.show(200,300);
         Slider2 = new SliderFenster(0,31,12,"Anderen Studiengängen");
        Slider2.show(200,400);

         o1 = new ChartObserver(Slider1.Subject);
         o2 = new ChartObserver(Slider2.Subject);
    }

    public static void update() {
        slice1.setPieValue(o1.getWert());
        slice2.setPieValue(o2.getWert());
        slice3.setPieValue(100 - (o1.getWert() + o2.getWert()));

        Slider1.setMax(100-o2.getWert());
        Slider2.setMax(100-o1.getWert());
    }



}