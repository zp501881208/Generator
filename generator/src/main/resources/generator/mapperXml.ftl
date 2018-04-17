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
</mapper>
