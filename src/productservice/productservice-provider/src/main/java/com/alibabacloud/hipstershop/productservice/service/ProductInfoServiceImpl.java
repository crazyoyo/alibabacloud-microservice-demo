package com.alibabacloud.hipstershop.productservice.service;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.alibabacloud.hipstershop.productservice.entity.ProductInfo;
import com.alibabacloud.hipstershop.productservice.repository.ProductInfoRepository;

/**
 * 对内的product service实现类。
 *
 * @date 2020/7/8
 */
@Service
public class ProductInfoServiceImpl implements ProductServiceApi {

    // @Resource
    // NacosConfigManager nacosConfigManager;

    @Value("${serviceVersion}")
    private String serviceVersion;

    @Resource
    ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo getProduct(String id) {
        Optional<ProductInfo> productInfo = productInfoRepository.findById(id);
        return productInfo.orElse(null);
    }

    @Override
    public List<ProductInfo> getAllProduct() {
        return productInfoRepository.findAll();
    }

    @Override
    public String setConfig(String dataId, String group, String content) {
        // try {
        //     if("clear".equals(content)){
        //         nacosConfigManager.getConfigService().publishConfig(dataId, group, "no exception!");
        //         return "config clear!";
        //     }
        //     else {
        //         content = content.replace('@', '\n');
        //         nacosConfigManager.getConfigService().publishConfig(dataId, group, content);
        //         return "config success!";
        //     }
        // } catch (NacosException e) {
        //     e.printStackTrace();
        //     return "config error!";
        // }
        return "not implemented";
    }

    @Override
    public String addFaultInstance(String dataId, String group, String content) {
        // try {
        //     FaultInfo faultInfo = new FaultInfo(dataId, group, content);
        //     if(faultInfo.isClear()){
        //         nacosConfigManager.getConfigService().publishConfig(dataId, group, "no exception!");
        //         return "";
        //     }
        //     else {
        //         String ip = getLocalIp();
        //         faultInfo.getIps().add(ip);
        //         nacosConfigManager.getConfigService().publishConfig(dataId, group, faultInfo.getContent());
        //         return String.join(",", faultInfo.getIps());
        //     }
        // } catch (NacosException e) {
        //     e.printStackTrace();
        //     return "config error!";
        // }
        return "not implemented";
    }
}
