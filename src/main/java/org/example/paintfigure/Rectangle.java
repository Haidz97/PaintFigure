package org.example.paintfigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Rectangle extends Shape {

    @Override

    void draw(GraphicsContext gc, double x, double y, Color color) {
        gc.setFill(color);
        gc.fillRect(x, y, 200, 200);
    }

    @Override
    void updateColor(Color newColor) {
        super.color = newColor;
    }




}