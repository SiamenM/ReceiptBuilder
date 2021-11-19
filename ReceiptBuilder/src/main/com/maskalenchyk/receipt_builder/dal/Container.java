package maskalenchyk.receipt_builder.dal;

import java.util.List;

public interface Container<ENTITY, KEY> {

    List<ENTITY> findAll();

    void save(ENTITY entity) throws ContainerException;

    void update(KEY key, ENTITY entity) throws ContainerException;

    ENTITY get(KEY key) throws ContainerException;

    void delete(KEY key) throws ContainerException;
}
