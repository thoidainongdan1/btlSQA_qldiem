/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.service.impl;

import com.sqa.qldiem.dao.IPointDAO;
import com.sqa.qldiem.dao.impl.PointDAO;
import com.sqa.qldiem.model.PointModel;
import com.sqa.qldiem.service.IPointService;
import com.sqa.qldiem.utils.FileUtil;
import java.io.File;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Administrator
 */
public class PointService implements IPointService {

    @Inject
    private IPointDAO pointDAO;

    @Override
    public List<PointModel> findBySemesterAndFacultyAndSubjectClassroom(String semester, String faculty, String subjectClass) {
        String fileName = semester.substring(3, 4) + semester.substring(9, 13) + "_" + faculty + "_" + subjectClass;
        File file = new File("stored/" + fileName);
        System.out.println(file.getAbsolutePath());
        List<PointModel> list = null;
        if (file.exists()) {
            list = FileUtil.readFile(file);
        } else {
            list = pointDAO.findBySemesterAndFacultyAndSubjectClassroom(semester, faculty, subjectClass);
            if (list.size() > 0) {
                for (PointModel p : list) {
                    p.setAvgPointAndResult();
                }
                Collections.sort(list);
                FileUtil.writeFile(file, list);
            }
        }
        return list;
    }

    public void setDAO() {
        pointDAO = new PointDAO();
    }
}
