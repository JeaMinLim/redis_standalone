package test.jmlim.redis.standalone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.jmlim.redis.standalone.StandaloneService;

@Controller
public class StandaloneController {
    @Autowired
    private StandaloneService standaloneService;

    /* Key-Value in the code
    String KEY = "username";
    String VALUE = "jmlim";
     */
    @Value("${property.RedisKey}")
    private String KEY;
    @Value("${property.RedisValue}")
    private String VALUE;

    @RequestMapping(value = "/standalone", method= RequestMethod.GET)
    public String standalone(Model model) {

        standaloneService.setRedisValue(KEY, VALUE);
        String RESULT = standaloneService.getRedisValue(KEY);
        System.out.println(RESULT);
        model.addAttribute("RESULT", RESULT);
        return "redis.html";
    }
}
