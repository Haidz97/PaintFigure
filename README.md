## JavaFX Example: Drawing Shapes on a Canvas

This example demonstrates how to use the JavaFX library to draw various shapes on a canvas in an application. The controller class handles the drawing of different shapes such as rectangles, lines, triangles, and ovals when corresponding buttons are clicked. Each shape is drawn using specific methods provided by the GraphicsContext class.

#### Class Overview

The main class for this example is `HelloController`, which contains methods for each type of shape to be drawn. These methods include:

- `onClickRectangle`: Draws a rounded rectangle.
- `onClickLine`: Draws a line and an arc.
- `onClickTriangle`: Draws a triangle.
- `onClickOval`: Draws an oval.

Each method clears the canvas before drawing the new shape with specified colors and thicknesses.

### Example Code

```java
package com.example.paintfigure;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;

    @FXML
    private ColorPicker colorPicker;
    private Shape currentFigure;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();

    }

    @FXML
    public void onMouseEvent(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        if (currentFigure != null) {
            currentFigure.draw(gc, x, y, colorPicker.getValue());
        }
    }

    @FXML
    public void onClickRectangle(ActionEvent actionEvent) {
        setCurrentFigure(new Rectangle());
    }

    @FXML
    public void onClickLine(ActionEvent actionEvent) {
        setCurrentFigure(new Line());
    }

    @FXML
    public void onClickTriangle(ActionEvent actionEvent) {
        setCurrentFigure(new Triangle());
    }

    @FXML
    public void onClickOval(ActionEvent actionEvent) {
        setCurrentFigure(new Oval());
    }

    @FXML
    public void onColorChanged(ActionEvent actionEvent) {

        if (currentFigure != null) {
            currentFigure.updateColor(colorPicker.getValue());
        }
    }

    private void setCurrentFigure(Shape shape) {
        currentFigure = shape;
        clearCanvas();
    }

    private void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
