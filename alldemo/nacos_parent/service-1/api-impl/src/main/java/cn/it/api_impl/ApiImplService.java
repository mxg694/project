package cn.it.api_impl;

import cn.it.api.ApiService;

/**
 * author: mxg
 * // 注解表示
 * // 此类的方法将来要暴露为Dubbo接口
 */
@org.apache.dubbo.config.annotation.Service
public class ApiImplService implements ApiService {

    /**
     * 调用其他 微服务   service1 调用 service2
     * @return
     */
//    @org.apache.dubbo.config.annotation.Reference
//    ProviderService providerService;

    @Override
    public String service() {

        System.out.println("dubbo 调用");
        return "service1 -api-impl invoke";
    }
}
