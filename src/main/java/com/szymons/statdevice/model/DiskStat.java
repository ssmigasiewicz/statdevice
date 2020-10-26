package com.szymons.statdevice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiskStat {

    @Id
    private String id;
    private Float statistics = 0.0f;
    private LocalDateTime date;

    @Override
    public String toString() {
        return String.format("Disk: %.2f at %s", statistics, date);
    }
}
