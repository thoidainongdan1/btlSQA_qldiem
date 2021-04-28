/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.dao;

import com.sqa.qldiem.model.ResultModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IResultDAO {
    List<ResultModel> findBySemesterAndFacultyAndQuantity(String semester, String faculty, int quantity);
}
