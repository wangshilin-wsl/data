package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

//泛型接口
public interface RowMapper<T> {
    T makeBean(ResultSet rs) throws SQLException;
}
