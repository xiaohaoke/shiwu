import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplate {


    public void addAccountTest(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao=(AccountDao)applicationContext.getBean("accountDao");
        Account account=new Account();
        account.setUsername("tom");
        account.setBalance(1000.00);
        int num=accountDao.addAccount(account);
        if(num>0)
        {
            System.out.println("成功插入了"+num+"条数据！");

        }else {
            System.out.println("插入操作执行失败！");
        }
    }




    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        try {
            jdbcTemplate.execute("create table account4(" + "id int primary key auto_increment," + "username varchar(50)," + "balance double)");
            System.out.println("账户表account创建成功!");
        }
        catch(Exception e){
            System.out.println("该表已经存在");

        }


    }
}
