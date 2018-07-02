package io.hexaforce.songs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.hexaforce.songs.common.SongListUtile;
import io.hexaforce.songs.model.MusicItemRepository;

@Service
public class SongListServiceImpl implements SongListService {
	
	@Autowired
	private MusicItemRepository musicItemRepository;
	
	@Autowired
	private SongListUtile songListUtile;
	
	@ResponseBody
	@RequestMapping(path = "/examinees-numbering", method = RequestMethod.GET)
	private void aaa() {
		
	}
	
}
