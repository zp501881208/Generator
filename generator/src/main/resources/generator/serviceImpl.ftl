package ${package};

import ${tableClass.fullClassName};
import ${basePackage}.mapper.${tableClass.shortClassName}Mapper;
import ${basePackage}.service.${tableClass.shortClassName}Service;
<#if baseServiceImpl??>import ${baseServiceImpl!};
<#else>import ${package}.BaseServiceImpl;</#if>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<#assign dateTime = .now>

/**
* ${tableClass.introspectedTable.remarks}实现
* @author zp
* @date ${dateTime?string["yyyy-MM-dd HH:mm:ss"]}
*/
@Service("${tableClass.variableName}Service")
public class ${tableClass.shortClassName}${mapperSuffix} extends ${baseServiceImpl!"BaseServiceImpl"}<${tableClass.shortClassName}> implements ${tableClass.shortClassName}Service{
    @Autowired
    private ${tableClass.shortClassName}Mapper ${tableClass.variableName}Mapper;


}