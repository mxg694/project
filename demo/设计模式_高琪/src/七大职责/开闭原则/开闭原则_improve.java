package 七大职责.开闭原则;

/**
 * author: mxg
 */
public class 开闭原则_improve {
    public static void main(String[] args) {
        IGraphicEditor graphicEditor = new IGraphicEditor();
        graphicEditor.drawShape(new IRectangle());
        graphicEditor.drawShape(new ICircle());
        graphicEditor.drawShape(new ITriangle());
    }
}

/**
 * 使用方
 */
class IGraphicEditor {
    public void drawShape(IShape shape) {
        shape.draw();
    }

}

/**
 * 提供方
 *  基类
 */
abstract class IShape {
    int type;
    public abstract void draw();//抽象方法
}

class IRectangle extends IShape {
    IRectangle() {
        super.type = 1;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制矩形 ");
    }
}

class ICircle extends IShape {
    ICircle() {
        super.type = 2;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制圆形 ");
    }
}

//新增画三角形
class ITriangle extends IShape {
    ITriangle() {
        super.type = 3;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}