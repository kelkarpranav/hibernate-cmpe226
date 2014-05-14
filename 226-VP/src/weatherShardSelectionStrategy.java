


import org.hibernate.shards.ShardId;
import org.hibernate.shards.strategy.selection.ShardSelectionStrategy;

public class weatherShardSelectionStrategy implements ShardSelectionStrategy {

	public ShardId selectShardIdForNewObject(Object obj) { 
        if (obj instanceof Weather) {
            int shardId = 1;
            String date = ((Weather) obj).getDATE();
            char firstchar = date.charAt(6);
            char secchar = date.charAt(7);
            if((firstchar=='1' && secchar=='2') || (firstchar=='1' && secchar == '3'))
                shardId = 1;
            else if((firstchar=='1' && secchar=='4') || (firstchar=='1' && secchar == '5') || (firstchar=='1' && secchar=='6') || (firstchar=='1' 
&& secchar== '7') || (firstchar=='1' && secchar=='8'))
    		{
            	shardId=2;
    		}
    		else if((firstchar=='1' && secchar=='9') || (firstchar=='2' && secchar == '1') || (firstchar=='2' && secchar=='2') || (firstchar=='2' 
&& secchar== '4') || (firstchar=='2' && secchar=='5') || (firstchar== '2' && secchar== '8'))
    		{
    			shardId=3;
    		}
    		else if((firstchar=='2' && secchar=='9') || (firstchar=='3' && secchar == '0') || (firstchar=='3' && secchar=='1'))
    		{
    			shardId=4;
    		}
    		else 
    		{
    			shardId=5;
    		}

            return new ShardId(shardId);
        }
        throw new IllegalArgumentException();
    }
}
