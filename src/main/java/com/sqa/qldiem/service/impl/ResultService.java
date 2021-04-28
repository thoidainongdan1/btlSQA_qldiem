/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.service.impl;

import com.sqa.qldiem.dao.IResultDAO;
import com.sqa.qldiem.model.ResultModel;
import com.sqa.qldiem.service.IResultService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Administrator
 */
public class ResultService implements IResultService {
    
    @Inject
    IResultDAO resultDAO;

    @Override
    public List<ResultModel> findBySemesterAndFacultyAndQuantity(String semester, String faculty, int quantity) {
        List<ResultModel> list = resultDAO.findBySemesterAndFacultyAndQuantity(semester, faculty, quantity);
        for(ResultModel rm : list) {
            rm.fillScholarship();
        }
        return list;
    }
    
}
