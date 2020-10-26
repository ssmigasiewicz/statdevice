package com.szymons.statdevice.infrastructure;

import com.szymons.statdevice.model.MemoryStat;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MemoryStatRepository extends ReactiveMongoRepository<MemoryStat, String> {
}
