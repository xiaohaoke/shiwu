import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TransactionTest {
    @Test
    public void xmlTest()
    {

        try {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationcontext2.xml");
        //获取AccountDao实例
        AccountDao accountDao=(AccountDao)applicationContext.getBean("accountDao");
        //调用实例中的转账方法
            accountDao.transfer("tom1", "tom2", 100.0);
            System.out.println("转账成功！");
        }catch (Exception e1)
        {
            System.out.println(e1);
        }
        //输出提示信息

    }

}
