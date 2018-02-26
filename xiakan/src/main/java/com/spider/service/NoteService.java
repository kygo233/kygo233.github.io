package com.spider.service;

import java.util.List;

import com.spider.dao.imp.NoteDaoImp;
import com.spider.model.Note;

public class NoteService {

	public List<Note> getNote() {
		// TODO Auto-generated method stub
		return new NoteDaoImp().getNote();
	}

	public Boolean addNote(String title, String content) {
		// TODO Auto-generated method stub
		return new NoteDaoImp().add(title, content);
	}

	public Note getCurNote() {
		// TODO Auto-generated method stub
		return new NoteDaoImp().getCurNote();
	}
	
	public boolean changeto0(int id)
	{
		return new NoteDaoImp().changeto0(id);
	}
	
	public boolean changeto1(int id)
	{
		return new NoteDaoImp().changeto1(id);
	}
	

	public boolean setnote(int id) {
		changeto0(getCurNote().getId());
		
		return changeto1(id);
	}

}
