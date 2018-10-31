import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaolmpl implements AccountDao{
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public int addAccount(Account account){
        String sql="insert into account4(username,balance) value(?,?)";
        Object[] obj=new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        int num=this.jdbcTemplate.update(sql,obj);
        return num;
    }



    public int updateAccotunt(Account account) {
        String sql="update account4 set username=?,balance=? where id=?";
        Object[] params=new Object[]{
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
        int num=this.jdbcTemplate.update(sql,params);
        return num;


    }

    public int deleAccoun(int id){
        String sql="delete from account4 where id =?";
        int num=this.jdbcTemplate.update(sql,id);
        return num;
    }

    @Override
    public void transfer(String outUser, String inUser, Double money) {
        this.jdbcTemplate.update("update account4 set balance=balance-?"+"where username=?",money,outUser);
        int i=1/0;
        this.jdbcTemplate.update("update account4 set balance=balance+?"+"where username=?",money,inUser );


    }
}