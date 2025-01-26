package com.example.paintfigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape{


    @Override
    void draw(GraphicsContext gr, double x, double y, Color color) {
        gr.setFill(super.color);
        gr.beginPath();
        gr.moveTo(x, y);
        gr.lineTo(x + 50, y + 75);
        gr.lineTo(x - 50, y + 75);
        gr.closePath();
        gr.fill();
    }

    @Override
    void updateColor(Color newColor) {
        super.color = newColor;
    }
}
