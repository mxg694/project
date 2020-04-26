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
import org.springframework.lang.Nullable;

/**
   Factory hook that allows for custom modification of new bean instances,
   e.g. checking for marker interfaces or wrapping them with proxies.
 *
   <p>ApplicationContexts can autodetect BeanPostProcessor beans in their
   bean definitions and apply them to any beans subsequently created.
   Plain bean factories allow for programmatic registration of post-processors,
   applying to all beans created through this factory.
 *
   <p>Typically, post-processors that populate beans via marker interfaces
   or the like will implement {@link #postProcessBeforeInitialization},
   while post-processors that wrap beans with proxies will normally
   implement {@link #postProcessAfterInitialization}.
 *
   @author Juergen Hoeller
   @since 10.10.2003
   @see InstantiationAwareBeanPostProcessor
   @see DestructionAwareBeanPostProcessor
   @see ConfigurableBeanFactory#addBeanPostProcessor
   @see BeanFactoryPostProcessor

   工厂挂钩，允许自定义修改新的bean实例， 例如，检查标记接口或用代理包装它们。
   ApplicationContexts可以自动检测它们中的BeanPostProcessor bean 和 bean definitions ，并将它们应用于随后创建的任何bean。
   普通的bean工厂允许编程注册后处理程序， 应用于通过该工厂创建的所有bean。
   通常，后处理程序通过标记接口填充bean
   或者类似的将实现{@link # postprocessbeforeinitialize}，
   而用代理包装bean的后处理器通常会 实现{@link # postProcessAfterInitialization}
 */
public interface BeanPostProcessor {

	/**
	   Apply this BeanPostProcessor to the given new bean instance <i>before</i> any bean
	   initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	   or a custom init-method). The bean will already be populated with property values.
	   The returned bean instance may be a wrapper around the original.
	   <p>The default implementation returns the given {@code bean} as-is.
	   @param bean the new bean instance
	   @param beanName the name of the bean
	   @return the bean instance to use, either the original or a wrapped one;
	   if {@code null}, no subsequent BeanPostProcessors will be invoked
	   @throws org.springframework.beans.BeansException in case of errors
	   @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet

	   在</i>任何bean之前，将这个BeanPostProcessor应用到给定的新bean实例<i>
	   初始化回调(比如InitializingBean的{@code afterPropertiesSet}) 或自定义init-方法)。
	   bean已经被填充了属性值。
	   返回的bean实例可能是原始bean的包装器。

	 */
	@Nullable
	default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/**
	   Apply this BeanPostProcessor to the given new bean instance <i>after</i> any bean
	   initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	   or a custom init-method). The bean will already be populated with property values.
	   The returned bean instance may be a wrapper around the original.
	   <p>In case of a FactoryBean, this callback will be invoked for both the FactoryBean
	   instance and the objects created by the FactoryBean (as of Spring 2.0). The
	   post-processor can decide whether to apply to either the FactoryBean or created
	   objects or both through corresponding {@code bean instanceof FactoryBean} checks.
	   <p>This callback will also be invoked after a short-circuiting triggered by a
	   {@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation} method,
	   in contrast to all other BeanPostProcessor callbacks.
	   <p>The default implementation returns the given {@code bean} as-is.
	   @param bean the new bean instance
	   @param beanName the name of the bean
	   @return the bean instance to use, either the original or a wrapped one;
	   if {@code null}, no subsequent BeanPostProcessors will be invoked
	   @throws org.springframework.beans.BeansException in case of errors
	   @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
	   @see org.springframework.beans.factory.FactoryBean

	   在任何bean </i>之后，将这个BeanPostProcessor应用到给定的新bean实例<i>
	   初始化回调(比如InitializingBean的{@code afterPropertiesSet}) 或自定义init-方法)
	   bean已经被填充了属性值。 返回的bean实例可能是原始bean的包装器。
	   对于FactoryBean，将为这两个FactoryBean调用这个回调 实例和FactoryBean创建的对象(从Spring 2.0开始)。
	   后处理器可以决定是应用于FactoryBean还是应用于已创建的FactoryBean
	   对象或两者都通过相应的{@code bean instanceof FactoryBean}检查。
	   与其他所有BeanPostProcessor回调不同。
	   在触发的短路后也将调用此回调 {@link InstantiationAwareBeanPostProcessor # postProcessBeforeInstantiation}方法,
	   默认实现按原样返回给定的{@code bean}
	 */

	@Nullable
	default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
