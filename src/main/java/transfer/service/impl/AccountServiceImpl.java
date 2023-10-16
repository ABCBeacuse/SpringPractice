package transfer.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import transfer.mapper.AccountMapper;
import transfer.service.AccountService;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false, propagation = Propagation.REQUIRED, timeout = -1)
// 这个事务配置针对于 该类下的 所有方法
public class AccountServiceImpl implements AccountService {

    private AccountMapper accountMapper;

    // @Autowired 省略
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false, propagation = Propagation.REQUIRED, timeout = -1)
    // 这个事务配置只针对于这个目标方法（如果某个方法需要单独配置，像这样在特定方法上重新进行 @Transactional 标注即可）
    public void transferMoney(String fromName, String toName, Double money) {
        accountMapper.decrMoney(fromName, money);
        // int i = 1 / 0;
        accountMapper.incrMoney(toName, money);
    }
}
