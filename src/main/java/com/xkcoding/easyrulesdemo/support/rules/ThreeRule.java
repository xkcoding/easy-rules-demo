package com.xkcoding.easyrulesdemo.support.rules;

import com.xkcoding.easyrulesdemo.model.CheckModel;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * <p>
 * 被 3 整除的规则
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/10/16 14:36
 */
@Slf4j
@Rule(name = "three")
public class ThreeRule extends BaseNumberRule {
    @Priority
    public int getPriority() {
        return 1;
    }

    @Override
    protected void doAction(CheckModel model) {
        model.setScore(model.getScore() + 3);
        log.info("{} 能被 3 整除，得 3 分，当前得分 {}", model.getNumber(), model.getScore());
    }

    @Override
    protected boolean getCondition(CheckModel model) {
        return model.getNumber() % 3 == 0;
    }
}
