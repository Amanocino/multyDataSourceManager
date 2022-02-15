package org.example.service;

import org.example.common.api.R;

public interface MemberService {

    /**
     * 生成验证码
     */
    R generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    R verifyAuthCode(String telephone, String authCode);
}
