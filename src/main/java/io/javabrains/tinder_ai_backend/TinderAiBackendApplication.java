package io.javabrains.tinder_ai_backend;

import io.javabrains.tinder_ai_backend.conversations.ChatMessage;
import io.javabrains.tinder_ai_backend.conversations.Conversation;
import io.javabrains.tinder_ai_backend.conversations.ConversationRepository;
import io.javabrains.tinder_ai_backend.profiles.Gender;
import io.javabrains.tinder_ai_backend.profiles.Profile;
import io.javabrains.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public static void main(String[] args) {
        SpringApplication.run(TinderAiBackendApplication.class, args);
    }

    public void run(String... args) throws Exception {

        profileRepository.deleteAll();
        conversationRepository.deleteAll();



        Profile profile = new Profile(
                "1",
                "John",
                "Doe",
                30,
                "Asian",
                Gender.MALE,
                "Hello, I'm John!",
                "image.jpg",
                "INTP"
        );

        Profile profile2 = new Profile(
                "2",
                "Jane",
                "Doe",
                30,
                "Asian",
                Gender.FEMALE,
                "Hello, I'm Jane!",
                "image.jpg",
                "INTP"
        ) ;


        Conversation conversation = new Conversation(
                "1",
                profile.id(),
                List.of(new ChatMessage("Hello!", profile.id(), LocalDateTime.now()))
        );

        profileRepository.save(profile);
        profileRepository.save(profile2);
        conversationRepository.save(conversation);
        profileRepository.findAll().forEach(System.out::println);
        conversationRepository.findAll().forEach(System.out::println);

    }


}
