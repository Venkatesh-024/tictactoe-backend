package com.tictactoe.controller;

import com.tictactoe.entity.Game;
import com.tictactoe.repository.GameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = "http://localhost:5173") // React Vite port
public class GameResultController {

    @Autowired
    private GameResultRepository repo;

    @PostMapping("/save")
    public ResponseEntity<String> saveGame(@RequestBody Game game) {
        System.out.println("📥 Game Received: " + game);
       repo.save(game);
        return ResponseEntity.ok("Saved");
    }


    @GetMapping("/all")
    public List<Game> getAllGames() {
        return repo.findAll();
    }

    @GetMapping("/search")
    public List<Game> search(@RequestParam String name) {
        return repo.findByPlayerXContainingIgnoreCaseOrPlayerOContainingIgnoreCase(name, name);
    }
}
