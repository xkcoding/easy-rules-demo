package com.xkcoding.easyrulesdemo.support.rules;

import com.xkcoding.easyrulesdemo.model.CheckModel;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.*;

/**
 * <p>
 * 被 5 整除的规则
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/10/16 14:36
 */
@Slf4j
@Rule(name = "five")
public class FiveRule extends BaseNumberRule {
    @Priority
    public int getPriority() {
        return 2;
    }

    @Override
    protected void doAction(CheckModel model) {
        model.setScore(model.getScore() + 5);
        log.info("{} 能被 5 整除，得 5 分，当前得分 {}", model.getNumber(), model.getScore());
    }

    @Override
    protected boolean getCondition(CheckModel model) {
        return model.getNumber() % 5 == 0;
    }
}
