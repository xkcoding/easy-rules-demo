package com.xkcoding.easyrulesdemo.support.rules;

import com.xkcoding.easyrulesdemo.model.CheckModel;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;

/**
 * <p>
 * 数值校验基类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/12/3 10:41
 */
public abstract class BaseNumberRule {
    @Condition
    public final boolean condition(@Fact("model") CheckModel model) {
        return getCondition(model);
    }

    @Action
    public final void action(@Fact("model") CheckModel model) {
       doAction(model);
    }

    protected abstract void doAction(CheckModel model);

    protected abstract boolean getCondition(CheckModel model);
}
