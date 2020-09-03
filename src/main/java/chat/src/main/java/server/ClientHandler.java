package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {
	private MyServer myServer;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private Timer tmr;

	private boolean authorized = false;
	private static final int timeout = 120000;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		myServer.broadcastMsg(name, "Я поменял ник на " + newName);
		name = newName;
	}

	public ClientHandler(MyServer myServer, Socket socket) {
		try {
			this.myServer = myServer;
			this.socket = socket;
			this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.name = "";
			this.tmr = new Timer();
			this.tmr.schedule(
				new TimerTask() {
					@Override
					public void run() {
					if (authorized != true) {
						closeConnection();
					}
					}
				},
				timeout
			);
			new Thread(() -> {
				try {
					authentication();
					readMessages();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					closeConnection();
				}
			}).start();
		} catch (IOException e) {
			throw new RuntimeException("Проблемы при создании обработчика клиента");
		}
	}

	public void authentication() throws IOException {
		while (true) {
			String str = in.readUTF();
			if (str.startsWith("/auth")) {
				String[] parts = str.split("\\s");
				String nick = myServer.getAuthService().getNickByLoginPass(parts[1], parts[2]);
				if (nick != null) {
					if (!myServer.isNickBusy(nick)) {
						sendMsg("/authok " + nick);
						name = nick;
						myServer.subscribe(this);
						authorized = true;
						return;
					} else {
						sendMsg("Учетная запись уже используется");
					}
				} else {
					sendMsg("Неверные логин/пароль");
				}
			}

			if (str.startsWith("/reg")) {
				String[] parts = str.split("\\s");
				myServer.getAuthService().addNewUser(parts[1], parts[2], parts[3]);
			}
		}
	}

	public void readMessages() throws IOException {
		while (true) {
			String strFromClient = in.readUTF();
			System.out.println("от " + name + ": " + strFromClient);
			if (strFromClient.equals("/end")) {
				return;
			}
			String[] words = strFromClient.split(" ");
			if (words[0].equals("/w")) {
				StringBuffer result = new StringBuffer();
				for (int i = 2; i < words.length; i++) {
					result.append(words[i] + " ");
				}
				myServer.privateMsg(name, words[1], result.toString());

				continue;
			}

			if (words[0].equals("/changenick")) {
				myServer.changeNickname(words[1], words[2]);

				continue;
			}

			myServer.broadcastMsg(name, strFromClient);
		}
	}

	public void sendMsg(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		myServer.unsubscribe(this);

		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
