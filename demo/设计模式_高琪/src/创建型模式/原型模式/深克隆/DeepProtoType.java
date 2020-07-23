package 创建型模式.原型模式.深克隆;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepProtoType implements Serializable, Cloneable {

    public String name;
    public DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType() {
        super();
    }


    /**
     * 深克隆   方式 1 使用clone 方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object deep = null;

        deep = super.clone();
        //这里完成对基本数据类型(属性)和String的克隆
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        //对引用类型的属性，进行单独处理
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deepProtoType;
    }

    /**
     * 深拷贝 - 方式2 通过对象的序列化实现 (推荐)
     *
     * @return
     */
    public Object deepClone() {

        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
			//序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//当前这个对象以对象流的方式输出

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType) ois.readObject();

            return copyObj;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }

    }

}
