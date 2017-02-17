/**
 * 
 */
package wang.yongrui.tmp.datainitialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wang.yongrui.model.jpa.User;
import wang.yongrui.repository.UserRepository;
import wang.yongrui.service.Initializer;
import wang.yongrui.service.InitializerConfig;

/**
 * @author I323560
 *
 */
@Component
public class UserInitializer extends Initializer {

    @Autowired
    private UserRepository repository;

    private static final String dataFileLocation = "./resources/InitialData/User.csv";

    /*
     * (non-Javadoc)
     * 
     * @see wang.yongrui.tmp.datainitialization.Initializer#build()
     */
    @Override
    public InitializerConfig build() {
        InitializerConfig config = new InitializerConfig(User.class, repository, dataFileLocation);
        return config;
    }

}
