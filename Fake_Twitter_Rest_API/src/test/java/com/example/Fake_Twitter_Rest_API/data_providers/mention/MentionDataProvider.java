package com.example.Fake_Twitter_Rest_API.data_providers.mention;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MentionDataProvider {
    static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of( 1, "ochian_a@yahoo.ro"),
                Arguments.of( 2, "dani@gmail.com")
        );
    }
}
