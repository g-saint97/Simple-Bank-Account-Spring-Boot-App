package com.example.demo.repos;

import com.example.demo.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@Profile("h2")
public class JDBCAccountRepo implements AccountRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> getAllAccounts() {
        String sql = "SELECT * FROM Account";
        return jdbcTemplate.query(sql, getAccountRowMapper());
    }

    @Override
    public Account findAccountById(int id) {
        String sql = "SELECT * FROM Account WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,getAccountRowMapper(), id);
    }

    @Override
    public void saveAccount(Account account) {
        String sql = "INSERT INTO Account(name, balance) VALUES (?, ?)";
        jdbcTemplate.update(sql, getAccountRowMapper());
    }

    @Override
    public void batchInsert(List<Account> accounts) {
        String sql = "INSERT INTO Account(name, balance) VALUES (?,?)";
        jdbcTemplate.batchUpdate(sql, accounts, 50,
                (PreparedStatement ps, Account account) -> {
                    ps.setString(1, account.getName());
                    ps.setDouble(2, account.getBalance());
        });
    }

    private RowMapper<Account> getAccountRowMapper(){
        return (resultSet, rowNum) -> {
            long id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double balance = resultSet.getDouble("balance");
            return new Account(id, name, balance);
        };
    }
}
