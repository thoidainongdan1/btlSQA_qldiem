package com.sqa.qldiem.dao;

import java.util.List;

import com.sqa.qldiem.mapper.RowMapper;

public interface GenericDAO<T> {

    List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

    void update(String sql, Object... parameters);

    Long insert(String sql, Object... parameters);
}
