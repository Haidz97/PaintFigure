package com.example.paintfigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Shape {

    protected Color color;

    abstract void draw(GraphicsContext gc, double x, double y, Color color);

    void updateColor(Color newColor) {
        this.color = newColor;
    }

}