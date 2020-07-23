package 结构型模式.桥接模式;

/**
 * author: mxg
 *
 * 未使用桥接
 */
public interface Computer {
    void sale();
}

class Desttop implements Computer {

    @Override
    public void sale() {
        System.out.println("销售台式机");
    }
}


class Laptop implements Computer {

    @Override
    public void sale() {
        System.out.println("销售笔记本");
    }
}


class Pad implements Computer {

    @Override
    public void sale() {
        System.out.println("销售平板电脑");
    }
}

class LxDesttop extends Desttop {
    @Override
    public void sale() {
        System.out.println("销售联想台式机");
    }
}
class LxLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("销售联想笔记本");
    }
}
class LxPad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售联想平板电脑");
    }
}

class DellDesttop extends Desttop {
    @Override
    public void sale() {
        System.out.println("销售Dell台式机");
    }
}
class DellLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("销售Dell笔记本");
    }
}
class DellPad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售Dell平板电脑");
    }
}