package com.spider.service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.spider.model.News;
public class test {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(1);   
       Callable c1 = new NewsSortThread(1); 
        List<News> sechtlist=(List<News>) pool.submit(c1).get();
       for (News v : sechtlist) {
		System.out.println(v.toString());
	   }
       System.out.println(sechtlist.size());
        pool.shutdown(); 
	}
	
}
