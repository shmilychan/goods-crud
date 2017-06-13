package cn.czl.goods.dao;

import java.util.List;

import cn.czl.goods.vo.Subitem;
import cn.czl.util.dao.IBaseDAO;

public interface ISubitemDAO extends IBaseDAO<Long, Subitem> {
	/**
	 * 根据一级分类ID列出该一级分类下的所有二级分类
	 * @param iid 一节栏目ID
	 * @return 返回多有的一级栏目下的二级栏目
	 */
	public List<Subitem> findAllByItem(Long iid);
}
