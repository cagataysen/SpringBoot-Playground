package com.account_service.repo;

import com.account_service.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository extends CassandraRepository<Account, String> {
}
