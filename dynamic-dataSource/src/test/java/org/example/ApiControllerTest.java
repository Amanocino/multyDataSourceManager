package org.example;

import org.example.config.factory.ServiceAction;
import org.example.test1.domain.Lamp_UserEntity;
import org.example.test1.service.Lamp_UserService;
import org.example.test1.service.impl.Lamp_UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhicheng chen
 * @date : 2022/2/16
 * @time : 9:29
 */
@SpringBootTest
public class ApiControllerTest {
    // 最大循环次数
    private static final int MAXCOUNT = 100000;
//
//    @Autowired
//    private Lamp_UserServiceImpl lamp_userService;
//
//    /**
//     * 循环单次插入
//     */
//    @Test
//    void save() {
//        long stime = System.currentTimeMillis(); // 统计开始时间
//        long etime0; // 统计结束时间
//        for (int i = 0; i < MAXCOUNT; i++) {
//            Lamp_UserEntity user = new Lamp_UserEntity();
//            user.setName("test:" + i);
//            user.setId(1000+i);
//            if (i==1000){
//                etime0 = System.currentTimeMillis();
//                System.out.println("1000执行时间：" + (etime0 - stime));
//            }
//
//            if (i==10000){
//                etime0 = System.currentTimeMillis();
//                System.out.println("10000执行时间：" + (etime0 - stime));
//            }
//            lamp_userService.save(user);
//        }
//        long etime = System.currentTimeMillis(); // 统计结束时间
//        System.out.println("执行时间：" + (etime - stime));
//    }
//
//    @Test
//    void saveMPBatch() {
//        long stime = System.currentTimeMillis(); // 统计开始时间
//        long etime0; // 统计结束时间
//        List<Lamp_UserEntity> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {//MAXCOUNT
//            Lamp_UserEntity user = new Lamp_UserEntity();
//            user.setName("test:" + i);
//            user.setId(1000+i);
//            list.add(user);
//        }
//
////        lamp_userService.saveBatchCustom(list);
//        long etime = System.currentTimeMillis(); // 统计结束时间
//        System.out.println("执行时间：" + (etime - stime));
//    }
}
