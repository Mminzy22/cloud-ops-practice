package org.example.basic.parkminji.unitthirteen;

import java.util.Optional;

public class UserService {
    public static void main(String[] args) {
        printEmailByUsername("admin");
        printEmailByUsername("user");
    }

    private static void printEmailByUsername(String username) {
        String result = findEmailByUsername(username)
                .orElse("이메일 없음");
        System.out.println("[" + username + "] 이메일 결과: " + result);
    }

    private static Optional<String> findEmailByUsername(String username) {
        if ("admin".equals(username)) {
            return Optional.of("admin@carrot.com");
        }
        return Optional.empty();
    }
}
