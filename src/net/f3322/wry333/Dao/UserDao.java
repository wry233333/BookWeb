package net.f3322.wry333.Dao;



import net.f3322.wry333.domain.User;
import net.f3322.wry333.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 */
public class UserDao {
    //声明JDBCTemplate对象共用
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());



    /**
     * 登陆方法
     * @param login_user 只有用户名和密码
     * @return user 包含用户全部数据
     */
    public User login (User login_user){
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), login_user.getUsername(),login_user.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 实现用户注册功能
     * @param reg_user 注册信息
     * @return 成功与否
     */
    public int register (User reg_user){
        try {
            String sql = "insert into user(username,password) values(?,?)";
            int update = jdbcTemplate.update(sql, reg_user.getUsername(), reg_user.getPassword());
            return update;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
