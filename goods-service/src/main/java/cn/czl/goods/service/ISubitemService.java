package cn.czl.goods.service;

import java.util.List;

import cn.czl.goods.vo.Subitem;

public interface ISubitemService {
	/**
	 * 根据一级栏目列出此一级栏目下的所有二级栏目
	 * @param iid 一级栏目ID
	 * @return 返回所有的二级栏目
	 */
	public List<Subitem> listByItem(long iid);
}
