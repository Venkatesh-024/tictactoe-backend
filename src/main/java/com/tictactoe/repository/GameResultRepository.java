package com.tictactoe.repository;

import com.tictactoe.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GameResultRepository extends JpaRepository<Game, Long> {
    List<Game> findByPlayerXContainingIgnoreCaseOrPlayerOContainingIgnoreCase(String x, String o);
}

