package io.javabrains.tinder_ai_backend.profiles;

public record Profile(
        String id,
        String firstName,
        String lastName,
        int age,
        String ethicity,
        Gender gender,
        String bio,
        String imageUrl,
        String myersBriggsPersonalityType

) {

}
