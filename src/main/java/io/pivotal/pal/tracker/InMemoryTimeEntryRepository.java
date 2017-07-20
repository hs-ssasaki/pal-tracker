package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> timeEntryRepositoryMap = new HashMap<>();

    @Autowired
    public InMemoryTimeEntryRepository() {

    }

    //    public ResponseEntity create(TimeEntry any) {
//        return null;
//    };

    public TimeEntry create(TimeEntry timeEntry) {
        Long size = timeEntryRepositoryMap.size()+1L;
        TimeEntry entry = new TimeEntry(
        size,
        timeEntry.getProjectId(),
        timeEntry.getUserId(),
        timeEntry.getDate(),
        timeEntry.getHours());
        timeEntryRepositoryMap.put(size,entry);
        return entry;
    }

    public TimeEntry find(long id) {
        return timeEntryRepositoryMap.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryRepositoryMap.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        timeEntryRepositoryMap.put(id, timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        timeEntryRepositoryMap.remove(id);
        return;
    }


}
