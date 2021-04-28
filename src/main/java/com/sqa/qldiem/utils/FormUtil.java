/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.qldiem.utils;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
/**
 *
 * @author Administrator
 */
public class FormUtil {

    @SuppressWarnings("unchecked")
    public static <T> T toModel(Class<T> cl, HttpServletRequest request) {
        T object = null;
        try {
            object = cl.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.print(e.getMessage());
        }
        return object;
    }
}
