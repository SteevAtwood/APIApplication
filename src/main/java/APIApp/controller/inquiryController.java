package APIApp.controller;

// import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import APIApp.repository.MySqlRepository;
import APIApp.model.InquirySummary;

import java.util.List;
import java.util.Optional;
import java.util.Map;

// @CrossOrigin(origins = "http://localhost:3000")
@RestController
public class inquiryController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/get-all-summary")
    public List<InquirySummary> getAllSummary() {

        return mySqlRepository.findAll();
    }

    @GetMapping("/search/{password}")
    public InquirySummary searchSummary(@PathVariable("password") String password) {
        return mySqlRepository.findByPassword(password).orElse(null);
    }

    @GetMapping("/get-summary/{id}")
    public InquirySummary getSingleSummary(@PathVariable("id") Integer id) {
        return mySqlRepository.findById(id).get();
    }

    @DeleteMapping("/remove/{id}")
    public boolean removeRow(@PathVariable("id") Integer id) {
        if (!mySqlRepository.findById(id).equals(Optional.empty())) {
            mySqlRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public InquirySummary updateSummary(@PathVariable("id") Integer id,
            @RequestBody Map<String, String> body) {

        InquirySummary current = mySqlRepository.findById(id).get();
        current.setText(body.get("text"));
        current.setLink(body.get("link"));
        current.setPassword(body.get("password"));

        mySqlRepository.save(current);
        return current;

    }

    @PostMapping("/add")
    public InquirySummary create(@RequestBody Map<String, String> body) {
        String text = body.get("text");
        String link = body.get("link");
        String password = body.get("password");

        InquirySummary newInquirySummary = new InquirySummary(text, link, password);

        return mySqlRepository.save(newInquirySummary);
    }

}

class SimpleCalculator {
    public int add(int numberA, int numberB) {
        return numberA + numberB;
    }
}