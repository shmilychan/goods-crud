package cn.czl.goods.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.czl.goods.dao.ISubitemDAO;
import cn.czl.goods.service.ISubitemService;
import cn.czl.goods.service.abs.AbstractService;
import cn.czl.goods.vo.Subitem;
@Service
public class SubitemServiceImpl extends AbstractService implements ISubitemService {
	@Resource
	private ISubitemDAO subitemDAO;
	@Override
	public List<Subitem> listByItem(long iid) {
		if (iid == 0) {
			return null;
		}
		return this.subitemDAO.findAllByItem(iid);
	}

}
