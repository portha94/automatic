
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toys")
public class ToyController {

    @Autowired
    private ToyRepository toyRepository;

    @GetMapping
    public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

    @PostMapping
    public Toy createToy(@RequestBody Toy toy) {
        return toyRepository.save(toy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToy(@PathVariable Long id) {
        toyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
