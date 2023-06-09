package com.example.eventapp.storage;

import com.example.eventapp.event.FileEvent;
import com.example.eventapp.event.FileEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    private final FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data) {
        try {
            log.info("파일 복사 완료");
            log.info("DB 메타 정보 저장 완료");
            FileEvent fileEvent = FileEvent.toCompleteEvent(data);
            fileEventPublisher.notifyComplete(fileEvent);
        } catch (Exception e) {
            log.error("file upload fail", e);
            FileEvent fileEvent = FileEvent.toErrorEvent(data);
            fileEventPublisher.notifyError(fileEvent);
        }
    }
}
