package org.pp.service;

import org.pp.entity.Dept;
import java.util.List;

public interface DeptService {

    Dept get(Integer deptNo);

    List<Dept> selectAll();
}