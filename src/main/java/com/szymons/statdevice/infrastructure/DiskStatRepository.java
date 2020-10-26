package com.szymons.statdevice.infrastructure;

import com.szymons.statdevice.model.DiskStat;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DiskStatRepository extends ReactiveMongoRepository<DiskStat, String> {
}
