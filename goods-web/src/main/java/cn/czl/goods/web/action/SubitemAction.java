package cn.czl.goods.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.czl.goods.service.ISubitemService;
import cn.czl.goods.web.action.abs.AbstractBaseAction;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/pages/back/admin/subitem/*")
public class SubitemAction extends AbstractBaseAction {
	@Resource
	private ISubitemService subitemService;
	
	@RequestMapping("list_subitem")
	public ModelAndView addPre(HttpServletResponse response,long iid){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("allSubitems", this.subitemService.listByItem(iid));
		super.print(response, jsonObject);
		return null;
	}
}
