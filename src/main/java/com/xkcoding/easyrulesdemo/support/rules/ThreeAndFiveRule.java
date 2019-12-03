package com.xkcoding.easyrulesdemo.support.rules;

import com.xkcoding.easyrulesdemo.model.CheckModel;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.*;

/**
 * <p>
 * 被 3 和 5 整除的规则
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/10/16 14:36
 */
@Slf4j
@Rule(name = "three and five")
public class ThreeAndFiveRule extends BaseNumberRule{
    @Priority
    public int getPriority() {
        return 0;
    }

    @Override
    protected void doAction(CheckModel model) {
        model.setScore(model.getScore() + 10);
        log.info("{} 能被 3 整除也能被 5 整除，得 10 分，当前得分 {}", model.getNumber(), model.getScore());
    }

    @Override
    protected boolean getCondition(CheckModel model) {
        return model.getNumber() % 3 == 0 && model.getNumber() % 5 == 0;
    }
}
