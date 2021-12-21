package com.amanoisuno.dynamicdatasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DynamicDatasourceApplicationTests {

	@Autowired
	interfaceFileSonImpl interfaceFileSon;
	@Test
	void contextLoads() {
		interfaceFile interfaceFile = interfaceFileSon;
		interfaceFile.testInterface("12");
	}

}
