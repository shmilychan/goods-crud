package cn.czl.goods.service;

import java.util.Map;
import java.util.Set;

import cn.czl.goods.vo.Goods;

public interface IGoodsService {
	/**
	 * 批量删除商品信息，逻辑删除
	 * @param gids 商品ID的集合
	 * @return 删除成功返回true，失败返回false
	 */
	public boolean delete(Set<Long> gids);
	/**
	 * 更新商品信息
	 * @param gid 要修改的商品编号
	 * @return 成功返回true，失败返回false
	 */
	public boolean edit(Goods vo);
	/**
	 * 进行商品信息更新前的查询操作
	 * @param gid 要修改的商品编号
	 * @return 包括如下内容：<br>
	 * 1.key = allItems, value = 所有的一级分类信息
	 * 2.key = allSubitems , value = 所有的二级分类信息
	 * 3.key = goods, value = 商品数据<br>
	 */
	public Map<String, Object> editPre(Long gid);
	/**
	 * 进行所有商品信息的列出操作
	 * @param currentPage 当前页
	 * @param lineSize 每页显示行数
	 * @param column 数据列
	 * @param keyWord 关键字
	 * @return 返回商品信息的Map集合
	 */
	public Map<String, Object> list(long currentPage,int lineSize,String column,String keyWord);
	/**
	 * 增加商品信息
	 * @param vo 商品信息vo对象
	 * @return 成功返回true
	 */
	public boolean add(Goods vo);
	/**
	 * 实现商品商品信息增加前的查询
	 * @return 包括如下内容：<br>
	 * 1.key = allItems , value = 所有的一级菜单<br>
	 * 
	 */
	public Map<String, Object> addPre();
}
