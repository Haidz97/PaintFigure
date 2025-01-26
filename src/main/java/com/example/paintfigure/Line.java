package com.example.paintfigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {

    @Override

    void draw(GraphicsContext gc, double x, double y, Color color) {
        gc.setFill(color);
        gc.beginPath();
        gc.moveTo(x, y);
        gc.lineTo(x + 100, y + 173);
        gc.lineTo(x - 100, y + 173);
        gc.closePath();
        gc.fill();
    }

    @Override
    void updateColor(Color newColor) {
        super.color = newColor;
    }}
