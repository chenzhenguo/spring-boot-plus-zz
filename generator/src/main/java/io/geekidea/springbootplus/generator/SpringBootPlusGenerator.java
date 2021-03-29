/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.geekidea.springbootplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import io.geekidea.springbootplus.generator.config.GeneratorStrategy;
import io.geekidea.springbootplus.generator.constant.GeneratorConstant;
import io.geekidea.springbootplus.generator.properties.GeneratorProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;

import static io.geekidea.springbootplus.generator.constant.GeneratorConstant.MAPPER_XML_TEMPLATE_PATH;

/**
 * spring-boot-plus代码生成器入口类
 *
 * @author geekidea
 * @date 2019-10-22
 **/
@Component
public class SpringBootPlusGenerator {

    /**
     * 生成代码
     * @param args
     */
    public static void main(String[] args) {
        GeneratorProperties generatorProperties = new GeneratorProperties();

        // 设置基本信息
        generatorProperties
                .setMavenModuleName("example")
                .setParentPackage("com.zz.project.provide.yy")
                .setAuthor("czg")
                .setFileOverride(true);
        // 设置表信息
        generatorProperties.addTable("sys_post","post_id");
        // 设置表前缀
      //   generatorProperties.setTablePrefix(Arrays.asList("zz_"));

        // 数据源配置
        generatorProperties.getDataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver")

//                .setDriverName("org.postgresql.Driver")
//                .setSchemaName("zzgtkjjcxxpt_dev")
                .setUrl("jdbc:mysql://localhost:3306/ry?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
             //   .setUrl("jdbc:postgresql://192.168.16.48:5432/postgres?searchpath=zzgtkjjcxxpt_dev&stringtype=unspecified&tSchema=zzgtkjjcxxpt_dev");

        // 生成配置
        generatorProperties.getGeneratorConfig()
                .setGeneratorStrategy(GeneratorStrategy.ALL)
                .setGeneratorEntity(true)
                .setGeneratorController(true)
                .setGeneratorService(true)
                .setGeneratorServiceImpl(true)
                .setGeneratorMapper(true)
                .setGeneratorMapperXml(true)
                .setGeneratorPageParam(true)
                .setGeneratorQueryVo(true)
                .setRequiresPermissions(false)
                .setPageListOrder(true)
                .setParamValidation(false)
                .setSwaggerTags(true)
                .setOperationLog(true);

        // 全局配置
        generatorProperties.getMybatisPlusGeneratorConfig().getGlobalConfig()
                .setOpen(true)
                .setSwagger2(true)
                .setIdType(IdType.AUTO)
                .setDateType(DateType.ONLY_DATE)
                .setBaseColumnList(true);

        // 策略配置
        generatorProperties.getMybatisPlusGeneratorConfig().getStrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setVersionFieldName(GeneratorConstant.VERSION)
                .setLogicDeleteFieldName(GeneratorConstant.DELETED)
                .setSuperMapperClass("com.zz.common.base.BaseMapper")
                .setSuperServiceClass("com.zz.common.base.IBaseService")
                .setSuperServiceImplClass("com.zz.common.base.IBaseService")
                .setSuperEntityClass("com.zz.common.base.BaseEntity")
                .setSuperEntityColumns("sid","tzzd","scbj","pxbj","djr","djsj","gxr","gxsj","bz");

        // 生成代码
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.generator(generatorProperties);

    }


}
