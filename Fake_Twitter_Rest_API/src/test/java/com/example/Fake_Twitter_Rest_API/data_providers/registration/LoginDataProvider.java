package com.example.Fake_Twitter_Rest_API.data_providers.registration;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LoginDataProvider {
    static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of( "ochian_a@yahoo.ro", "asd"),
                Arguments.of( "dani@gmail.com", "asd"),
                Arguments.of( "gabi@gmail.com", "asd")
        );
    }
}
