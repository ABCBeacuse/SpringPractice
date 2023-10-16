package transfer.mapper;

public interface AccountMapper {

    void incrMoney(String name, Double money);

    void decrMoney(String name, Double money);

}
