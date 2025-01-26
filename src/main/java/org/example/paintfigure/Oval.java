package org.example.paintfigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

public class Oval extends Shape {


    @Override
    public void draw(GraphicsContext gc, double x, double y, Color color) {
        gc.setFill(color);
        gc.fillOval(x, y, 200, 200);
    }

    @Override
    void updateColor(Color newColor) {
        super.color = newColor;
    }
}