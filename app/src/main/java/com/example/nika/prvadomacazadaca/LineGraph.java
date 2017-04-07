package com.example.nika.prvadomacazadaca;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.content.Context;

import org.achartengine.ChartFactory;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
/**
 * Created by NIKA on 4/7/2017.
 */

public class LineGraph {
    double[] xy;
    String firstTitle;
    String secondTitle;
    String resultTitle;



    public String complexToString(double re, double im) {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }
    public Intent getIntent(double[] xy, Context context){
        this.xy =xy;
        firstTitle=complexToString(xy[0],xy[1]);
        secondTitle=complexToString(xy[2], xy[3]);
        resultTitle=complexToString(xy[4], xy[5]);

        XYSeries series1= new XYSeries("firstTitle");
        series1.add(xy[0], xy[1]);

        XYSeries series2= new XYSeries("secondTitle");
        series2.add(xy[2], xy[3]);

        XYSeries seriesResult= new XYSeries("resultTitle");
        seriesResult.add(xy[4], xy[5]);

        XYMultipleSeriesDataset dataset= new XYMultipleSeriesDataset();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(seriesResult);

        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer=new XYSeriesRenderer();
        renderer.setFillPoints(true);

        mRenderer.addSeriesRenderer(renderer);

        Intent intent
                = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "RESULTS");
        return null;
    }






}
