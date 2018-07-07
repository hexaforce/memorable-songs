package io.hexaforce.songs.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicItemRepository extends JpaRepository<MusicItem, Integer> {
	
	@Query("SELECT c FROM MusicItem c WHERE (c.artist LIKE %:searchWord%) OR (c.title LIKE %:searchWord%)")
	List<MusicItem> findByArtistContaining(@Param("searchWord")String searchWord);

	@Query("SELECT c FROM MusicItem c WHERE c.year LIKE %:released%")
	List<MusicItem> findByYearReleased(@Param("released")String released);
	
}
