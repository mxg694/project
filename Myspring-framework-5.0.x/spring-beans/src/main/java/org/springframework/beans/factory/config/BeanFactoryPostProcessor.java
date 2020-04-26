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

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 Allows for custom modification of an application context's bean definitions,
 adapting the bean property values of the context's underlying bean factory.
 *
 <p>Application contexts can auto-detect BeanFactoryPostProcessor beans in
 their bean definitions and apply them before any other beans get created.
 *
 <p>Useful for custom config files targeted at system administrators that
 override bean properties configured in the application context.
 *
 <p>See PropertyResourceConfigurer and its concrete implementations
 for out-of-the-box(开箱即用) solutions that address such configuration needs.
 *
 <p>A BeanFactoryPostProcessor may interact with and modify bean
 definitions, but never bean instances. Doing so may cause premature bean
 instantiation, violating the container and causing unintended side-effects.
 If bean instance interaction is required, consider implementing
 {@link BeanPostProcessor} instead.
 *
 @author Juergen Hoeller
 @since 06.07.2003
 @see BeanPostProcessor
 @see PropertyResourceConfigurer
 */

/**
 允许自定义修改应用程序上下文的bean定义，调整上下文的基础bean工厂的bean属性值
 应用程序上下文可以自动检测BeanFactoryPostProcessor bean 它们的bean定义，并在创建任何其他bean之前应用它们。
 有用的自定义配置文件的目标系统管理员 重写在应用程序上下文中配置的bean属性。
 参见PropertyResourceConfigurer及其具体实现 开箱即用的(开箱即用)解决这样的配置需求的解决方案。
 BeanFactoryPostProcessor可以与bean交互并修改它定义，但从来没有bean实例
 这样做可能会导致早熟实例化，违反容器，造成意外的副作用。
 如果需要bean实例交互，请考虑实现{@link BeanPostProcessor}。
 */
@FunctionalInterface
public interface BeanFactoryPostProcessor {

	/**
	 Modify the application context's internal bean factory after its standard
	 initialization. All bean definitions will have been loaded, but no beans
	  will have been instantiated yet.. This allows for overriding or adding
	 properties even to eager-initializing beans
	  @param beanFactory the bean factory used by the application context
	  @throws org.springframework.beans.BeansException in case of errors
	 *
	  根据应用程序上下文的标准修改它的内部bean工厂 初始化
	  将加载所有bean定义，但不加载bean 将已经被实例化。
	  这允许覆盖或添加 属性，甚至包括急于初始化的bean
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
