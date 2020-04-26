/*
   Copyright 2002-2016 the original author or authors.
 *
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 *
        https://www.apache.org/licenses/LICENSE-2.0
 *
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.springframework.core.env;

/**
   Interface representing the environment in which the current application is running.
   Models two key aspects of the application environment: <em>profiles</em> and
   <em>properties</em>. Methods related to property access are exposed via the
   {@link PropertyResolver} superinterface.
 *
   <p>A <em>profile</em> is a named, logical group of bean definitions to be registered
   with the container only if the given profile is <em>active</em>. Beans may be assigned
   to a profile whether defined in XML or via annotations; see the spring-beans 3.1 schema
   or the {@link org.springframework.context.annotation.Profile @Profile} annotation for
   syntax details. The role of the {@code Environment} object with relation to profiles is
   in determining which profiles (if any) are currently {@linkplain #getActiveProfiles
   active}, and which profiles (if any) should be {@linkplain #getDefaultProfiles active
   by default}.
 *
   <p><em>Properties</em> play an important role in almost all applications, and may
   originate from a variety of sources: properties files, JVM system properties, system
   environment variables, JNDI, servlet context parameters, ad-hoc Properties objects,
   Maps, and so on. The role of the environment object with relation to properties is to
   provide the user with a convenient service interface for configuring property sources
   and resolving properties from them.
 *
   <p>Beans managed within an {@code ApplicationContext} may register to be {@link
   org.springframework.context.EnvironmentAware EnvironmentAware} or {@code @Inject} the
   {@code Environment} in order to query profile state or resolve properties directly.
 *
   <p>In most cases, however, application-level beans should not need to interact with the
   {@code Environment} directly but instead may have to have {@code ${...}} property
   values replaced by a property placeholder configurer such as
   {@link org.springframework.context.support.PropertySourcesPlaceholderConfigurer
   PropertySourcesPlaceholderConfigurer}, which itself is {@code EnvironmentAware} and
   as of Spring 3.1 is registered by default when using
   {@code <context:property-placeholder/>}.
 *
   <p>Configuration of the environment object must be done through the
   {@code ConfigurableEnvironment} interface, returned from all
   {@code AbstractApplicationContext} subclass {@code getEnvironment()} methods. See
   {@link ConfigurableEnvironment} Javadoc for usage examples demonstrating manipulation
   of property sources prior to application context {@code refresh()}.
 *
   @author Chris Beams
   @since 3.1
   @see PropertyResolver
   @see EnvironmentCapable
   @see ConfigurableEnvironment
   @see AbstractEnvironment
   @see StandardEnvironment
   @see org.springframework.context.EnvironmentAware
   @see org.springframework.context.ConfigurableApplicationContext#getEnvironment
   @see org.springframework.context.ConfigurableApplicationContext#setEnvironment
   @see org.springframework.context.support.AbstractApplicationContext#createEnvironment

   表示当前应用程序正在其中运行的环境的接口，
   对应用程序环境的两个关键方面建模:<em>profiles</em>和 < em > properties< / em >属性。
   方法公开与属性访问相关的方法 {@link PropertyResolver}超接口

   一个<em>profiles</em>是一个命名的、要注册的bean定义的逻辑组 只有当给定的配置文件<em>active</em>时，才使用容器
   可以分配bean 到XML或通过注释定义的配置文件;
   参见spring-beans 3.1模式 或者{@link org.springframework.context.annotation。配置文件@Profile}注释 语法细节
   与配置文件相关的{@code Environment}对象的角色是 在确定哪些配置文件(如果有的话)当前是{@linkplain #getActiveProfiles ，
   以及哪些配置文件(如果有的话)应该是{@linkplain #getDefaultProfiles active 在默认情况下}

   <em>properties</em>在几乎所有的应用中起着重要的作用，
   并且可能 源自多种来源:属性文件、JVM系统属性、系统 环境变量、JNDI、servlet上下文参数、特定属性对象、 Map等等。
   与属性相关的环境对象的作用是 为用户配置属性源提供方便的服务接口 并从中解析属性。

   在{@code ApplicationContext}中管理的bean可以注册为{@link org.springframework.context。
   或{@code @Inject} {@code环境}，以便查询配置文件状态或直接解析属性。

   但是，在大多数情况下，应用程序级bean不需要与 {@code环境}直接，
   但可能必须有{@code ${…}}属性 属性占位符配置程序替换的值，
   如 {@link org.springframework.context.support.PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer}，
   它本身是{@code EnvironmentAware}和 从Spring 3.1开始，在使用时默认注册 {@code <上下文:property-placeholder / >}。

   环境对象的配置必须通过 {code ConfigurableEnvironment}接口，返回所有 {@code AbstractApplicationContext}子类{@code getEnvironment()方法
   看到 {@link ConfigurableEnvironment} Javadoc用于演示操作的使用示例 属性源之前的应用程序上下文{@code refresh()}。
 */
public interface Environment extends PropertyResolver {

	/**
	   Return the set of profiles explicitly made active for this environment. Profiles
	   are used for creating logical groupings of bean definitions to be registered
	   conditionally, for example based on deployment environment.  Profiles can be
	   activated by setting {@linkplain AbstractEnvironment#ACTIVE_PROFILES_PROPERTY_NAME
	   "spring.profiles.active"} as a system property or by calling
	   {@link ConfigurableEnvironment#setActiveProfiles(String...)}.
	   <p>If no profiles have explicitly been specified as active, then any
	   {@linkplain #getDefaultProfiles() default profiles} will automatically be activated.
	   @see #getDefaultProfiles
	   @see ConfigurableEnvironment#setActiveProfiles
	   @see AbstractEnvironment#ACTIVE_PROFILES_PROPERTY_NAME
	 */
	String[] getActiveProfiles();

	/**
	   Return the set of profiles to be active by default when no active profiles have
	   been set explicitly.
	   @see #getActiveProfiles
	   @see ConfigurableEnvironment#setDefaultProfiles
	   @see AbstractEnvironment#DEFAULT_PROFILES_PROPERTY_NAME
	 */
	String[] getDefaultProfiles();

	/**
	   Return whether one or more of the given profiles is active or, in the case of no
	   explicit active profiles, whether one or more of the given profiles is included in
	   the set of default profiles. If a profile begins with '!' the logic is inverted,
	   i.e. the method will return true if the given profile is <em>not</em> active.
	   For example, <pre class="code">env.acceptsProfiles("p1", "!p2")</pre> will
	   return {@code true} if profile 'p1' is active or 'p2' is not active.
	   @throws IllegalArgumentException if called with zero arguments
	   or if any profile is {@code null}, empty or whitespace-only
	   @see #getActiveProfiles
	   @see #getDefaultProfiles
	 */
	boolean acceptsProfiles(String... profiles);

}
