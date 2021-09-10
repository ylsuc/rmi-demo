echo @off
cd .
javac IRemoteMath.java
javac RemoteMath.java
javac -encoding utf-8 RMIServer.java
java RMIServer
pause;