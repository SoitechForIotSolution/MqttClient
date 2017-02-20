package soitech;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttLoRaClient extends DefaultMqttClient {

	public MqttLoRaClient(String topic) {
		super(topic);

	}

	@Override
	public void handle(String channel, MqttMessage message) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp + " " + channel + " Message  : " + message);

	}

	public static void main(String[] args) {
		MqttLoRaClient mqttLoRaClient = new MqttLoRaClient("NewAirQuality");
		mqttLoRaClient.start();

	}

}
