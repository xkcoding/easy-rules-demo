package com.xkcoding.easyrulesdemo.config;

import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * easy-rules 配置
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/10/16 14:03
 */
@Configuration
public class EasyRulesConfig {
    @Bean
    public RulesEngine rulesEngine() {
        // skipOnFirstAppliedRule: 匹配到第一条规则就跳过后面规则匹配
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        return new DefaultRulesEngine(parameters);

        // return new DefaultRulesEngine();
    }
}
