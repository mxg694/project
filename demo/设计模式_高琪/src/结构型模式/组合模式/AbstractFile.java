package 结构型模式.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 * 抽象构建
 */
public interface AbstractFile {
    void killVirus(); //杀毒
}

class ImageFile implements AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---图像文件"+name+"进行杀毒");
    }
}
class TextFile implements AbstractFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本文件"+name+"进行杀毒");
    }
}

class Folder implements AbstractFile {
    private String name;
    //定义容器，用了存放容器构建下的子节点
    List<AbstractFile> list = new ArrayList<>();


    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本夹"+name+"进行杀毒");
        for (AbstractFile file: list) {
            file.killVirus();
        }
    }

    public void  add(AbstractFile file){
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }
}