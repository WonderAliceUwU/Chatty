import java.net.Socket;

public class ChatRoom {
    private int connections;
    private int ongoingConnections;
    private Socket table[];

    public ChatRoom(int connections, int ongoingConnections, Socket[] table) {
        this.setConnections(connections);
        this.setOngoingConnections(ongoingConnections);
        this.table = table;
    }

    public int getConnections() { return connections; }
    public void setConnections(int connections) { this.connections = connections; }
    public int getOngoingConnections() { return ongoingConnections; }
    public void setOngoingConnections(int ongoingConnections) { this.ongoingConnections = ongoingConnections; }
    public void addTabla (Socket s,int i) { table[i]=s; }
}
