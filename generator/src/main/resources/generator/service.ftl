package ${package};

import ${tableClass.fullClassName};

<#if baseService??>import ${baseService!};
<#else>import ${package}.BaseService;</#if>
<#assign dateTime = .now>

/**
* ${tableClass.introspectedTable.remarks}接口
* @author zp
* @date ${dateTime?string["yyyy-MM-dd HH:mm:ss"]}
*/
public interface ${tableClass.shortClassName}${mapperSuffix} extends ${baseService!"BaseService"} {
    ${tableClass.shortClassName} selectByPrimaryKey(Integer id);
}