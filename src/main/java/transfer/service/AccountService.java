package transfer.service;


public interface AccountService {

    void transferMoney(String fromName, String toName, Double money);
}
