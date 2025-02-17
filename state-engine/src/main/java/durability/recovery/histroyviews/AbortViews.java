package durability.recovery.histroyviews;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class AbortViews {
    public ConcurrentHashMap<Integer, ConcurrentSkipListSet<Long>> threadToAbortList = new ConcurrentHashMap<>();
    public void addAbortId(int threadId, long bid) {
        threadToAbortList.putIfAbsent(threadId, new ConcurrentSkipListSet<>());
        threadToAbortList.get(threadId).add(bid);
    }
    public boolean inspectView(int threadId, long bid) {
        return threadToAbortList.get(threadId).contains(bid);
    }
}
