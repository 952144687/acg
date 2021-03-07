package com.acg.service;

import com.acg.entity.Anime;
import com.acg.entity.AnimeItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnimeService {
	public List<Anime> selectAllAnimes();


	public boolean insertAnime(Anime anime);

	public boolean delectAnime(String animes);

	public List<Anime> select(String input);

	public boolean changeAnime(Anime anime);


	public  List selectAnimeItem();

	public boolean addAnimeItem(AnimeItem animeItem);

	public boolean delectAnimeItem(int a_id,int a_number);

	public  List searchAnimeItem(String input);

	public List selectByType(String a_type);

	public List searchAnime(String input);

	public int maxAnimeNumber(int a_id);

	public List getAnimeItems(int a_id);

	public Anime selectAnimeById(int a_id);

}
