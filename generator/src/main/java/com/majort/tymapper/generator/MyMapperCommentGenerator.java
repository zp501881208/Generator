package com.majort.tymapper.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import tk.mybatis.mapper.generator.MapperCommentGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自动生成注释
 * @author zp
 * @date 2018/4/13 15:05
 */
public class MyMapperCommentGenerator extends MapperCommentGenerator {
    /**
     * 去掉getter注释
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    /**
     * 去掉setter注释
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    /**
     * 增加class文件注释
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        StringBuilder sb = new StringBuilder();
        topLevelClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getRemarks());
        sb.append("\n");
        sb.append(" * 工具生成不可修改\n");
        sb.append(" * @author zp\n");
        sb.append(" * @date "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine(" */");
    }
}
