/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.service;

import com.sqa.qldiem.model.PointModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IPointService {
    List<PointModel> findBySemesterAndFacultyAndSubjectClassroom(String semester, String faculty, String subjectClass);
}
