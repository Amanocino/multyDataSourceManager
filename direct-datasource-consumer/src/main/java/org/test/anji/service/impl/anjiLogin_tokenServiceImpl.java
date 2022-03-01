package org.test.anji.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.test.anji.domain.anjiLogin_tokenEntity;
import org.test.anji.mapper.anjiLogin_tokenMapper;
import org.test.anji.service.anjiLogin_tokenService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 持久化用户登录会话 服务实现类
 * </p>
 *
 * @author ChenZhiCheng
 * @since 2022-02-28
 */
@Service
public class anjiLogin_tokenServiceImpl extends ServiceImpl<anjiLogin_tokenMapper, anjiLogin_tokenEntity> implements anjiLogin_tokenService {

}
