package com.szymons.statdevice.infrastructure;

import com.szymons.statdevice.model.DiskStat;
import com.szymons.statdevice.model.MemoryStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Initializer implements ApplicationRunner {

    @Autowired
    private MemoryStatRepository memoryStatRepository;
    @Autowired
    private DiskStatRepository diskStatRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<MemoryStat> memoryStats = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<20; i++) {
            memoryStats.add(new MemoryStat(null, random.nextFloat(), LocalDateTime.now().plusMinutes(i)));
        }
        /*Flux<MemoryStat> statFlux = Flux.fromIterable(memoryStats);
        statFlux.flatMap(this.memoryStatRepository::save).subscribe(System.out::println);*/
        /*statFlux.subscribe(stat -> { <---- doesn't work
            System.out.println("storing: " + stat.toString());
            memoryStatRepository.save(stat);
            System.out.println("saved: " + stat.getId());
        });*/
        List<DiskStat> diskStats = new ArrayList<>();
        random = new Random();
        for(int i=0; i<10; i++) {
            diskStats.add(new DiskStat(null, random.nextFloat(), LocalDateTime.now().plusMinutes(i)));
        }
        Flux<DiskStat> diskStatFlux = Flux.fromIterable(diskStats);
        diskStatFlux.flatMap(this.diskStatRepository::save).subscribe(System.out::println);
    }

}
