package com.acg.mapper;

import com.acg.entity.Anime;
import com.acg.entity.AnimeItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AnimeMapper {
	public List<Anime> selectAllAnimes();

	public boolean insertAnime(Anime anime);

	public boolean delectAnime(@Param("animes") String animes);

	public List<Anime> select(@Param("input") String input);

	public boolean changeAnime(Anime anime);


	public  List selectAnimeItem();

	public boolean addAnimeItem(AnimeItem animeItem);

	public boolean delectAnimeItem(@Param("a_id") int a_id,@Param("a_number") int a_number);

	public  List searchAnimeItem(@Param("input")String input);

	public List selectByType(@Param("a_type")String a_type);


	public List searchAnime(@Param("input")String input);

	public int maxAnimeNumber(@Param("a_id")int a_id);

	public List getAnimeItems(@Param("a_id")int a_id);


	public Anime selectAnimeById(@Param("a_id")int a_id);



}
