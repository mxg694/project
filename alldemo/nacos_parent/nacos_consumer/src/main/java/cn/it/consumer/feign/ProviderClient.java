package cn.it.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "serve-provider")
public interface ProviderClient {

    @GetMapping("/service")
    String service();
}
