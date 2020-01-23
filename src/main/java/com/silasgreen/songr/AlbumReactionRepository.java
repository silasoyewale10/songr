package com.silasgreen.songr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumReactionRepository extends JpaRepository<ReactionToAlbum, Long>{

}
