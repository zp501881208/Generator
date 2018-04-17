/**
 *    Copyright 2010-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.magict.magic.spring.mapper;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionTemplate;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * BeanFactory that enables injection of MyBatis mapper interfaces. It can be set up with a
 * SqlSessionFactory or a pre-configured SqlSessionTemplate.
 * <p>
 * Sample configuration:
 * <p>
 * <pre class="code">
 * {@code
 * <bean id="baseMapper" class="org.mybatis.spring.mapper.MapperFactoryBean" abstract="true" lazy-init="true">
 * <property name="sqlSessionFactory" ref="sqlSessionFactory" />
 * </bean>
 * <p>
 * <bean id="oneMapper" parent="baseMapper">
 * <property name="mapperInterface" value="my.package.MyMapperInterface" />
 * </bean>
 * <p>
 * <bean id="anotherMapper" parent="baseMapper">
 * <property name="mapperInterface" value="my.package.MyAnotherMapperInterface" />
 * </bean>
 * }
 * </pre>
 * <p>
 * Note that this factory can only inject <em>interfaces</em>, not concrete classes.
 *
 * @author Eduardo Macarron
 * @author liuzh
 * @see SqlSessionTemplate
 */
public class MapperFactoryBean<T> extends org.mybatis.spring.mapper.MapperFactoryBean<T> {

    private Class<T> mapperInterface;

    private MapperHelper mapperHelper;

    public MapperFactoryBean() {
        //intentionally empty
    }

    public MapperFactoryBean(Class<T> mapperInterface) {
        super(mapperInterface);
        this.mapperInterface = mapperInterface;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void checkDaoConfig() {
        super.checkDaoConfig();
        Configuration configuration = getSqlSession().getConfiguration();
        //直接针对接口处理通用接口方法对应的 MappedStatement 是安全的，通用方法不会出现 IncompleteElementException 的情况
        if (configuration.hasMapper(this.mapperInterface) && mapperHelper != null && mapperHelper.isExtendCommonMapper(this.mapperInterface)) {
            mapperHelper.processConfiguration(getSqlSession().getConfiguration(), this.mapperInterface);
        }
    }

    /**
     * 设置通用 Mapper 配置
     *
     * @param mapperHelper
     */
    public void setMapperHelper(MapperHelper mapperHelper) {
        this.mapperHelper = mapperHelper;
    }
}
