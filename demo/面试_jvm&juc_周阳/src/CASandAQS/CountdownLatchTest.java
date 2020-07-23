package luban.bingfa.CASandAQS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountdownLatchTest {
    private static List<String> company = Arrays.asList("A","B","C");
    private static List<String> fightlist = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        String origin = "bj";
        String dest = "sh";
        Thread[] ts = new Thread[company.size()];
        CountDownLatch latch = new CountDownLatch(company.size());

        for (int i=0; i<ts.length; i++) {
            String name = company.get(i);
            ts[i] = new Thread(()-> {
                System.out.printf("%s 查询从%s到%s的机票\n",name,origin,dest);
                int val = new Random().nextInt(10);

                try {
                    TimeUnit.SECONDS.sleep(val);
                    fightlist.add(name+"--"+val);
                    System.out.printf("%s公司查询成功！\n",name);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            ts[i].start();
        }

        latch.await();
        System.out.println("==============查询结果如下：================");
        fightlist.forEach(System.out::println);

    }

}
