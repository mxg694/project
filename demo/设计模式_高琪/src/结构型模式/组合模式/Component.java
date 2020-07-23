package 结构型模式.组合模式;

/**
 * author: mxg
 *  抽象组件
 */
public interface Component {
    void operation();
}

/**
 * 叶子节点
 */
interface Leaf extends Component {

}

/**
 * 容器组件
 */
interface  Composite  extends Component {
    void add(Component c);
    void remove(Component c);
    Component getChild(Component c);
}