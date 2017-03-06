/**
 *
 */
package wang.yongrui.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author I323560
 *
 */
public class InitializerConfig {

    @SuppressWarnings("rawtypes")
    private Class entityClass;

    @SuppressWarnings("rawtypes")
    private CrudRepository repository;

    private String dataFileLocation;

    private List<Object> initializedEntityList;

    /**
     * @param entityClass
     * @param repository
     * @param dataFileLocation
     */
    @SuppressWarnings("rawtypes")
    public InitializerConfig(Class entityClass, CrudRepository repository, String dataFileLocation) {
        super();
        this.entityClass = entityClass;
        this.repository = repository;
        this.dataFileLocation = dataFileLocation;
    }

    /**
     * @param entityClass
     * @param repository
     * @param initializedEntityList
     */
    @SuppressWarnings("rawtypes")
    public InitializerConfig(Class entityClass, CrudRepository repository, List<Object> initializedEntityList) {
        super();
        this.entityClass = entityClass;
        this.repository = repository;
        this.initializedEntityList = initializedEntityList;
    }

    /**
     * @return the entityClass
     */
    @SuppressWarnings("rawtypes")
    public Class getEntityClass() {
        return entityClass;
    }

    /**
     * @return the repository
     */
    @SuppressWarnings("rawtypes")
    public CrudRepository getRepository() {
        return repository;
    }

    /**
     * @return the dataFileLocation
     */
    public String getDataFileLocation() {
        return dataFileLocation;
    }

    /**
     * @return the initializedEntityList
     */
    public List<Object> getInitializedEntityList() {
        return initializedEntityList;
    }

}
