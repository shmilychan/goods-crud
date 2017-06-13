package cn.czl.goods.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations = {"classpath:spring/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class IGoodsServiceTest {

	@Resource
	private IGoodsService goodsService;
	
	@Test
	public void testAddPre() {
		try {
			System.out.println(this.goodsService.addPre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
