package com.acg.service.impl;

import com.acg.entity.Anime;
import com.acg.entity.AnimeItem;
import com.acg.mapper.AnimeMapper;
import com.acg.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {

	@Autowired(required = false)
	private AnimeMapper animeMapper;

	public void setAnimeMapper(AnimeMapper animeMapper) {
		this.animeMapper = animeMapper;
	}

	@Override
	public List<Anime> selectAllAnimes() {
		return animeMapper.selectAllAnimes();
	}


	@Override
	public boolean insertAnime(Anime anime) {
		return animeMapper.insertAnime(anime);
	}

	@Override
	public boolean delectAnime(String animes) {
		return animeMapper.delectAnime(animes);
	}

	@Override
	public List<Anime> select(String input) {
		return animeMapper.select(input);
	}

	@Override
	public boolean changeAnime(Anime anime) {
		return animeMapper.changeAnime(anime);
	}

	@Override
	public List selectAnimeItem() {
		return animeMapper.selectAnimeItem();
	}

	@Override
	public boolean addAnimeItem(AnimeItem animeItem) {
		return animeMapper.addAnimeItem(animeItem);
	}

	@Override
	public boolean delectAnimeItem(int a_id, int a_number) {
		return animeMapper.delectAnimeItem(a_id,a_number);
	}

	@Override
	public List searchAnimeItem(String input) {
		return animeMapper.searchAnimeItem(input);
	}

	@Override
	public List selectByType(String a_type) {
		return animeMapper.selectByType(a_type);
	}

	@Override
	public List searchAnime(String input) {
		return animeMapper.searchAnime(input);
	}

	@Override
	public int maxAnimeNumber(int a_id) {
		return animeMapper.maxAnimeNumber(a_id);
	}

	@Override
	public List getAnimeItems(int a_id) {
		return animeMapper.getAnimeItems(a_id);
	}

	@Override
	public Anime selectAnimeById(int a_id) {
		return animeMapper.selectAnimeById(a_id);
	}
}
