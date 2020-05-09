package cn.it.mybatisplus;

import cn.it.mybatisplus.entity.User;
import cn.it.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //查询user中所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //新增
    @Test
    public void addUser() {
        User user = new User();
        user.setAge(12);
        user.setUserName("maoxgMp");
        user.setPassword("maoxg");
        int insert = userMapper.insert(user);
        System.out.println("insert:" + insert);
    }

    //修改
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(4L);
        user.setAge(38);
        userMapper.updateById(user);
    }
    /**
     *  测试乐观锁
     */
    @Test
    public void testLeGuansuo() {
        User user = userMapper.selectById(7);
        user.setAge(38);
        userMapper.updateById(user);
    }

    /**
     * 根据id批量查询
     */
    @Test
    public void queryByIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    /**
     * 分页查询
     */
    @Test
    public void testPage() {
        Page<User> page = new Page<>(1,2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        System.out.println( userIPage.getRecords());
    }

    /**
     * 复杂查询
     */
    @Test
    public void testQueryWrapper() {

        QueryWrapper<User> qw = new QueryWrapper<>();
        // ge  gt  le  lt  大于 小于
        qw.gt("age", 30);
        //eq, nt   等于 不等于
        qw.eq("name","lilei");
        //between  在...之间

        //like  模糊查询

        //orderByDesc   排序

        //last   拼接sql 语句
        qw.last("limit 1");
        //指定要查询的列   select 后面的字段
        qw.select("id", "name");
        userMapper.selectList(qw);
    }
}
