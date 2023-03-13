package org.comstudy.boardweb.persistence;

import org.comstudy.boardweb.domain.Board;
import org.springframework.data.repository.CrudRepository;

//public interface BoardRepository extends JpaRepository<Board, Long> {
public interface BoardRepository extends CrudRepository<Board, Long> {

}
