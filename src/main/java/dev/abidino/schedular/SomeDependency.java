package dev.abidino.schedular;

import org.springframework.stereotype.Service;

@Service
public record SomeDependency() {
    void log (String message) {
        System.out.println(message);
    }
}
