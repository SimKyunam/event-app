package com.example.eventapp.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileEvent {
    private String eventId;
    private String type;
    private Map<String, Object> data;

    public static FileEvent toCompleteEvent(Map data) {
        return FileEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.COMPETE.name())
                .data(data)
                .build();
    }

    public static FileEvent toErrorEvent(Map data) {
        return FileEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.ERROR.name())
                .data(data)
                .build();
    }
}
