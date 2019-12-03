package com.xkcoding.easyrulesdemo.support.rules;

import com.xkcoding.easyrulesdemo.model.CheckModel;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * <p>
 * 其余规则
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/10/16 14:36
 */
@Slf4j
@Rule(name = "other")
public class OtherRule extends BaseNumberRule {

    @Priority
    public int getPriority() {
        return 3;
    }

    @Override
    protected void doAction(CheckModel model) {
        log.info("{} 不能被 3 整除且不能被 5 整除，得 0 分，当前得分 {}", model.getNumber(), model.getScore());
    }

    @Override
    protected boolean getCondition(CheckModel model) {
        return model.getNumber() % 3 != 0 && model.getNumber() % 5 != 0;
    }
}
