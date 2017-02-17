/**
 * 
 */
package wang.yongrui.service;

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
     * @return the entityClass
     */
    @SuppressWarnings("rawtypes")
    public Class getEntityClass() {
        return entityClass;
    }

    /**
     * @param entityClass
     *            the entityClass to set
     */
    @SuppressWarnings("rawtypes")
    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * @return the repository
     */
    @SuppressWarnings("rawtypes")
    public CrudRepository getRepository() {
        return repository;
    }

    /**
     * @param repository
     *            the repository to set
     */
    @SuppressWarnings("rawtypes")
    public void setRepository(CrudRepository repository) {
        this.repository = repository;
    }

    /**
     * @return the dataFileLocation
     */
    public String getDataFileLocation() {
        return dataFileLocation;
    }

    /**
     * @param dataFileLocation
     *            the dataFileLocation to set
     */
    public void setDataFileLocation(String dataFileLocation) {
        this.dataFileLocation = dataFileLocation;
    }

}
