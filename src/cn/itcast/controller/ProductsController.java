package cn.itcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.pojo.SearchResult;
import cn.itcast.service.ProductsService;

@Controller
public class ProductsController {
	
	//注入service服务对象
	@Autowired
	private ProductsService productsService;
	
	/**
	 * 测试git的使用
	 */
	@RequestMapping("git")
	public String showGit(){
		
		System.out.println("这是A程序员第一次修改代码,大家注意了");
		System.out.println("这是B程序员更改的代码,请注意更新");
		System.out.println("这是B程序员更改的代码,没有更新代码直接开发,提交,发送代码,发生冲突");
		System.out.println("这是A程序员开发代码,push提交到中央仓库.B没有更新,直接开发,提交推送");
		System.out.println("在bug99上开发新的业务");
		return "git";		
	}
	
	
	
	/**
	 * 需求:跳转到商品搜索列表页面product_list
	 * 参数:String queryString,String catalog_name,String price,Integer page,Integer rows,String sort,Model model
	 */
	@RequestMapping("list")
	public String list(String queryString,
			String catalog_name,
			String price,
			@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="60") Integer rows,
			@RequestParam(defaultValue="1") String sort,
			Model model){
		//调用service服务方法
		SearchResult result = productsService.queryProductsWithCondition(queryString, catalog_name, price, page, rows, sort);
		//回显主查询条件
		model.addAttribute("queryString", queryString);
		//类别
		model.addAttribute("catalog_name", catalog_name);
		//价格
		model.addAttribute("price", price);
		//排序
		model.addAttribute("sort", sort);
		//分页数据
		model.addAttribute("result", result);
		return "product_list";
	}

}
