package ${basePackage}.model;

import lombok.Data;

/**
 * 数据模型
 */
@Data
public class DataModel {
<#list modelConfig.models as modelInfo>
    <#if modelInfo.groupKey??>
        public ${modelInfo.type} ${modelInfo.groupKey};
        @Data
        public class ${modelInfo.type} {
            <#list modelInfo.models as modelInfo>
                <#if modelInfo.description??>
                    /**
                    * ${modelInfo.description}
                    */
                </#if>
                public ${modelInfo.type} ${modelInfo.fieldName} <#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
            </#list>
        }
        <#else>
<#if modelInfo.description??>
    /**
    * ${modelInfo.description}
    */
</#if>
    public ${modelInfo.type} ${modelInfo.fieldName} <#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
    </#if>
</#list>
}