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
package org.example.paintfigure;

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
        gc = canvas.getGraphicsContext2D();
        // Очистим холст
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // установка толщины линии
        gc.setLineWidth(10.0);
        // установка цвета
        gc.setFill(Color.CYAN);
        // рисование скругленного прямоугольника
        gc.strokeRoundRect(500, 250, 50, 50, 10, 10);
        // закрашивание скругленного прямоугольника
        gc.fillRoundRect(500, 250, 50, 50, 10, 10);
        // установка цвета заполнения
        gc.setFill(Color.BLACK);
    }

    @FXML
    public void onClickLine(ActionEvent actionEvent) {
        gc = canvas.getGraphicsContext2D();
        // Очистим холст
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // рисование линии
        gc.strokeLine(200, 50, 300, 50);

    }

    @FXML
    public void onClickTriangle(ActionEvent actionEvent) {
        gc = canvas.getGraphicsContext2D();
        // Очистим холст
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Определим координаты вершин треугольника
        double x1 = 100;
        double y1 = 100;
        double x2 = 200;
        double y2 = 100;
        double x3 = 150;
        double y3 = 200;
        // Начнем путь
        gc.beginPath();
        // Переместимся в первую точку
        gc.moveTo(x1, y1);
        // Нарисуем линию до второй точки
        gc.lineTo(x2, y2);
        // Нарисуем линию до третьей точки
        gc.lineTo(x3, y3);
        // Закроем путь, соединив последнюю точку с первой
        gc.closePath();
        // Установим цвет заливки
        gc.setFill(javafx.scene.paint.Color.BLUE);
        // Заливка треугольника
        gc.fill();
        // Установим цвет обводки
        gc.setStroke(javafx.scene.paint.Color.BLACK);
        // Толщина линии
        gc.setLineWidth(2);
        // Обведем контур треугольника
        gc.stroke();
    }


    @FXML
    public void onClickOval(ActionEvent actionEvent) {
        gc = canvas.getGraphicsContext2D();
        // Очистим холст
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //Установка цвета заливки
        gc.setFill(Color.RED);
        // рисование овала
        gc.strokeOval(700, 200, 50, 30);
        // закрашивание овала
        gc.fillOval(700, 200, 50, 30);

    }

    @FXML
    public void onColorChanged(ActionEvent actionEvent) {

        if (currentFigure != null) {
            currentFigure.updateColor(colorPicker.getValue());
        }
    }
}
