public interface AccountDao {
      public int addAccount(Account account);
      public int updateAccotunt(Account account);
      public int deleAccoun(int id);
      public void transfer(String outUser,String inUser,Double money );

}
