package com.spider.springmvc;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spider.model.Media;
import com.spider.model.News;
import com.spider.model.Note;
import com.spider.model.Record;
import com.spider.model.Suggession;
import com.spider.model.User;
import com.spider.service.DM3Thread;
import com.spider.service.NewsSortThread;
import com.spider.service.NoteService;
import com.spider.service.RecordService;
import com.spider.service.SearchThread;
import com.spider.service.SinaThread;
import com.spider.service.SugService;
import com.spider.service.UserService;
import com.spider.service.WYNewsThread;
import com.spider.service.WYYThread;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class SpiderController {

	@RequestMapping("/")
	public String index(Model model) {
		Note note=new NoteService().getCurNote();
		
		model.addAttribute("note", note);
		System.out.println(note.getTitle());
		return "index";
	}
	@RequestMapping("/tonote")
	public String tonote(Model model) {
		
		return "note";
	}
	
	@RequestMapping("/tocreateNote")
	public String tocreateNote(Model model) {
		
		return "addnote";
	}
	
	@RequestMapping("/toaddsug")
	public String toaddsug(Model model) {
		
		return "addsug";
	}
	
	@RequestMapping("/tosug")
	public String tosug(Model model) {
		
		return "suggestion";
	}
	@RequestMapping("/getNote")
	public String getNote(Model model) {
	   List<Note> note=new NoteService().getNote();
		model.addAttribute("notelist", note);
		return "note";
	}
	
	@RequestMapping(value = "/createnote", method = RequestMethod.POST)
	public String createNote(String title,String content, Model model) {
	   Boolean flag=new NoteService().addNote(title,content);
		if(flag) {System.out.println("添加成功");}
		else{System.out.println("添加失败" );}
		return "redirect:/getNote";
	}
	@RequestMapping(value = "/getsug")
	public String getsug(Model model) {
		List<Suggession> suglist=new SugService().getsug();
		model.addAttribute("suglist", suglist);
		return "suggestion";
	}
	
	@RequestMapping(value = "/createsug", method = RequestMethod.POST)
	public String createsug(String content, Model model) {
	   Boolean flag=new SugService().addsug(content);
		if(flag) {System.out.println("反馈成功"); model.addAttribute("msg", "反馈成功");}
		else{System.out.println("反馈失败" );model.addAttribute("msg", "反馈失败");}
		return "addsug";
	}
	
	@RequestMapping(value = "/setnote", method = RequestMethod.POST)
	@ResponseBody
	public String setnote(String id) {
		
		System.out.println(id);
		if (new NoteService().setnote(Integer.parseInt(id))) {
			
			return "ok";
		} else {
			return "fail";
		}

	}
	
	@RequestMapping("/ms")
	public String manage(Model model) {
		
		return "MSLogin";
	}
	
	@RequestMapping("/tomsIndex")
	public String tomsIndex(Model model) {
		return "msIndex";
	}
	
	@RequestMapping(value = "/mslogin", method = RequestMethod.POST)
	public String mslogin(String name, String password,Model model) {
		
		if(name.equals("ys") && password.equals("ys"))
			{return "redirect:/tomsIndex";}
		
		else {
			model.addAttribute("msg", "用户名或密码错误");
			return "MSLogin";	
		}
		
	}

	@RequestMapping("/register")
	public String register() {

		return "register";
	}

	@RequestMapping("/news")
	public String news(Model model) throws InterruptedException,
			ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Callable c1 = new DM3Thread();
		Callable c2 = new SinaThread();
		Callable c3 = new WYNewsThread();
		List<News> dm3list = (List<News>) pool.submit(c1).get();
		List<News> sinalist = (List<News>) pool.submit(c2).get();
		List<News> wylist = (List<News>) pool.submit(c3).get();

		model.addAttribute("sinalist", sinalist);
		model.addAttribute("wylist", wylist);
		model.addAttribute("dm3list", dm3list);
		pool.shutdown();
		return "news";
	}

	@RequestMapping("/wyy")
	public String wyy(Model model, int i) throws InterruptedException,
			ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(1);
		Callable c1 = new WYYThread(i);
		List<Media> wyylist = (List<Media>) pool.submit(c1).get();
		model.addAttribute("wyylist", wyylist);
		pool.shutdown();
		return "music";
	}
	
	@RequestMapping("/sort")
	public String sortNews(Model model, int i) throws InterruptedException,
			ExecutionException {
		System.out.println(i);
		ExecutorService pool = Executors.newFixedThreadPool(1);
		Callable c1 = new NewsSortThread(i);
		List<News> newslist = (List<News>) pool.submit(c1).get();
	    //System.out.println(newslist.get(2).toString());
		model.addAttribute("newslist", newslist);
		model.addAttribute("msg", "123");
		pool.shutdown();
		return "sortnews";
	}

	@RequestMapping("/loginout")
	public String loginout(HttpSession session) {
		session.removeAttribute("user");
		return "index";
	}

	@RequestMapping("/toregister")
	public String toregister(String name, String password, HttpSession session) {

		return "register";
	}

	@RequestMapping("/tohostindex")
	public String tohostindex() {

		return "hostindex";
	}
	
	@RequestMapping("/tosearch")
	public String tosearch() {

		return "search";
	}
	
	@RequestMapping("/getRecord")
	public String getRecord(Model model, HttpSession session) {
		if (session.getAttribute("user") == null)
		{  
			System.out.println("未登录");
		    
		}
		else {
			int id = ((User) session.getAttribute("user")).getId();
			  List<Record> relist=new RecordService().getRecord(id);
			  model.addAttribute("relist", relist);
		}
		return "hostindex";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model, @RequestParam("name") String name,
			@RequestParam("password") String password) {
		UserService us = new UserService();
		int id = us.namecheck(name);
		System.out.println(id);
		if (id != 0) {
			model.addAttribute("msg", "用户名已存在");
			return "register";
		} else {
			if (us.register(name, password))
				System.out.println("注册成功");

			return "index";

		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(String name, String password, HttpSession session) {
		UserService us = new UserService();
		System.out.println(us.logincheck(name, password));
		if (us.logincheck(name, password)) {
			int id = us.namecheck(name);
			User user = new User(id, name, password);
			session.setAttribute("user", user);
			return "ok";
		} else {
			return "error";
		}

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("word") String word, Model model)
			throws InterruptedException, ExecutionException {
		System.out.println(word);
		ExecutorService pool = Executors.newFixedThreadPool(1);
		Callable c1 = new SearchThread(word);
		List<News> shlist = (List<News>) pool.submit(c1).get();
		model.addAttribute("word", word);
		model.addAttribute("searchRS", shlist);
		pool.shutdown();
		return "search";
	}

	@RequestMapping(value = "/record", method = RequestMethod.POST)
	@ResponseBody
	public String record(String url, String title, String category,
			HttpSession session) {
		
		if (session.getAttribute("user") == null)
		{  System.out.println("未登录");
			return "no";}
		else {
			int id = ((User) session.getAttribute("user")).getId();
			boolean b = new RecordService().add(url, title, category, id);
			if (b)
				return "ok";
			else
				return "no";
		}
	}

}
