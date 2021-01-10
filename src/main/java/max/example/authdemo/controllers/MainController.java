package max.example.authdemo.controllers;

import max.example.authdemo.entity.Message;
import max.example.authdemo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        return "main";
    }

    @GetMapping("/message")
    public String message(Model model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "message";
    }

    @PostMapping("/message")
    public String add(@RequestParam(name = "text", required = false) String text,
            Model model) {
        Message message = new Message(text);

        if (message.getText() != null && !message.getText().isEmpty()) {
            messageRepository.save(message);
        }

        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "message";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

}
