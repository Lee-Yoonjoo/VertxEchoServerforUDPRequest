package teamnova;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResultHandler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.datagram.DatagramSocket;
import io.vertx.core.datagram.DatagramSocketOptions;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.datagram.DatagramPacket;
import io.vertx.core.AsyncResult;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;


public class VertxServer extends AbstractVerticle {

	private DatagramSocket socket;
	boolean echo = false;

	public void start() {
		System.out.println("Starting UDP Listener");
		// TODO should be stored in a configuration repository somewhere
		int port = 9876;

		 DatagramSocket socket = vertx.createDatagramSocket();


        socket.listen(9876, "192.168.0.45", this::socketHandler);

	}
	
    void socketHandler(AsyncResult<DatagramSocket> res) {
        if (res.succeeded()) {
            // Successfully received a datagram
            DatagramSocket socket = res.result();
            socket.handler(p -> this.datagramHandler(socket, p));
        }
    }
    void datagramHandler(DatagramSocket socket, DatagramPacket p) {
    	//JMeter UDP Request 로 보내진 Packet 처리
    	
    	////JMeter에 입력한 Packet Data가 String일 때
        if (p.data().toString().matches("[A-Za-z0-9 \n\r]*")) {
        	System.out.println(p.data().getBytes().length);
            Buffer reply = p.data();            
            socket.send(reply, p.sender().port(), p.sender().host(), this::sendHandler);
            
        ////JMeter에 입력한 Packet Data가 16진수로 된 음성 Packet Data일 때
        }else {
        	System.out.println(p.data().getBytes().length);
            Buffer reply = p.data();
            socket.send(reply, p.sender().port(), p.sender().host(), this::sendHandler);
        }
    }

    void sendHandler(AsyncResult<DatagramSocket> sent) {
        if (sent.succeeded()) {
          System.out.println("SUCCESS");
        } else {
        	System.out.println("FAILED");
        }
    }
	public void stop() {
		System.out.println("Stopping UdpListenerVerticle");
		if (socket != null)
			socket.close();
	}
}