package com.xiaolin.mapper;

import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpExpr;
import com.xiaolin.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> listEmp(@Param("condition") EmpQueryParam condition);

    List<EmpExpr> listExpr(Integer id);

    void insertExprBatch(@Param("exprList") List<EmpExpr> exprList);

    void insertEmp(Emp emp);

    void deleteEmp(@Param("ids") Integer[] ids);

    void deleteExpr(@Param("ids") Integer[] ids);

    Emp info(Integer id);

    void updateEmp(@Param("emp") Emp emp);

    void updateExpr(@Param("expr") EmpExpr expr);

    Emp getUserInfo(@Param("emp") Emp emp);
}