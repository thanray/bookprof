package org.bookprof;

import org.bookprof.config.DefaultConfig;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by kr on 12/04/15.
 */
@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = { DefaultConfig.class }, loader = SpringApplicationContextLoader.class)
public class RepositoryIntegrationTest {

}
