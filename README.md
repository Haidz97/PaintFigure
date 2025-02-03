---

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
package org.example.task2_figura;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class HelloController {

    @FXML
    private Canvas canvas;
    GraphicsContext gc;

    @FXML
    public void onClickRectangle(ActionEvent actionEvent) {
        gc = canvas.getGraphicsContext2D();
        // Очистим холст
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // установка толщины линии
        gc.setLineWidth(6.0);
        // установка цвета
        gc.setFill(Color.RED);
        // рисование скругленного прямоугольника
        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);
        // закрашивание скругленного прямоугольника
        gc.fillRoundRect(100, 10, 50, 50, 10, 10);
        // установка цвета заполнения
        gc.setFill(Color.BLUE);
    }

    @FXML
    public void onClickLine(ActionEvent actionEvent) {
        gc = canvas.getGraphicsContext2D();
        // Очистим холст
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // рисование линии
        gc.strokeLine(200, 50, 300, 50);
        // рисование дуги
        gc.strokeArc(320, 10, 50, 50, 40, 80, ArcType.ROUND);
        // закрашивание дуги
        gc.fillArc(320, 70, 50, 50, 00, 120, ArcType.OPEN);
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

        // рисование овала
        gc.strokeOval(10, 70, 50, 30);
        // закрашивание овала
        gc.fillOval(100, 70, 50, 30);
        // рисование линии
    }
}
