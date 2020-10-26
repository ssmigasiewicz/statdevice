package com.szymons.statdevice.api;

import com.szymons.statdevice.infrastructure.DiskStatRepository;
import com.szymons.statdevice.infrastructure.MemoryStatRepository;
import com.szymons.statdevice.model.DiskStat;
import com.szymons.statdevice.model.MemoryStat;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.Duration;

@RestController
public class StatRestController {

    @Autowired
    private MemoryStatRepository memoryStatRepository;
    @Autowired
    private DiskStatRepository diskStatRepository;

    /*
    Non-browser clients can request a stream of JSON by setting the Accept header to application/stream+json,
    and the response will be a stream of JSON similar to Server-Sent-Events but without extra formatting ("data:")
     */
    @GetMapping(value = "/stats/memory", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<MemoryStat> getAllMemoryStats() {
        return memoryStatRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value = "/stats/disk", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<DiskStat> getAllDiskStats() {
        return diskStatRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value = "/hello")
    public ResponseEntity<String> getHello(@RequestParam("name") String name) {
        return ResponseEntity.ok(String.format("Hello %s", name));
    }

}
