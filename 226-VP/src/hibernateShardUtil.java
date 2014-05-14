


import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.shards.ShardId;
import org.hibernate.shards.ShardedConfiguration;
import org.hibernate.shards.cfg.ConfigurationToShardConfigurationAdapter;
import org.hibernate.shards.strategy.ShardStrategy;
import org.hibernate.shards.strategy.ShardStrategyFactory;
import org.hibernate.shards.strategy.ShardStrategyImpl;
import org.hibernate.shards.strategy.access.SequentialShardAccessStrategy;
import org.hibernate.shards.strategy.access.ShardAccessStrategy;
import org.hibernate.shards.strategy.resolution.ShardResolutionStrategy;
import org.hibernate.shards.strategy.selection.ShardSelectionStrategy;

public class hibernateShardUtil
{
    public static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static
    {
        try
        {
            Configuration config = new Configuration();
            System.out.println("Inside HibernateShardUtil...");
            config.configure("hibernate1.cfg.xml");
            List shardConfigs = new ArrayList();
            shardConfigs.add(new ConfigurationToShardConfigurationAdapter(new Configuration().configure("hibernate1.cfg.xml")));
            shardConfigs.add(new ConfigurationToShardConfigurationAdapter(new Configuration().configure("hibernate2.cfg.xml")));
            shardConfigs.add(new ConfigurationToShardConfigurationAdapter(new Configuration().configure("hibernate3.cfg.xml")));
            shardConfigs.add(new ConfigurationToShardConfigurationAdapter(new Configuration().configure("hibernate4.cfg.xml")));
            shardConfigs.add(new ConfigurationToShardConfigurationAdapter(new Configuration().configure("hibernate5.cfg.xml")));
            ShardStrategyFactory shardStrategyFactory = buildShardStrategyFactory();
            ShardedConfiguration shardedConfig = new ShardedConfiguration(config,shardConfigs,shardStrategyFactory);
            sessionFactory = shardedConfig.buildShardedSessionFactory();
        }
        catch (Throwable ex)
        {
            System.out.println("session is null");
                    ex.printStackTrace();
            sessionFactory = null;
        }
    }
     static ShardStrategyFactory buildShardStrategyFactory()
    {
    	 ShardStrategyFactory shardStrategyFactory = new ShardStrategyFactory() {
            public ShardStrategy newShardStrategy(List<ShardId> shardIds) {
                ShardSelectionStrategy wss = new weatherShardSelectionStrategy();
                ShardResolutionStrategy wrs = new weatherShardResolutionStrategy(shardIds);
                ShardAccessStrategy was = new SequentialShardAccessStrategy();
                return new ShardStrategyImpl(wss, wrs, was);
            }
        };
        return shardStrategyFactory;
    }
     
}