package 七大职责.开闭原则;

/**
 * author: mxg
 */
public class 开闭原则_not {
    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
    }
}

/**
 * 使用方
 */
class GraphicEditor {

    public void drawShape(Shape shape) {
        if (shape.type ==1) {
            drawRectangle(shape);
        }else if (shape.type ==2) {
            drawCircle(shape);
        }else if (shape.type ==3) {
            drawTriangle(shape);
        }


    }

    //绘制矩形
    public void drawRectangle(Shape r) {
        System.out.println(" 绘制矩形 ");
    }

    //绘制圆形
    public void drawCircle(Shape r) {
        System.out.println(" 绘制圆形 ");
    }

    //新增的方法 绘制三角形
    public void drawTriangle(Shape r) {
        System.out.println(" 绘制三角形 ");
    }
}

/**
 * 提供方
 */
class Shape {
    int type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.type = 2;
    }
}

//新增画三角形
class Triangle extends Shape {
    Triangle() {
        super.type = 3;
    }
}