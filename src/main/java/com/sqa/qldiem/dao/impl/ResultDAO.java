/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao.impl;

import com.sqa.qldiem.dao.IResultDAO;
import com.sqa.qldiem.mapper.ResultMapper;
import com.sqa.qldiem.model.ResultModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ResultDAO extends AbstractDAO<ResultModel> implements IResultDAO {

    @Override
    public List<ResultModel> findBySemesterAndFacultyAndQuantity(String semester, String faculty, int quantity) {
        String sql = "SELECT * FROM result as r "
                + "INNER JOIN user AS u ON r.userid = u.id "
                + "WHERE roleid = 3 AND semester = ? AND faculty = ? AND point >= 2.5 "
                + "ORDER BY point DESC LIMIT ?";
        List<ResultModel> results = query(sql, new ResultMapper(), semester, faculty, quantity);
        return results;
    }
    
}
