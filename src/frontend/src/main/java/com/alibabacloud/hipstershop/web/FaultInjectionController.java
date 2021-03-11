package com.alibabacloud.hipstershop.web;

// import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibabacloud.hipstershop.dao.ProductDAO;
import com.alibabacloud.hipstershop.domain.bo.fault.FaultInfo;
import com.alibabacloud.hipstershop.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.HashSet;

/**
 * @author xiaofeng.gxf
 * @date 2020/8/25
 */
@Controller
@RequestMapping(value = "/fault")
public class FaultInjectionController {

    @Resource
    ProductDAO productDAO;

    // @Resource
    // NacosConfigManager nacosConfigManager;

    private final String dataId = "productservice.properties";
    private final String group = "DEFAULT_GROUP";


    @GetMapping("/result")
    public String faultInjection(){
        return "fault.html";
    }

    @RequestMapping("/start/fullgc")
    public RedirectView startFullGc(RedirectAttributes redirectAttributes){
        FaultInfo faultInfo = new FaultInfo(dataId, group, new HashSet<>(), 50, Constant.FULL_GC, 1);
        String ips = productDAO.addFaultInstance(dataId, group, faultInfo.getContent());
        redirectAttributes.addFlashAttribute("startFullGCResult", "product的实例：" + ips + " 注入fullgc");
        return new RedirectView("/fault/result");
    }

    @RequestMapping("/end/fullgc")
    public RedirectView endFullGc(RedirectAttributes redirectAttributes){
        try {
            //nacosConfigManager.getConfigService().publishConfig(dataId, group, "no exception!");
            redirectAttributes.addFlashAttribute("endFullGCResult", "fullgc故障已清除");
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("endFullGCResult", "故障清除失败");
        }
        return new RedirectView("/fault/result");
    }

    @RequestMapping("/start/timeout")
    public RedirectView startTimeout(RedirectAttributes redirectAttributes){
        FaultInfo faultInfo = new FaultInfo(dataId, group, new HashSet<>(), 50, Constant.SLEEP, 500);
        String ips = productDAO.addFaultInstance(dataId, group, faultInfo.getContent());
        redirectAttributes.addFlashAttribute("startTimeoutResult", "注入Timeout 故障实例IP：" + ips);
        return new RedirectView("/fault/result");
    }

    @RequestMapping("/end/timeout")
    public RedirectView endTimeout(RedirectAttributes redirectAttributes){
        try {
            //nacosConfigManager.getConfigService().publishConfig(dataId, group, "no exception!");
            redirectAttributes.addFlashAttribute("endTimeoutResult", "Timeout 故障已清除");
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("endFullGCResult", "故障清除失败");
        }
        return new RedirectView("/fault/result");
    }

}
