package ${package};

import ${tableClass.fullClassName};
<#if baseMapper??>import ${baseMapper!};
<#else>import tk.mybatis.mapper.common.Mapper;</#if>
<#assign dateTime = .now>

/**
* ${tableClass.introspectedTable.remarks}
* @author zp
* @date ${dateTime?string["yyyy-MM-dd HH:mm:ss"]}
*/
public interface ${tableClass.shortClassName}${mapperSuffix} extends ${baseMapper!"Mapper"}<${tableClass.shortClassName}> {

}
