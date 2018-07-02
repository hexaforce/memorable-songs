package io.hexaforce.songs.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicItemRepository extends JpaRepository<MusicItem, Integer> {

}
