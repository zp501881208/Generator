<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapperPackage}.${tableClass.shortClassName}${mapperSuffix}">
    <resultMap id="BaseResultMap" type="${entityPackage}.${tableClass.shortClassName}">
        <#if tableClass.allFields??>
        <#list tableClass.allFields as field>
        <result column="${field.columnName}" jdbcType="${field.jdbcType}" property="${field.fieldName}" />
        </#list>
        </#if>
    </resultMap>

    <!-- 自行选择是否增加 -->
    <sql id="Base_Column_List" >
    <#if tableClass.allFields??>
        <#list tableClass.allFields as field>
        <#if field_index==0>
        ${field.columnName}
        </#if>
        <#if field_index!=0>
        ,${field.columnName}
        </#if>
        </#list>
    </#if>
    </sql>
</mapper>
