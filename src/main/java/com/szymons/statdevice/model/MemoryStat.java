package com.szymons.statdevice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemoryStat {

    @Id
    private String id;
    private Float statistics = 0.0f;
    private LocalDateTime date;

    @Override
    public String toString() {
        return String.format("Memory: %.2f at %s, id: (%s)", statistics, date, id);
    }

}
