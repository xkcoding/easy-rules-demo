package com.xkcoding.easyrulesdemo.controller;

import cn.hutool.core.lang.Dict;
import com.xkcoding.easyrulesdemo.model.CheckModel;
import com.xkcoding.easyrulesdemo.support.rules.FiveRule;
import com.xkcoding.easyrulesdemo.support.rules.OtherRule;
import com.xkcoding.easyrulesdemo.support.rules.ThreeAndFiveRule;
import com.xkcoding.easyrulesdemo.support.rules.ThreeRule;
import com.xkcoding.magic.core.tool.api.R;
import lombok.RequiredArgsConstructor;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/10/16 14:06
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TestController {
    private final RulesEngine rulesEngine;

    @GetMapping("/rules/{num}")
    public R testRules(@PathVariable Long num) {
        Facts facts = new Facts();
        facts.put("model", new CheckModel(num, 0L));

        Rules rules = new Rules();
        rules.register(new ThreeRule());
        rules.register(new FiveRule());
        rules.register(new ThreeAndFiveRule());
        rules.register(new OtherRule());

        // 校验符合的规则
        Map<Rule, Boolean> check = rulesEngine.check(rules, facts);
        // 执行
        rulesEngine.fire(rules, facts);
        return R.success(Dict.create().set("check", check).set("facts", facts));
    }
}
