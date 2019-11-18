package by.pvt.repository;

import by.pvt.pojo.AppData;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<AppData, Long> {
}
