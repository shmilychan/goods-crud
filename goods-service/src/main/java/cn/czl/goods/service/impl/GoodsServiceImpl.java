package cn.czl.goods.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.czl.goods.dao.IGoodsDAO;
import cn.czl.goods.dao.IItemDAO;
import cn.czl.goods.dao.ISubitemDAO;
import cn.czl.goods.service.IGoodsService;
import cn.czl.goods.service.abs.AbstractService;
import cn.czl.goods.vo.Goods;
@Service
public class GoodsServiceImpl extends AbstractService implements IGoodsService {

	@Resource
	private IItemDAO itemDAO;
	@Resource
	private IGoodsDAO goodsDAO;
	@Resource
	private ISubitemDAO subitemDAO;
	
	
	
	@Override
	public boolean delete(Set<Long> gids) {
		if (gids == null || gids.size() == 0) {
			return false;
		}
		return this.goodsDAO.doRemoveBatch( gids.toArray());
	}
	
	@Override
	public boolean edit(Goods vo) {
		
		return this.goodsDAO.doUpdate(vo);
	}
	@Override
	public Map<String, Object> editPre(Long gid) {
		Map<String, Object> map = new HashMap<>();
		Goods goods = this.goodsDAO.findById(gid);
		
		map.put("goods", this.goodsDAO.findById(gid));
		map.put("allItems", this.itemDAO.findAll());
		map.put("allSubitems", this.subitemDAO.findAllByItem(goods.getIid()));
		return map;
	}
	@Override
	public Map<String, Object> list(long currentPage, int lineSize, String column, String keyWord) {
		Map<String, Object> map = new HashMap<>();
		map.put("allItems", this.itemDAO.findAll());
		//定义一个Map集合用于接收分页参数
		Map<String, Object> paramSplit = super.handleParam(currentPage, lineSize, column, keyWord);
		map.put("allGoods", this.goodsDAO.findAllSplit(paramSplit));
		map.put("allRecorders", this.goodsDAO.getAllCount(paramSplit));
		return map;
	}
	@Override
	public boolean add(Goods vo) {
		vo.setDelflag(0);
		return this.goodsDAO.doCreate(vo);
	}
	@Override
	public Map<String, Object> addPre() {
		Map<String, Object> map = new HashMap<>();
		map.put("allItems", this.itemDAO.findAll());
		return map;
	}

}
