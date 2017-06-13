package cn.czl.goods.web.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.czl.goods.service.IGoodsService;
import cn.czl.goods.vo.Goods;
import cn.czl.goods.vo.Item;
import cn.czl.goods.web.action.abs.AbstractBaseAction;
import cn.czl.util.split.ActionSplitPageUtil;
import cn.czl.util.web.upload.FileUtils;


@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsAction extends AbstractBaseAction {
	
	private static final String FLAG = "商品";
	
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletRequest request,String ids){
		ModelAndView mav = new ModelAndView(super.getUrl("forward.page"));
		Set<Long> gids = new HashSet<>();
		String result[] = ids.split(",");
		for (int i = 0; i < result.length; i++) {
			gids.add(Long.parseLong(result[i]));
		}
		if (this.goodsService.delete(gids)) {
			super.setUrlAndMsg(request, "goods.list.action",
					"vo.delete.success", FLAG);
		}else {
			super.setUrlAndMsg(request, "goods.list.action",
					"vo.delete.failure", FLAG);
		}
		return mav;
	}
	
	@RequestMapping("edit")
	public ModelAndView edit(HttpServletRequest request,Goods vo,MultipartFile pic){
		ModelAndView mav = new ModelAndView(super.getUrl("forward.page"));
		FileUtils fu = null;
		if (!(pic == null || pic.isEmpty())) { // 图片不为空
			fu = new FileUtils(pic);
			vo.setPhoto(fu.createFileName()); // 保存图片名称
		}
		if (this.goodsService.edit(vo)) {
			if (!(pic == null || pic.isEmpty())) {
				fu.saveFile(request, "upload/goods/", vo.getPhoto());
			}
			super.setUrlAndMsg(request, "goods.list.action", "vo.edit.success",
					FLAG);
		} else {
			super.setUrlAndMsg(request, "goods.list.action", "vo.edit.failure",
					FLAG);
		}
		return mav;
	}
	
	@RequestMapping("edit_pre")
	public ModelAndView editPre(Long gid){
		ModelAndView mav = new ModelAndView(super.getUrl("goods.edit.page"));
		mav.addAllObjects(this.goodsService.editPre(gid));
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mav = new ModelAndView(super.getUrl("goods.list.page"));
		//得到分页参数
		ActionSplitPageUtil aspu = new ActionSplitPageUtil(request, "商品名称:title", super.getUrl("goods.list.action"));
		Map<String, Object> map = this.goodsService.list(aspu.getCurrentPage(), aspu.getLineSize(), aspu.getColumn(), aspu.getKeyWord());
		mav.addAllObjects(map);
		List<Item> allItems = (List<Item>) map.get("allItems");
		Iterator<Item> iter = allItems.iterator();
		//此Map存放每一个商品对应的一类二类详情
		Map<Long, String> itemMap = new HashMap<>();
		
		while (iter.hasNext()) {
			Item item = iter.next();//取得当前的一级分类
			//当前的key = iid ,value = title
			itemMap.put(item.getIid(), item.getTitle());
		}
		mav.addObject("allItems",itemMap);
		
		return mav;
	}
	
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request,Goods vo,MultipartFile pic){
		ModelAndView mav = new ModelAndView(super.getUrl("forward.page"));
		FileUtils fu = null;
		if (!(pic == null || pic.isEmpty())) { // 图片不为空
			fu = new FileUtils(pic);
			vo.setPhoto(fu.createFileName()); // 保存图片名称
		}
		if (this.goodsService.add(vo)) {
			if (!(pic == null || pic.isEmpty())) {
				fu.saveFile(request, "upload/goods/", vo.getPhoto());
			}
			super.setUrlAndMsg(request, "goods.add.action", "vo.add.success",
					FLAG);
		} else {
			super.setUrlAndMsg(request, "goods.add.action", "vo.add.failure",
					FLAG);
		}
		return mav;
	}
	
	@RequestMapping("add_pre")
	public ModelAndView addPre(){
		ModelAndView mav = new ModelAndView(super.getMsg("goods.add.page"));
		mav.addAllObjects(this.goodsService.addPre());
		return mav;
	}
}
