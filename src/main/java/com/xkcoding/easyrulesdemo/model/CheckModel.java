package com.xkcoding.easyrulesdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * 校验对象
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/10/16 15:00
 */
@Data
@AllArgsConstructor
public class CheckModel {
    private Long number;
    private Long score;
}
