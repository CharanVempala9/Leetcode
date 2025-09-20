import java.util.*;

class Router {

    private static class Packet {
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return source == packet.source && destination == packet.destination && timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private static class DestinationData {
        List<Integer> timestamps = new ArrayList<>();
        int start = 0;
        int end = -1;
    }

    private final int memoryLimit;
    private final Queue<Packet> queue;
    private final Set<Packet> packetSet;
    private final Map<Integer, DestinationData> destinationMap;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destinationMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);

        if (packetSet.contains(packet)) {
            return false;
        }

        if (queue.size() >= memoryLimit) {
            Packet oldest = queue.poll();
            packetSet.remove(oldest);

            DestinationData data = destinationMap.get(oldest.destination);
            if (data != null) {
                data.start++;
            }
        }

        queue.add(packet);
        packetSet.add(packet);
        DestinationData data = destinationMap.computeIfAbsent(destination, k -> new DestinationData());
        data.timestamps.add(timestamp);
        data.end++;

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[0];
        }

        Packet packet = queue.poll();
        packetSet.remove(packet);
        DestinationData data = destinationMap.get(packet.destination);
        if (data != null) {
            data.start++;
        }

        return new int[]{packet.source, packet.destination, packet.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        DestinationData data = destinationMap.get(destination);
        if (data == null || data.start > data.end) {
            
            return 0;
        }

        List<Integer> timestamps = data.timestamps;
        int startIdx = data.start;
        int endIdx = data.end;

        List<Integer> sub = timestamps.subList(startIdx, endIdx + 1);

        int low = 0, high = sub.size() - 1, lower = sub.size();
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = sub.get(mid);
            if (midVal >= startTime) {
                lower = mid;
                
                high = mid - 1;
            } else {
                
                low = mid + 1;
            }
        }
        low = 0;
        
        high = sub.size() - 1;
        
        int upper = -1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = sub.get(mid);
            if (midVal <= endTime) {
                
                upper = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (upper == -1 || lower == sub.size()) {
            
            return 0;
            
        }
        return Math.max(0, upper - lower + 1);
    }
}
