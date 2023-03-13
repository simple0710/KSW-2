package org.comstudy.boardweb.persistence;

import org.comstudy.boardweb.board.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
