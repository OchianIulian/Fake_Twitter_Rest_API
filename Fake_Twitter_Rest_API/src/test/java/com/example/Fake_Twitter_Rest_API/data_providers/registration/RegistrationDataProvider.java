package com.example.Fake_Twitter_Rest_API.data_providers.registration;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class RegistrationDataProvider {
    static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of("Andrei", "Ochian", "ochian_a@yahoo.ro", "asd"),
                Arguments.of("Daniel", "Apopei", "dani@gmail.com", "asd"),
                Arguments.of("Gabriela", "Stanciu", "gabigmail.com", "asd")
        );
    }
}
